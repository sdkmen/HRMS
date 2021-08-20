package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.JobExperienceService;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.Hrms.entities.concretes.JobExperience;
import kodlamaio.Hrms.entities.dtos.GetJobExperienceDto;
import kodlamaio.Hrms.entities.dtos.JobExperienceDto;

@Service
public class JobExperienceManager implements JobExperienceService{
	private JobExperienceDao jobExperienceDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao, DtoConverterService dtoConverterService) {
		super();
		this.jobExperienceDao = jobExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		JobExperience jobExperience = (JobExperience) dtoConverterService.dtoToEntity(jobExperienceDto, JobExperience.class);
		jobExperience.setId(jobExperienceDto.getId());
		if(!jobExperience.getIsWorking()) {
			if(jobExperience.getWorkLeftYear() == null) {
				return new ErrorResult("Isten ayrilma yili bos gecilemez");
			}
		}
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("Is bilgileri eklendi");
	}

	@Override
	public DataResult<List<GetJobExperienceDto>> getAllSortedByCandidateId(int candidateId) {
		Sort sort = Sort.by(Sort.Direction.DESC,"workLeftYear");
		return new SuccessDataResult<List<GetJobExperienceDto>>(this.dtoConverterService.entityToDto(jobExperienceDao.findAllSortedByCandidateId(candidateId, sort), GetJobExperienceDto.class),"Is bilgileri ayrilma yilina gore tersten siralandi");
	}

	@Override
	public DataResult<List<GetJobExperienceDto>> getByCandidateId(int candidateId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<GetJobExperienceDto>>(this.dtoConverterService.entityToDto(jobExperienceDao.findAllByCandidateId(candidateId), GetJobExperienceDto.class),"Is bilgileri adaya gore listelendi");
	}
}
