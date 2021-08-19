package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.LanguageService;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.Hrms.entities.concretes.Language;
import kodlamaio.Hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService{
	private LanguageDao languageDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao, DtoConverterService dtoConverterService) {
		super();
		this.languageDao = languageDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(LanguageDto languageDto) {
		Language language = (Language) dtoConverterService.dtoToEntity(languageDto, Language.class);
		language.setId(languageDto.getId());
		languageDao.save(language);
		return new SuccessResult("Yeni dil eklendi");
	}
}
