package kodlamaio.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCandidateDto {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int birthOfYear;
	private String pictureUrl;
}
