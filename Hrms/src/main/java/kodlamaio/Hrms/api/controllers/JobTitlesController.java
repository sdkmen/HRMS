package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.JobTitleService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitlesController {
	
	private JobTitleService jobPositionService;

	@Autowired
	public JobTitlesController(JobTitleService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getalltitle")
	public DataResult<List<JobTitle>> getAllTitle(){
		return this.jobPositionService.getAllTitle();
	}
	
	@PostMapping("/addTitle")
	public Result add(@RequestBody JobTitle jobTitle) {
		return this.jobPositionService.add(jobTitle);
	}
	
}
