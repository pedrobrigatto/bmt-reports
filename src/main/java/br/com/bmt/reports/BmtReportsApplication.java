package br.com.bmt.reports;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.bmt.reports.persistence.ContractRepository;
import br.com.bmt.reports.persistence.dto.ContractDbDTO;
import br.com.bmt.reports.persistence.dto.OperationDbDTO;

@SpringBootApplication
public class BmtReportsApplication {
	
	@Autowired
	private ContractRepository contractRepository;

	public static void main(String[] args) {
		SpringApplication.run(BmtReportsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init() {
		return evt -> {
			ContractDbDTO contract = ContractDbDTO.of("7000.0100036.16.2", "BUENO ENGENHARIA E CONSTRUÇÃO LTDA",
                    "PR-4703.34-6512-911-BBQ-001", "Substituição de Trechos do Oleoduto OPASA 16''");
			contract.generateId();
			
			OperationDbDTO operation = OperationDbDTO.of(
					"REVESTIMENTO", "KM-02 / KM-245", "KM-05", "Paulínia");
			operation.generateId();
			
			Set<OperationDbDTO> operations = new HashSet<>();
			operations.add(operation);
			contract.setOperations(operations);
			
			contractRepository.save(contract);
		};
	}

}
