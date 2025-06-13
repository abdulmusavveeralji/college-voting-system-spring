package com.sawam.Service.impl;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawam.Repository.VotersRepository;
import com.sawam.controller.VotersController;
import com.sawam.Service.VoterService;
import com.sawam.entity.User;
import com.sawam.entity.Voters;

import ch.qos.logback.core.testUtil.RandomUtil;

@Service
public class VoterServiceImpl implements VoterService {

    @Autowired
    private VotersRepository repository;

    @Override
    public List<Voters> getAllVoters() {
        return repository.findAll();

    }

    @Override
    public Voters addVoters(Voters voters) {
        voters.setPassword(UUID.randomUUID().toString());
        voters.setVoted(false);
        return repository.save(voters);
    }

    @Override
    public void deleteVoters(int id) {
        repository.deleteById(id);
    }

    @Override
    public Voters updateVoters(int id, Voters voters) {
        return repository.save(voters);
    }

    @Override
    public Voters validateUser(Voters entity) {
        Optional<Voters> get = repository.findByIdNumber(entity.getIdNumber());
        try {

            if (!get.isPresent())
                throw new VoterNotFoundException("Voter Not found");
            if (!get.get().getPassword().equals(entity.getPassword()))
                throw new InvalidPasswordException("Password Not Match");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return get.get();

    }

    @Override
    public Optional<Voters> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Voters> findByIdNumber(String id) {
        return repository.findByIdNumber(id);
    }

}

class VoterNotFoundException extends Exception {
    public VoterNotFoundException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}