
public class Login {
	private String username;
	private String password;

	// Constructor
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean login(String user, String pass) {
		if (username.equals(user)) {
			System.out.println("Đúng username!");
			if (password.equals(pass)) {
				System.out.println("Đúng password!");
				return true;
			}
		}
		return false;
	}
}
