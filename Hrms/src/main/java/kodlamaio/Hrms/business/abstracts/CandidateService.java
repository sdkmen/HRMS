package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateService {
	Result add(Candidate candidate);
	DataResult<Candidate> getById(int candidateId);
	DataResult<List<Candidate>> getAll();
}
