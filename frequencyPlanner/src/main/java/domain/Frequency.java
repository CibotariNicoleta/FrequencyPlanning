package domain;



import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Frequency")
public class Frequency {
	
	private int frequencyValue;
	
	public Frequency(int frequencyValue) {
		super();
		this.frequencyValue = frequencyValue;
	}
	
	public Frequency() {}

	public int getFrequencyValue() {
		return frequencyValue;
	}

	public void setFrequencyValue(int frequencyValue) {
		this.frequencyValue = frequencyValue;
	}


	
	

}
