package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.security.*;
import java.math.*;

public class loginDB {
	public static void main(String args[]) throws NoSuchAlgorithmException, SQLException{
		abrir("mxhugoxm@gmail.com","19862010");
	}
	private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sta";
    private static Statement statement = null;
    private static ResultSet resultSet = null;
	private static Connection conn;
	private static Boolean checked;
	
	public static void abrir(String email, String password) throws SQLException, NoSuchAlgorithmException{
		try{
			conn = DriverManager.getConnection(URL, USUARIO, SENHA);
	    	System.out.println("MySQL Connection has been stabilished!");
		} catch(Exception e) {
			System.out.println("MySQL Connection cannot been stabilished! \n"+e);
		}
		statement = conn.createStatement();
		String sql = "select * from sta.login where email='" + email +"'";
		try{
			resultSet = statement.executeQuery(sql);
			System.out.println("SQL Query has been made with sucess!");
		} catch (Exception e){
			System.out.println("SQL Querry Error \n"+e);
		}
		resultSet = statement.executeQuery(sql);
		String passMD5 = md5(password);
		System.out.println("Email passado: " + email + "\nSenha passada: " + password);
		checked = checarEmail(email, passMD5, resultSet);
		System.out.println(checked);
	}
	public static String md5(String s) throws NoSuchAlgorithmException{
		MessageDigest m = MessageDigest.getInstance("MD5");
	    m.update(s.getBytes(),0,s.length());
	    System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
	    return s;
	}
	public static Boolean checarEmail(String email, String password, ResultSet resultset) throws SQLException{
		String emailOriginal = new String(resultset.getString("email"));
		String passwordOriginal = new String(resultset.getString("password"));
		System.out.println("Email original:" + emailOriginal + "\n Senha original:" + passwordOriginal);
		Boolean checked;
		if(emailOriginal == email && passwordOriginal == password){
			checked = true;
		} else {
			checked = false;
		}
		return checked;
		
	}
}
