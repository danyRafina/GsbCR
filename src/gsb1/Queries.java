package gsb1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {
	private static String tblSQuerySelect[] = {
		"SELECT * from collaborateur inner join travailler on collaborateur.COL_MATRICULE = travailler.COL_MATRICULE where TRA_ROLE != 'Responsable' ",
		"SELECT * from praticien",
		"SELECT * from rapport_visite inner join motif on rapport_visite.rap_motif= motif.mot_num where col_matricule = ? and year(rap_date) = ? and month (rap_date) = ?"
	};
	private static ResultSet result;
	
	public static ResultSet queryCollaborateur() throws SQLException{
		result = Singleton.getResult(tblSQuerySelect[0]);
		return result;
		
	}
	
	public static ResultSet queryPraticienH() throws SQLException{
		result = Singleton.getResult(tblSQuerySelect[1]);
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
