package kodlamaio.Hrms.core.adapters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;

@Component
public class CloudManager implements CloudService{
	
	private final Cloudinary cloudinary;
	
	public CloudManager() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("cloud_name","dinwaug1r" );
        valuesMap.put("api_key", "827453852358878" );
        valuesMap.put("api_secret","4e2ZYua8WazBXhR-SGJ1GnC47Gw" );
        cloudinary = new Cloudinary(valuesMap);
    }
	
	@Override
	public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
        File file;
        try {
            file = convert(multipartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<>(result);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<>("Dosya yuklenemedi");
        }
    }
	
	@Override
    public DataResult<Map> delete (String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return new SuccessDataResult<>(result);
    }


    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}
