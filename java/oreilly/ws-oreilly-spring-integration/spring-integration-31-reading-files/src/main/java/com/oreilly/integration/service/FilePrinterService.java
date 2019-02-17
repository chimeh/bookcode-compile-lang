package com.oreilly.integration.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilePrinterService {

	@SneakyThrows
	public void print(File file, Map<String, String> headers) {

		log.info("headers: {}", headers);

		@Cleanup
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line = null;

		while ((line = br.readLine()) != null) {
			log.info(line);
		}
	}
}
