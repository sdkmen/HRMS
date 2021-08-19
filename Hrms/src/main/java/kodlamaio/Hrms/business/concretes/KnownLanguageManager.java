package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.KnownLanguageService;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.KnownLanguageDao;
import kodlamaio.Hrms.entities.concretes.KnownLanguage;
import kodlamaio.Hrms.entities.dtos.GetKnownLanguageDto;
import kodlamaio.Hrms.entities.dtos.KnownLanguageDto;

@Service
public class KnownLanguageManager implements KnownLanguageService{
	private KnownLanguageDao knownLanguageDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public KnownLanguageManager(KnownLanguageDao knownLanguageDao, DtoConverterService dtoConverterService) {
		super();
		this.knownLanguageDao = knownLanguageDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(KnownLanguageDto knownLanguageDto) {
		KnownLanguage knownLanguage = (KnownLanguage) dtoConverterService.dtoToEntity(knownLanguageDto, KnownLanguage.class);
		knownLanguage.setId(knownLanguageDto.getId());
		knownLanguageDao.save(knownLanguage);
		return new SuccessResult("Dil bilgileri eklendi");
	}

	@Override
	public DataResult<List<GetKnownLanguageDto>> getAll() {
		return new SuccessDataResult<List<GetKnownLanguageDto>>(dtoConverterService.entityToDto(knownLanguageDao.findAll(), GetKnownLanguageDto.class),"Dil bilgileri listelendi");
	}	
	
	
}
