package kodlamaio.Hrms.business.concretes;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.business.abstracts.PictureService;
import kodlamaio.Hrms.core.adapters.CloudService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.PictureDao;
import kodlamaio.Hrms.entities.concretes.Picture;

@Service
public class PictureManager implements PictureService{
	private PictureDao pictureDao;
	private CloudService cloudService;
	private CandidateService candidateService;
	
	@Autowired
	public PictureManager(PictureDao pictureDao, CloudService cloudService, CandidateService candidateService) {
		super();
		this.pictureDao = pictureDao;
		this.cloudService = cloudService;
		this.candidateService = candidateService;
	}

	@Override
	public Result add(MultipartFile multipartFile, int candidateId) {
		var result=this.cloudService.upload(multipartFile);
		if(!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		var candidate = this.candidateService.getById(candidateId).getData();
		Picture picture = new Picture();
		picture.setCandidate(candidate);
		picture.setPictureUrl(result.getData().get("url"));
		picture.setPublicId(result.getData().get("public_id"));
		this.pictureDao.save(picture);
		return new SuccessResult("Fotograf eklendi");
	}

	@Override
	public DataResult<Picture> getById(int candidateId) {
		return new SuccessDataResult<Picture>(this.pictureDao.getByCandidateId(candidateId));
	}

	@Override
	public Result delete(int id) throws IOException {
		var publicId = this.pictureDao.findById(id).get().getPublicId();
		var result = this.cloudService.delete(publicId);
		this.pictureDao.deleteById(id);
        return new SuccessResult("Fotograf silindi");
	}
}
