package kodlamaio.Hrms.core.utilities;

public class StringExtensions {
	public static boolean isNullOrEmpty(String... values) {
		for(String field : values) {
			if(field.isBlank() || field== null) {
				return true;
			}
		}
		return false;
	}
}
