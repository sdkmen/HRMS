package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.WorkHourService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.WorkHourDao;
import kodlamaio.Hrms.entities.concretes.WorkHour;

@Service
public class WorkHourManager implements WorkHourService{
	
	private WorkHourDao workHourDao;
	
	@Autowired
	public WorkHourManager(WorkHourDao workHourDao) {
		super();
		this.workHourDao = workHourDao;
	}

	@Override
	public Result add(WorkHour workHour) {
		this.workHourDao.save(workHour);
		return new SuccessResult("Calisma saati turu eklendi");
	}

	@Override
	public DataResult<List<WorkHour>> getAll() {
		return new SuccessDataResult<List<WorkHour>>(this.workHourDao.findAll(), "Calisma saati turleri listelendi");
	}

}
