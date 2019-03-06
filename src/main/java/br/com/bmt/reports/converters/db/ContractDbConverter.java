package br.com.bmt.reports.converters.db;

import br.com.bmt.reports.controllers.dto.ContractRestDTO;
import br.com.bmt.reports.converters.DbDtoConverter;
import br.com.bmt.reports.persistence.dto.ContractDbDTO;

public class ContractDbConverter implements DbDtoConverter<ContractDbDTO, ContractRestDTO> {

	@Override
	public ContractDbDTO toDbDTO(ContractRestDTO restDTO) {
		ContractDbDTO dto = ContractDbDTO.of(restDTO.getNumber(), 
				restDTO.getProvider(), restDTO.getDocument(), restDTO.getObject());
		dto.setId(dto.getId().get());
		return dto;
	}
}
