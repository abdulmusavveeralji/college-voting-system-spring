package com.sawam.Service;

import java.util.List;

import com.sawam.entity.Vote;
import com.sawam.entity.Voters;

public interface VoteService {

  List<Vote> getAllVotes();
    Vote addaVote(Vote vote);
    void deleteVote(int id);
    Vote updateVote(int id, Vote vote);  

    Vote voteCandidate(Voters voter, int candidateId, int categoryId);
} 
