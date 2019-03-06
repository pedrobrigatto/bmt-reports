package br.com.bmt.reports.persistence.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "operations")
public class OperationDbDTO extends BaseDbDTO {
	
	private static final long serialVersionUID = 7704106445719603958L;
	
	private String phase;
    private String stretch;
    private String band;
    private String city;
    
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = ReportDbDTO.class)
    private Set<ReportDbDTO> reports;
    
    public OperationDbDTO () {}
    
    private OperationDbDTO (String phase, String stretch, String band, String city) {
    	this.phase = phase;
    	this.stretch = stretch;
    	this.band = band;
    	this.city = city;
    }
    
    public static OperationDbDTO of (String phase, String stretch, String band, String city) {
    	return new OperationDbDTO(phase, stretch, band, city);
    }

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getStretch() {
		return stretch;
	}

	public void setStretch(String stretch) {
		this.stretch = stretch;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Set<ReportDbDTO> getReports() {
		return reports;
	}
	
	@Transient
	public OperationDbDTO addReport (ReportDbDTO report) {
		if (reports == null) {
			reports = new HashSet<>();
		}
		reports.add(report);
		return this;
	}
}
