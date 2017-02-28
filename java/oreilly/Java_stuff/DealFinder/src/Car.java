
public class Car {
	
	private String make;
	private double price;
	private String model;
	private int year;
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getMake() {
		return make;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setYear(int year) {
		if ((year > 1900) && (year < 2020)) {
			this.year = year;
		}
	}
	
	public int getYear() {
		return year;
	}
	
}
