package libraryManagement.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import org.hibernate.annotations.DynamicUpdate;


/* This is the Book class for the project.
 * In this class all the attributes for the library are present. 
 * All are encapsulated so we derived getters and setters for each attribute.
 * Here the @Entity is used on the class to create a table in the database with same name of class or different name as specified.
 * Here @Dynamic update is used to check specified records for faster operations.
 * Even toString method is also used for displaying the ouput objects.
 */
@Entity(name = "library_details")
@DynamicUpdate
public class Book {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_ISBN")
	private Integer bookISBN;
	@Column(name = "book_name",length = 10,nullable = false)
	private String bookName;
	@Column(name = "book_author",length = 20,nullable = false)
	private String author;
	@Column(name = "NoOfPages")
	private Integer noOfpages;
	@Column(name = "book_Cost")
	private Double bookCost;
	@Column
	private Boolean isPublished;
	@Column
	private Double ratingOfBook;



	
	
	@Override
	public String toString() {
		return "Book [bookISBN=" + bookISBN + ", bookName=" + bookName + ", author=" + author + ", noOfpages="
				+ noOfpages + ", bookCost=" + bookCost + ", isPublished=" + isPublished + ", ratingOfBook="
				+ ratingOfBook + "]";
	}
	public Boolean getIsPublished() {
		return isPublished;
	}
	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}
	public Integer bookISBN() {
		return bookISBN;
	}
	public Integer getBookISBN(){
		return bookISBN;
	}
	public void setbookISBN(Integer bookISBN) {
		this.bookISBN = bookISBN;
	}
	public String bookName() {
		return bookName;
	}
	public String getBookName(){
		return bookName;
	}
	public void setbookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer noOfpages() {
		return noOfpages;
	}
	public Integer getNoOfpages() {
		return noOfpages;
	}
	public void setNoOfpages(Integer noOfpages) {
		this.noOfpages = noOfpages;
	}
	public Double getBookCost() {
		return bookCost;
	}
	public void setBookCost(Double bookCost) {
		this.bookCost = bookCost;
	}
	public Double getRatingOfBook() {
		return ratingOfBook;
	}
	public void setRatingOfBook(Double ratingOfBook) {
		this.ratingOfBook = ratingOfBook;
	}

}


