package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.KnownLanguage;

public interface KnownLanguageDao extends JpaRepository<KnownLanguage, Integer>{

}
