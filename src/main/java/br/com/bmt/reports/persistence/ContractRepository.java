package br.com.bmt.reports.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bmt.reports.persistence.dto.ContractDbDTO;

@Repository
public interface ContractRepository extends JpaRepository<ContractDbDTO, String> {
	
	public ContractDbDTO findByNumber (@Param("number") String number);

}
