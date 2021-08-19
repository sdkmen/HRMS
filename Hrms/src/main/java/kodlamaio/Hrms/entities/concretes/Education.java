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
@Table(name="educations")
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="college_started_year")
	@NotNull
	@NotEmpty
	private String collegeStartedYear;
	
	@Column(name="college_graduated_year")
	private String collegeGraduatedYear;
	
	@Column(name="is_graduated")
	private Boolean isGraduated;
	
	@ManyToOne()
	@JoinColumn(name="college_id")
	@NotNull
	@NotEmpty
	private College college;
	
	@ManyToOne()
	@JoinColumn(name="college_department_id")
	@NotNull
	@NotEmpty
	private CollegeDepartment collegeDepartment;
	
	@ManyToOne()
	@JoinColumn(name="education_id")
	private Candidate candidate;
	
}
