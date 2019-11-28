package com.bookshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop.model.Book;
import com.bookshop.service.BookService;

@RestController
@CrossOrigin(origins = "*")
public class BookController {
	
	@Autowired
	private BookService bookService;

	public BookController() {
		super();
	}

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping(path = "/books") //works
	public List<Book> getAllBooks(){
		return bookService.findAllBooks();
	}
	
	@PutMapping(path = "/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable long bookId) {
		return bookService.addOrUpdateBook(book, bookId);
	}
	
	@GetMapping(path = "/books/{bookId}") //works
	public Book getBook(@PathVariable long bookId) {
		return bookService.findById(bookId);
	}
	
	@PostMapping("/books") //works
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book, book.getBookId());
	}
	
	@DeleteMapping(path = "/books/{bookId}")
	public Book removeBook(@PathVariable long bookId) {
		return bookService.deleteBook(bookId);
	}
		
	

}
