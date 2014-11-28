package fr.gsbcr.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import fr.gsbcr.database.Singleton;

/** Classe Quieres de l'application
 * @author rafina
 *
 */
public class Queries {
	private static String tblSQuerySelect[] = {
		"SELECT COLLABORATEUR.COL_MATRICULE ,COL_MDP from COLLABORATEUR inner join TRAVAILLER ON COLLABORATEUR.COL_MATRICULE = TRAVAILLER.COL_MATRICULE where COLLABORATEUR.COL_MATRICULE = ? AND COL_MDP = ? AND TRA_ROLE='Délégué'",
		"SELECT * from PRATICIEN inner join RAPPORT_VISITE on RAPPORT_VISITE.PRA_NUM= PRATICIEN.PRA_NUM where COEF_CONF < 5 ",
		"SELECT * from RAPPORT_VISITE inner join MOTIF on RAPPORT_VISITE.RAP_MOTIF= MOTIF.MOT_NUM where COL_MATRICULE = ? and year(RAP_DATE) = ? and month (RAP_DATE) = ?",
		"SELECT * from COLLABORATEUR inner join TRAVAILLER on COLLABORATEUR.COL_MATRICULE = TRAVAILLER.COL_MATRICULE where TRA_ROLE = 'Visiteur'  AND  TRAVAILLER.REG_CODE IN (SELECT REGION.REG_CODE FROM REGION inner join TRAVAILLER ON TRAVAILLER.REG_CODE = REGION.REG_CODE where COL_MATRICULE = ? AND TRA_ROLE='Délégué') ",
		"UPDATE RAPPORT_VISITE SET RAP_EST_LU = 1 WHERE RAP_NUM = ? ",
		"SELECT DATE_VISITE from RAPPORT_VISITE WHERE PRA_NUM = ?"
	};
	private static ResultSet result;
	
	/** Récupération d'un délégué
	 * @param login Identifiant du délégué
	 * @param mdp mot de passe du délégué
	 * @return Résultat de la requête
	 * @throws SQLException  Peut générer une exception sql
	 */
	public static ResultSet queryDelegue(String login,String mdp) throws SQLException{
		PreparedStatement pstmt = Singleton.prepareStatement(tblSQuerySelect[0]);
		pstmt.setString(1,login);
		pstmt.setString(2,mdp);
		result = Singleton.getResult(pstmt);
		return result;
		
	}
	
	/** Récupération des praticiens hésitants
	 * @return Résultat de la requête 
	 * @throws SQLException  Peut générer une exception sql
	 */
	public static ResultSet queryPraticienH() throws SQLException{
		result = Singleton.getResult(tblSQuerySelect[1]);
		return result;
		
	}
	
	/** Récupération des visiteurs travaillant pour le délégué connecté
	 * @param sMatriculeDeg Matricule du délégué connecté
	 * @return Résultat de la requête 
	 * @throws SQLException  Peut générer une exception sql
	 */
	public static ResultSet queryVisiteur(String sMatriculeDeg) throws SQLException{
		PreparedStatement pstmt = (PreparedStatement) Singleton.prepareStatement(tblSQuerySelect[3]);
		pstmt.setString(1,sMatriculeDeg);
		ResultSet result = Singleton.getResult(pstmt);
		return result;
		
	}
	
	/** Récupération des compte-rendus
	 * @param sColMatricule Matricule du visiteur
	 * @param iYear Année de rédaction du compte-rendu
	 * @param iMonth Mois de rédaction du compte-rendu
	 * @return Résultat de la requête 
	 * @throws SQLException  Peut générer une exception sql
	 */
	public static ResultSet queryCompteRendu(String sColMatricule,int iYear,int iMonth) throws SQLException{
		
		PreparedStatement pstmt = (PreparedStatement) Singleton.prepareStatement(tblSQuerySelect[2]);
		pstmt.setString(1,sColMatricule);
		pstmt.setInt(2,iYear);
		pstmt.setInt(3,iMonth);
		
		ResultSet result = Singleton.getResult(pstmt);
		
		return result;
	}
	
	/** Définir un état de lecture pour un compte-rendu
	 * @param iRapNum Numéro du compte-rendu
	 * @throws SQLException  Peut générer une exception sql
	 */
	public static void setRapLu(int iRapNum) throws SQLException{
			PreparedStatement pstmt = (PreparedStatement) Singleton.prepareStatement(tblSQuerySelect[4]);
			pstmt.setInt(1,iRapNum);
			pstmt.executeUpdate();
	}
	
	/** Récupérer la date de visite d'un compte-rendu en fonction du praticien
	 * @param iPraNum Numéro du praticien
	 * @return Résultat de la requête 
	 * @throws SQLException  Peut générer une exception sql
	 */
	public static ResultSet getDateVisite(int iPraNum) throws SQLException{
			
			PreparedStatement pstmt = (PreparedStatement) Singleton.prepareStatement(tblSQuerySelect[5]);
			pstmt.setInt(1,iPraNum);
			ResultSet result = Singleton.getResult(pstmt);
			return result;
	}
	

}
