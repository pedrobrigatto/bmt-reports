package br.com.bmt.reports.controllers.dto;

public class ResourceUtilizationRestDTO extends SupervisedDataRestDTO {
	
	private String type;
	private String function;
	private int units;
	
	public ResourceUtilizationRestDTO (String currentLevel, boolean approved, 
			String type, String function, int units, String comments) {
		super(currentLevel, approved, comments);
		this.type = type;
		this.function = function;
		this.units = units;
	}

	public String getType() {
		return type;
	}

	public String getFunction() {
		return function;
	}

	public int getUnits() {
		return units;
	}
}
