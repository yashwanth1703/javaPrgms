package libraryManagement.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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


@RestController
@CrossOrigin
@RequestMapping("/library.com")
public class AuthorController {
	@Autowired
	private AuthorServiceImplementation authorService;
	
	public AuthorController(AuthorServiceImplementation authorService) {
		this.authorService = authorService;
	}
	
	@PostMapping("/saveAuthor")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author)throws Exception{
		try {
		return new ResponseEntity<Author>(authorService.saveAuthor(author),HttpStatus.CREATED);
	}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

}

	@PutMapping("/updateAuthor/{authorId}")
	public ResponseEntity<Author> updateAuthor(@PathVariable("authorId") Integer authorId ,@RequestBody Author author) throws Exception{
		try {
			return new ResponseEntity<Author>(authorService.updateAuthorDetails(author, authorId),HttpStatus.OK);
		}
		catch(Exception exc){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/readAuthor/{authorId}")
	public ResponseEntity<Author>readAuthorById(@PathVariable("authorId")Integer authorId) throws Exception{
		try {
			return new ResponseEntity<Author>(authorService.getAuthorById(authorId),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteAuthor/{authorId}")
	public void deleteAuthorById(@PathVariable("authorId") Integer authorId) throws Exception{
		try {
			authorService.deleteAuthorById(authorId);
		}
	   catch(Exception exc) {
		   System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	}
	@DeleteMapping("/deleteAllAuthors")
	public void deleteAllAuthors()throws Exception{
		try {
			authorService.deleteAllAuthors();
		}
		catch(Exception exc) {
			System.out.println(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/readAllAuthors")
	public ResponseEntity<List<Author>>fetchAllAuthors(){
		try {
			return new ResponseEntity<List<Author>>(authorService.getAllAuthors(),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
		
		
		}
	
	
	
