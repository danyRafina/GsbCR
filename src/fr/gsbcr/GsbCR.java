package fr.gsbcr;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import fr.gsbcr.controller.Controleur;
import fr.gsbcr.database.Singleton;
import fr.gsbcr.model.ModeleCompteRendu;
import fr.gsbcr.model.ModeleException;
import fr.gsbcr.views.GuiGsbCR;
import fr.gsbcr.views.StartApp;

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
	 * @param args Arguments
	 * @throws UnsupportedLookAndFeelException   Peut générer une exception d'incompatibilité
	 * @throws IllegalAccessException   Peut générer une exception d'accès illégal
	 * @throws InstantiationException  Peut générer une exception d'instanciation
	 * @throws ClassNotFoundException  Peut générer une exception de ClassNotFound
	 * @throws SQLException  Peut générer une exception sql
	 * @throws ModeleException Peut générer une exception 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ModeleException, UnsupportedLookAndFeelException {
		StartApp.startApp();
		System.out.println("GsbCR::main()") ;
		
		System.out.println("[Création d'une instance de connexion]") ;
		
		Singleton.getAInstance() ;
		
		System.out.println("[Création d'un Statement]") ;
		
		Singleton.getStmt();
		
		System.out.println("[Création du modèle]") ;
		ModeleCompteRendu modele = new ModeleCompteRendu() ;
		
		System.out.println(" [Création du contrôleur]") ;
		Controleur controleur = new Controleur(modele) ;
		
		System.out.println(" [Création de la vue principale]") ;
		new GuiGsbCR(modele,controleur) ;
	}
	
	
	

}


 
