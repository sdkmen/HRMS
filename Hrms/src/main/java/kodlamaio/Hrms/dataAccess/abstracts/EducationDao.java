package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer>{
	List<Education> findAllByCandidateId(int candidateId);
	List<Education> findAllSortedByCandidateId(int candidateId, Sort sort);
}
