package libraryManagement.ServiceImplementation;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import libraryManagement.Model.LibraryUser;
import libraryManagement.Repository.LibraryUserRepository;
@Service
public class LibraryUserImplementation {
@Autowired
private LibraryUserRepository libraryUserRepository;

 public void addUser(LibraryUser libUser) {
	 this.libraryUserRepository.save(libUser);
 }
 public Optional<LibraryUser> getUserByEmail(String email){
	 return this.libraryUserRepository.findByuserEmail(email);
 }
}
