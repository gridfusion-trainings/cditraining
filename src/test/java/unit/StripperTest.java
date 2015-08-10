package unit;

import java.util.List;

import logic.Calculator;
import logic.InputStripper;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;


public class StripperTest {
	
	

	
	@Test(groups="unit")
	public void shouldRemoveWhitespacesInName() {
		
		InputStripper stripper = new InputStripper();
		Assert.assertEquals(stripper.stripWhitespaces("Michael Palotas"), "MichaelPalotas");
	}

	
	@Test(groups="unit")
	public void shouldRemoveMultipleWhitespacesInName() {
		
		InputStripper stripper = new InputStripper();
		Assert.assertEquals(stripper.stripWhitespaces("Mi ch ael Pal o tas "), "MichaelPalotas");
	}
	
	
}
