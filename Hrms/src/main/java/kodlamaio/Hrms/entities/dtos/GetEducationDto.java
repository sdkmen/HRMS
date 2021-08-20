package kodlamaio.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEducationDto {
	private int id;
	private String collegeStartedYear;
	private String collegeGraduatedYear;
	private Boolean isGraduated;
	private String collegeName;
	private String collegeDepartmentName;
}
