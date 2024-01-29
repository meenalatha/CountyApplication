package com.example.county.service;

import com.example.county.entity.CountyDetails;
import com.example.county.repository.CountyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyDetailsService {
    @Autowired
    private CountyDetailsRepository countyDetailsRepository;

    public Iterable<CountyDetails> save(List<CountyDetails> countyDetails) {
        return countyDetailsRepository.saveAll(countyDetails);
    }

    public List<CountyDetails> getCountyDetailsByState(String state) {
        return countyDetailsRepository.findByState(state);
    }

    public List<CountyDetails> getCountyDetailsByName(String name) {
        return countyDetailsRepository.findByName(name);
    }

    public List<CountyDetails> getCountyDetailsByStateAndName(String state, String name) {
        return countyDetailsRepository.findByStateAndName(state, name);
    }

    public List<CountyDetails> getCountyDetailsByStateOrName(String state, String name) {
        return countyDetailsRepository.findByStateOrName(state, name);
    }

}
