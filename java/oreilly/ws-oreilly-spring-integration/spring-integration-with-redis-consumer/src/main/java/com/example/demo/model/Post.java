package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Post implements Serializable {

	private static final long serialVersionUID = 1034485112435034358L;

	private String url;
	private String title;
	private List<String> emails;
}
