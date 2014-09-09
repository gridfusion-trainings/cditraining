package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mpalotas on 18/03/14.
 */
public class Calculator {

    public String calculateName (String first, String last) throws InputIsEmptyException
    {    	
    	if(first== "" || last=="") {
    		throw new InputIsEmptyException();
    	}
    	else {
            return first + " " + last;    		
    	}
    }

    public int calculateNumberOfChars(String fullname) {

        return fullname.replace(" ", "").length();
    }

}
