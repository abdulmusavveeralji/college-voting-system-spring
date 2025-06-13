package com.sawam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sawam.Service.VoterService;
import com.sawam.entity.Voters;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class VotersController {
    @Autowired
    private VoterService votersService;

    @GetMapping("/voters")
    public ResponseEntity<List<Voters>> getAllVoterss() {
        List<Voters> Voters =  votersService.getAllVoters();
        return ResponseEntity.ok(Voters);
    }

    @PostMapping("/voters")
    public ResponseEntity<Voters> addVoters(@RequestBody Voters Voters) {
        Voters response =  votersService.addVoters(Voters);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/voters/{id}")
    public ResponseEntity<Voters> updateVoters(@PathVariable("id") int id, @RequestBody Voters Voters) {
        Voters response =  votersService.updateVoters(id, Voters);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/voters/{id}")
    public ResponseEntity<HttpStatus> deleteVoters(@PathVariable("id") int id) {
        votersService.deleteVoters(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/voters/validateUser")
    public ResponseEntity<Voters> validateUser(@RequestBody Voters entity) {
        return ResponseEntity.ok(votersService.validateUser(entity));
    }
}
