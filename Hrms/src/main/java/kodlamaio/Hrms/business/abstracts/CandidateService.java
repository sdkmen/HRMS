package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.dtos.CandidateDto;
import kodlamaio.Hrms.entities.dtos.GetCandidateDto;

public interface CandidateService {
	Result add(CandidateDto candidateDto);
	DataResult<Candidate> getById(int candidateId);
	DataResult<List<GetCandidateDto>> getAll();
	List<GetCandidateDto> findByCandidateId(int id);
}
