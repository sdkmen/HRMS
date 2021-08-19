package kodlamaio.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	private int id;
	private int collegeStartedYear;
	private int collegeGraduatedYear;
	private Boolean isGraduated;
	private String collegeName;
	private String collegeDepartmentName;
}
