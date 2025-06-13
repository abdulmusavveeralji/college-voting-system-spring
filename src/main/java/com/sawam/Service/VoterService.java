package com.sawam.Service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import com.sawam.entity.User;
import com.sawam.entity.Voters;

public interface VoterService {
    List<Voters> getAllVoters();
    Voters addVoters(Voters Voters);
    void deleteVoters(int id);
    Voters updateVoters(int id, Voters Voters);
    Voters validateUser(Voters entity);
    Optional<Voters> findById(int id);
    Optional<Voters> findByIdNumber(String id);
}
