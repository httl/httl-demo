package com.demo.action;

import java.util.List;

import com.demo.domain.Book;
import com.demo.service.BookService;

public class BooksAction {

	private BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	private List<Book> books;

	public List<Book> getBooks() {
		return books;
	}

	public String execute() throws Exception {
		books = bookService.findBooks();
		return "success";
	}

}
