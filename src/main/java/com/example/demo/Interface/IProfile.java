package com.example.demo.Interface;

import com.example.demo.Model.ProfileModel;
import com.example.demo.Model.ResultModel;

public interface IProfile {
    public ProfileModel GetProfile(String Name, String Password);
    public ResultModel[] GetResultsByAlgoritmId(int id);
}
