package gsb1;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.*;
import java.awt.event.*;

import javax.swing.UnsupportedLookAndFeelException;

/** Classe principale de l'application
 * 
 * @author gsb
 *
 */
public class GsbCR {

	/**
	 * @param args
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws ModeleException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ModeleException, UnsupportedLookAndFeelException {
		StartApp.startApp();
		System.out.println("GsbCR::main()") ;
		
		System.out.println("Instanciation de Singleton") ;
		
		Singleton.getAInstance() ;
		
		Singleton.getStmt();
		
		System.out.println(" [Création du mod�le]") ;
		ModeleCompteRendu modele = new ModeleCompteRendu() ;
		
		System.out.println(" [Création du contrôleur]") ;
		Controleur controleur = new Controleur(modele) ;
		
		System.out.println(" [Création de la vue principale]") ;
		new GuiGsbCR(modele,controleur) ;
	}
	
	

}


 
