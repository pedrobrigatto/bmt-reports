package br.com.bmt.reports.converters.rest;

import br.com.bmt.reports.controllers.dto.ContractRestDTO;
import br.com.bmt.reports.controllers.dto.OperationRestDTO;
import br.com.bmt.reports.converters.RestConverter;
import br.com.bmt.reports.converters.RestDtoConverter;
import br.com.bmt.reports.persistence.dto.ContractDbDTO;
import br.com.bmt.reports.persistence.dto.OperationDbDTO;

@RestConverter(dto = "Contract")
public class ContractRestConverter implements RestDtoConverter <ContractRestDTO, ContractDbDTO> {

	@Override
	public ContractRestDTO toRest(ContractDbDTO dbDTO) {
		ContractRestDTO dto = new ContractRestDTO(dbDTO.getNumber(), 
				dbDTO.getProvider(), dbDTO.getDocument(), dbDTO.getObject());
		dto.setId(dbDTO.getId());
		for (OperationDbDTO operation : dbDTO.getOperations()) {
			OperationRestDTO operationDTO = OperationRestDTO.of(operation.getPhase(), 
					operation.getStretch(), operation.getBand(), operation.getCity());
			operationDTO.setId(operation.getId());
			dto.addOperation(operationDTO);
		}
		return dto;
	}
}
