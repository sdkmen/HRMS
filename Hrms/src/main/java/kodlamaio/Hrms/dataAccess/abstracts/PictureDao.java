package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.Picture;

public interface PictureDao extends JpaRepository<Picture, Integer>{
	Picture getByCandidateId(int candidateId);
}
