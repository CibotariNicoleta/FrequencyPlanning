package com.example.optaplanner.frequencyPlanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Site;
import domain.Transmitter;

class SiteTest {

	@Test
	public void setSiteTest() {
		
		Site s1=new Site(22);
		s1.setIdSite(24);
		
		assertEquals(24,s1.getIdSite());
		
		}
	
	@Test
	public void setTransmitterListforSiteTest()
	{
		Transmitter tr1=new Transmitter();
		List<Transmitter> transmitters = new ArrayList<Transmitter>();
		Site s1=new Site();
		
		int [] values={2,14,44,66};
		
		for(int i=0;i<values.length;i++)
		{
		tr1.setId(values[i]);
		transmitters.add(tr1);
		}
		
		s1.setTransmittersList(transmitters);
		
		assertEquals(transmitters,s1.getTransmittersList());
	}
}

