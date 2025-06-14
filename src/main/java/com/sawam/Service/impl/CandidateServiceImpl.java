package com.sawam.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sawam.Repository.CandidateRepository;
import com.sawam.Repository.CategoryRepository;
import com.sawam.Repository.VoteRepository;
import com.sawam.Service.CandidateService;
import com.sawam.Service.VoterService;
import com.sawam.entity.Candidate;
import com.sawam.entity.Category;
import com.sawam.entity.Vote;
import com.sawam.entity.Voters;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private CandidateRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired 
    private VoteRepository voteRepository;

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
    @Transactional
    public void voteCandidate(Voters voter, int candidateId, int categoryId) {
        Optional<Candidate> candidateOpt = repository.findById(candidateId);
        Optional<Category> categoryOpt = categoryRepository.findById(categoryId);

        if (!candidateOpt.isPresent() || !categoryOpt.isPresent()) {
            // Handle case when candidate or category is not found
            return; 
        }

        Candidate candidate = candidateOpt.get();
        Category category = categoryOpt.get();

        // Ensure the candidate belongs to the selected category
        if (!candidate.getCategory().equals(category)) {
            // Handle case when the candidate doesn't belong to the selected category
            return;
        }

        // Check if the voter has already voted in the given category
        Optional<Vote> existingVote = voteRepository.findByVoter_IdAndCategory_Id(voter.getId(), category.getId());
        if (existingVote.isPresent()) {
            // Handle case where the voter has already voted in this category
            return;
        }

        // Create the vote
        Vote vote = new Vote();
        vote.setVoter(voter);
        vote.setCandidate(candidate);
        vote.setCategory(category);

        // Save the vote
        voteRepository.save(vote);
    }
    
}
