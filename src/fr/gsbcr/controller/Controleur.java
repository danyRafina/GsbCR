package fr.gsbcr.controller;
import fr.gsbcr.database.Singleton;
import fr.gsbcr.entities.*;
import fr.gsbcr.model.ModeleCompteRendu;
import fr.gsbcr.views.GuiGsbCR;

import java.sql.SQLException;

/** Contrôleur de l'application
 * @author rafina
 */
public class Controleur {

	private GuiGsbCR vuePrincipale ;
	private ModeleCompteRendu modele ;
	
	/** Créer le contrôleur
	 * 
	 * @param modele Le modèle
	 */
	public Controleur(ModeleCompteRendu modele) {
		super();
		System.out.println("Controleur::Controleur()") ;
		this.modele = modele;
	}
	
	/** Obtenir la vue principale
	 * 
	 * @return La vue principale
	 */
	public GuiGsbCR getVuePrincipale() {
		System.out.println("Controleur::getVuePrincipale()") ;
		return vuePrincipale ;
	}

	/** Modifier la vue principale
	 * 
	 * @param vuePrincipale La nouvelle vue principale
	 */
	public void setVuePrincipales(GuiGsbCR vuePrincipale) {
		System.out.println("Controleur::setVuePrincipale()") ;
		this.vuePrincipale = vuePrincipale ;
	}
	
	/** Visualiser la liste  des praticiens hésitants sous une forme tabulaire
	 */
	public void visualiserPraticienH(){
		System.out.println("Controleur::visualiserPraticienH()") ;
		this.vuePrincipale.changerDeVue("Liste praticiens hesitants");                                                                                                                                                        
	}
	
	/** Visualiser la liste des visiteurs sous une forme tabulaire
	 */
	public void visualiserVisit(){
		System.out.println("Controleur::visualiserVisit()") ;
		this.vuePrincipale.changerDeVue("Liste des Visiteurs") ;
		this.visualiserModele();
	}
	
	/** Visualiser la fenêtre de connexion 
	 */
	public void visualiserConnexion(){
		System.out.println("Controleur::visualiserConnexion()") ;
		this.vuePrincipale.changerDeVue("Connexion") ;
	}
	
	/** Visualiser la liste des comptes rendus sous une forme tabulaire
	 */
	public void visualiserCR(){
		System.out.println("Controleur::visualiserCR()") ;
		this.vuePrincipale.changerDeVue("Liste des Comptes Rendus") ;
	}
	/** Visualiser les informations sur l'application
	 */
	public void visualiserAPropos() {
		this.vuePrincipale.changerDeVue("A propos") ;
		
	}
	
	/** Visualiser les informations du compte-rendu
	 */
	public void visualiserInfoCR() {
		this.vuePrincipale.changerDeVue("Info compte-rendu") ;
		
	}
	
	/** Connecter un délégué
	 * 
	 * @param sLogin L'identifiant du délégué
	 * @param sPasswd Le mot de passe du délégué
	 * @throws SQLException Peut générer une exception sql
	 * @return Vrai si il existe un délégué avec cet indentifiant et mot de passe
	 */
	public boolean seConnecter(String sLogin, String sPasswd ) throws SQLException{
		boolean bSuccess = true;
		System.out.println("Controleur::seConnecter()") ;
		boolean coOK = this.modele.seConnecter(sLogin,sPasswd) ;
		if (coOK == true ){
			this.vuePrincipale.changeStateMenu(1);
			this.vuePrincipale.changerDeVue("Liste praticiens hesitants") ;
			System.out.println("Controleur::seConnecter()::mdp et id vrai") ;
		}
		else {
			bSuccess = false;
			System.out.println("Controleur::seConnecter()::mdp ou id faux") ;
		}
		return bSuccess;
	}
	
	/** Déconnecter l'utilisateur courant
	 * @throws SQLException  Peut générer une exception sql
	 */
	public void deconnexion() throws SQLException{
		System.out.println("Controleur::deconnexion()") ;
		//Singleton.destroyInstance();
		this.vuePrincipale.changeStateMenu(0);
		this.vuePrincipale.changerDeVue("Vue Connexion") ;
	}
	
	
	/** Quitter l'application
	 */
	public void quitterApplication(){
		System.out.println("Controleur::quitterApplication()") ;
		System.exit(0) ;
	}
	
	
	/** Visualiser les données de la couche "Logique Métier"
	 * 
	 */
	public void visualiserModele(){
		System.out.println("Controleur::visualiserModele()") ;
		System.out.println("") ;
		System.out.println("------------------ Liste des Praticiens Hésitants ----------------------------") ;
		for(Praticien praticien : this.modele.getPraticienH()){
			System.out.println(praticien) ;
		}
		System.out.println("------------------- Liste des Visiteurs -----------------------------") ;
		for(Collaborateur visiteur : this.modele.getVisiteur()){
			System.out.println(visiteur) ;
		}
		System.out.println("------------------ Liste des Comptes Rendus ----------------------------") ;
		for(CompteRendu compteRendu : this.modele.getCompteRendus()){
			System.out.println(compteRendu) ;
		}
	}

	
}
