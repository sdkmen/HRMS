package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.abstracts.EmailVerificationService;
import kodlamaio.Hrms.core.abstracts.MernisVerificationService;
import kodlamaio.Hrms.core.utilities.StringExtensions;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private EmailVerificationService emailVerificationService;
	private MernisVerificationService mernisVerificationService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailVerificationService emailVerificationService, MernisVerificationService mernisVerificationService) {
		super();
		this.candidateDao = candidateDao;
		this.emailVerificationService = emailVerificationService;
		this.mernisVerificationService = mernisVerificationService;
	}

	@Override
	public Result add(Candidate candidate) {
		if(StringExtensions.isNullOrEmpty(candidate.getFirstName(), candidate.getLastName(), candidate.getEmail(), candidate.getPassword()
				, candidate.getPasswordAgain(), String.valueOf(candidate.getBirthOfYear()), candidate.getIdentityNumber())) {
			return new ErrorResult("Bos alan birakilamaz.");
		}
		else if(!mernisVerificationService.checkIfRealPerson()) {
			return new ErrorResult("Hatali bilgi girisi.");
		}
		else if(this.candidateDao.findByEmail(candidate.getEmail()) != null ||
				this.candidateDao.findByIdentityNumber(candidate.getIdentityNumber()) != null) {
			return new ErrorResult("Bilgiler daha onceden kullanilmis.");
		}
		else if(!emailVerificationService.isVerified()) {
			return new ErrorResult("Email dogrulanmamis.");
		}
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday eklendi.");	
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Adaylar listelendi.");
	}

	@Override
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(candidateId), "Aday listelendi");
	}

}
