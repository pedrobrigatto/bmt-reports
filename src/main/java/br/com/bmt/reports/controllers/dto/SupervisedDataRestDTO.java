package br.com.bmt.reports.controllers.dto;

/**
 * The generic representation of any aspect of a report that requires approval (following a well-known 
 * approval workflow that must be respected in order to have it accepted.
 */
abstract class SupervisedDataRestDTO {
	
	private String currentLevel;
	private boolean approved;
	private String comments;
	
	protected SupervisedDataRestDTO (String currentLevel, boolean approved, String comments) {
		this.approved = approved;
		this.currentLevel = currentLevel;
		this.comments = comments;
	}
	
	public String getCurrentLevel () {
		return this.currentLevel;
	}
	
	public boolean isApproved() {
		return this.approved;
	}
	
	public String getComments() {
		return this.comments;
	}
}
