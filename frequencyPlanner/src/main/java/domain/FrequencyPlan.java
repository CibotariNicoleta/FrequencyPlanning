package domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;


@PlanningSolution
@XStreamAlias("FrequencyPlan")
public class FrequencyPlan {
	
	List<Transmitter> transmitterList;
	List<Frequency> frequencyList;
	
	 
	    private HardSoftScore score;
	
	public FrequencyPlan(List<Transmitter> transmitter, List<Frequency> frequency) {
		super();
		this.transmitterList = transmitter;
		this.frequencyList = frequency;
	}
	
	public FrequencyPlan() {}
	
	@PlanningEntityCollectionProperty
	public List<Transmitter> getTransmitterList() {
		return transmitterList;
	}
	public void setTransmitterList(List<Transmitter> transmitter) {
		this.transmitterList = transmitter;
	}
	
	  @ValueRangeProvider(id = "frequencyRange")
	    @ProblemFactCollectionProperty
	public List<Frequency> getFrequencyList() {
		return frequencyList;
	}
	public void setFrequencyList(List<Frequency> frequency) {
		this.frequencyList = frequency;
	}
	
	
	  @PlanningScore
	    public HardSoftScore getScore() {
	        return score;
	    }

	    public void setScore(HardSoftScore score) {
	        this.score = score;
	    }
	

}
