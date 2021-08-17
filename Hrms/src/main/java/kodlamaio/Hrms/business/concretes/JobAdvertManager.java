package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobAdvertService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.Hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Is ilani eklendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActive(),"Aktif is ilanlari listelendi.");
	}

	@Override
	public DataResult<List<JobAdvert>> getAllSortedByDate() {
		Sort sort = Sort.by(Sort.Direction.ASC,"creationDate");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort),"Tarihe gore siralandi.");
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsActiveOrderByEmployer(int employerId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveOrderByEmployer(employerId),"Is verene gore aktif ilanlar siralandi.");
	}

	@Override
	public Result setIsActiveToPassive(int id) {
		JobAdvert jobAdvertisementId = this.jobAdvertDao.getById(id);
		jobAdvertisementId.setIsActive(false);
		this.jobAdvertDao.save(jobAdvertisementId);
		return new SuccessResult("Is ilani pasif yapildi.");
	}
}
