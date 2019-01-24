package com.au.library.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.au.library.model.Book;

@Repository
public class BookDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Book> getBooks() {
		String query = "SELECT * FROM book";
		return jdbcTemplate.query(query, (rs, i) -> {
			return new Book(rs.getInt("BOOK_ID"), rs.getString("BOOK_NAME"), rs.getString("BOOK_AUTHORNAME"),
					rs.getDouble("BOOK_PRICE"), rs.getString("BOOK_DESC"));
		});
	}

	public Book getBook(int bookId) {
		String query = "SELECT * FROM book WHERE BOOK_ID = " + bookId;
		return jdbcTemplate.queryForObject(query, (rs, i) -> {
			return new Book(rs.getInt("BOOK_ID"), rs.getString("BOOK_NAME"), rs.getString("BOOK_AUTHORNAME"),
					rs.getDouble("BOOK_PRICE"), rs.getString("BOOK_DESC"));
		});
	}

	public Book insertBook(Book book) {
		String query = "INSERT INTO book (BOOK_NAME, BOOK_AUTHORNAME, BOOK_PRICE, BOOK_DESC) VALUES (?, ?, ?, ?)";
		book.setId(jdbcTemplate.update(query,
				new Object[] { book.getName(), book.getAuthorName(), book.getPrice(), book.getDescription() }));
		return book;
	}
}
