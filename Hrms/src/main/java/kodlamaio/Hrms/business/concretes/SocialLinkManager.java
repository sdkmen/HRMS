package kodlamaio.Hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.Hrms.business.abstracts.SocialLinkService;
import kodlamaio.Hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
import kodlamaio.Hrms.dataAccess.abstracts.SocialLinkDao;
import kodlamaio.Hrms.entities.concretes.SocialLink;
import kodlamaio.Hrms.entities.dtos.SocialLinkDto;

@Service
public class SocialLinkManager implements SocialLinkService{
	private SocialLinkDao socialLinkDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public SocialLinkManager(SocialLinkDao socialLinkDao, DtoConverterService dtoConverterService) {
		super();
		this.socialLinkDao = socialLinkDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(SocialLinkDto socialLinkDto) {
		SocialLink socialLink = (SocialLink) dtoConverterService.dtoToEntity(socialLinkDto, SocialLink.class);
		socialLink.setId(socialLinkDto.getId());
		socialLinkDao.save(socialLink);
		return new SuccessResult("Sosyal medya linki eklendi");
	}

	@Override
	public DataResult<List<SocialLinkDto>> getAll() {
		return new SuccessDataResult<List<SocialLinkDto>>(dtoConverterService.entityToDto(socialLinkDao.findAll(), SocialLinkDto.class),"Sosyal medya linkleri listelendi");
	}
}
