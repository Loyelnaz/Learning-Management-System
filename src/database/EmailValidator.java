package database;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	
	private static final String EMAIL_REGEX = "^[A-Z][A-Z0-9_]+[.]*[A-Z0-9_]+@[A-Z][A-Z0-9-]+\\.[A-Z]{2,6}$";
	private static Pattern pattern;
	private Matcher matcher;

	public EmailValidator() {
		// initialize the Pattern object
		pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
	}
	
	public boolean validateEmail(String email) {
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
