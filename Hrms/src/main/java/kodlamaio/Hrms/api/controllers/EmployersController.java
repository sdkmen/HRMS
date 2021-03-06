package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.EmployerService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Employer;
import kodlamaio.Hrms.entities.dtos.EmployerDto;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
	private EmployerService employerService;
	
	public EmployersController() {
			}
	
	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getEmployers")
	public DataResult<List<EmployerDto>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/addEmployer")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
}
