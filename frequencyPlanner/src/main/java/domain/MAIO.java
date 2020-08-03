package domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("MAIO")
public class MAIO {
	
	private int position;
    private int frequencyGroupNumber;
    
	
	public MAIO(int position, int frequencyGroupNumber) {
		this.position = position;
		this.frequencyGroupNumber = frequencyGroupNumber;
	}
	
	public MAIO() {
		
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getFrequencyGroupNumber() {
		return frequencyGroupNumber;
	}

	public void setFrequencyGroupNumber(int frequencyGroupNumber) {
		this.frequencyGroupNumber = frequencyGroupNumber;
	}
	
	
	

}
