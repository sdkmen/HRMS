package kodlamaio.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
	private int id;
	private String collegeStartedYear;
	private String collegeGraduatedYear;
	private Boolean isGraduated;
	private int collegeId;
	private int collegeDepartmentId;
    private int candidateId;
}
