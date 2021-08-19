package kodlamaio.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.SocialLink;

public interface SocialLinkDao extends JpaRepository<SocialLink, Integer>{
	List<SocialLink> findAllByCandidateId(int candidateId);
}
