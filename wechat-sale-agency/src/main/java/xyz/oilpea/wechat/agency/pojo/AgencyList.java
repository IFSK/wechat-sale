package xyz.oilpea.wechat.agency.pojo;

import java.io.Serializable;
import java.util.List;

public class AgencyList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Agency> agency;
	public AgencyList() {
		super();
	}
	public AgencyList(List<Agency> agency) {
		super();
		this.agency = agency;
	}
	public List<Agency> getAgency() {
		return agency;
	}
	public void setAgency(List<Agency> agency) {
		this.agency = agency;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
