package logic;


/**
 * Created by mpalotas on 18/03/14.
 */
public class Calculator {
	
	private InputStripper stripper;


	public Calculator() {
		// TODO Auto-generated constructor stub
		this.stripper = new InputStripper();
	}

	public String calculateName (String first, String last) throws InputIsEmptyException
    {    	
    	if(first== "" || last=="") {
    		throw new InputIsEmptyException();
    	}
    	else {
            return first + " " + last;    		
    	}
    }

    public int calculateNumberOfChars(String fullName) {
    	
    	String strippedString;
    	
    	strippedString = stripper.stripWhitespaces(fullName);
        return strippedString.length();
    }
    
    
    public void setStripper(InputStripper stripper) {
    	this.stripper = stripper;
    }
}
