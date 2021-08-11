package kodlamaio.Hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.Hrms.core.abstracts.MernisVerificationService;

@Service
public class MernisVerificationManager implements MernisVerificationService{

	@Override
	public boolean checkIfRealPerson() {
		return true;
	}

}
