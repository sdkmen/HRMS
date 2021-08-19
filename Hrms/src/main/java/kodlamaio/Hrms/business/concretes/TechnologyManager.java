package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.TechnologyService;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.Hrms.entities.concretes.Technology;
import kodlamaio.Hrms.entities.dtos.TechnologyDto;

@Service
public class TechnologyManager implements TechnologyService{
	private TechnologyDao technologyDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao, DtoConverterService dtoConverterService) {
		super();
		this.technologyDao = technologyDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(TechnologyDto technologyDto) {
		Technology technology = (Technology) dtoConverterService.dtoToEntity(technologyDto, Technology.class);
		technology.setId(technologyDto.getId());
		technologyDao.save(technology);
		return new SuccessResult("Teknoloji eklendi");
	}

	@Override
	public DataResult<List<TechnologyDto>> getAll() {
		return new SuccessDataResult<List<TechnologyDto>>(dtoConverterService.entityToDto(technologyDao.findAll(), TechnologyDto.class),"Teknolojiler listelendi");
	}
}
