package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.KnownLanguageService;
import kodlamaio.Hrms.dataAccess.abstracts.KnownLanguageDao;

@Service
public class KnownLanguageManager implements KnownLanguageService{
	private KnownLanguageDao knownLanguageDao;
	
	@Autowired
	public KnownLanguageManager(KnownLanguageDao knownLanguageDao) {
		super();
		this.knownLanguageDao = knownLanguageDao;
	}	
}
