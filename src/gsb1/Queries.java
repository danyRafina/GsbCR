package gsb1;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {
	private static String tblSQuerySelect[] = {
		"SELECT * from collaborateur inner join travailler on collaborateur.COL_MATRICULE = travailler.COL_MATRICULE where TRA_ROLE != 'Responsable' ",
		"SELECT * from praticien",
		"SELECT * from rapport_visite"
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
	public static ResultSet queryCompteRendu() throws SQLException{
		result = Singleton.getResult(tblSQuerySelect[2]);
		return result;
	}
	

}
