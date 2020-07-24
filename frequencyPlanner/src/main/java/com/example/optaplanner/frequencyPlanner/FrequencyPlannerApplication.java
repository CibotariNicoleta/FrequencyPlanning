package com.example.optaplanner.frequencyPlanner;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import domain.Frequency;
import domain.FrequencyPlan;
import domain.Transmitter;
import persistence.FrequencyPlanGenerator;

@SpringBootApplication
public class FrequencyPlannerApplication {

	public static void main(String[] args) {
		FrequencyPlan unsolvedFrequencyPlan = new FrequencyPlanGenerator().createFrequencyPlan(8, 3);
		 
		for(Transmitter iterator: unsolvedFrequencyPlan.getTransmitterList()) {
			System.out.println("\n Transmitter id------------>:"+iterator.getId() );
			if(iterator.getNeighbours()!=null) {
			for(Transmitter secondIterrator:iterator.getNeighbours())
			System.out.println(" \n TransmitterNeighbour id ->:"+secondIterrator.getId() );
		    }
		}
		
		
		for(Frequency frequency:unsolvedFrequencyPlan.getFrequencyList()) {
			System.out.println("\n frequency id: ----->" + frequency.getFrequencyValue());
		}
		
		
	}

}
