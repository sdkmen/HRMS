package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate findByEmail(String email);
	Candidate findByIdentityNumber(String identityNumber);
	
	@Query("FROM Candidate where id=:id")
	List<Candidate> findByCandidateId(int id);
}
