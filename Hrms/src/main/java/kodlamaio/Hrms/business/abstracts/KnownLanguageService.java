package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.GetKnownLanguageDto;
import kodlamaio.Hrms.entities.dtos.KnownLanguageDto;

public interface KnownLanguageService {
	Result add(KnownLanguageDto knownLanguageDto);
	DataResult<List<GetKnownLanguageDto>> getAll();
}
