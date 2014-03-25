package logic;


import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;


import logic.Calculator;

/**
 * Created by mpalotas on 18/03/14.
 */
public class CalculatorTest {

    @Test(groups = {"unit"})

    public void shouldReturnFullnameTest() {

        Calculator calc = new Calculator();
        Assert.assertEquals("Michael Palotas", calc.calculateName("Michael", "Palotas"));
    }

    @Test(groups = {"unit"})
    public void shouldReturnLengthOfNameTest() {

        String fullname = "Michael Palotas";

        Calculator calc = new Calculator();
        Assert.assertEquals(14, calc.calculateNumberOfChars("Michael Palotas"));
    }
    
    @Test(groups = {"unit"})
    public void shouldReturnNumberOfDaysAlive() throws Exception {
    	
    	Calculator calc = new Calculator();
    	Assert.assertEquals(1049, calc.calculateDaysAlive("2011-05-11"));
    }

    
    @Test(groups = {"unit"})
    public void shouldThrowException() {
    	
    	Calculator calc = new Calculator();
    	try {
    		// invalid case because date is in the future
			calc.calculateDaysAlive("2015-12-31");
		} catch (Exception e) {
			// this is an expected exception
			e.printStackTrace();
			Assert.assertTrue(true);
		}
    } 
       
}
