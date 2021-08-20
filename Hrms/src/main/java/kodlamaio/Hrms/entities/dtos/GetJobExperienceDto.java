package kodlamaio.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetJobExperienceDto {
	private int id;
	private String workplaceName;
	private String workStartedYear;
	private String workLeftYear;
	private Boolean isWorking;
	private String jobTitle;
}
