package logic;

import javax.servlet.http.HttpServlet;

public class InputProcessor {
	
	public String stripWhitespaces(String fullName) {
		
		return fullName.replaceAll(" ", "");
		
	}

}
