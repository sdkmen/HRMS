package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.SocialLink;

public interface SocialLinkDao extends JpaRepository<SocialLink, Integer>{

}
