package com.sawam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sawam.entity.Voters;

@Repository
public interface VotersRepository extends JpaRepository<Voters, Integer>{
    
}
