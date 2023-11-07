package com.example.demo.Model;

import com.example.demo.Business.Profile;

public class ProfileModel {
    public int ID;
    public String Name;
    public int[] AlgoritmIDs;

    public ProfileModel(int ID, String name, int[] algoritmIDs) {
        this.ID = ID;
        this.Name = name;
        this.AlgoritmIDs = algoritmIDs;
    }

    public ProfileModel(Profile profile) {
        this.ID = profile.id;
        this.Name = profile.name;
        this.AlgoritmIDs = profile.GetAlgoritmIDs();
    }
}
