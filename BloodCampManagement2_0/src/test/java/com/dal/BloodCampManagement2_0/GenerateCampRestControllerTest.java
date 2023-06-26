package com.dal.BloodCampManagement2_0;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dal.controller.GenerateCampRestController;
import com.dal.entity.Donor;
import com.dal.repository.DonorRepository;
import com.dal.service.DonorService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GenerateCampRestControllerTest {
	
	@Mock
	//means dummy instance
	private DonorRepository donorRepository;
	
	@Mock
	private DonorService donorService;
	
	@InjectMocks
	private GenerateCampRestController generateCampRestController;
	
	@BeforeEach
	public void setup()
	{
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testListAllDonor()
	{
		Donor donor1 = new Donor();
        donor1.setDonor_id(502L);
        donor1.setName("Minchu");
        List<Donor> donors = Arrays.asList(donor1);
        when(donorService.listAllDonor()).thenReturn(donors);
        List<Donor> result = generateCampRestController.listAllDonor();
        assertEquals(donors, result);
	}
	
//	 @Test
//	    public void testSearchByDonorId() {
//	        Long did = 355L;
//	        Donor donor = new Donor();
//	        donor.setDonor_id(did);
//	        donor.setName("pooja");
//	        when(donorService.searchBydonorId(did)).thenReturn(Optional.of(donor));
//
//	        Optional<Donor> result = generateCampRestController.searchBydonorId(did);
//	        assertEquals(donor, result.get());
//	    }
	

}
