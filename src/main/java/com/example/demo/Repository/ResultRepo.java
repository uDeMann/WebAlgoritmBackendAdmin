package com.example.demo.Repository;

import com.example.demo.Business.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("ResultRepo")
public interface ResultRepo extends CrudRepository<Result, Integer>{
    Optional<List<Result>> findResultsByAlgoritm_Id(int AlgoritmID);
}
