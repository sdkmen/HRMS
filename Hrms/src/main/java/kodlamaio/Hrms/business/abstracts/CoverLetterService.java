package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.CoverLetterDto;

public interface CoverLetterService {
	Result add(CoverLetterDto coverLetterDto);
	DataResult<List<CoverLetterDto>> getByCandidateId(int candidateId);
}
