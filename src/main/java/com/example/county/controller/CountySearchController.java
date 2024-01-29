package com.example.county.controller;

import com.example.county.entity.CountyDetails;
import com.example.county.service.CountyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/countySuggestion")
public class CountySearchController {

    @Autowired
    private CountyDetailsService countryDetailsService;

    @GetMapping(path = "/getByState")
    public List<CountyDetails> getCountyDetailsByState(@RequestParam String state) {
        List<CountyDetails> countyDetailsList = countryDetailsService.getCountyDetailsByState(state);
        return countyDetailsList;
    }

    @GetMapping(path = "/getByName")
    public List<CountyDetails> getCountyDetailsByName(@RequestParam String name) {
        List<CountyDetails> countyDetailsList = countryDetailsService.getCountyDetailsByName(name);
        return countyDetailsList;
    }

    @GetMapping(path = "/getByStateAndName")
    public List<CountyDetails> getCountyDetailsByStateAndName(@RequestParam String state, @RequestParam String name) {
        List<CountyDetails> countyDetailsList = countryDetailsService.getCountyDetailsByStateAndName(state, name);
        return countyDetailsList;
    }

    @GetMapping(path = "/getByStateOrName")
    public List<CountyDetails> getCountyDetailsByStateOrName(@RequestParam String state, @RequestParam String name) {
        List<CountyDetails> countyDetailsList = countryDetailsService.getCountyDetailsByStateOrName(state, name);
        return countyDetailsList;
    }

}