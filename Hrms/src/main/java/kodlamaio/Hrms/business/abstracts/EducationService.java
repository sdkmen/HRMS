package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.EducationDto;
import kodlamaio.Hrms.entities.dtos.GetEducationDto;

public interface EducationService {
	Result add(EducationDto educationDto);
	DataResult<List<GetEducationDto>> getAll();
	DataResult<List<GetEducationDto>> getAllBySorted();
}
