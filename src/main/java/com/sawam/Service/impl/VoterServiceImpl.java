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
        voters.setStatus("Unvoted");
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
    public Boolean validateUser(Voters entity) {
        Optional<Voters> get = repository.findByIdNumber(entity.getIdNumber());
        if (!get.isPresent()) return false;

        System.out.println(entity.toString());
        System.out.println(get.get().toString());
        return get.get().getPassword().equals(entity.getPassword());
    }

    @Override
    public Optional<Voters> findById(int id) {
        return repository.findById(id);
    }
    
    @Override
    public Optional<Voters> findByIdNumber(String id) {
        return  repository.findByIdNumber(id);
    }
    
}
