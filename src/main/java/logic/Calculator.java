package logic;


public class Calculator {
	
	private InputProcessor processor;


	public Calculator() {
		//set default InputProcessor in case no mocking is needed
		this.processor = new InputProcessor();
	}
	

    public void setInputProcessor(InputProcessor strp) {
    	this.processor = strp;
    }

    /** 
     * required for unit tests and mocking
     * @param  stripper  the InputProcessor of choice  
     * @return none
     */    
	public String calculateName (String first, String last) throws InputIsEmptyException
    {    	
    	if(first== "" || last=="") {
    		throw new InputIsEmptyException();
    	}
    	else {
            return first + " " + last + "adding bug which will be caught by unit tests";    		
    	}
    }

    /** 
     * required for unit tests and mocking
     * @param  stripper  the InputProcessor of choice  
     * @return none
     */ 
	public int calculateNumberOfChars(String fullName) {
    	
    	String strippedString;
    	
    	//call to (external) InputProcessor class 
    	strippedString = processor.stripWhitespaces(fullName);
        return strippedString.length();
    }
}
