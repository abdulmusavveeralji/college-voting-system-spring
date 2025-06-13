package com.sawam.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sawam.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Integer> {


    Optional<Vote> findByVoter_IdAndCategory_Id(int id, int id2);

    
}
