package libraryManagement.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import libraryManagement.Model.*;

import libraryManagement.ServiceImplementation.*;


/* This is the Controller class for the project.
 * It consists of all the methods in which are present in the other classes(service , service implementation and repository).
 * It is an API class which controls the whole project. 
 * Any method present in this class helps to create beans for the project.
 * This class accepts the requests from the front end application and processes the request back.
 * It imports almost all libraries,packages and dependencies used to run the project.
 * This class has an annotation called @RestController.
 * The @RestController used to specify the controller used for this project and controlling every class.
 */

//@RequestMapping("/library.com
@RestController
public class LibraryController {

	

/* This is a class where object is created on type of class.
 * It is used to extract all methods available in it's class.
 */
	@Autowired
private LibraryServiceImplementation libraryService;

    //This is constructor injection of library Service implementation class
	public LibraryController(LibraryServiceImplementation libraryService) {
		this.libraryService = libraryService;
	}


	 //This is save API method it creates a record in database when called 
	@PostMapping("/saveBook")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) throws Exception{
		try {
		return new ResponseEntity<Book>(libraryService.saveBook(book), HttpStatus.CREATED);
	}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
   //This is the update API method updates the specified record in database 
	@PutMapping("/updateBook/{bisbn}")
	public ResponseEntity<Book>updateBookByISBN(@PathVariable("bisbn") Integer bisbn,
			@RequestBody Book book){
		try {
		return new ResponseEntity<Book>(libraryService.updateBookDetails(book, bisbn), HttpStatus.OK);

	}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
			
	//This is get all records API method returns all records in database
	@GetMapping("/readAllBooks")
	public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false)String bookName){
		try {
		List<Book> books = new ArrayList<Book>();
		
		if(bookName==null)
			libraryService.getBooksFromDb(bookName).forEach(books::add);
		
		else
			libraryService.fetchBookByNameIgnoringCase(bookName).forEach(books::add);
		
		if(books.isEmpty())
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		
	    return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	    
	}
		catch(Exception exc) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//@GetMapping("readForEmail/{email}")
	//public List<Book> getEmpsByEmailId(@PathVariable("email") String email){
		//return  libServ.getEmpsRecByEmail(email);
	//}


//	@GetMapping("/readByFirstAndLast/{fname}/{lname}")
//	public List<Book> getEmpsByNames(@PathVariable("fname") String fname,@PathVariable("lname") String lname){
//		return  libServ.getEmpsRecByNames(fname, lname);
//	}

//	@GetMapping("/readAllEmpWithFirstName/{name}")
//	public List<Employee> getAllEmpsByFirstName(@PathVariable("name") String fname){
//		return  empServ.getEmpsRecByFirstName(fname);
//	}
	//localhost:8080/edubridge.com/readEmp/5
	
	
	
	
	//This is get by id API method returns specific record when callled
	@GetMapping("/readBook/{bisbn}")
	
	public ResponseEntity<Book>  getBookByISBN(@PathVariable("bisbn")  Integer bisbn){
		try {
		return new ResponseEntity<Book>(libraryService.getBookByISBN(bisbn), HttpStatus.OK);
	}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// This is delete by id APi method which deletes a book by id.
	@DeleteMapping("/deleteBook/{bisbn}")
	public void  deleteBookByISBN(@PathVariable("bisbn")  Integer bisbn){
		try {
		libraryService.deleteBookByISBN(bisbn);	
	}
		catch(Exception exc) {
			System.out.println((HttpStatus.INTERNAL_SERVER_ERROR));	
		}
	}
	
	
//	@GetMapping("/fetchDataByISBN/{bisbn}")
//	public void fetchByISBN(@PathVariable("bisbn") int bisbn) {
//		List<Book> book = 
//	}
//	@GetMapping("/checkPublishedBook/{booleanObj}")
//	public void  checkingPublishedBook(@PathVariable("booleanObj") Boolean booleanObj) {
//		try {
//			libServ.checkIfBookPublished(booleanObj);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	//This is boolean API method which returns true or false based on is published entity.
	@GetMapping("/ispublished")
	public ResponseEntity<List<Book>> getPublishedBook(){
		try {
		return new ResponseEntity<List<Book>>( libraryService.checkIfBookIsPublished(true), HttpStatus.OK);
	}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//This is also a boolean method API returns true or false based on not published entity
	@GetMapping("/isNotPublished")
	public ResponseEntity<List<Book>> getNotPublishedBook(){
		try {
		return new ResponseEntity<List<Book>> (libraryService.checkIfBookIsNotPublished(false),HttpStatus.OK);
	}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//This is an Delete all API method deletes all records in table.
	@DeleteMapping("/deletAllBooksFromDataBase")
	public ResponseEntity<Book> deleteAllBooks() {
		try {
		libraryService.deleteAllBooks();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
}
