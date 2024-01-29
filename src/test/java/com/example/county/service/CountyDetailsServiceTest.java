package com.example.county.service;

import com.example.county.entity.CountyDetails;
import com.example.county.repository.CountyDetailsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class CountyDetailsServiceTest {

    @Mock
    private CountyDetailsRepository countyDetailsRepository;

    @InjectMocks
    private CountyDetailsService countyDetailsService;

    @Test
    public void getByState() {
        CountyDetails countyDetails = new CountyDetails("53001", "WA", "Adams");
        CountyDetails countyDetails1 = new CountyDetails("53003", "WA", "Asotin");
        String state = "WA";
        given(countyDetailsRepository.findByState(state)).willReturn(List.of(countyDetails, countyDetails1));
        var countyDetailsList = countyDetailsService.getCountyDetailsByState(state);
        assertThat(countyDetailsList).isNotNull();
        assertThat(countyDetailsList.size()).isEqualTo(2);
    }

    @Test
    public void getByName() {
        CountyDetails countyDetails = new CountyDetails("01025", "AL", "Clarke");
        CountyDetails countyDetails1 = new CountyDetails("01027", "AL", "Clay");
        CountyDetails countyDetails2 = new CountyDetails("01029", "AL", "Cleburne");
        String name = "Cl";
        given(countyDetailsRepository.findByName(name)).willReturn(List.of(countyDetails, countyDetails1, countyDetails2));
        var countyDetailsList = countyDetailsService.getCountyDetailsByName(name);
        assertThat(countyDetailsList).isNotNull();
        assertThat(countyDetailsList.size()).isEqualTo(3);
    }

}
