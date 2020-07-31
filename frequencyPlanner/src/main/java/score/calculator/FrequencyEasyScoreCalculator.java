package score.calculator;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import domain.FrequencyPlan;
import domain.Transmitter;

public class FrequencyEasyScoreCalculator implements EasyScoreCalculator<FrequencyPlan>{
	
	 @Override
	public HardSoftScore calculateScore(FrequencyPlan fr) {
		 int hardScore = 0;
		 for(Transmitter iterator : fr.getTransmitterList()) {
			 for(Transmitter neighbourIterator : iterator.getNeighbours())  
				 if(iterator.getFrequency()==null || neighbourIterator.getFrequency() ==null)
					 continue;
				 else if(iterator.getFrequency().getFrequencyValue() == neighbourIterator.getFrequency().getFrequencyValue() )
					 hardScore-=1;
		 }
		 
		 
		 for(int i = 0 ; i<fr.getTransmitterList().size(); i++)
			 for(int j=i+1 ; j < fr.getTransmitterList().size(); j++) {
				 if(( fr.getTransmitterList().get(i).getFrequency()==null||fr.getTransmitterList().get(j).getFrequency()==null ))
					 continue;
				 else {
				 if((fr.getTransmitterList().get(i).getSite().getIdSite()==fr.getTransmitterList().get(j).getSite().getIdSite()) )
					 if(Math.abs(fr.getTransmitterList().get(i).getFrequency().getFrequencyValue() - fr.getTransmitterList().get(j).getFrequency().getFrequencyValue())<2)
						 hardScore-=1;
				 }
			 }
		 
//		 for(Transmitter iterator : fr.getTransmitterList()) {
//			 if(iterator.getFrequency()==null)
//				 hardScore-=1;
//		 }
			 
				 
		 
						 return HardSoftScore.of(hardScore, 0 );
	}
}


