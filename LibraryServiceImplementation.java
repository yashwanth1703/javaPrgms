package libraryManagement.ServiceImplementation;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryManagement.Model.*;
import libraryManagement.Repository.*;
import libraryManagement.Service.*;

/* This is the implementation class for service interface.
 * In this class all the methods present in the service interface are overriden.
 * All the methods in this are defined in our way.
 * This class has @Service annotation
 */


@Service
public class LibraryServiceImplementation implements LibraryService{
	@Autowired
  private  LibraryRepository libraryRepository;
 // private  LibraryService libServ;
	public LibraryServiceImplementation(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}
	
	public Book saveBook(Book book) {
	
		
		return libraryRepository.save(book);
	}

	@Override
	public List<Book> getBooksFromDb(String bookName) {
		// TODO Auto-generated method stub
		
		return libraryRepository.findAll();
	}

	@Override
	public Book getBookByISBN(Integer book_isbn) {
		// TODO Auto-generated method stub
		Optional<Book> book = libraryRepository.findById(book_isbn);  //null , or it can 5tg person rec
		if(book.isPresent()) {
			return book.get();
		}
		else {
			return null;
		}
		
		
	}

	@Override
	public Book updateBookDetails(Book newVal, Integer book_isbn ) {
		// TODO Auto-generated method stub
		Optional<Book> book = libraryRepository.findById(book_isbn);
		if(book.isPresent()) {
			Book existingbook = book.get();  //'2', 'mny@123', 'abc', 'xyz'

			existingbook.setbookName(newVal.getBookName());
			existingbook.setBookCost(newVal.getBookCost());
			existingbook.setNoOfpages(newVal.getNoOfpages());
			existingbook.setIsPublished(newVal.getIsPublished());
			existingbook.setAuthor(newVal.getAuthor());
			existingbook.setIsPublished(newVal.getIsPublished());
			libraryRepository.save(existingbook);
			return existingbook;
		}
		else {
			return null;
		}
	
	}

	@Override
	public void deleteBookByISBN(Integer book_isbn) {
		// TODO Auto-generated method stub
		Optional<Book> book = libraryRepository.findById(book_isbn);
		if(book.isPresent()) {
			libraryRepository.deleteById(book_isbn);
		}	
		
	}

		public List<Book> checkIfBookIsPublished(Boolean booleanObj){
			List<Book> book = libraryRepository.findByIsPublished(true);
			return book;
		}
		public List<Book> checkIfBookIsNotPublished(Boolean booleanObj){
			List<Book> book = libraryRepository.findByIsPublished(false);
			return book;
		}

		@Override
		public void deleteAllBooks() {
			// TODO Auto-generated method stub
			libraryRepository.deleteAll();
			System.out.println("All Books are deleted");
			
			
		}
		public Iterable<Book>fetchBookByNameIgnoringCase(String book_name){
			Iterable<Book> book = libraryRepository.findByBookNameContainingIgnoreCase(book_name);
			return book;
		}
//		public List<Book>fetchBooksInOrder(int book_isbn){
//			List<Book> book = libraryRepository.findByBookISBNOrderByBookNameAsc(book_isbn);
//			return book;
//		}

//		@Override
//		public List<Book> getBooksFromDb() {
//			// TODO Auto-generated method stub
//			return null;
//		}
	}


