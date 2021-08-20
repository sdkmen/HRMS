package kodlamaio.Hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Picture;

public interface PictureService {
	Result add(MultipartFile multipartFile, int candidateId);
	Result delete(int id);
	DataResult<Picture> getById(int candidateId);
}
