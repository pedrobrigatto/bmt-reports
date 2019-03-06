package br.com.bmt.reports.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmt.reports.controllers.dto.ContractRestDTO;
import br.com.bmt.reports.converters.DbDtoConverter;
import br.com.bmt.reports.converters.DtoConverterFactory;
import br.com.bmt.reports.converters.RestDtoConverter;
import br.com.bmt.reports.persistence.ContractRepository;
import br.com.bmt.reports.persistence.dto.ContractDbDTO;

@RestController
public class ContractController {
	
	@Autowired
	ContractRepository contractRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping (path = "/path/contracts/")
	public ResponseEntity<ContractRestDTO> createContract(
			@RequestBody ContractRestDTO contract, BindingResult result) {
		if (contract.getId().isPresent()) {
			result.addError(new ObjectError("contrato", "IDs não devem ser informados ao salvar um contrato"));
			return ResponseEntity.badRequest().body(contract);
		}
		
		Optional<DbDtoConverter> converter = DtoConverterFactory.createDbDtoConverter(ContractDbDTO.class);
		if (!converter.isPresent()) {
			result.addError(new ObjectError("contrato", "Problema na preparação dos dados para salvar o contrato"));
			return ResponseEntity.badRequest().body(contract);
		}
		
		ContractDbDTO dto = contractRepository.save((ContractDbDTO) converter.get().toDbDTO(contract));
		contract.setId(dto.getId());
		return ResponseEntity.ok(contract);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping (path = "/api/contracts")
	public ResponseEntity<List<ContractRestDTO>> listContracts() {
		List<ContractDbDTO> contractsFromStore = contractRepository.findAll();
		
		Optional<RestDtoConverter> converter = DtoConverterFactory.createRestDtoConverter(ContractRestDTO.class);
		if (!converter.isPresent()) {
			return ResponseEntity.badRequest().body(null);
		}
		
		List<ContractRestDTO> allContracts = contractsFromStore.stream().map(c -> (ContractRestDTO) 
				((RestDtoConverter) converter.get()).toRest(c)).collect(Collectors.toList());
		return ResponseEntity.ok().body(allContracts);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping (path = "/api/contracts/{contract_number}")
	public ResponseEntity<ContractRestDTO> findByContractNumber(
			@PathVariable("contract_number") String contractNumber, BindingResult result) {
		ContractDbDTO contractFromDataStore = contractRepository.findByNumber(contractNumber);
		Optional<RestDtoConverter> converter = DtoConverterFactory.createRestDtoConverter(ContractRestDTO.class);
		if (!converter.isPresent()) {
			result.addError(new ObjectError("contrato", "Problema na preparação dos dados ao buscar o contrato"));
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok().body((ContractRestDTO)converter.get().toRest(contractFromDataStore));
	}
}
