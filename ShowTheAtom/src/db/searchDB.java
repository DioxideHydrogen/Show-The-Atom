package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class searchDB {
	private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sta";
    private Statement statement = null;
    private ResultSet resultSet = null;
	private Connection conn;
    public void abrir() throws Exception {
    	
        // Registrar o driver
        
        // Capturar a conexão
        try{
        	conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        	System.out.println("MySQL Connection has been stabilished!");
        } catch (Exception e) {
        	System.out.println(e);
        }
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
		statement = conn.createStatement();
        // Result set get the result of the SQL query
        resultSet = statement.executeQuery("select * from sta.elements");
        writeResultSet(resultSet);
    }
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
    	//Map<String, String> atomos = new HashMap<String, String>();
    	ArrayList<String> atomos = new ArrayList<String>();
    	ArrayList<Integer> idAtom = new ArrayList<Integer>();
    	ArrayList<Integer> numAtom = new ArrayList<Integer>();
    	ArrayList<String> descriptioN = new ArrayList<String>();
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            Integer id = resultSet.getInt("id");
            String element = resultSet.getString("element");
            Integer numatom = resultSet.getInt("numatom");
            String description = resultSet.getString("description");
            //atomos.put("element", element);
            idAtom.add(id);
            atomos.add(element);
            numAtom.add(numatom);
            descriptioN.add(description);
            
            //System.out.println("ID: " + id);
            //System.out.println("Número atômico: " + numatom);
            //System.out.println("Elemento: " + element);
            //System.out.println("Description: " + description);
        }
        int n = atomos.size();
//        for(int i=0; i < n; i++){
//        	System.out.println("ID: " + idAtom.get(i) + "\nAtomic Number: " + numAtom.get(i) + "\nAtom: " + atomos.get(i) + "\nDescription: " + descriptioN.get(i));
//        }
        
    }
  
}

