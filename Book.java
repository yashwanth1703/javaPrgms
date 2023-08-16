package libraryManagement.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.math.BigDecimal;

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
	    @Column(name = "b_ISBN")
	    private Integer bookISBN;
	    @Column(name = "b_name",length = 10,nullable = false)
	    private String bookName;
	    @Column(name = "b_author",length = 20,nullable = false)
	    private String author;
	    @Column(name = "NOP")
        private Integer noOfpages;
	    @Column(name = "cost")
	    private Integer bookCost;
	    @Column
	    private Boolean isPublished;    
	    
	   
	@Override
		public String toString() {
			return "Book [bookISBN=" + bookISBN + ", bookName=" + bookName + ", author=" + author + ", noOfpages="
					+ noOfpages + ", bookCost=" + bookCost + ", isPublished=" + isPublished + "]";
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
	public Integer bookCost(){
	        return bookCost;
	    }
	    public Integer getBookCost(){
	        return bookCost;
	    }
	    public void setBookCost(Integer bookCost){
	        this.bookCost = bookCost;
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
	   
	}


