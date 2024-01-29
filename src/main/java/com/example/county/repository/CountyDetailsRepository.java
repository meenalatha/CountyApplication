package com.example.county.repository;

import com.example.county.entity.CountyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountyDetailsRepository extends JpaRepository<CountyDetails, String> {

    List<CountyDetails> findByState(String state);

    @Query(value = "SELECT * FROM county_details WHERE name LIKE :name%", nativeQuery = true)
    List<CountyDetails> findByName(String name);

    List<CountyDetails> findByStateAndName(String state, String name);

    List<CountyDetails> findByStateOrName(String state, String name);

}
