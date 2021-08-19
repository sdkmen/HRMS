package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.SocialLinkService;

@RestController
@RequestMapping("/api/sociallinks")
public class SocialLinksController {
	private SocialLinkService socialLinkService;
	
	@Autowired
	public SocialLinksController(SocialLinkService socialLinkService) {
		super();
		this.socialLinkService = socialLinkService;
	}
}
