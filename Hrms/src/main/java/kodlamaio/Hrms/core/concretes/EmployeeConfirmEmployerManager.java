package kodlamaio.Hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.core.abstracts.EmployeeConfirmEmployerService;

@Service
public class EmployeeConfirmEmployerManager implements EmployeeConfirmEmployerService{

	@Override
	public boolean confirmEmployer() {
		return true;
	}

}
