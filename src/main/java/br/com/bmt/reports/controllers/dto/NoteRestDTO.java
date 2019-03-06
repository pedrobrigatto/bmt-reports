package br.com.bmt.reports.controllers.dto;

public class NoteRestDTO extends SupervisedDataRestDTO {
	
	/** Reveals the role of the note's author, which can be either an executor (labor force) or its supervisor */
	private String scope;
	private String note;
	
	public NoteRestDTO(String currentLevel, boolean approved, String note, String scope, String comments) {
		super(currentLevel, approved, comments);
		this.note = note;
		this.scope = scope;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public String getScope() {
		return this.scope;
	}
}
