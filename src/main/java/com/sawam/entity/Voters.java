package com.sawam.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Voters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="voters_id")
    private int id;
    private Long idNumber;
    private String password;
    private String firstname;
    private String lastname;
    private String year;
    private String status;
    private String account;

    
    // @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JoinColumn(name = "candidate_id")
    // private Candidate candidate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Long getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    
}
