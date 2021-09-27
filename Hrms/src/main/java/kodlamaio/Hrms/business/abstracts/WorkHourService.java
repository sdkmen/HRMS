package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.WorkHour;

public interface WorkHourService {
	Result add(WorkHour workHour);
	DataResult<List<WorkHour>> getAll();
}
