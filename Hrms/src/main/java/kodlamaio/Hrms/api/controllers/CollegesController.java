package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CollegeService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.CollegeDto;

@RestController
@RequestMapping("/api/colleges")
@CrossOrigin
public class CollegesController {
	private CollegeService collegeService;
	
	@Autowired
	public CollegesController(CollegeService collegeService) {
		super();
		this.collegeService = collegeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CollegeDto collegeDto) {
		return this.collegeService.add(collegeDto);
	}
}
