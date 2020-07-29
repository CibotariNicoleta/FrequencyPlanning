package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.Frequency;
import domain.FrequencyPlan;
import domain.Site;
import domain.Transmitter;

public class FrequencyPlanGenerator {
	
    
	private static final int[] frequencyValue = {1,4,3,2,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
			19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56};
	
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
	
	
	public FrequencyPlan createFrequencyPlan(int transmitterList, int frequencyList, int numberOfTransmittersPerSite) {
		random = new Random(47);
		FrequencyPlan frequencyPlan = new FrequencyPlan();
		createFrequencyList(frequencyPlan, frequencyList);
		createTransmitterList(frequencyPlan, transmitterList, numberOfTransmittersPerSite);
		return frequencyPlan;
	}
	
	
	public void createTransmitterList(FrequencyPlan frequencyPlan, int transmitterListSize, int numberOfTransmittersPerSite) {
		List<Transmitter> transmitterList = new ArrayList<>(transmitterListSize);
		for(int i=0; i< transmitterListSize; i++)
		{
			Transmitter transmitter = generateTransmitter(transmitterListSize);
			transmitterList.add(transmitter);
			//aici trebuie sters
			//transmitter.setFrequency(frequencyPlan.getFrequencyList().get(random.nextInt(frequencyPlan.getFrequencyList().size())));
		}
		
		generateNeighbours(transmitterList);
		
		List<Site> siteList = generateTransmitterSite(transmitterList, numberOfTransmittersPerSite);
		frequencyPlan.setTransmitterList(transmitterList);
		frequencyPlan.setSiteList(siteList);
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
		while(check) {
			int idTransmitter = random.nextInt(transmitterListSize+100);
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
		int generateNumberOfNeighbours = random.nextInt(10);
		System.out.println("-----------------------------------------------" + generateNumberOfNeighbours);
		for(Transmitter transmitter:transmitterList)
		{
			int currentSize = transmitter.getNeighbours().size();
			
			for(int i=currentSize; i<generateNumberOfNeighbours; i++)
			{
				
				    Transmitter transmitterNeighbourGenerate = transmitterList.get(random.nextInt(transmitterList.size()));  
				    if( transmitter.getId() == transmitterNeighbourGenerate.getId()|| transmitter.getNeighbours().contains(transmitterNeighbourGenerate)) {
                        
					     continue;
				}else 
				{
					if(transmitterNeighbourGenerate.getNeighbours().size()<generateNumberOfNeighbours) {
					transmitter.getNeighbours().add(transmitterNeighbourGenerate);
					 transmitterNeighbourGenerate.getNeighbours().add(transmitter);
					 
					}else i--;
					
				}
			}
		}	
		
	}
	

	public List<Site> generateTransmitterSite(List<Transmitter> transmitterList, int numberOfTransmittersPerSite) {
	    List<Site> siteList = new ArrayList<>();
	    int numberOfSitesGenerated=0;
	    if(transmitterList.size()%numberOfTransmittersPerSite == 0) {
		   numberOfSitesGenerated = transmitterList.size()/numberOfTransmittersPerSite;
	    }else {
	       numberOfSitesGenerated = transmitterList.size()/numberOfTransmittersPerSite+1;
	    }
	    
		for(int i=0; i<  numberOfSitesGenerated; i++)
		{
			Site site = generateSite(numberOfSitesGenerated);
			siteList.add(site);
			
		}
		
		addTransmittersToSite(siteList, transmitterList, numberOfTransmittersPerSite);
		
		return siteList;
		
	}
	
	public Site generateSite(int numberOfSitesGenerated) {
		List<Integer> idSite = new ArrayList<>();
		boolean check=true;
		Site siteGeneration = null;
		while(check) {
			int idSiteGenerated = random.nextInt(numberOfSitesGenerated+100);
			if(!idSite.contains(idSiteGenerated)) {
				idSite.add(idSiteGenerated);
				siteGeneration = new Site(idSiteGenerated);		
				check = false;
			}else continue;
	
		}
	
		return siteGeneration;
		
	}
	
	public void addTransmittersToSite(List<Site> siteList, List<Transmitter> transmitterList, int numberOfTransmittersPerSite ) {
		int start = 0; 
		int finish = numberOfTransmittersPerSite ;
		System.out.println(numberOfTransmittersPerSite );
		for(int siteIterator = 0 ; siteIterator < siteList.size(); siteIterator++) {
			for(int transmitterIterator = start; transmitterIterator < finish; transmitterIterator++ ) {
				System.out.println(transmitterIterator);
				if(transmitterList.size() > transmitterIterator) {
				transmitterList.get(transmitterIterator)
				.setSite(siteList.get(siteIterator));
				siteList.get(siteIterator).getTransmittersList().add(transmitterList.get(transmitterIterator));
				}
				
			}
			start = finish;
			finish+=numberOfTransmittersPerSite;
		}
		System.out.println("cv");
		
	}

}
