package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getCandidates")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/addCandidate")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	@GetMapping("/getById")
	public DataResult<Candidate> getById(int candidateId) {
		return this.candidateService.getById(candidateId);
	}
}
