package com.sawam.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Voters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="voters_id")
    private int id;
    private String idNumber;
    private String password;
    private String firstname;
    private String lastname;
    private String year;
    private boolean isVoted;
    private String account;

    
    // @OneToMany(mappedBy = "voter", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Vote> votes = new ArrayList<>();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    
    public boolean isVoted() {
        return isVoted;
    }
    public void setVoted(boolean isVoted) {
        this.isVoted = isVoted;
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
    public String getIdNumber() {
        return idNumber;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    
}
