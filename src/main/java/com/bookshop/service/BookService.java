package com.bookshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop.model.Book;
import com.bookshop.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
	private BookRepository bookrepo;
	
	//Generate out the Constructors
	public BookService() {
		super();
	}
	
	@Autowired
	public BookService(BookRepository bookrepo) {
		super();
		this.bookrepo = bookrepo;
	}
	
	//Functionalities: find the books, getbook by table id, get book by ISBN unique string
	//adding or updating book details, saving book and deleting book
	public List<Book> findAllBooks(){
		List<Book> books = bookrepo.findAll();
		return books;
	}
	
	public Book findById(Long bookid) {
		Optional<Book> optionalBook = bookrepo.findById(bookid);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else return null;
	}
	
	
	public Book addOrUpdateBook(Book book, long bookId) {
		Optional<Book> optionalBook = bookrepo.findById(bookId);
		if(optionalBook.isPresent()) {
			Book bookToBeUpdated = optionalBook.get();
			bookToBeUpdated.setCategory(book.getCategory());
			bookToBeUpdated.setTitle(book.getTitle());
			bookToBeUpdated.setAuthor(book.getAuthor());
			bookToBeUpdated.setDescription(book.getDescription());
			bookToBeUpdated.setIsbnNum(book.getIsbnNum());
			bookToBeUpdated.setImage(book.getImage());
			bookToBeUpdated.setPrice(book.getPrice());
			bookToBeUpdated.setPublishDate(book.getPublishDate());
			
			return bookToBeUpdated;
		}
		
		return null;
	}
	
	public Book saveBook(Book book, long id) {
		return bookrepo.save(book);
	}
	
	public Book deleteBook(long id) {
		Optional<Book> optionalBook =  bookrepo.findById(id);
		if(optionalBook.isPresent()) {
			bookrepo.delete(optionalBook.get());
			return optionalBook.get();
		}
		else return null;
	}
	
	

}
