package br.com.bmt.reports.controllers.dto;

/**
 * One specific entry of a planned schedule for a labor day. One very common example is 'lunch time', which
 * goes from a starting to an ending time, and must be approved by all levels in an 'approval workflow' to be
 * finally accepted by the back-office team.
 */
public class ScheduleEntryRestDTO extends SupervisedDataRestDTO {
	
	private String reason;
	private String startTime;
	private String endTime;
	private boolean status;
	
	public ScheduleEntryRestDTO (String currentLevel, boolean approved, String comments,
			String reason, String startTime, String endTime, boolean status) {
		super(currentLevel, approved, comments);
		this.reason = reason;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public boolean isStatus() {
		return status;
	}
}
