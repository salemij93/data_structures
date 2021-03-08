package template_next_date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateObjTest {

	@Test
	
	@DisplayName("Constructor should throw an exception on bad Feb 29")
	void testConstructorBadFeb() {
		assertThrows(IllegalArgumentException.class, () -> new DateObj(2019, 2, 29));
	}

}
