package kodlamaio.Hrms.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.business.abstracts.PictureService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Picture;

@RestController
@RequestMapping("/api/pictures")
@CrossOrigin
public class PicturesController {
	private PictureService pictureService;
	
	@Autowired
	public PicturesController(PictureService pictureService) {
		super();
		this.pictureService = pictureService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestPart MultipartFile image, int candidateId) {
		return this.pictureService.add(image, candidateId);
	}
	
	@GetMapping("/getById")
	public DataResult<Picture> getById(int candidateId){
		return this.pictureService.getById(candidateId);
	}
	
	@GetMapping("/delete")
	public Result delete(int id) throws IOException {
		return this.pictureService.delete(id);
	}
}
