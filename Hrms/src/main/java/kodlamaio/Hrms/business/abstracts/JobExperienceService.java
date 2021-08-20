package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.GetJobExperienceDto;
import kodlamaio.Hrms.entities.dtos.JobExperienceDto;

public interface JobExperienceService {
	Result add(JobExperienceDto jobExperienceDto);
	DataResult<List<GetJobExperienceDto>> getByCandidateId(int candidateId);
	DataResult<List<GetJobExperienceDto>> getAllSortedByCandidateId(int candidateId);
}
