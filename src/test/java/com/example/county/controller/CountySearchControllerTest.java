package com.example.county.controller;

import com.example.county.entity.CountyDetails;
import com.example.county.repository.CountyDetailsRepository;
import com.example.county.service.CountyDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CountySearchController.class)
public class CountySearchControllerTest {

    @MockBean
    public CountyDetailsService countyDetailsServiceMock;

    @Mock
    public CountyDetailsRepository countyDetailsRepository;

    @Autowired
    private MockMvc mockMvc;

    List<CountyDetails> countyDetailsList;

    private CountyDetails countyDetails;

    private CountyDetails countyDetails1;

    @BeforeEach
    void before() {
        countyDetails = new CountyDetails();
        countyDetails.setFips("06037");
        countyDetails.setState("CA");
        countyDetails.setName("Los Angeles");

        countyDetails1 = new CountyDetails();
        countyDetails1.setFips("06041");
        countyDetails1.setState("CA");
        countyDetails1.setName("Marin");

        countyDetailsList = new ArrayList<>();
        countyDetailsList.add(countyDetails);
        countyDetailsList.add(countyDetails1);
    }


    @Test
    public void shouldReturnListOfCountyByState() throws Exception {
        String state = "CA";
        when(countyDetailsServiceMock.getCountyDetailsByState(state)).thenReturn(countyDetailsList);
        mockMvc.perform(get("/api/v1/countySuggestion/getByState?state="+ state))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(countyDetailsList.size()))
                .andDo(print());

    }

    @Test
    public void shouldReturnListOfCountyByName() throws Exception {
        List<CountyDetails> countyDetailsList1 = new ArrayList<>(
                Arrays.asList(new CountyDetails("01025","AL","Clarke"),
                        new CountyDetails("01027", "AL", "Clay"),
                        new CountyDetails("01029", "AL", "Cleburne")));
        String name = "Cl";
        when(countyDetailsServiceMock.getCountyDetailsByName(name)).thenReturn(countyDetailsList1);
        mockMvc.perform(get("/api/v1/countySuggestion/getByName?name="+ name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(countyDetailsList1.size()))
                .andDo(print());

    }


    @Test
    public void shouldReturnListOfCountyByStateAndName() throws Exception {
        String name = "Marin";
        String state = "CA";
        when(countyDetailsServiceMock.getCountyDetailsByStateAndName(state,name)).thenReturn(countyDetailsList);
        mockMvc.perform(get("/api/v1/countySuggestion/getByStateAndName?state=" + state + "&name="+ name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(countyDetailsList.size()))
                .andDo(print());

    }

    @Test
    public void shouldReturnListOfCountyByStateOrName() throws Exception {
        String name = "Marin";
        String state = "CA";
        when(countyDetailsServiceMock.getCountyDetailsByStateOrName(state,name)).thenReturn(countyDetailsList);
        mockMvc.perform(get("/api/v1/countySuggestion/getByStateOrName?state=" + state + "&name="+ name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(countyDetailsList.size()))
                .andDo(print());

    }

}
