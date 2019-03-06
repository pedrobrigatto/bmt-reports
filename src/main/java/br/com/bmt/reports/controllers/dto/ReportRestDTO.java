package br.com.bmt.reports.controllers.dto;

import java.util.List;


public class ReportRestDTO extends BaseRestDTO {
	
	private String stage;
	private OperationRestDTO operation;
	private List<ScheduleEntryRestDTO> schedule;
	private List<NoteRestDTO> serviceProviderNotes;
	private List<NoteRestDTO> fiscalNotes;
	private List<ResourceUtilizationRestDTO> equipmentLog;
	private List<ResourceUtilizationRestDTO> workforceLog;
	private List<ResourceStoppageRestDTO> equipmentStoppage;
	private List<ResourceStoppageRestDTO> workforceStoppage;
	
	public ReportRestDTO(String stage, OperationRestDTO operation, List<ScheduleEntryRestDTO> schedule,
			List<NoteRestDTO> serviceProviderNotes, List<NoteRestDTO> fiscalNotes,
			List<ResourceUtilizationRestDTO> equipmentLog, List<ResourceUtilizationRestDTO> workforceLog, 
			List<ResourceStoppageRestDTO> equipmentStoppage, List<ResourceStoppageRestDTO> workforceStoppage) {
		super();
		this.stage = stage;
		this.operation = operation;
		this.schedule = schedule;
		this.serviceProviderNotes = serviceProviderNotes;
		this.fiscalNotes = fiscalNotes;
		this.equipmentLog = equipmentLog;
		this.workforceLog = workforceLog;
		this.equipmentStoppage = equipmentStoppage;
		this.workforceStoppage = workforceStoppage;
	}
	
	public String getStage() {
		return this.stage;
	}

	public OperationRestDTO getOperation() {
		return operation;
	}

	public List<ScheduleEntryRestDTO> getSchedule() {
		return schedule;
	}

	public List<NoteRestDTO> getServiceProviderNotes() {
		return serviceProviderNotes;
	}

	public List<NoteRestDTO> getFiscalNotes() {
		return fiscalNotes;
	}

	public List<ResourceUtilizationRestDTO> getEquipmentLog() {
		return equipmentLog;
	}

	public List<ResourceUtilizationRestDTO> getWorkforceLog() {
		return workforceLog;
	}

	public List<ResourceStoppageRestDTO> getEquipmentStoppage() {
		return equipmentStoppage;
	}

	public List<ResourceStoppageRestDTO> getWorkforceStoppage() {
		return workforceStoppage;
	}
}
