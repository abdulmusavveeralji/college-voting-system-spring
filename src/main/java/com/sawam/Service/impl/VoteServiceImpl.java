package com.sawam.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sawam.Repository.CandidateRepository;
import com.sawam.Repository.CategoryRepository;
import com.sawam.Repository.VoteRepository;
import com.sawam.Repository.VotersRepository;
import com.sawam.Service.VoteService;
import com.sawam.entity.Candidate;
import com.sawam.entity.Category;
import com.sawam.entity.Vote;
import com.sawam.entity.Voters;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private CandidateRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private VotersRepository votersRepository;

    @Override
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @Override
    public Vote addaVote(Vote vote) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addaVote'");
    }

    @Override
    public void deleteVote(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteVote'");
    }

    @Override
    public Vote updateVote(int id, Vote vote) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateVote'");
    }
    

    @Override
    @Transactional
    public Vote voteCandidate(Voters voter, int candidateId, int categoryId) {
        Optional<Candidate> candidateOpt = repository.findById(candidateId);
        Optional<Category> categoryOpt = categoryRepository.findById(categoryId);
        Optional<Voters> voterOpt = votersRepository.findByIdNumber(voter.getIdNumber());

        if (!candidateOpt.isPresent() || !categoryOpt.isPresent()) {
            // Handle case when candidate or category is not found
            return null; 
        }

        Candidate candidate = candidateOpt.get();
        Category category = categoryOpt.get();

        // Ensure the candidate belongs to the selected category
        if (!candidate.getCategory().equals(category)) {
            // Handle case when the candidate doesn't belong to the selected category
            return null;
        }

        // Check if the voter has already voted in the given category
        Optional<Vote> existingVote = voteRepository.findByVoter_IdAndCategory_Id(voter.getId(), category.getId());
        if (existingVote.isPresent()) {
            // Handle case where the voter has already voted in this category
            return null;
        }

        // Create the vote
        Vote vote = new Vote();

        Voters newVoter = voterOpt.get();
        newVoter.setVoted(true);
        vote.setVoter(newVoter);
        vote.setCandidate(candidate);
        vote.setCategory(category);

        // Save the vote
        return voteRepository.save(vote);
    }
}
