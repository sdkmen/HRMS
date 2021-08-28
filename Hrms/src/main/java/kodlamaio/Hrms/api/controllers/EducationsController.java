package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.EducationService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.EducationDto;
import kodlamaio.Hrms.entities.dtos.GetEducationDto;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
	private EducationService educationService;
	
	@Autowired
	public EducationsController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EducationDto educationDto) {
		return this.educationService.add(educationDto);
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<List<GetEducationDto>> getByCandidateId(int candidateId) {
		return this.educationService.getByCandidateId(candidateId);
	}
	
	@GetMapping("/getAllSortedByCandidateId")
	public DataResult<List<GetEducationDto>> getAllSortedByCandidateId(int candidateId) {
		return this.educationService.getAllSortedByCandidateId(candidateId);
	}
}
