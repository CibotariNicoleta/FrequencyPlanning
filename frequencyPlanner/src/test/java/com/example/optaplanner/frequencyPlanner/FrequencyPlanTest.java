package com.example.optaplanner.frequencyPlanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import domain.Frequency;
import domain.FrequencyPlan;
import domain.MAIO;
import domain.Site;
import domain.Transmitter;

class FrequencyPlanTest {

	@Test
	public void setTransmitterListforFrequencyPlanTest()
	{
		FrequencyPlan frq1=new FrequencyPlan();
		Transmitter tr1=new Transmitter();
		List<Transmitter> transmitters = new ArrayList<Transmitter>();
	
		int [] values={23,12,55,78,166};
		//int [] values2= {24,155,51,67,88}; //pentru failure test
		
		for(int i=0;i<values.length;i++)
		{
		tr1.setId(values[i]);
		transmitters.add(tr1);
		}
		
		
		frq1.setTransmitterList(transmitters);
		
		assertEquals(transmitters,frq1.getTransmitterList());
	}
	
	@Test
	public void setFrequencyListforFrequencyPlanTest()
	{
		FrequencyPlan frq1=new FrequencyPlan();
		Frequency fr1=new Frequency();
		List<Frequency> frequencyList = new ArrayList<Frequency>();
	
		int [] values={1,2,3,4,5};
		//int [] values2= {4,5,6,7,8}; //pentru failure test 
		
		for(int i=0;i<values.length;i++)
		{
		fr1.setFrequencyValue(values[i]);
		frequencyList.add(fr1);
		}
	
		frq1.setFrequencyList(frequencyList);
		
		assertEquals(frequencyList,frq1.getFrequencyList());
	}
	
	@Test
	public void setMAIOListforFrequencyPlanTest()
	{
		FrequencyPlan frq1=new FrequencyPlan();
		MAIO m1=new MAIO();
		Random rand=new Random();
		int [] frgroups = {1,2};
		List<MAIO> maioList = new ArrayList<MAIO>();
	
		int [] values={1,2,3,4,5};
		//int [] values2= {4,5,6,7,8}; //pentru failure test 
		
		for(int i=0;i<values.length;i++)
		{
		m1.setPosition(values[i]);
		m1.setFrequencyGroupNumber(frgroups[rand.nextInt(frgroups.length)]);
		maioList.add(m1);
		}
	
		frq1.setMaioList(maioList);
		
		assertEquals(maioList,frq1.getMaioList());
	}
	
	@Test
	public void setSiteListforFrequencyPlanTest()
	{
		FrequencyPlan frq1=new FrequencyPlan();
		Site s1=new Site();
		List<Site> siteList = new ArrayList<Site>();
	
		int [] values={14,7,33,65,99};
		//int [] values2= {76,88,56,9,45}; //pentru failure test 
		
		for(int i=0;i<values.length;i++)
		{
		s1.setIdSite(values[i]);
		siteList.add(s1);
		}
	
		frq1.setSiteList(siteList);
		
		assertEquals(siteList,frq1.getSiteList());
	}
	

}
