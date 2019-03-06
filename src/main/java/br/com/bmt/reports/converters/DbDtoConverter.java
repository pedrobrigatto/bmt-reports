package br.com.bmt.reports.converters;

import br.com.bmt.reports.controllers.dto.BaseRestDTO;
import br.com.bmt.reports.persistence.dto.BaseDbDTO;

public interface DbDtoConverter <D extends BaseDbDTO, R extends BaseRestDTO> {
	
	D toDbDTO(R restDTO);

}
