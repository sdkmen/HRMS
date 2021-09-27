package kodlamaio.Hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
	private int id;
	private String companyName;
	private String jobTitle;
	private int freePositionNo;
	private int minSalary;
	private int maxSalary;
	private String cityName;
	private String jobDefinition;
	private Date creationDate;
	private Date deadline;
	private Boolean isRemote;
	private String hourType;
}
