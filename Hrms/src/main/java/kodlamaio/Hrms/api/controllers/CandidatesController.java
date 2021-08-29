package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;
import kodlamaio.Hrms.entities.dtos.CandidateDto;
import kodlamaio.Hrms.entities.dtos.GetCandidateDto;

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
	public DataResult<List<GetCandidateDto>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/addCandidate")
	public Result add(@RequestBody CandidateDto candidateDto) {
		return this.candidateService.add(candidateDto);
	}
	
	@GetMapping("/getById")
	public DataResult<Candidate> getById(int candidateId) {
		return this.candidateService.getById(candidateId);
	}
	
	@GetMapping("/getByCandidateId/{id}")
	public List<GetCandidateDto> findByCandidateId(@PathVariable int id) {
		return this.candidateService.findByCandidateId(id);
	}
}
