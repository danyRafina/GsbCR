package gsb1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class Singleton {
	private String connectionInf = "jdbc:mysql://localhost:3306/GsbCRSlam";
	private String userName ="root";
	private String userPass ="mysql";
	private static Statement stmt ;
	private static Connection instance;
	private static Singleton aInstance;
	
	private Singleton() throws SQLException{
		try {
			Singleton.instance = DriverManager.getConnection(this.connectionInf,this.userName,this.userPass);
		}
		catch(SQLException event){
			System.out.println("Singleton error");
			throw event;
		}
		
		
	}
	
	public static Singleton getAInstance() throws SQLException{
		if(Singleton.instance == null){
			Singleton.aInstance =  new Singleton();
		}
		return aInstance;
	
	}

	public static Statement getStmt() throws SQLException {
		try {
			Singleton.setStmt((Statement)Singleton.instance.createStatement());
		}
		catch(SQLException event){
			throw event;
		}
		return stmt;
	}
	
	public static ResultSet getResult(String query) throws SQLException{
		try {
			return Singleton.stmt.executeQuery(query);
		}
		catch(SQLException event){
			throw event;
		}
	}
	
	public static int getResultUpdate(String query) throws SQLException{
		try {
			return Singleton.stmt.executeUpdate(query);
		}
		catch(SQLException event){
			throw event;
		}
	}	

	public static void setStmt(Statement stmt) {
		Singleton.stmt = stmt;
	}
	
	public static PreparedStatement getPreparedStatement(String query) throws SQLException{
		PreparedStatement pstmt = (PreparedStatement) Singleton.instance.prepareStatement(query);
		return pstmt;
		
	}
	
	public static void destroyInstance() throws SQLException{
		if(Singleton.instance != null){
			Singleton.instance.close();
		}	
	}
	
	
}
