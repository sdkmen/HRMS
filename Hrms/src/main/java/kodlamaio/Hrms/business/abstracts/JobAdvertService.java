package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvert;
import kodlamaio.Hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
	Result setIsActiveToPassive(int id);
	List<JobAdvertDto> getByIsActive();
	List<JobAdvertDto> getAllActiveSortedByDate();
	List<JobAdvertDto> getByIsActiveOrderByEmployer(int employerId);
}
