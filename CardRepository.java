package libraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import libraryManagement.Model.CardDetails;

public interface CardRepository extends JpaRepository<CardDetails,Integer> {

}
