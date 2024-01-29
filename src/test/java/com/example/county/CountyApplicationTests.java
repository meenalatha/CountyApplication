package com.example.county;

import com.example.county.controller.CountySearchController;
import com.example.county.entity.CountyDetails;
import com.example.county.service.CountyDetailsService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class CountyApplicationTests {

	@Mock
	public CountyDetailsService countyDetailsServiceMock;

	@InjectMocks
	CountySearchController countySearchController;

	CountyDetails countyDetails = new CountyDetails();

	@Before
	public void before() {
		countyDetails.setFips("01001");
		countyDetails.setState("AL");
		countyDetails.setName("Autauga");
	}

	@Test
	public void getCountyDetailsByStateTest() {
		String state = "AL";
		List<CountyDetails> countyDetailsList = new ArrayList<CountyDetails>();
		countyDetailsList.add(countyDetails);
		when(countyDetailsServiceMock.getCountyDetailsByState(state)).thenReturn(countyDetailsList);
		assertEquals(countyDetailsList, countySearchController.getCountyDetailsByState(state));
		Mockito.verify(countyDetailsServiceMock, times(1)).getCountyDetailsByState(state);
	}

	@Test
	public void getCountyDetailsByNameTest() {
		String name = "Autauga";
		List<CountyDetails> countyDetailsList = new ArrayList<CountyDetails>();
		countyDetailsList.add(countyDetails);
		when(countyDetailsServiceMock.getCountyDetailsByName(name)).thenReturn(countyDetailsList);
		assertEquals(countyDetailsList, countySearchController.getCountyDetailsByName(name));
		Mockito.verify(countyDetailsServiceMock, times(1)).getCountyDetailsByName(name);
	}

	@Test
	public void getCountyDetailsByStateAndNameTest() {
		String name = "Autauga";
		String state = "AL";
		List<CountyDetails> countyDetailsList = new ArrayList<CountyDetails>();
		countyDetailsList.add(countyDetails);
		when(countyDetailsServiceMock.getCountyDetailsByStateAndName(state, name)).thenReturn(countyDetailsList);
		assertEquals(countyDetailsList, countySearchController.getCountyDetailsByStateAndName(state, name));
		Mockito.verify(countyDetailsServiceMock, times(1)).getCountyDetailsByStateAndName(state, name);
	}

	@Test
	public void getCountyDetailsByStateOrNameTest() {
		String name = "Autauga";
		String state = "AL";
		List<CountyDetails> countyDetailsList = new ArrayList<CountyDetails>();
		countyDetailsList.add(countyDetails);
		when(countyDetailsServiceMock.getCountyDetailsByStateOrName(state, name)).thenReturn(countyDetailsList);
		assertEquals(countyDetailsList, countySearchController.getCountyDetailsByStateOrName(state, name));
		Mockito.verify(countyDetailsServiceMock, times(1)).getCountyDetailsByStateOrName(state, name);
	}

}
