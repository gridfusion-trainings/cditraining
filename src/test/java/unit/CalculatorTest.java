package unit;


import static org.mockito.Mockito.*;
import logic.Calculator;
import logic.InputIsEmptyException;
import logic.InputProcessor;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CalculatorTest {
	
	
	@Test(groups="unit")
	public void shouldRemoveSingleWhitespaceInName() {

		InputProcessor mockedStripper = mock(InputProcessor.class);

		// stubbing appears before the actual execution
		when(mockedStripper.stripWhitespaces("Michael Palotas")).thenReturn("MichaelPalotas");
		
		
		Calculator calc = new Calculator();
		calc.setInputProcessor(mockedStripper);
		
		Assert.assertEquals(calc.calculateNumberOfChars("Michael Palotas"), 14);		
		
	}
	

	@Test(groups="unit")
	public void shouldRemoveMultipleWhitespaceInName() {

		InputProcessor mockedStripper = mock(InputProcessor.class);

		// stubbing appears before the actual execution
		when(mockedStripper.stripWhitespaces("Mi ch ael    Palo tas")).thenReturn("MichaelPalotas");
		
		
		Calculator calc = new Calculator();
		calc.setInputProcessor(mockedStripper);
		
		Assert.assertEquals(calc.calculateNumberOfChars("Mi ch ael    Palo tas"), 14);		
		
	}
	
    
    @Test(groups = {"unit"})
    public void shouldReturnFullname() throws InputIsEmptyException {

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



