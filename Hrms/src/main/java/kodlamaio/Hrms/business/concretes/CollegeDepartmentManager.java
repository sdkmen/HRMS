package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CollegeDepartmentService;
import kodlamaio.Hrms.dataAccess.abstracts.CollegeDepartmentDao;

@Service
public class CollegeDepartmentManager implements CollegeDepartmentService{
	private CollegeDepartmentDao collegeDepartmentDao;
	
	@Autowired
	public CollegeDepartmentManager(CollegeDepartmentDao collegeDepartmentDao) {
		super();
		this.collegeDepartmentDao = collegeDepartmentDao;
	}
}
