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
		 return HardSoftScore.of(hardScore, 0 );
	}
}


