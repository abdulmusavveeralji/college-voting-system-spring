package com.sawam.Service;

import java.util.List;

import com.sawam.entity.Voters;

public interface VoterService {
    List<Voters> getAllVoters();
    Voters addVoters(Voters Voters);
    void deleteVoters(int id);
    Voters updateVoters(int id, Voters Voters);
}
