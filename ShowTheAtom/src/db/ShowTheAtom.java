package db;
import login.loginDB;
import db.searchDB;

import javax.swing.*;
public class ShowTheAtom {
	public static void main(String[] args) {
		searchDB dao = new searchDB();
		try {
			dao.abrir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String username = JOptionPane.showInputDialog(null, "Email: ", "Login", JOptionPane.QUESTION_MESSAGE);
		JPasswordField passwordField = new JPasswordField(8);
		JOptionPane.showMessageDialog(null, passwordField, "Password",
                JOptionPane.QUESTION_MESSAGE);
		String pass = new String(passwordField.getPassword());
		login(username, pass);
	}
	private static void login(String email, String password){
		loginDB logando = new loginDB();
		try {
			logando.abrir(email,password);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
