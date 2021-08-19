package kodlamaio.Hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.PictureService;

@RestController
@RequestMapping("/api/pictures")
public class PicturesController {
	private PictureService pictureService;
	
	@Autowired
	public PicturesController(PictureService pictureService) {
		super();
		this.pictureService = pictureService;
	}
}
