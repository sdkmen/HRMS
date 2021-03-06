package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.JobAdvertAddDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	Result add(JobAdvertAddDto jobAdvertAddDto);
	Result setIsActiveToPassive(int id);
	Result setIsConfirmed(int id);
	List<JobAdvertDto> getByIsActive();
	List<JobAdvertDto> getAllActiveSortedByDate();
	List<JobAdvertDto> getByIsActiveOrderByEmployer(int employerId);
	List<JobAdvertDto> getById(int id);
	DataResult<List<JobAdvertDto>> getByNotConfirmed();
	DataResult<List<JobAdvertDto>> getByIsActiveAndIsConfirmed();
}
