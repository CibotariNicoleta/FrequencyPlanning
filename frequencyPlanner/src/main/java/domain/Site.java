package domain;

import java.util.ArrayList;
import java.util.List;

public class Site {
	
	private int idSite;
	private List<Transmitter> transmittersList = new ArrayList<Transmitter>();
	
	public Site(int idSite) {
		this.idSite = idSite;
	}
	
	public Site() {
		
	}

	public int getIdSite() {
		return idSite;
	}

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}

	public List<Transmitter> getTransmittersList() {
		return transmittersList;
	}

	public void setTransmittersList(List<Transmitter> transmittersList) {
		this.transmittersList = transmittersList;
	}

}
