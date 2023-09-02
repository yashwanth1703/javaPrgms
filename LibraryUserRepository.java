package libraryManagement.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import libraryManagement.Model.LibraryUser;

public interface LibraryUserRepository extends JpaRepository<LibraryUser,Long>{
	@Query(value = "SELECT * FROM LIBRARY_USER lu WHERE lu.user_email = ?1",nativeQuery = true  )
	public Optional<LibraryUser> findByuserEmail(String email);
	@Query(value = "SELECT * FROM LIBRARY_USER lu WHERE lu.user_email = ?1 AND u.user_password = ?2 ",nativeQuery = true  )
	public Optional<LibraryUser> findByuserEmailAndPassword(String email, String password);
}
