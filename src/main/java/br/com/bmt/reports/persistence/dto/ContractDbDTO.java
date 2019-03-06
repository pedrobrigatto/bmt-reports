package br.com.bmt.reports.persistence.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "contracts")
public class ContractDbDTO extends BaseDbDTO {

	private static final long serialVersionUID = 7572039968950219306L;
	
	private String number;
	private String provider;
	private String document;
	private String object;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = OperationDbDTO.class)
	private Set<OperationDbDTO> operations;
	
	public ContractDbDTO () {}
	
	public static ContractDbDTO of (String number, String provider, String document, String object) {
		ContractDbDTO dto = new ContractDbDTO();
		dto.setNumber(number);
		dto.setProvider(provider);
		dto.setDocument(document);
		dto.setObject(object);
		return dto;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}
	
	public void setOperations(Set<OperationDbDTO> operations) {
		this.operations = operations;
	}
	
	public Set<OperationDbDTO> getOperations() {
		return this.operations;
	}
}
