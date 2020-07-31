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
	private Site site;
	private MAIO maio;
	private String type;
	

	public Transmitter(int id, String type) {
		this.id = id;
		this.type = type;
	}
	
	public Transmitter() {
		
	}
	
	@PlanningVariable(valueRangeProviderRefs = {"MAIORange"})
	public MAIO getMaio() {
		return maio;
	}

	public void setMaio(MAIO maio) {
		this.maio = maio;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int frequencyValue) {
		this.id = frequencyValue;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
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
		return neighbours.size();
	}
	
	

}
