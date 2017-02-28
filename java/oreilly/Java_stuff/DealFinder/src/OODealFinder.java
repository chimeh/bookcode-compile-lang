
public class OODealFinder {
	
	public static final boolean LOWEST_PRICED_CAR_AT_TOP = true;
	public static final boolean LOWEST_PRICED_CAR_AT_BOTTOM = false;
	
	public static void main(String[] args) {	
		String[] carFilenames = {"audi-listings-2.html", "bmw-listings.html", "mercedes-listings-2.html", "porsche-listings.html"};
		boolean[] lowestPricedAtBottom = {LOWEST_PRICED_CAR_AT_BOTTOM, LOWEST_PRICED_CAR_AT_TOP, LOWEST_PRICED_CAR_AT_BOTTOM, LOWEST_PRICED_CAR_AT_TOP};
		String[] carTypes = {"Audi", "BMW", "Mercedes", "Porsche"};
		
		CarProcessor processor = new CarProcessor();
		Car[] lowestPricedCars = new Car[carFilenames.length];
		for (int i = 0; i < carFilenames.length; i++) {
			Car lowestPricedCar = processor.processCarFile(carFilenames[i], lowestPricedAtBottom[i], carTypes[i]);
			lowestPricedCars[i] = lowestPricedCar;
		}
		
		for (int i = 0; i < lowestPricedCars.length; i++) {
			Car car = lowestPricedCars[i];
			System.out.println("The " + car.getYear() + " " + car.getMake() + 
					" " + car.getModel() + " sells for $" + car.getPrice());
		}
	}

}
