package pm_Service;

public class Data_pm {
	//Declare variables
	private String type, typeId;
	private boolean on;
	private int density;
	public static Data_pm pms;

	//Constructors
	public Data_pm() {
		this.type = "Particular Matter";
		this.on = true;
		this.typeId = "PM ID";
		this.density = 3;
	}

	//Setters and getters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public int getDensity() {
		return density;
	}

	public void setDensity(int density) {
		this.density = density;
	}
	//
	public static Data_pm getMatter() {
		if(pms == null) {
		pms = new Data_pm();
		}
		return pms;
	}

}
