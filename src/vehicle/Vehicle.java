package vehicle;

public abstract class Vehicle {
	private String brand = "";
	private String model = "";
	private int yearOfManufacture = 0;
	private String licensePlate = "";
	private double dailyValue = 0.0;
	private double assessedValue = 0.0;
	
	public Vehicle() {
		
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public double getDailyValue() {
		return dailyValue;
	}

	public void setDailyValue(double dailyValue) {
		this.dailyValue = dailyValue;
	}

	public double getAssessedValue() {
		return assessedValue;
	}

	public void setAssessedValue(double assessedValue) {
		this.assessedValue = assessedValue;
	}


}
