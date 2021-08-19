package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.CollegeService;
import kodlamaio.Hrms.dataAccess.abstracts.CollegeDao;

@Service
public class CollegeManager implements CollegeService{
	private CollegeDao collegeDao;
	
	@Autowired
	public CollegeManager(CollegeDao collegeDao) {
		super();
		this.collegeDao = collegeDao;
	}
}
