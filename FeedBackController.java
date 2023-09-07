package libraryManagement.Controller;
import java.util.List;
import jakarta.validation.Valid;
import libraryManagement.Model.Feedback;
import libraryManagement.Service.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/feedback")
public class FeedBackController {
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/add/{bookid}/{userId}")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback,
												@PathVariable("bookid") int bookid,@PathVariable("userId")Integer userId) throws Exception{
		
		Feedback feedback2 = feedbackService.addFeedBack(feedback, bookid, userId);
		
		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
		
	}
}
////	@GetMapping("/feedback/{id}")
////	public ResponseEntity<Feedback> viewFeedback(@PathVariable("id") Integer ID) {
////		
////		Feedback feedback2 = feedbackService.viewFeedback(ID);
////		
////		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
////		
////	}
////	@GetMapping("/feedback/all")
////	public ResponseEntity<List<Feedback>> viewFeedbackAll()  {
////		
////		List<Feedback> feedback2 =  feedbackService.viewFeedbackAll();
////		
////		return new ResponseEntity<List<Feedback>>(feedback2,HttpStatus.ACCEPTED);
////		
////	}
////	@DeleteMapping("feedback/delete/{id}")
////	public ResponseEntity<Feedback> deleteFeedback(@PathVariable("id") Integer feedbackId) throws FeedBackException, UserException {
////		
////		Feedback feedback2 = feedbackService.deleteFeedBack(feedbackId);
////		
////		return new ResponseEntity<Feedback>(feedback2,HttpStatus.ACCEPTED);
////		
////	}
////}
