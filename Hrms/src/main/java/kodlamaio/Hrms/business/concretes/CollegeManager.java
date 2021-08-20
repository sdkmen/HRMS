package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CollegeService;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CollegeDao;
import kodlamaio.Hrms.entities.concretes.College;
import kodlamaio.Hrms.entities.dtos.CollegeDto;

@Service
public class CollegeManager implements CollegeService{
	private CollegeDao collegeDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CollegeManager(CollegeDao collegeDao, DtoConverterService dtoConverterService) {
		super();
		this.collegeDao = collegeDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CollegeDto collegeDto) {
		College college = (College) dtoConverterService.dtoToEntity(collegeDto, College.class);
		college.setId(collegeDto.getId());
		collegeDao.save(college);
		return new SuccessResult("Okul adi eklendi");
	}
}
