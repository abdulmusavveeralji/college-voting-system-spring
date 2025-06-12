package com.sawam.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawam.Repository.VotersRepository;
import com.sawam.Service.VoterService;
import com.sawam.entity.Voters;

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
    
}
