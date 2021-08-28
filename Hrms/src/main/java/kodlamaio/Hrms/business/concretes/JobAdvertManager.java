package kodlamaio.Hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobAdvertService;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.Hrms.entities.concretes.JobAdvert;
import kodlamaio.Hrms.entities.dtos.JobAdvertAddDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(JobAdvertAddDto jobAdvertAddDto) {
		jobAdvertAddDto.setCreationDate(LocalDate.now());
		JobAdvert jobAdvert = (JobAdvert) dtoConverterService.dtoToEntity(jobAdvertAddDto, JobAdvert.class);
		jobAdvert.setId(jobAdvertAddDto.getId());
		jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Is ilani eklendi");
	}

	@Override
	public List<JobAdvertDto> getByIsActive() {
		return dtoConverterService.entityToDto(jobAdvertDao.getByIsActive(), JobAdvertDto.class);
	}

	@Override
	public List<JobAdvertDto> getAllActiveSortedByDate() {
		Sort sort = Sort.by(Sort.Direction.ASC,"creationDate");
		return dtoConverterService.entityToDto(jobAdvertDao.getAllActiveSortedByDate(sort), JobAdvertDto.class);
	}

	@Override
	public List<JobAdvertDto> getByIsActiveOrderByEmployer(int employerId) {
		return dtoConverterService.entityToDto(jobAdvertDao.getByIsActiveOrderByEmployer(employerId), JobAdvertDto.class);
	}

	@Override
	public Result setIsActiveToPassive(int id) {
		JobAdvert jobAdvertisementId = this.jobAdvertDao.getById(id);
		jobAdvertisementId.setIsActive(false);
		this.jobAdvertDao.save(jobAdvertisementId);
		return new SuccessResult("Is ilani pasif yapildi.");
	}

	@Override
	public List<JobAdvertDto> getById(int id) {
		return dtoConverterService.entityToDto(jobAdvertDao.getByIdentityNumber(id), JobAdvertDto.class);
	}
}
