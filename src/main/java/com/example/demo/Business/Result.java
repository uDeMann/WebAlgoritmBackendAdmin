package com.example.demo.Business;

import jakarta.persistence.*;

import java.util.Date;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "Result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "int")
    public int id;
    @Column(columnDefinition = "BIGINT")
    public long algoritmTimeNeeded;
    @Column(columnDefinition = "Datetime")
    public Date timeOfCommit;
    @ManyToOne(cascade = CascadeType.ALL, fetch=LAZY)
    public Algoritm algoritm;

    public Result(int id, long algoritmTimeNeeded, Date timeOfCommit) {
        this.id = id;
        this.algoritmTimeNeeded = algoritmTimeNeeded;
        this.timeOfCommit = timeOfCommit;
    }

    public Result() {
    }
}