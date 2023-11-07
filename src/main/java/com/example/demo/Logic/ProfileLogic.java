package com.example.demo.Logic;

import com.example.demo.Business.Result;
import com.example.demo.Interface.IProfile;
import com.example.demo.Model.ProfileModel;
import com.example.demo.Model.ResultModel;
import com.example.demo.Repository.AlgoritmRepo;
import com.example.demo.Repository.ProfileRepo;
import com.example.demo.Repository.ResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProfileLogic")
public class ProfileLogic implements IProfile {

    @Autowired
    AlgoritmRepo ar;
    @Autowired
    ProfileRepo pr;
    @Autowired
    ResultRepo rr;

    @Override
    public ProfileModel GetProfile(String Name, String Password) {
        return new ProfileModel(pr.findProfileByNameAndPassword(Name, Password).get());
    }

    @Override
    public ResultModel[] GetResultsByAlgoritmId(int id) {
        Result[] results = rr.findResultsByAlgoritm_Id(id).get().stream().toArray(Result[]::new);
        ResultModel[] resultModels = new ResultModel[results.length];
        for (int i = 0; i < results.length; i++) {
            resultModels[i] = new ResultModel(results[i]);
        }
        return resultModels;
    }
}
