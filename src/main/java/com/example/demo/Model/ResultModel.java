package com.example.demo.Model;

import com.example.demo.Business.Result;

import java.util.Date;

public class ResultModel {
    public int ID;
    public String AlgoritmName;
    public long TimeNeeded;
    public Date TimeOfCommit;

    public ResultModel(int ID, String algoritmName, long timeNeeded, Date timeOfCommit) {
        this.ID = ID;
        this.AlgoritmName = algoritmName;
        this.TimeNeeded = timeNeeded;
        this.TimeOfCommit = timeOfCommit;
    }

    public ResultModel(com.example.demo.Business.Result result){
        this.ID = result.id;
        this.AlgoritmName = result.algoritm.name;
        this.TimeNeeded = result.algoritmTimeNeeded;
        this.TimeOfCommit = result.timeOfCommit;
    }
}
