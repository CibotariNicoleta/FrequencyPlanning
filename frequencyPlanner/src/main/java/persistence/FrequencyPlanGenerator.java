package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.Frequency;
import domain.FrequencyPlan;
import domain.Transmitter;

public class FrequencyPlanGenerator {

	private static final int[] frequencyValue = {1,2,3,4,5};
	
//	private static final Transmitter[] transmitter = {
//			new Transmitter(123),
//			new Transmitter(124),
//			new Transmitter(125),
//			new Transmitter(126),
//			new Transmitter(127),
//			
//		
//	};
	
	private Random random;
	
	public FrequencyPlan createFrequencyPlan(int transmitterList, int frequencyList ) {
		random = new Random(47);
		FrequencyPlan frequencyPlan = new FrequencyPlan();
		createFrequencyList(frequencyPlan, frequencyList);
		createTransmitterList(frequencyPlan, transmitterList);
		
		return frequencyPlan;
	}
	
	
	public void createTransmitterList(FrequencyPlan frequencyPlan, int transmitterListSize) {
		List<Transmitter> transmitterList = new ArrayList<>(transmitterListSize);
		for(int i=0; i< transmitterListSize; i++)
		{
			Transmitter transmitter = generateTransmitter(transmitterListSize);
			transmitterList.add(transmitter);
		}
		
		generateNeighbours(transmitterList);
		frequencyPlan.setTransmitterList(transmitterList);
	}
	
	
	
	public void createFrequencyList(FrequencyPlan frequencyPlan, int frequencyListSize) {
		List<Frequency> frequencyList = new ArrayList<>(frequencyListSize);
		for(int i=0; i < frequencyListSize; i++) {
			Frequency frequency = generateFrequency();
			frequencyList.add(frequency);
		}
		
		frequencyPlan.setFrequencyList(frequencyList);
	}
	
	public Transmitter generateTransmitter(int transmitterListSize) {
		List<Integer> idList = new ArrayList<>();
		boolean check=true;
		Transmitter transmitterGeneration = null;
		int idTransmitter = random.nextInt(transmitterListSize+100);
		while(check) {
		if(!idList.contains(idTransmitter)) {
			idList.add(idTransmitter);
			transmitterGeneration = new Transmitter(idTransmitter);		
			check = false;
		}else continue;
		}
		
		return transmitterGeneration;
	}
	
	public Frequency generateFrequency() {
		Frequency frequency = new Frequency();
		int generateFrequencyValue = random.nextInt(frequencyValue.length);
		frequency.setFrequencyValue(frequencyValue[generateFrequencyValue]);
		
		return frequency;
	}
	
	public void generateNeighbours(List<Transmitter> transmitterList) {
		
		for(Transmitter transmitter:transmitterList)
		{
			for(int i=0; i<3; i++)
			{
				    Transmitter transmitterNeighbourGenerate = transmitterList.get(random.nextInt(transmitterList.size()));
				    
				    if( transmitter.getId() == transmitterNeighbourGenerate.getId()|| transmitter.getNeighbours().contains(transmitterNeighbourGenerate)) {
				    	continue;
					     
				}else 
				{
					transmitter.getNeighbours().add(transmitterNeighbourGenerate);
					 transmitterNeighbourGenerate.getNeighbours().add(transmitter);
					
				}
			}
		}
	}
}
