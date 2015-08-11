package logic;


public class Calculator {
	
	private InputProcessor processor;


	public Calculator() {
		//set default InputProcessor in case no mocking is needed
		this.processor = new InputProcessor();
	}
	
    //required for unit tests and mocking
    public void setStripper(InputProcessor stripper) {
    	this.processor = stripper;
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
    	
    	//call to (external) InputProcessor class 
    	strippedString = processor.stripWhitespaces(fullName);
        return strippedString.length();
    }
}
