package com.example.optaplanner.frequencyPlanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import domain.MAIO;

class MAIOTest {
	MAIO m1=new MAIO(1,1);
	
	@Test
	public void setMAIOpositionTest() {
	
		m1.setPosition(3);
		
		assertEquals(3,m1.getPosition());
		
	}
	
	@Test
	public void setMaioFrequencyGroupNumberTest()
	{
		m1.setFrequencyGroupNumber(2);
		
		assertEquals(2,m1.getFrequencyGroupNumber());
	}


}