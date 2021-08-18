package kodlamaio.Hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobAdvertService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.Hrms.entities.concretes.JobAdvert;
import kodlamaio.Hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;
	private ModelMapper modelMapper;
	private List<JobAdvert> jobAdverts;
	private List<JobAdvertDto> dtos;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, ModelMapper modelMapper) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Is ilani eklendi");
	}

	@Override
	public List<JobAdvertDto> getByIsActive() {
		jobAdverts = jobAdvertDao.getByIsActive();
		dtos = jobAdverts.stream().map(jobAdvert -> modelMapper.map(jobAdvert, JobAdvertDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<JobAdvertDto> getAllActiveSortedByDate() {
		Sort sort = Sort.by(Sort.Direction.ASC,"creationDate");
		jobAdverts = jobAdvertDao.getAllActiveSortedByDate(sort);
		dtos = jobAdverts.stream().map(jobAdvert -> modelMapper.map(jobAdvert, JobAdvertDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public List<JobAdvertDto> getByIsActiveOrderByEmployer(int employerId) {
		jobAdverts = jobAdvertDao.getByIsActiveOrderByEmployer(employerId);
		dtos = jobAdverts.stream().map(jobAdvert -> modelMapper.map(jobAdvert, JobAdvertDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public Result setIsActiveToPassive(int id) {
		JobAdvert jobAdvertisementId = this.jobAdvertDao.getById(id);
		jobAdvertisementId.setIsActive(false);
		this.jobAdvertDao.save(jobAdvertisementId);
		return new SuccessResult("Is ilani pasif yapildi.");
	}
}
