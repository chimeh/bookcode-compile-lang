package com.example.demo.util.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.stereotype.Component;

import com.example.demo.util.Color;
import com.example.demo.util.IColorWriter;

@Component
public class ColorWriterWindows implements IColorWriter {

	@PostConstruct
	public void setUp() {
		AnsiConsole.systemInstall();
	}

	@PreDestroy
	public void destroy() {
		AnsiConsole.systemUninstall();
	}

	@Override
	public String getColoredMessage(Color color, String mensaje) {
		return Ansi.ansi().eraseScreen()
				.render("@|" + color.getColor() + " " + mensaje + "|@")
				.toString();
	}

}
