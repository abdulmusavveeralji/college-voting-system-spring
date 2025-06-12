package com.sawam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="candidate_id")
    private int id;
    private String position;
    private String year;
    private String gender;
    private String firstname;
    private String lastname;
    // @OneToOne(mappedBy = "candidate")
    // private Voters voter;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    // public Voters getVoter() {
    //     return voter;
    // }
    // public void setVoter(Voters voter) {
    //     this.voter = voter;
    // }
    // @Override
    // public String toString() {
    //     return "Candidate [id=" + id + ", position=" + position + ", yearLevel=" + yearLevel + ", gender=" + gender
    //             + ", firstname=" + firstname + ", lastname=" + lastname + ", voter=" + voter + "]";
    // }
    
    
}
