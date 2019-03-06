package br.com.bmt.reports.controllers.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Metadata indicating the origin of the report.
 */
public class OperationRestDTO extends BaseRestDTO {
	
	private String phase;
    private String stretch;
    private String band;
    private String city;
    
    private Set<ReportRestDTO> reports;
    
    public OperationRestDTO() {}
    
    private OperationRestDTO (String phase, String stretch, String band, String city) {
    	this.phase = phase;
		this.stretch = stretch;
		this.band = band;
		this.city = city;
    }
	
    public static OperationRestDTO of(String phase, String stretch, String band, String city) {
    	return new OperationRestDTO(phase, stretch, band, city);
	}

	public String getPhase() {
		return phase;
	}

	public String getStretch() {
		return stretch;
	}

	public String getBand() {
		return band;
	}

	public String getCity() {
		return city;
	}
	
	public OperationRestDTO addReport (ReportRestDTO report) {
		getReports().add(report);
		return this;
	}

	public Set<ReportRestDTO> getReports() {
		if (reports == null) {
			reports = new HashSet<>();
		}
		return reports;
	}
}
