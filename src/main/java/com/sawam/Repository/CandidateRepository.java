package com.sawam.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sawam.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository< Candidate, Integer>{
    
}
