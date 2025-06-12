package com.sawam.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sawam.entity.Candidate;

public interface CandidateService {

    List<Candidate> getAllCandidates();
    Candidate addCandidate(Candidate candidate);
    void deleteCandidate(int id);
    Candidate updateCandidate(int id, Candidate candidate);
}
