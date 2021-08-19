package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.SocialLinkService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.SocialLinkDto;

@RestController
@RequestMapping("/api/sociallinks")
public class SocialLinksController {
	private SocialLinkService socialLinkService;
	
	@Autowired
	public SocialLinksController(SocialLinkService socialLinkService) {
		super();
		this.socialLinkService = socialLinkService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody SocialLinkDto socialLinkDto) {
		return this.socialLinkService.add(socialLinkDto);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<SocialLinkDto>> getByCandidateId(int candidateId) {
		return this.socialLinkService.getByCandidateId(candidateId);
	}
}
