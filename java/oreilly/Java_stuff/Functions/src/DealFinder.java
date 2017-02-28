import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DealFinder {
	
	public static final boolean LOWEST_PRICED_CAR_AT_TOP = true;
	public static final boolean LOWEST_PRICED_CAR_AT_BOTTOM = false;
	
	public static String readFile(String filename) {
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
	
	public static String getLowestPricedCarType(String content, boolean lowestPricedFirst) {
		int start;
		if (lowestPricedFirst)
			start = content.indexOf("vehicle\">");
		else
			start = content.lastIndexOf("vehicle\">");
		String carType = content.substring(start + 9);
		int end = carType.indexOf("</td>");
		carType = carType.substring(0, end);
		return carType;
	}
		
	public static String getLowestPricedCarPrice(String content, boolean lowestPricedFirst) {
		int start;
		if (lowestPricedFirst)
			start = content.indexOf("price\">");
		else
			start = content.lastIndexOf("price\">");
		String carPrice = content.substring(start + 7);
		int end = carPrice.indexOf("</td>");
		carPrice = carPrice.substring(0, end);
		return carPrice;
	}
	
	public static void processCarFile(String carFilename, boolean lowestPricedFirst, String carMake) {
		String fileContent = readFile(carFilename);
		String topCar = getLowestPricedCarType(fileContent, lowestPricedFirst);
		String topCarPrice = getLowestPricedCarPrice(fileContent, lowestPricedFirst);
		System.out.println("The best priced " + carMake + " this week sells for: " + topCarPrice);
		System.out.println("It's a " + topCar);
	}
	
	public static void main(String[] args) {	
		String[] carFilenames = {"audi-listings-2.html", "bmw-listings.html", "mercedes-listings-2.html", "porsche-listings.html"};
		boolean[] lowestPricedAtBottom = {LOWEST_PRICED_CAR_AT_BOTTOM, LOWEST_PRICED_CAR_AT_TOP, LOWEST_PRICED_CAR_AT_BOTTOM, LOWEST_PRICED_CAR_AT_TOP};
		String[] carTypes = {"Audi", "BMW", "Mercedes", "Porsche"};
		
		for (int i = 0; i < carFilenames.length; i++) {
			processCarFile(carFilenames[i], lowestPricedAtBottom[i], carTypes[i]);
		}
		/*
		double audiPrice = Double.parseDouble(topAudiPrice.substring(1));
		double bmwPrice = Double.parseDouble(topBMWPrice.substring(1));
		double mercedesPrice = Double.parseDouble(topMercedesPrice.substring(1));
		double bestPrice = 0;
		
		if ((audiPrice < bmwPrice) && (audiPrice < mercedesPrice))
	            bestPrice = audiPrice;
	    else if ((bmwPrice < audiPrice) && (bmwPrice < mercedesPrice))
	        	bestPrice = bmwPrice;
	    else if ((mercedesPrice < audiPrice) && (mercedesPrice < bmwPrice))
	        	bestPrice = mercedesPrice;
		
		if (bestPrice == audiPrice)
			System.out.println("The Audi, at " + topAudiPrice + ", is the best deal.");
		else if (bestPrice == bmwPrice)
			System.out.println("The BMW, at " + topBMWPrice + ", is the best deal.");
		else
			System.out.println("The Mercedes, at " + topMercedesPrice + ", is the best deal.");
			*/
	}

}
