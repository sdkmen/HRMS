package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CoverLetterService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.CoverLetterDto;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersController {
	private CoverLetterService coverLetterService;
	
	@Autowired
	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetterDto coverLetterDto) {
		return this.coverLetterService.add(coverLetterDto);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<CoverLetterDto>> getByCandidateId(int candidateId) {
		return this.coverLetterService.getByCandidateId(candidateId);
	}
}
