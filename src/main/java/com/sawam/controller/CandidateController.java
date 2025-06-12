package com.sawam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sawam.Service.CandidateService;
import com.sawam.entity.Candidate;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidate =  candidateService.getAllCandidates();
        return ResponseEntity.ok(candidate);
    }

    @PostMapping("/candidates")
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
        Candidate response =  candidateService.addCandidate(candidate);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/candidates/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable("id") int id, @RequestBody Candidate candidate) {
        Candidate response =  candidateService.updateCandidate(id, candidate);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/candidates/{id}")
    public ResponseEntity<HttpStatus> deleteCandidate(@PathVariable("id") int id) {
        candidateService.deleteCandidate(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
