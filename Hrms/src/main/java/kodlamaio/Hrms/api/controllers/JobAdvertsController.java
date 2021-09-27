package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobAdvertService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.JobAdvertAddDto;
import kodlamaio.Hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobadverts")
@CrossOrigin
public class JobAdvertsController {
	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertAddDto jobAdvertAddDto) {
		return this.jobAdvertService.add(jobAdvertAddDto);
	}
	
	@GetMapping("/getByIsActive")
	public ResponseEntity<List<JobAdvertDto>> getByIsActive() {
		return ResponseEntity.ok(jobAdvertService.getByIsActive());
	}
	
	@GetMapping("/getAllActiveSortedByDate")
	public ResponseEntity<List<JobAdvertDto>> getAllActiveSortedByDate(){ 
		return ResponseEntity.ok(jobAdvertService.getAllActiveSortedByDate());
	}
	
	@GetMapping("/getByIsActiveOrderEmployer")
	public ResponseEntity<List<JobAdvertDto>> getByIsActiveOrderByEmployer(int employerId) {
		return ResponseEntity.ok(jobAdvertService.getByIsActiveOrderByEmployer(employerId));
	}
	
	@PostMapping("/setIsActiveToPassive/{id}")
	public Result setIsActiveToPassive(@PathVariable int id) {
		return this.jobAdvertService.setIsActiveToPassive(id);
	}
	
	@GetMapping("/getById/{id}")
	public List<JobAdvertDto> getById(@PathVariable int id) {
		return this.jobAdvertService.getById(id);
	}
	
	@PostMapping("/setIsConfirmed")
	public Result setIsConfirmed(int id) {
		return this.jobAdvertService.setIsConfirmed(id);
	}
	
	@GetMapping("/getByNotConfirmed")
	public DataResult<List<JobAdvertDto>> getByNotConfirmed() {
		return this.jobAdvertService.getByNotConfirmed();
	}
	
	@GetMapping("/getByIsActiveAndIsConfirmed")
	public DataResult<List<JobAdvertDto>> getByIsActiveAndIsConfirmed() {
		return this.jobAdvertService.getByIsActiveAndIsConfirmed();
	}
}
