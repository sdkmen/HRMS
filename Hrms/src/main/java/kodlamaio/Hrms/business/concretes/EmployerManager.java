package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.abstracts.EmailVerificationService;
import kodlamaio.Hrms.core.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.Hrms.core.utilities.StringExtensions;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.dtos.EmployerDto;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private EmployeeConfirmEmployerService employeeConfirmEmployerService;
	private DtoConverterService dtoConverterService;
	 
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService
			, EmployeeConfirmEmployerService employeeConfirmEmployerService
			, DtoConverterService dtoConverterService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.employeeConfirmEmployerService = employeeConfirmEmployerService;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(Employer employer) {
		String[] splitEmail = employer.getEmail().split("@");
		
		if(StringExtensions.isNullOrEmpty(employer.getCompanyName(), employer.getEmail(), employer.getPassword()
				, employer.getPasswordAgain(), employer.getPhoneNumber(), employer.getWebAddress())) {
			return new ErrorResult("Bos alan birakilamaz.");
		}
		else if(!this.emailVerificationService.isVerified()) {
			return new ErrorResult("Email dogrulanmamis.");
		}
		else if(!this.employeeConfirmEmployerService.isConfirmedEmployer()) {
			return new ErrorResult("Sistem calisanlari tarafindan hala dogrulanmadiniz.");
		}
		else if(this.employerDao.findByEmail(employer.getEmail()) != null) {
			return new ErrorResult("Email adresi daha onceden kullanilmis.");
		}
		else if(!splitEmail[1].equals(employer.getWebAddress())) {
            return new ErrorResult("Mail adresiniz domain uzantinizi tasimalidir.");
        }
		this.employerDao.save(employer);
		return new SuccessResult("Is veren eklendi.");
	}

	@Override
	public DataResult<List<EmployerDto>> getAll() {
		return new SuccessDataResult<List<EmployerDto>>(dtoConverterService.entityToDto(employerDao.findAll(), EmployerDto.class), "Data listelendi");
	}
	
}
