package test;
import static org.junit.Assert.*;
import org.junit.Test;

public class loginTest {
	@Test
    public void dungUserDungPass() {
        login login = new login("016","016"); 
        String validUsername = "016";
        String validPassword = "016";
        assertEquals(true,login.login(validUsername, validPassword));
    }
    @Test
    public void saiUserSaiPass() {
        login login = new login("016","016"); 
        String validUsername = "AA";
        String validPassword = "AA";
        assertEquals(false,login.login(validUsername, validPassword));
    }
    @Test
    public void dungUserSaiPass() {
        login login = new login("016","016"); 
        String validUsername = "016";
        String validPassword = "AA";
        assertEquals(false,login.login(validUsername, validPassword));
    }
    @Test
    public void khongNhapUser() {
        login login = new login("016","016"); 
        String validUsername = "";
        String validPassword = "AA";
        assertEquals(false,login.login(validUsername, validPassword));
    }
    @Test
    public void khongNhapPass() {
        login login = new login("016","016"); 
        String validUsername = "";
        String validPassword = "AA";
        assertEquals(false,login.login(validUsername, validPassword));
    }
    @Test
    public void saiUserDungPass() {
        login login = new login("016","016"); 
        String validUsername = "AA";
        String validPassword = "016";
        assertEquals(false,login.login(validUsername, validPassword));
    }
}



