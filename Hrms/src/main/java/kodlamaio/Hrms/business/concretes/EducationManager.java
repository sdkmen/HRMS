package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EducationService;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.Hrms.entities.concretes.Education;
import kodlamaio.Hrms.entities.dtos.EducationDto;
import kodlamaio.Hrms.entities.dtos.GetEducationDto;

@Service
public class EducationManager implements EducationService{
	private EducationDao educationDao;
	private DtoConverterService dtoConverterService;

	@Autowired
	public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
		super();
		this.educationDao = educationDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(EducationDto educationDto) {
		Education education = (Education) dtoConverterService.dtoToEntity(educationDto, Education.class);
		education.setId(educationDto.getId());
		if(education.getIsGraduated()) {
			if(education.getCollegeGraduatedYear() == null) {
				return new ErrorResult("Mezuniyet yili bos gecilemez");
			}
		}
		this.educationDao.save(education);
		return new SuccessResult("Egitim bilgileri eklendi");
	}

	@Override
	public DataResult<List<GetEducationDto>> getAll() {
		return new SuccessDataResult<List<GetEducationDto>>(this.dtoConverterService.entityToDto(educationDao.findAll(), GetEducationDto.class),"Egitim bilgileri listelendi");
	}

	@Override
	public DataResult<List<GetEducationDto>> getAllBySorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"collegeGraduatedYear");
		return new SuccessDataResult<List<GetEducationDto>>(this.dtoConverterService.entityToDto(educationDao.findAll(sort), GetEducationDto.class),"Mezuniyet yilina gore tersten listelendi");
	}
}
