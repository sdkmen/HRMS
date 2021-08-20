package kodlamaio.Hrms.core.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.Hrms.core.utilities.results.DataResult;

public interface CloudService {
	DataResult<Map<String, String>> upload(MultipartFile multipartFile);
	DataResult<Map> delete(String id) throws IOException;
}
