package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","resumes"})
public class JobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="workplace_name")
	@NotNull
	@NotEmpty
	private String workplaceName;
	
	@Column(name="work_started_year")
	@NotNull
	@NotEmpty
	private String workStartedYear;
	
	@Column(name="work_left_year")
	private String workLeftYear;
	
	@Column(name="is_working")
	private Boolean isWorking;
	
	@ManyToOne()
	@JoinColumn(name="job_title_id")
	private JobTitle jobTitle;
}
