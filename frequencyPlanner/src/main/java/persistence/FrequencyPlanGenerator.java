package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import domain.Frequency;
import domain.FrequencyPlan;
import domain.MAIO;
import domain.Site;
import domain.Transmitter;

public class FrequencyPlanGenerator {
	
    
	private static final int[] frequencyValue = {1,4,3,2,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
			19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,
			46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,
			74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,
			101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,
			122,123,124,125,126,127,128,129,130,131,132,33,134,135,136,137,138,139,140,141,142,
			143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160};
	
	private static final String[] transmitterType = {
			"Hopping", "Non-Hopping"
	};
	
	
	public static int[] frequencyDomain = {
			1,4,3,2,5,6,7,8,9,10,11,12,13,14,15,16,17,18,
			19,20};
	
	
	public static int[] frequencyGroup1 = {1,4,3,2,5,6,7,8,9,10};
	
	public static int[] frequencyGroup2 = {11,12,13,14,15,16,17,18,19,20};
	
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
		createMaioList(frequencyPlan);
		return frequencyPlan;
	}
	
	
	public void createMaioList(FrequencyPlan frequencyPlan) {
		List<MAIO> maioList = new ArrayList<MAIO>();
		for(int i=0; i<frequencyDomain.length/2; i++)
		{
			MAIO maio1 = new MAIO(i, 1);
			MAIO maio2 = new MAIO(i, 2);
			maioList.add(maio1);
			maioList.add(maio2);	
		}
		
		frequencyPlan.setMaioList(maioList);
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
			Frequency frequency = new Frequency(i);
					//generateFrequency();
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
				transmitterGeneration = new Transmitter(idTransmitter, transmitterType[random.nextInt(2)]);		
				check = false;
			}else continue;
	
		}
	
		return transmitterGeneration;
	}
	
	
	
	//

	public Frequency generateFrequency() {
		Frequency frequency = new Frequency();
		int generateFrequencyValue = random.nextInt(frequencyValue.length);
		frequency.setFrequencyValue(frequencyValue[generateFrequencyValue]);
		return frequency;
	}
	
	
	public void generateNeighbours(List<Transmitter> transmitterList) {
		int generateNumberOfNeighbours = random.nextInt(5);
		System.out.println("-----------------------------------------------" + generateNumberOfNeighbours);
		for(Transmitter transmitter:transmitterList)
		{
			int currentSize = transmitter.getNeighbours().size();
		
			for(int i=currentSize; i<3; i++)
			{
				
				    Transmitter transmitterNeighbourGenerate = transmitterList.get(random.nextInt(transmitterList.size()));  
				    if( transmitter.getId() == transmitterNeighbourGenerate.getId()|| transmitter.getNeighbours().contains(transmitterNeighbourGenerate)) {
                        
					     continue;
				}else 
				{
					if(transmitterNeighbourGenerate.getNeighbours().size()<3) {
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
		for(int siteIterator = 0 ; siteIterator < siteList.size(); siteIterator++) {
			for(int transmitterIterator = start; transmitterIterator < finish; transmitterIterator++ ) {
				
				if(transmitterList.size() > transmitterIterator) {
				transmitterList.get(transmitterIterator)
				.setSite(siteList.get(siteIterator));
				siteList.get(siteIterator).getTransmittersList().add(transmitterList.get(transmitterIterator));
				}
				
			}
			start = finish;
			finish+=numberOfTransmittersPerSite;
		}
		
		
	}

}
