package com.dal.BloodCampManagement2_0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.dal.controller.GenerateCampRestController;

@SpringBootTest
class BloodCampManagement20ApplicationTests {
	
	@InjectMocks
    private GenerateCampRestController generateCampRestController;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testWelcome() {
        String result= GenerateCampRestController.welcome();
        assertEquals("Welcome To BBMS Blood Bank", result);
    }

}
