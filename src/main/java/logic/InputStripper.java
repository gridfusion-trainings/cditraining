package logic;

public class InputStripper {
	
	public String stripWhitespaces(String fullName) {
		
		return fullName.replaceAll(" ", "");
		
	}

}
