package com.sawam.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawam.Repository.CandidateRepository;
import com.sawam.Service.CandidateService;
import com.sawam.entity.Candidate;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateRepository repository;

    @Override
    public List<Candidate> getAllCandidates() {
        return repository.findAll();
    }

    @Override
    public Candidate addCandidate(Candidate candidate) {
        return repository.save(candidate);
    }

    @Override
    public void deleteCandidate(int id) {
        repository.deleteById(id);
    }

    @Override
    public Candidate updateCandidate(int id, Candidate candidate) {
        return repository.save(candidate);
    }
    
}
