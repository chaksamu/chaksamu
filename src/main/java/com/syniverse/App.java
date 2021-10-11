package com.syniverse;
import java.util.ResourceBundle;
public class App {
	public int userLogin(String in_user, String in_pwd) {
		ResourceBundle rbc = ResourceBundle.getBundle("config");
		String uname = rbc.getString("username");
		String passwd = rbc.getString("password");
		if (in_user.equals(uname) && in_pwd.equals(passwd))
			return 1;
		else
			return 0;
	}
}