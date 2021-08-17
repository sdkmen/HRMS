package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.Hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	@Query("SELECT new kodlamaio.Hrms.entities.dtos.JobAdvertDto(j.id, e.companyName, t.jobTitle, j.freePositionNo, j.creationDate, j.deadline) "
			+ "FROM JobAdvert j Inner Join j.employer e Inner Join j.jobTitle t WHERE j.isActive=true")
	List<JobAdvert> getByIsActive();
	
	@Query("FROM JobAdvert where is_active = true and employer.id =: employerId")
	List<JobAdvert> getByIsActiveOrderByEmployer(int employerId);
}
