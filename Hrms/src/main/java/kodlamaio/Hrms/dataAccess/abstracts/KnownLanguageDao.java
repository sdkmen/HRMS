package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.KnownLanguage;

public interface KnownLanguageDao extends JpaRepository<KnownLanguage, Integer>{
	List<KnownLanguage> findAllByCandidateId(int candidateId);
}
