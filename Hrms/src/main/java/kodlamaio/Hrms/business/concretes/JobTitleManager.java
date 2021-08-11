package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobTitleService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.Hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleDao jobPositionDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAllTitle() {
		return new SuccessDataResult<List<JobTitle>>(this.jobPositionDao.findAll(), "Is pozisyonlari listelendi.");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		this.jobPositionDao.save(jobTitle);
		return new SuccessResult("Is pozisyonu eklendi.");
	}

}
