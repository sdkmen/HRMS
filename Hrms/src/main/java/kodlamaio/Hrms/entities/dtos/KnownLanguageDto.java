package kodlamaio.Hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KnownLanguageDto {
	private int id;
	private int candidateId;
	private int languageLevel;
	private int languageId;
}
