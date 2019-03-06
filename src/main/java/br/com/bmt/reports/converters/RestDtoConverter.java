package br.com.bmt.reports.converters;

import br.com.bmt.reports.controllers.dto.BaseRestDTO;
import br.com.bmt.reports.persistence.dto.BaseDbDTO;

public interface RestDtoConverter <T extends BaseRestDTO, U extends BaseDbDTO> {
	
	T toRest(U dbDTO);

}
