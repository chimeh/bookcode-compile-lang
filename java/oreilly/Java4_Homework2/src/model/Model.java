package model;

public class Model {
	private String[] columnNames = {"First Name",
		      "Last Name",
		      "Birthday",
		      "Phone",
		      "Address",
		      "City",
		      "Zip"};
	private String[][] tableValues;
	private String[] baseTableData = {"Fred",
			"Flintstone",
			"Birthday",
			"Phone",
			"Address",
			"City",
			"Zip"};
	private int numberOfRows = 7;
	
	public Model() {
		//TODO Create automated filling of data.
	}
	
	public String[] getColumnNames() {
		return columnNames;
	}
	
	public String[][] getTableValues() {
		return tableValues;
	}

}
