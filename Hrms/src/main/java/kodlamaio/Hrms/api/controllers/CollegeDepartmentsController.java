package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CollegeDepartmentService;

@RestController
@RequestMapping("/api/collegedepartmens")
public class CollegeDepartmentsController {
	private CollegeDepartmentService collegeDepartmentService;
	
	@Autowired
	public CollegeDepartmentsController(CollegeDepartmentService collegeDepartmentService) {
		super();
		this.collegeDepartmentService = collegeDepartmentService;
	}
}
