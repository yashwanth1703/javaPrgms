package libraryManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import libraryManagement.Model.Book;


/* This is the Repository interface for the project.
 * This interface extends the Jpa Repository interface.
 */
public interface LibraryRepository extends JpaRepository<Book,Integer> {

	List<Book> findByIsPublished(boolean booleanObj);

	Iterable<Book> findByBookNameContainingIgnoreCase(String book_name);

//	List<Book> findByBookISBNOrderByBookNameAsc(int book_isbn);

}
