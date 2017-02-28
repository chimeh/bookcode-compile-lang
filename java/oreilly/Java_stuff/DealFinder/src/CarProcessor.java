import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CarProcessor {
	
	public static final boolean LOWEST_PRICED_CAR_AT_TOP = true;
	public static final boolean LOWEST_PRICED_CAR_AT_BOTTOM = false;
	
	private String readFile(String filename) {
		String content = "";
		try {
			File file = new File(filename);
			FileReader reader = new FileReader(file);
			BufferedReader br = new BufferedReader(reader);
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null)
				sb.append(line);
			content = sb.toString();
		} catch (IOException e) {
			System.err.println("There's been an error: " + e.getMessage());
			System.exit(-1);
			}
		
		return content;
		}
	
	private String getLowestPricedCarType(String content, boolean lowestPricedFirst) {
		int start;
		if (lowestPricedFirst)
			start = content.indexOf("vehicle\">");
		else
			start = content.lastIndexOf("vehicle\">");
		String carType = content.substring(start + 9);
		int end = carType.indexOf("</td>");
		String topCar = carType.substring(0, end);
		return topCar;
	}
	
	private double getLowestPricedCarPrice(String content, boolean lowestPricedFirst) {
		int start;
		if (lowestPricedFirst)
			start = content.indexOf("price\">");
		else
			start = content.lastIndexOf("price\">");
		String carPrice = content.substring(start + 7);
		int end = carPrice.indexOf("</td>");
		carPrice = carPrice.substring(0, end);
		double price = Double.parseDouble(carPrice.substring(1));
		return price;
	}
	
	public Car processCarFile(String carFilename, boolean lowestPricedFirst, String carMake) {
		String fileContent = readFile(carFilename);
		String topCar = getLowestPricedCarType(fileContent, lowestPricedFirst);
		double topCarPrice = getLowestPricedCarPrice(fileContent, lowestPricedFirst);
		int modelIndex = topCar.indexOf(carMake);
		modelIndex += carMake.length() + 1;
		String model = topCar.substring(modelIndex);
		String yearString = topCar.substring(0, 4);
		int year = Integer.parseInt(yearString);
		
		Car car = new Car();
		car.setMake(carMake);
		car.setPrice(topCarPrice);
		car.setModel(model);
		car.setYear(year);
		return car;
	}

}
