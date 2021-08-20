package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CollegeDepartmentService;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.dtos.CollegeDepartmentDto;

@RestController
@RequestMapping("/api/collegedepartmens")
public class CollegeDepartmentsController {
	private CollegeDepartmentService collegeDepartmentService;
	
	@Autowired
	public CollegeDepartmentsController(CollegeDepartmentService collegeDepartmentService) {
		super();
		this.collegeDepartmentService = collegeDepartmentService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CollegeDepartmentDto collegeDepartmentDto) {
		return this.collegeDepartmentService.add(collegeDepartmentDto);
	}
}
