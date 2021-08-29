package kodlamaio.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {
	private int id;
	private String firstName;
	private String lastName;
	private String identityNumber;
	private int birthOfYear;
	private String email;
	private String password;
	private String passwordAgain;
}
