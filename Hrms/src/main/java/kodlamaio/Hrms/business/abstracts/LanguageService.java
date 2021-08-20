package kodlamaio.Hrms.business.abstracts;

import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.LanguageDto;

public interface LanguageService {
	Result add(LanguageDto languageDto);
}
