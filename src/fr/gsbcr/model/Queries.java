package fr.gsbcr.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.gsbcr.database.Singleton;

public class Queries {
	private static String tblSQuerySelect[] = {
		"SELECT COLLABORATEUR.COL_MATRICULE ,COL_MDP from COLLABORATEUR inner join TRAVAILLER ON COLLABORATEUR.COL_MATRICULE = TRAVAILLER.COL_MATRICULE where COLLABORATEUR.COL_MATRICULE = ? AND COL_MDP = ? AND TRA_ROLE='Délégué'",
		"SELECT * from PRATICIEN inner join RAPPORT_VISITE on RAPPORT_VISITE.PRA_NUM= PRATICIEN.PRA_NUM where COEF_CONF < 5 ",
		"SELECT * from RAPPORT_VISITE inner join MOTIF on RAPPORT_VISITE.RAP_MOTIF= MOTIF.MOT_NUM where COL_MATRICULE = ? and year(RAP_DATE) = ? and month (RAP_DATE) = ?",
		"SELECT * from COLLABORATEUR inner join TRAVAILLER on COLLABORATEUR.COL_MATRICULE = TRAVAILLER.COL_MATRICULE where TRA_ROLE = 'Visiteur' ",
	};
	private static ResultSet result;
	
	public static ResultSet queryDelegue(String login,String mdp) throws SQLException{
		PreparedStatement pstmt = Singleton.prepareStatement(tblSQuerySelect[0]);
		pstmt.setString(1,login);
		pstmt.setString(2,mdp);
		result = Singleton.getResult(pstmt);
		return result;
		
	}
	
	public static ResultSet queryPraticienH() throws SQLException{
		result = Singleton.getResult(tblSQuerySelect[1]);
		return result;
		
	}
	public static ResultSet queryVisiteur() throws SQLException{
		result = Singleton.getResult(tblSQuerySelect[3]);
		return result;
		
	}
	public static ResultSet queryCompteRendu(String colMatricule,int year,int month) throws SQLException{
		
		PreparedStatement pstmt = (PreparedStatement) Singleton.prepareStatement(tblSQuerySelect[2]);
		pstmt.setString(1,colMatricule);
		pstmt.setInt(2,year);
		pstmt.setInt(3,month);
		
		ResultSet result = Singleton.getResult(pstmt);
		
		return result;
	}
	

}
