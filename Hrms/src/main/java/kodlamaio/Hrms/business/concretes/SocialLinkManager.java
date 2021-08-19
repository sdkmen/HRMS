package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.SocialLinkService;
import kodlamaio.Hrms.dataAccess.abstracts.SocialLinkDao;

@Service
public class SocialLinkManager implements SocialLinkService{
	private SocialLinkDao socialLinkDao;
	
	@Autowired
	public SocialLinkManager(SocialLinkDao socialLinkDao) {
		super();
		this.socialLinkDao = socialLinkDao;
	}
}
