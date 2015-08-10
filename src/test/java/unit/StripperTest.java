package unit;

import logic.InputStripper;

import org.testng.Assert;
import org.testng.annotations.Test;


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
