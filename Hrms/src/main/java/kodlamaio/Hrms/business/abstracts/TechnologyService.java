package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.TechnologyDto;

public interface TechnologyService {
	Result add(TechnologyDto technologyDto);
	DataResult<List<TechnologyDto>> getAll();
}
