package com.example.optaplanner.frequencyPlanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import domain.Frequency;
import domain.MAIO;
import domain.Site;
import domain.Transmitter;

class TransmitterTest {

	@Test
	public void setTransmitterTest(){
		Transmitter t1=new Transmitter(13,"Non-Hopping");
		
		t1.setId(15);
		t1.setType("Hopping");
		
		
		assertEquals(15,t1.getId());
		assertEquals("Hopping",t1.getType());
		
	}
	
	@Test
	public void setMAIOforTransmitterTest()
	{
		Transmitter t1=new Transmitter();
		MAIO m1=new MAIO(1,1);
		
		m1.setPosition(3);
		m1.setFrequencyGroupNumber(2);
		
		t1.setMaio(m1);
		
		assertEquals(m1,t1.getMaio()); //din clasa Transmitter
		//din clasa MAIO
		//assertEquals(3,m1.getPosition());
		//assertEquals(2,m1.getFrequencyGroupNumber());
		
	}
	
	@Test
	public void setSiteforTransmitterTest() 
	{
		Transmitter t1=new Transmitter();
		Site s1=new Site(13);
		s1.setIdSite(17);
		
		t1.setSite(s1);
		
		assertEquals(s1,t1.getSite()); //din clasa Transmitter
		//assertEquals(17,s1.getIdSite()); //din clasa Site
	}
	
	@Test
	public void setFrequencyforTransmitterTest() 
	{
		Transmitter t1=new Transmitter(13,"Non-Hopping");
		Frequency fr1=new Frequency(6);
		
		fr1.setFrequencyValue(7);
		
		t1.setFrequency(fr1);
		

		assertEquals(fr1,t1.getFrequency()); //din clasa Transmitter
		//assertEquals(7,fr1.getFrequencyValue()); //din clasa Frequency
		
	}
	
	@Test
	public void setNeighboursListforTransmitterTest()
	{
		Transmitter tr1=new Transmitter();
		List<Transmitter> neighbours = new ArrayList<Transmitter>();
	
		int [] values={15,44,65,66};
		
		for(int i=0;i<values.length;i++)
		{
		tr1.setId(values[i]);
		neighbours.add(tr1);
		}
		
		
		tr1.setNeighbours(neighbours);
		
		assertEquals(neighbours,tr1.getNeighbours());
	}
}

