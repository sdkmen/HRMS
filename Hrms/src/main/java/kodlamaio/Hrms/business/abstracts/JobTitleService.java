package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	DataResult<List<JobTitle>> getAllTitle();
	Result add(JobTitle jobTitle);
}
