package libraryManagement.ServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryManagement.Model.CardDetails;
import libraryManagement.Model.LibraryUser;
import libraryManagement.Repository.CardRepository;

@Service
public class CardServiceImpl {
@Autowired
 private CardRepository cardRepo;

public CardDetails createCard(LibraryUser user) {
	CardDetails card = new CardDetails();
	user.setCard(card);
	card.setStudent(user);
	cardRepo.save(card);
	return card;
}
}
