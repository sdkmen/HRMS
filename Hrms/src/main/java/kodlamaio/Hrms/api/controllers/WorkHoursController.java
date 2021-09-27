package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.WorkHourService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.WorkHour;

@RestController
@RequestMapping("/api/workhours")
@CrossOrigin
public class WorkHoursController {
	private WorkHourService workHourService;
	
	@Autowired
	public WorkHoursController(WorkHourService workHourService) {
		super();
		this.workHourService = workHourService;
	}
	
	@PostMapping("/addWorkHour")
	public Result add(@RequestBody WorkHour workHour) {
		return this.workHourService.add(workHour);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkHour>> getAll() {
		return this.workHourService.getAll();
	}
}
