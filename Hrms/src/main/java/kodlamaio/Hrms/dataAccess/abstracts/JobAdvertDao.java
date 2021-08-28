package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;

import kodlamaio.Hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{
	@Query("FROM JobAdvert where is_active = true")
	List<JobAdvert> getByIsActive();
	
	@Query("FROM JobAdvert where is_active = true")
	List<JobAdvert> getAllActiveSortedByDate(Sort sort);
	
	@Query("FROM JobAdvert where is_active = true and employer.id=:employerId")
	List<JobAdvert> getByIsActiveOrderByEmployer(int employerId);
	
	@Query("FROM JobAdvert where id=:id")
	List<JobAdvert> getByIdentityNumber(int id);
}
