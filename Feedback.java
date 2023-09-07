//package libraryManagement.Model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//@Entity
//public class Feedback {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer feedBackId;
//	
//	
//	@Override
//	public String toString() {
//		return "Feedback [feedBackId=" + feedBackId + ", bookRating=" + bookRating + ", overallRating=" + overallRating
//				+ ", comments=" + comments + ", user=" + user + ", book=" + book + "]";
//	}
//
//	public Integer getFeedBackId() {
//		return feedBackId;
//	}
//
//	public void setFeedBackId(Integer feedBackId) {
//		this.feedBackId = feedBackId;
//	}
//
//	public Integer getBookRating() {
//		return bookRating;
//	}
//
//	public void setBookRating(Integer bookRating) {
//		this.bookRating = bookRating;
//	}
//
//	public Integer getOverallRating() {
//		return overallRating;
//	}
//
//	public void setOverallRating(Integer overallRating) {
//		this.overallRating = overallRating;
//	}
//
//	public String getComments() {
//		return comments;
//	}
//
//	public void setComments(String comments) {
//		this.comments = comments;
//	}
//
//	public LibraryUser getUser() {
//		return user;
//	}
//
//	public void setUser(LibraryUser user) {
//		this.user = user;
//	}
//
//	public Book getBook() {
//		return book;
//	}
//
//	public void setBook(Book book) {
//		this.book = book;
//	}
//
//	@Min(value=1, message="Rating must be in range of 1-5")
//	@Max(value=5, message="Rating must be in range of 1-5")
//	private Integer bookRating;
//	
//	@Min(value=1, message="Rating must be in range of 1-5")
//	@Max(value=5, message="Rating must be in range of 1-5")
//	private Integer overallRating;
//	
//	private String comments;
//
//	
//	@OneToOne
//	private LibraryUser user;
//	
//	@OneToOne
//	private Book book;
//}
