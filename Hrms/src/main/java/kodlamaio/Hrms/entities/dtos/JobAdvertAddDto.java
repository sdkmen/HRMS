package kodlamaio.Hrms.entities.dtos;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {	
	private int id;
	private int employerId;
	private int jobTitleId;
	private int cityId;
	private String jobDefinition;
	private double minSalary;
	private double maxSalary;
	private int freePositionNo;
	private LocalDate creationDate;
	private Date deadline;
	private Boolean isActive;
}
