package logic;


import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by mpalotas on 18/03/14.
 */
public class CalculatorTest {
	
    @Test(groups = {"unit"})
    public void anotherTest() {
    	Assert.assertTrue(true);
    }

    @Test(groups = {"unit"})
    public void shouldReturnFullnameTest() throws InputIsEmptyException {

        Calculator calc = new Calculator();
        Assert.assertEquals("Michael Palotas", calc.calculateName("Michael", "Palotas"));
    }
    

    @Test(groups = {"unit"}, expectedExceptions=InputIsEmptyException.class)
    public void shouldThrowInputIsEmptyExceptionBothNames() throws InputIsEmptyException {

        Calculator calc = new Calculator();
        Assert.assertEquals("Michael Palotas", calc.calculateName("", ""));
    } 
    
    @Test(groups = {"unit"}, expectedExceptions=InputIsEmptyException.class)
    public void shouldThrowInputIsEmptyExceptionFirstName() throws InputIsEmptyException {

        Calculator calc = new Calculator();
        Assert.assertEquals("Michael Palotas", calc.calculateName("", "Palotas"));
    }    
    
    @Test(groups = {"unit"}, expectedExceptions=InputIsEmptyException.class)
    public void shouldThrowInputIsEmptyExceptionLastName() throws InputIsEmptyException {

        Calculator calc = new Calculator();
        Assert.assertEquals("Michael Palotas", calc.calculateName("Michael", ""));
    }
    
    /*
    @Parameters("environment")
    @Test(groups = {"unit"})
    public void shouldReturnLengthOfNameTest(String environment) {

        String fullname = "Michael Palotas";

        Calculator calc = new Calculator();
        Assert.assertEquals(14, calc.calculateNumberOfChars(fullname));
        System.out.println("Annotation: " + environment);

    }
    
    @Test(groups = {"unit"}, expectedExceptions=DateInFutureException.class)
    public void shouldReturnNumberOfDaysAlive() throws Exception {
    	
    	Calculator calc = new Calculator();
    	calc.calculateDaysAlive("2099-12-31");
    }
*/
}
