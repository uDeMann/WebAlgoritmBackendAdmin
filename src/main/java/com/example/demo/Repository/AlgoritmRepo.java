package com.example.demo.Repository;

import com.example.demo.Business.Algoritm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("AlgoritmRepo")
public interface AlgoritmRepo extends CrudRepository<Algoritm, Integer> {
    Optional<Algoritm> findAlgoritmById(int ID);
}
