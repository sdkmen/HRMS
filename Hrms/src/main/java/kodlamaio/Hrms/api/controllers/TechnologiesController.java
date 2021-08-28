package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.TechnologyService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.TechnologyDto;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin
public class TechnologiesController {
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody TechnologyDto technologyDto) {
		return this.technologyService.add(technologyDto);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<TechnologyDto>> getByCandidateId(int candidateId) {
		return this.technologyService.getByCandidateId(candidateId);
	}
}
