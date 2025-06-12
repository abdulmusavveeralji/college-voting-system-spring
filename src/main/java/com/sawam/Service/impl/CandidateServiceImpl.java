package com.sawam.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sawam.Repository.CandidateRepository;
import com.sawam.Service.CandidateService;
import com.sawam.Service.VoterService;
import com.sawam.entity.Candidate;
import com.sawam.entity.Voters;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateRepository repository;
    @Autowired
    private VoterService voterService;

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

    @Override
    public void voteCandidate(Candidate entity) {
        Optional<Candidate> candi = repository.findById(entity.getId());

        Optional<Voters> byId = voterService.findByIdNumber(entity.getVoters().get(0).getIdNumber());
        if(!candi.isPresent() || !byId.isPresent() ) {
            return; 
        }
        Voters voters = byId.get();
        Candidate candidate = candi.get();
        candidate.getVoters().add(voters);
        repository.save(candidate);
    }
    
}
