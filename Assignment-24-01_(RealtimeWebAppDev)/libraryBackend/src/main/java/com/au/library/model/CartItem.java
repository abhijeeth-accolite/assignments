package com.au.library.model;

public class CartItem {
	private Integer bookId;
	private Integer userId;

	public CartItem() {
	}

	public CartItem(Integer bookId, Integer userId) {
		this.bookId = bookId;
		this.userId = userId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
