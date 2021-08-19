package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CoverLetterService;
import kodlamaio.Hrms.dataAccess.abstracts.CoverLetterDao;

@Service
public class CoverLetterManager implements CoverLetterService{
	private CoverLetterDao coverLetterDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}	
}
