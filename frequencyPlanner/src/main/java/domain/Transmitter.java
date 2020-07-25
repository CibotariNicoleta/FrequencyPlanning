package domain;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import optional.domain.TransmitterDifficultyComparator;

@PlanningEntity(difficultyComparatorClass = TransmitterDifficultyComparator.class)
@XStreamAlias("Transmitter")
public class Transmitter {
	
	private int id;
	private List<Transmitter> neighbours = new ArrayList<Transmitter>();
	
	private Frequency frequency;
	
	public Transmitter(int id) {
		this.id = id;
	}
	
	public Transmitter() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int frequencyValue) {
		this.id = frequencyValue;
	}

	public List<Transmitter> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Transmitter> neighbours) {
		this.neighbours = neighbours;
	}

	@PlanningVariable(valueRangeProviderRefs = {"frequencyRange"})
	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}
	
	public int getRequiredNumberOfFrequency()
	{
		return 2;
	}
	
	

}
