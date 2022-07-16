package dto;

public class CarDTO {

	private Integer id;
	private String brand;
	private String model;
	private String plateNumber;
	private Integer employeeId;
    private Integer accessCardId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getAccessCardId() {
		return accessCardId;
	}
	public void setAccessCardId(Integer accessCardId) {
		this.accessCardId = accessCardId;
	}
	

}
