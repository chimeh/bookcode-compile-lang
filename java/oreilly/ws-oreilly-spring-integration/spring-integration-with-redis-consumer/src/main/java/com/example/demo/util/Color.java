package com.example.demo.util;

public enum Color {
	BLACK("black", "\033[0m"),
	BLUE("blue", "\033[34m"),
	CYAN("cyan", "\033[36m"),
	DEFAULT("default", "\033[0m"),
	GREEN("green", "\033[32m"),
	MAGENTA("magenta", "\033[35m"),
	RED("red", "\033[31m"),
	WHITE("white", "\033[37m"),
	YELLOW("yellow", "\033[33m");

	private String color;

	private String colorCode;

	private Color(String color, String colorCode) {
		this.color = color;
		this.colorCode = colorCode;
	}

	public String getColor() {
		return this.color;
	}

	public String getColorCode() {
		return this.colorCode;
	}
}
