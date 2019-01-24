package com.au.library.model;

public class Book {
	private Integer id;
	private String name;
	private String authorName;
	private Double price;
	private String description;

	public Book() {
	}

	public Book(Integer id, String name, String authorName, Double price, String description) {
		this.id = id;
		this.name = name;
		this.authorName = authorName;
		this.price = price;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
