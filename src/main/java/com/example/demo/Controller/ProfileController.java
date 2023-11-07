package com.example.demo.Controller;

import com.example.demo.Interface.IProfile;
import com.example.demo.Model.ProfileModel;
import com.example.demo.Model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfileController {

    @Autowired
    IProfile pl;

    // http://localhost:8081/Login
    @GetMapping("/Login")
    public ResponseEntity<ProfileModel> Login(@RequestParam("username") String username, @RequestParam("password") String password){
        try {
            return ResponseEntity.ok(pl.GetProfile(username, password));
        } catch (Exception ex) {
            return ResponseEntity.ok(null);
        }
    }

    @GetMapping("/GetResults")
    public ResponseEntity<ResultModel[]> GetResultsByAlgoritmID(@RequestBody int id){
        try {
            return ResponseEntity.ok(pl.GetResultsByAlgoritmId(id));
        } catch (Exception ex) {
            return ResponseEntity.ok(null);
        }
    }

}
