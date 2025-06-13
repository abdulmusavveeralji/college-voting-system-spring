package com.sawam.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sawam.entity.Candidate;
import com.sawam.entity.Voters;

public interface CandidateService {

    List<Candidate> getAllCandidates();
    Candidate addCandidate(Candidate candidate);
    void deleteCandidate(int id);
    Candidate updateCandidate(int id, Candidate candidate);
    void voteCandidate(Voters voter, int candidateId, int categoryId);
}
