package kodlamaio.Hrms.core.abstracts;

public interface EmailVerificationService {
	void sendVerificationCode(String verificationCode);
	void verifyEmail();
	boolean isVerified();
}
