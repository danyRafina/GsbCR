package fr.gsbcr.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import fr.gsbcr.model.ModeleException;

public class Singleton {
	private String connectionInf = "jdbc:mysql://localhost:3306/GsbCRSlam";
	private String userName ="root";
	private String userPass ="mysql";
	private static Statement stmt ;
	private static Connection instance;
	private static Singleton aInstance;
	
	private Singleton() throws SQLException ,ModeleException{
		try {
			Singleton.instance = DriverManager.getConnection(this.connectionInf,this.userName,this.userPass);
		}
		catch(SQLException event){
			System.out.println("Singleton error");
			throw new ModeleException(event.getMessage());
		}
		
		
	}
	
	public static Singleton getAInstance() throws SQLException, ModeleException{
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
	
	public static ResultSet getResult(java.sql.PreparedStatement pstmt) throws SQLException{
		try {
			return pstmt.executeQuery();
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
	
	public static PreparedStatement prepareStatement(String query) throws SQLException{
		PreparedStatement pstmt = (PreparedStatement) Singleton.instance.prepareStatement(query);
		return pstmt;
		
	}
	
	public static void destroyInstance() throws SQLException{
		if(Singleton.instance != null){
			Singleton.instance.close();
		}	
	}
	
	
}
