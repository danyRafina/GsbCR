package fr.gsbcr.database;

import javax.swing.JOptionPane;

/** Chargeur du driver mysql
 * @author rafina
 */
public class LoadingDriver {
	
	private String sDriverInf ="com.mysql.jdbc.Driver";
	
	/** Création du chargeur 
	 * @throws ClassNotFoundException Peut généré une exception de type ClassNotFoundException
	 */
	
	public LoadingDriver() throws ClassNotFoundException {
		try {
			Class.forName(this.sDriverInf);
		}
		catch (ClassNotFoundException event){
			JOptionPane.showMessageDialog(null,"Erreur du chargement du driver mysql : "+ event.getMessage());
		}
	}

}
