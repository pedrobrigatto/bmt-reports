package br.com.bmt.reports.persistence.dto;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseDbDTO implements Serializable {
	
	private static final long serialVersionUID = 7353498754519758763L;
	
	@Id
	protected String id;
	
	public BaseDbDTO() {}
	
	public void generateId() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Optional<String> getId() {
		return Optional.ofNullable(id);
	}

	public void setId(String id) {
		this.id = id;
	}
}
