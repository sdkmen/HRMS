package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CoverLetterService;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.Hrms.entities.concretes.CoverLetter;
import kodlamaio.Hrms.entities.dtos.CoverLetterDto;

@Service
public class CoverLetterManager implements CoverLetterService{
	private CoverLetterDao coverLetterDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao, DtoConverterService dtoConverterService) {
		super();
		this.coverLetterDao = coverLetterDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CoverLetterDto coverLetterDto) {
		CoverLetter coverLetter = (CoverLetter) dtoConverterService.dtoToEntity(coverLetterDto, CoverLetter.class);
		coverLetter.setId(coverLetterDto.getId());
		coverLetterDao.save(coverLetter);
		return new SuccessResult("On yazi eklendi");
	}

	@Override
	public DataResult<List<CoverLetterDto>> getAll() {
		return new SuccessDataResult<List<CoverLetterDto>>(dtoConverterService.entityToDto(coverLetterDao.findAll(), CoverLetterDto.class),"On yazilar listelendi");
	}	
}
