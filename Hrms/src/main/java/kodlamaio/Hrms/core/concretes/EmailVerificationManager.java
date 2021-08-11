package kodlamaio.Hrms.core.concretes;

import kodlamaio.Hrms.core.abstracts.EmailVerificationService;

public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public void sendVerificationCode(String verificationCode) {
		
	}

	@Override
	public void verifyEmail() {
			
	}

	@Override
	public boolean isVerified() {
		return true;
	}

}
