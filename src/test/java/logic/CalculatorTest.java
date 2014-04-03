package logic;


import java.text.ParseException;
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
    	Assert.assertEquals(calc.calculateDaysAlive("2011-05-11"), 1058);
    }

    
    @Test(groups = {"unit"})
    public void shouldReturnNumberOfDaysAlive1() throws Exception {
    	

    	int a=1;
    	int b=2;
    	int c =a+b;
    	Assert.assertEquals(c, 3);
    }

    @Test(groups = {"unit"})
    public void shouldReturnNumberOfDaysAlive2() throws Exception {
    	

    	int a=2;
    	int b=2;
    	int c =a+b;
    	Assert.assertEquals(c, 4);
    }

    
    
    /*
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
    */
    

    /*
    @Test(groups = {"unit"})
    public void shouldThrowParseException() {
    	
    	Calculator calc = new Calculator();
    	try {
    		// invalid case because date is in the future
			calc.calculateDaysAlive("michael");
		} catch (Exception e) {
			// this is an expected exception
			e.printStackTrace();
			Assert.assertFalse(false);
		} 
    } 
    */
}
