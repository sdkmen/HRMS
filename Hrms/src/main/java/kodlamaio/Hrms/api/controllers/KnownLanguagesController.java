package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.KnownLanguageService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.GetKnownLanguageDto;
import kodlamaio.Hrms.entities.dtos.KnownLanguageDto;

@RestController
@RequestMapping("/api/knownlanguages")
@CrossOrigin
public class KnownLanguagesController {
	private KnownLanguageService knownLanguageService;
	
	@Autowired
	public KnownLanguagesController(KnownLanguageService knownLanguageService) {
		super();
		this.knownLanguageService = knownLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody KnownLanguageDto knownLanguageDto) {
		return this.knownLanguageService.add(knownLanguageDto);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<GetKnownLanguageDto>> getByCandidateId(int candidateId) {
		return this.knownLanguageService.getByCandidateId(candidateId);
	}
}
