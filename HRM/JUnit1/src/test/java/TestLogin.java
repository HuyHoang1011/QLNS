import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestLogin {
	@Test
	public void dungUserDungPass() {
		Login a = new Login("016","016");
		String validUsername = "016";
		String validPassword = "016";
		assertTrue(a.login(validUsername, validPassword));
	}
	
	@Test
	public void dungUsersaiPass() {
		Login a = new Login("016","anhDanDepTrai");
		String validUsername = "016";
		String validPassword = "016";
		assertFalse(a.login(validUsername, validPassword));
	}
}
