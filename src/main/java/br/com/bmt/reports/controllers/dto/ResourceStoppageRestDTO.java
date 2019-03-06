package br.com.bmt.reports.controllers.dto;

public class ResourceStoppageRestDTO extends SupervisedDataRestDTO {
	
	private String resourceType;
	private String reason;
	private String from;
	private String to;
	
	public ResourceStoppageRestDTO(String currentLevel, boolean approved, String comments, String resourceType,
			String reason, String from, String to) {
		super(currentLevel, approved, comments);
		this.resourceType = resourceType;
		this.reason = reason;
		this.from = from;
		this.to = to;
	}

	public String getResourceType() {
		return resourceType;
	}

	public String getReason() {
		return reason;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}
}
