package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobAdvertService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {
	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvert>> getByIsActive() {
		return this.jobAdvertService.getByIsActive();
	}
	
	@GetMapping("/getAllSortedByData")
	public DataResult<List<JobAdvert>> getAllSortedByDate(){
		return this.jobAdvertService.getAllSortedByDate();
	}
	
	@GetMapping("/getByIsActiveOrderEmployer")
	public DataResult<List<JobAdvert>> getByIsActiveOrderByEmployer(int employerId) {
		return this.jobAdvertService.getByIsActiveOrderByEmployer(employerId);
	}
	
	@PostMapping("/setIsActiveToPassive/{id}")
	public Result setIsActiveToPassive(@PathVariable int id) {
		return this.jobAdvertService.setIsActiveToPassive(id);
	}
}
