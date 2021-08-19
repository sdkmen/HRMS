package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.CollegeDepartmentDto;

public interface CollegeDepartmentService {
	Result add(CollegeDepartmentDto collegeDepartmentDto);
}
