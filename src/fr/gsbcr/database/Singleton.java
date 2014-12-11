package fr.gsbcr.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import fr.gsbcr.model.ModeleException;

/** Classe Singleton de l'application
 * @author rafina
 */
public class Singleton {
	private String connectionInf = "jdbc:mysql://localhost:3306/GsbCRSlam";
	//private String connectionInf = "jdbc:mysql://172.16.70.101/GsbCRSlam";
	private String userName ="root";
	private String userPass ="mysql";
	//private String userName ="gsb";
	//private String userPass ="azerty";
	private static Statement stmt ;
	private static Connection instance;
	private static Singleton aInstance;
	
	/** Création de Singleton 
	 * @throws SQLException
	 * @throws ModeleException
	 */
	private Singleton() throws SQLException ,ModeleException{
		try {
			Singleton.instance = DriverManager.getConnection(this.connectionInf,this.userName,this.userPass);
		}
		catch(SQLException event){
			System.out.println("Singleton error");
			throw new ModeleException(event.getMessage());
		}
		
		
	}
	/** Retourne une instance de connexion unique
	 * @return Instance de connexion
	 * @throws SQLException  Peut générer une exception sql
	 * @throws ModeleException  Peut générer une exception 
	 */
	
	public static Singleton getAInstance() throws SQLException, ModeleException{
		if(Singleton.instance == null){
			Singleton.aInstance =  new Singleton();
		}
		return aInstance;
	
	}
	/** Modification du statement 
	 * @param stmt Statement
	 */
	
	public static void setStmt(Statement stmt) {
		Singleton.stmt = stmt;
	}
	
	/** Création d'un statement 
	 * @return stmt Statement 
	 * @throws SQLException  Peut générer une exception sql
	 */
	public static Statement getStmt() throws SQLException {
		try {
			Singleton.setStmt((Statement)Singleton.instance.createStatement());
		}
		catch(SQLException event){
			throw event;
		}
		return stmt;
	}
	
	/** Création d'une requête préparé
	 * @param sQuery Requête textuelle
	 * @return pstmt Requête préparé
	 * @throws SQLException  Peut générer une exception sql
	 */
	public static PreparedStatement prepareStatement(String sQuery) throws SQLException{
		PreparedStatement pstmt = (PreparedStatement) Singleton.instance.prepareStatement(sQuery);
		return pstmt;
		
	}
	
	/** Retourne le résultat d'une requête 
	 * @param sQuery Requête à exécuter
	 * @return result Résultat de la requête 
	 * @throws SQLException  Peut générer une exception sql
	 */
	
	public static ResultSet getResult(String sQuery) throws SQLException{
		try {
			ResultSet result = Singleton.stmt.executeQuery(sQuery);
			return result;
		}
		catch(SQLException event){
			throw event;
		}
	}
	
	/** Retourne le résultat d'une requête préparé
	 * @param pstmt Requête préparé à exécuter
	 * @return result Résultat de la requête préparé
	 * @throws SQLException  Peut générer une exception sql
	 */
	
	public static ResultSet getResult(PreparedStatement pstmt) throws SQLException{
		try {
			ResultSet result = pstmt.executeQuery();
			return result;
		}
		catch(SQLException event){
			throw event;
		}
	}
	
	/** Retourne le résultat d'une requête d'insertion ou de mise à jour
	 * @param sQuery Requête à exécuter
	 * @return result Résultat de la requête 
	 * @throws SQLException  Peut générer une exception sql
	 */
	
	public static int getResultUpdate(String sQuery) throws SQLException{
		try {
			return Singleton.stmt.executeUpdate(sQuery);
		}
		catch(SQLException event){
			throw event;
		}
	}	
	
	/** Destruction de l'instance de connexion
	 * @throws SQLException  Peut générer une exception sql
	 */
	public static void destroyInstance() throws SQLException{
		if(Singleton.instance != null){
			Singleton.instance.close();
		}	
	}
	
	
}
