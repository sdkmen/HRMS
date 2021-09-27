package kodlamaio.Hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.Hrms.entities.concretes.WorkHour;

public interface WorkHourDao extends JpaRepository<WorkHour, Integer>{

}
