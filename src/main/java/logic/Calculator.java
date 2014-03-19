package logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mpalotas on 18/03/14.
 */
public class Calculator {

    public String calculateName (String first, String last)
    {
        return first + " " + last;
    }

    public int calculateNumberOfChars(String fullname) {

        return fullname.replace(" ", "").length();
    }


    public int calculateDaysAlive(String dateInString) {
        SimpleDateFormat dobFormatter = new SimpleDateFormat("yyyy-MM-dd");

        Date today = new Date();
        Date yourDateOfBirth;

        try {
            yourDateOfBirth = dobFormatter.parse(dateInString);
            long diff = today.getTime() - yourDateOfBirth.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);

            //check if dob is in the future
            if(diffDays < 0) {

                //TODO: throw exception here later
                return -1;
            }
            else {
                return (int)diffDays;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
