package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
	Result setIsActiveToPassive(int id);
	DataResult<List<JobAdvert>> getByIsActive();
	DataResult<List<JobAdvert>> getAllSortedByDate();
	DataResult<List<JobAdvert>> getByIsActiveOrderByEmployer(int employerId);
}
