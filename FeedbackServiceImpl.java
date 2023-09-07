package libraryManagement.ServiceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryManagement.Model.Book;
import libraryManagement.Model.Feedback;
import libraryManagement.Model.LibraryUser;
import libraryManagement.Repository.FeedbackRepository;
import libraryManagement.Repository.LibraryRepository;
import libraryManagement.Repository.LibraryUserRepository;
import libraryManagement.Service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired	
	private FeedbackRepository feedBackRepository;
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private LibraryUserRepository libUserRepo;

	//good book/3/1
	@Override
	public Feedback addFeedBack(Feedback feedBack, Integer bookId, Integer userId) throws Exception {
		
			
			Optional<Book> bookObj = libraryRepository.findById(bookId);
			if (bookObj.isEmpty()) {
				throw new Exception("Bus is not present with Id: "+ bookId);
			}
			Optional<LibraryUser> user = libUserRepo.findById(userId);//.orElseThrow(()-> new UserException("User not found!"));
			if (user.isEmpty()) {
				throw new Exception("Book is not present with Id: "+ bookId);
			}
			feedBack.setBook(bookObj.get());
			feedBack.setUser(user.get());
			Feedback savedFeedback = feedBackRepository.save(feedBack);

			return savedFeedback;
			}


	@Override
	public Feedback deleteFeedBack(Integer feedbackId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback viewFeedback(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewFeedbackAll() {
		// TODO Auto-generated method stub
	return null;
	}

}