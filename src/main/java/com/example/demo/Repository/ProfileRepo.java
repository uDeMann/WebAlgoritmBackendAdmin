package com.example.demo.Repository;

import com.example.demo.Business.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepo extends CrudRepository<Profile, Integer> {
    Optional<Profile> findProfileByNameAndPassword(String Name, String Password);
}
