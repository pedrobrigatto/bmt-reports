package br.com.bmt.reports.persistence.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "reports")
public class ReportDbDTO extends BaseDbDTO {

	private static final long serialVersionUID = 2293776135778716210L;

}
