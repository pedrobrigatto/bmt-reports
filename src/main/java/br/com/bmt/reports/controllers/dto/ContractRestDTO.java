package br.com.bmt.reports.controllers.dto;

import java.util.HashSet;
import java.util.Set;

public class ContractRestDTO extends BaseRestDTO {
	
	private String number;
	private String provider;
	private String document;
	private String object;
	
	private Set<OperationRestDTO> operations;
	
	public ContractRestDTO (String number, String provider, String document, String object) {
		this.number = number;
		this.provider = provider;
		this.document = document;
		this.object = object;
	}

	public String getNumber() {
		return number;
	}

	public String getProvider() {
		return provider;
	}

	public String getDocument() {
		return document;
	}

	public String getObject() {
		return object;
	}
	
	public ContractRestDTO addOperation (OperationRestDTO operation) {
		getOperations().add(operation);
		return this;
	}
	
	public Set<OperationRestDTO> getOperations() {
		if (operations == null) {
			operations = new HashSet<>();
		}
		return operations;
	}
}
