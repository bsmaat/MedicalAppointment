import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBWork {

	public static void createDB() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			System.out.println("Opened database successfully");

			//now create table
			stmt = c.createStatement();
			String sql =
					"CREATE TABLE PATIENT " +
			"(ID INTEGER PRIMARY KEY," +
							" NAME	TEXT	NOT NULL," +
			"ADDRESS	CHAR(50))";
			
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Table created successfully");
	}
	
	public static void addPatientRecord(Patient p) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO PATIENT (ID, NAME,ADDRESS) " + 
			"VALUES (null, '" + p.getName() + "', '" + p.getAddress() + "');";
			stmt.executeUpdate(sql);
			c.commit();
			c.close();
			
		} catch(Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		
		}
		System.out.println("Records created successfully");
	}
	
	public static List<Patient> readPatientRecord() {
		Connection c = null;
		Statement stmt = null;
		List<Patient> p = new ArrayList<Patient>();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM PATIENT;");
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				p.add(new Patient(id, name, address, 0));
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done succcessfully");
		return p;
	}
	
	public static Patient getPatientFromID(int id) {
		Connection c = null;
		Statement stmt = null;
		Patient p = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "SELECT * FROM PATIENT WHERE ID=" + Integer.toString(id) + ";";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int key = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				p = new Patient(key, name, address, 0);
			}
			rs.close();
			stmt.close();
			c.close();
			return p;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
			return null;
		}
	}
}
