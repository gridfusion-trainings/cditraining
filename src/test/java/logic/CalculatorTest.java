package logic;


import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(14, calc.calculateNumberOfChars(fullname));
    }
    
    @Test(groups = {"unit"})
    public void shouldReturnNumberOfDaysAlive() throws Exception {
    	
    	Calculator calc = new Calculator();
    	Assert.assertEquals(calc.calculateDaysAlive("2011-05-11"), 1208);
    }

}
