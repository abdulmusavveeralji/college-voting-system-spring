package com.sawam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sawam.Service.VoteService;
import com.sawam.entity.Vote;
import com.sawam.entity.Voters;

@RestController
@RequestMapping("/api")
public class VoteController {
    
    @Autowired
    private VoteService service;

    @GetMapping("/vote")
    public ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> Vote =  service.getAllVotes();
        return ResponseEntity.ok(Vote);
    }

    @PostMapping("/vote")
    public ResponseEntity<Vote> addVote(@RequestBody Vote Vote) {
        Vote response =  service.addaVote(Vote);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/vote/{id}")
    public ResponseEntity<Vote> updateVote(@PathVariable("id") int id, @RequestBody Vote Vote) {
        Vote response =  service.updateVote(id, Vote);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/vote/{id}")
    public ResponseEntity<HttpStatus> deleteVote(@PathVariable("id") int id) {
        service.deleteVote(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/vote/voteCandidate")
    public ResponseEntity<Vote> voteCandidate(@RequestBody Voters voter, @RequestParam("candidateId") int candiateId , @RequestParam("categoryId") int categoryId) {

        return ResponseEntity.ok(service.voteCandidate(voter, candiateId, categoryId));
    }
    
}
