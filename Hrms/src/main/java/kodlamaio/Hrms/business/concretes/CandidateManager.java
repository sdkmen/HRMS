package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.abstracts.EmailVerificationService;
import kodlamaio.Hrms.core.abstracts.MernisVerificationService;
import kodlamaio.Hrms.core.utilities.StringExtensions;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.dtos.CandidateDto;
import kodlamaio.Hrms.entities.dtos.GetCandidateDto;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	private EmailVerificationService emailVerificationService;
	private MernisVerificationService mernisVerificationService;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailVerificationService emailVerificationService, 
			MernisVerificationService mernisVerificationService, DtoConverterService dtoConverterService) {
		super();
		this.candidateDao = candidateDao;
		this.emailVerificationService = emailVerificationService;
		this.mernisVerificationService = mernisVerificationService;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(CandidateDto candidateDto) {
		if(StringExtensions.isNullOrEmpty(candidateDto.getFirstName(), candidateDto.getLastName(), candidateDto.getEmail(), candidateDto.getPassword()
				, candidateDto.getPasswordAgain(), String.valueOf(candidateDto.getBirthOfYear()), candidateDto.getIdentityNumber())) {
			return new ErrorResult("Bos alan birakilamaz.");
		}
		else if(!mernisVerificationService.checkIfRealPerson()) {
			return new ErrorResult("Hatali bilgi girisi.");
		}
		else if(this.candidateDao.findByEmail(candidateDto.getEmail()) != null ||
				this.candidateDao.findByIdentityNumber(candidateDto.getIdentityNumber()) != null) {
			return new ErrorResult("Bilgiler daha onceden kullanilmis.");
		}
		else if(!emailVerificationService.isVerified()) {
			return new ErrorResult("Email dogrulanmamis.");
		}
		else if(!candidateDto.getPassword().equals(candidateDto.getPasswordAgain())) {
			return new ErrorResult("Sifreler eslesmiyor.");
		}
		Candidate candidate = (Candidate) dtoConverterService.dtoToEntity(candidateDto, Candidate.class);
		candidate.setId(candidateDto.getId());
		this.candidateDao.save(candidate);
		return new SuccessResult("Aday eklendi.");	
	}

	@Override
	public DataResult<List<GetCandidateDto>> getAll() {
		return new SuccessDataResult<List<GetCandidateDto>>(dtoConverterService.entityToDto(candidateDao.findAll(), GetCandidateDto.class), "Data listelendi");
	}

	@Override
	public DataResult<Candidate> getById(int candidateId) {
		return new SuccessDataResult<Candidate>(candidateDao.findById(candidateId).get(), "Data getirildi");
	}

	@Override
	public List<GetCandidateDto> findByCandidateId(int id) {
		return dtoConverterService.entityToDto(candidateDao.findByCandidateId(id), GetCandidateDto.class);
	}

}
