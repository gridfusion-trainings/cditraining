package logic;

import java.util.Date;

import logic.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mpalotas on 18/03/14.
 */
public class CalculatorTest {

    @Test
    public void shouldReturnFullnameTest() {

        Calculator calc = new Calculator();
        Assert.assertEquals("Michael Palotas", calc.calculateName("Michael", "Palotas"));
    }

    @Test
    public void shouldReturnLengthOfNameTest() {

        String fullname = "Michael Palotas";

        Calculator calc = new Calculator();
        Assert.assertEquals(14, calc.calculateNumberOfChars("Michael Palotas"));
    }
    
    @Test
    public void shouldReturnNumberOfDaysAlive() {
    	
    	Calculator calc = new Calculator();
    	Assert.assertEquals(1048, calc.calculateDaysAlive("2011-05-11"));
    }
    
    @Test
    public void passThisTest() {
    	Assert.assertTrue(true);
    }

    @Test
    public void passAnotherTest() {
    	Assert.assertTrue(true);
    }
}
