package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CollegeDepartmentService;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CollegeDepartmentDao;
import kodlamaio.Hrms.entities.concretes.CollegeDepartment;
import kodlamaio.Hrms.entities.dtos.CollegeDepartmentDto;

@Service
public class CollegeDepartmentManager implements CollegeDepartmentService{
	private CollegeDepartmentDao collegeDepartmentDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CollegeDepartmentManager(CollegeDepartmentDao collegeDepartmentDao, DtoConverterService dtoConverterService) {
		super();
		this.collegeDepartmentDao = collegeDepartmentDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CollegeDepartmentDto collegeDepartmentDto) {
		CollegeDepartment collegeDepartment = (CollegeDepartment) dtoConverterService.dtoToEntity(collegeDepartmentDto, CollegeDepartment.class);
		collegeDepartment.setId(collegeDepartmentDto.getId());
		collegeDepartmentDao.save(collegeDepartment);
		return new SuccessResult("Bolum adi eklendi");
	}
}
