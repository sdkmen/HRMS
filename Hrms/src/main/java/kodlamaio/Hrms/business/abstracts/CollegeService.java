package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.CollegeDto;

public interface CollegeService {
	Result add(CollegeDto collegeDto);
}
