package com.example.optaplanner.frequencyPlanner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.Frequency;
public class FrequencyTest {
   
	
	@Test
	public void setFrequencyTest(){
		
		Frequency fr1 = new Frequency(1);
		fr1.setFrequencyValue(2);
		
		assertEquals(2, fr1.getFrequencyValue());
	}
	
}
