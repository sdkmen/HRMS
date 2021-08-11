package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.abstracts.EmailVerificationService;
import kodlamaio.Hrms.core.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.Hrms.core.utilities.StringExtensions;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.Hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private EmployeeConfirmEmployerService employeeConfirmEmployerService;
	 
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailVerificationService emailVerificationService
			, EmployeeConfirmEmployerService employeeConfirmEmployerService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.employeeConfirmEmployerService = employeeConfirmEmployerService;
	}

	@Override
	public Result add(Employer employer) {
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
		this.employerDao.save(employer);
		return new SuccessResult("Is veren eklendi.");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Is verenler listelendi.");
	}
	
}
