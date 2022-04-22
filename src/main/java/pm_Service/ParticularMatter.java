package pm_Service;

public class ParticularMatter {
	private String pmRequest;
	private String pmChange;
	
	// default constructor
	public ParticularMatter() {
		
	}
	
	// constructor with parameters
	public ParticularMatter(String pmRequest, String pmChange) {
		this.setPmRequest(pmRequest);
		this.setPmChange(pmChange);
	}
	
	// getters and setters
	public String getPmRequest() {
		return pmRequest;
	}

	public void setPmRequest(String pmRequest) {
		this.pmRequest = pmRequest;
	}

	public String getPmChange() {
		return pmChange;
	}

	public void setPmChange(String pmChange) {
		this.pmChange = pmChange;
	}
}
