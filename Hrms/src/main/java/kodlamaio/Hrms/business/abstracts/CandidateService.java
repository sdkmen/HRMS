package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;

public interface CandidateService {
	Result add(Candidate candidate);
}
