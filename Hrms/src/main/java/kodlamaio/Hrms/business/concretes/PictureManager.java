package kodlamaio.Hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.business.abstracts.PictureService;
import kodlamaio.Hrms.dataAccess.abstracts.PictureDao;

@Service
public class PictureManager implements PictureService{
	private PictureDao pictureDao;
	
	@Autowired
	public PictureManager(PictureDao pictureDao) {
		super();
		this.pictureDao = pictureDao;
	}
}
