package br.com.bmt.reports.controllers.dto;

import java.util.Optional;

public abstract class BaseRestDTO {
	
	private Optional<String> id;
	
	protected BaseRestDTO() {}
	
	public void setId(Optional<String> id) {
		this.id = id;
	}
	
	public Optional<String> getId() {
		return this.id;
	}
}
