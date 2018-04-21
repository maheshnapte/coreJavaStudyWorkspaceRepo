package webapp;

public class UsrerValidationService {

	public boolean isUserValid(String user, String password) {
		if (user.equalsIgnoreCase("mahesh") && password.equals("123")) {
			return true;
		} else {
			return false;
		}
	}

}
