package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobTitleService;
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
	public List<JobTitle> getAllTitle() {
		return this.jobPositionDao.findAll();
	}

}
