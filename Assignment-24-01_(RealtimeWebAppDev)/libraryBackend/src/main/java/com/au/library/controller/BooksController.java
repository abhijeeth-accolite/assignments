package com.au.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.library.model.Book;
import com.au.library.repository.BookDAO;

@RestController
public class BooksController {

	@Autowired
	BookDAO bookDAO;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable Integer bookId) {
		return bookDAO.getBook(bookId);
	}

	@PostMapping("/books")
	public Book insertBook(@RequestBody Book book) {
		return bookDAO.insertBook(book);
	}
}
