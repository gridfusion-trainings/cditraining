package unit;


import static org.mockito.Mockito.*;
import logic.Calculator;
import logic.InputIsEmptyException;
import logic.InputProcessor;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CalculatorTest {

	@Test(groups="unit")
	public void falseTest() {
		Assert.assertTrue(true);
	}
	
	
	@Test(groups="unit")
	public void shouldRemoveSingleWhitespaceInName() {

		InputProcessor mockedInputProcessor = mock(InputProcessor.class);

		// stubbing appears before the actual execution
		when(mockedInputProcessor.stripWhitespaces("Michael Palotas")).thenReturn("MichaelPalotas");


		Calculator calc = new Calculator();
		calc.setInputProcessor(mockedInputProcessor);

		Assert.assertEquals(calc.calculateNumberOfChars("Michael Palotas"), 14);

		//verify that the call to the mock was done with the correct parameter
		verify(mockedInputProcessor).stripWhitespaces("Michael Palotas");

	}
	

//	@Test(groups="unit")
//	public void shouldRemoveMultipleWhitespaceInName() {
//
//		InputProcessor mockedInputProcessor = mock(InputProcessor.class);
//
//		// stubbing appears before the actual execution
//		when(mockedInputProcessor.stripWhitespaces("Mi ch ael    Palo tas")).thenReturn("MichaelPalotas");
//
//
//		Calculator calc = new Calculator();
//		calc.setInputProcessor(mockedInputProcessor);
//
//		Assert.assertEquals(calc.calculateNumberOfChars("Mi ch ael    Palo tas"), 14);
//
//	}
	
//
//    @Test(groups = {"unit"})
//    public void shouldReturnFullname() throws InputIsEmptyException {
//
//        Calculator calc = new Calculator();
//        Assert.assertEquals(calc.calculateName("Michael", "Palotas"), "Michael Palotas");
//    }

    
//
//    @Test(groups = {"unit"}, expectedExceptions=InputIsEmptyException.class)
//    public void shouldThrowInputIsEmptyExceptionBothNames() throws InputIsEmptyException {
//
//        Calculator calc = new Calculator();
//        Assert.assertEquals("Michael Palotas", calc.calculateName("", ""));
//    }
//
//    @Test(groups = {"unit"}, expectedExceptions=InputIsEmptyException.class)
//    public void shouldThrowInputIsEmptyExceptionFirstName() throws InputIsEmptyException {
//
//        Calculator calc = new Calculator();
//        Assert.assertEquals("Michael Palotas", calc.calculateName("", "Palotas"));
//    }
    
//    @Test(groups = {"unit"}, expectedExceptions=InputIsEmptyException.class)
//    public void shouldThrowInputIsEmptyExceptionLastName() throws InputIsEmptyException {
//
//        Calculator calc = new Calculator();
//        Assert.assertEquals("Michael Palotas", calc.calculateName("Michael", ""));
//    }
//
//    @Test(groups = {"unit"})
//    public void failedTest() throws InputIsEmptyException {
//
//        Assert.assertTrue(true);
//    }
}



