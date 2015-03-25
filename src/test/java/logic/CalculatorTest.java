package logic;


import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mpalotas on 18/03/14.
 */
public class CalculatorTest {
	

    @Test(groups = {"unit"})
    public void shouldReturnFullnameTest() throws InputIsEmptyException {

        Calculator calc = new Calculator();
        Assert.assertEquals(calc.calculateName("Michael", "Palotas"), "Michael Palotas");
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
    
}



