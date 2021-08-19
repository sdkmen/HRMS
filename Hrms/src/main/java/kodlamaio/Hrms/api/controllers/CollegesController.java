package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CollegeService;

@RestController
@RequestMapping("/api/colleges")
public class CollegesController {
	private CollegeService collegeService;
	
	@Autowired
	public CollegesController(CollegeService collegeService) {
		super();
		this.collegeService = collegeService;
	}
}
