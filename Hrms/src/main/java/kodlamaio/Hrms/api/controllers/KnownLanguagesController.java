package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.KnownLanguageService;

@RestController
@RequestMapping("/api/knownlanguages")
public class KnownLanguagesController {
	private KnownLanguageService knownLanguageService;
	
	@Autowired
	public KnownLanguagesController(KnownLanguageService knownLanguageService) {
		super();
		this.knownLanguageService = knownLanguageService;
	}
}
