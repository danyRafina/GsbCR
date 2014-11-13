package gsb1;

import java.sql.SQLException;
import java.util.* ;

import javax.swing.JOptionPane;

/** Contrôleur de l'application
 * 
 * @author gsb
 *
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
	
	/** Visualiser la liste praticien hésitant sous une forme tabulaire
	 * 
	 */
	public void visualiserPraticienH(){
		System.out.println("Controleur::visualiserPraticienH()") ;
		this.vuePrincipale.changerDeVue("Liste praticiens hesitants");                                                                                                                                                        
	}
	
	/** Visualiser la liste des locations sous une forme tabulaire
	 * 
	 */
	public void visualiserVisit(){
		System.out.println("Controleur::visualiserVisit()") ;
		this.vuePrincipale.changerDeVue("Liste des Visiteurs") ;
	}
	
	/** Visualiser la liste des locations sous une forme tabulaire
	 * 
	 */
	public void visualiserConnexion(){
		System.out.println("Controleur::visualiserConnexion()") ;
		this.vuePrincipale.changerDeVue("Connexion") ;
	}
	
	/** Visualiser la liste des véhicules sous une forme tabulaire
	 * 
	 */
	public void visualiserVehicules(){
		System.out.println("Controleur::visualiserVehicules()") ;
		this.vuePrincipale.changerDeVue("Liste véhicules");
	}
	
	
	
	/** Afficher le formulaire de saisie d'un nouveau client
	 * 
	 */
	public void saisirNouveauClient(){
		System.out.println("Controleur::saisirNouveauClient()") ;
		this.vuePrincipale.changerDeVue("Nouveau client");
	}
	
	/** Afficher le formulaire de saisie d'une nouvelle location
	 * 
	 */
	public void saisirNouvelleLocation(){
		System.out.println("Controleur::saisirNouvelleLocation()") ;
		this.vuePrincipale.changerDeVue("Nouvelle location");
	}
	
	
	/** Enregistrer un nouveau client
	 * 
	 * @param nom Le nom du client
	 * @param prenom Le prénom du client
	 * @param mobile Le numéro de mobile du client
	 */
	public void seConnecter(String login, String mdp){
		System.out.println("Controleur::seConnecter()") ;
		boolean coOK = this.modele.seConnecter(login,mdp) ;
		if (coOK == true ){
			this.vuePrincipale.changeStateMenu(1);
			this.vuePrincipale.changerDeVue("Liste praticiens hesitants") ;
			System.out.println("Controleur::seConnecter()::mdp et id vrai") ;
		}
		else {
			this.vuePrincipale.showMessage("Erreur : Veuillez vérifer l'identifiant ou le mot de passe saisie ");
			System.out.println("Controleur::seConnecter()::mdp ou id faux") ;
		}
	}
	
	public void deconnexion() throws SQLException{
		System.out.println("Controleur::deconnexion()") ;
		 Singleton.destroyInstance();
			this.vuePrincipale.changeStateMenu(0);
			this.vuePrincipale.changerDeVue("Vue Connexion") ;
	}
	
	/** Enregistrer un nouveau client
	 * 
	 * @param nom Le nom du client
	 * @param prenom Le prénom du client
	 * @param mobile Le numéro de mobile du client
	 */
	/*public void enregistrerClient(String nom, String prenom, String mobile){
		System.out.println("Controleur::enregistrerClient()") ;
		this.modele.ajouterClient(nom,prenom,mobile) ;
		this.vuePrincipale.changerDeVue("Liste clients") ;
	}
	
	/** Annuler l'enregistrement d'un nouveau client
	 * 
	 */
	/*public void annulerEnregistrerClient(){
		System.out.println("Controleur::annulerEnregistrerClient()") ;
		this.vuePrincipale.changerDeVue("Liste clients") ;
	}
	
	/** Enregistrer une nouvelle location
	 * 
	 * @param immVehicule Le numéro d'immatriculation du véhicule réservé
	 * @param numClient Le numéro du client
	 * @param dateDepart La date de début de location
	 */
	/*public void enregistrerLocation(String immVehicule,int numClient,GregorianCalendar dateDepart){
		System.out.println("Controleur::enregistrerLocation()") ;
		this.modele.ajouterLocation(immVehicule,numClient,dateDepart) ;
		this.vuePrincipale.changerDeVue("Liste locations") ;
	}
	
	/** Annuler l'enregistrement d'une nouvelle location
	 * 
	 */
	/*public void annulerEnregistrerLocation(){
		System.out.println("Controleur::annulerEnregistrerLocation()") ;
		this.vuePrincipale.changerDeVue("Liste locations") ;
	}
	
	/** Enregistrer le départ d'un véhicule
	 * Début de la location
	 * @param numeroLocation Le numéro de la location
	 */
	/*public void enregistrerDepart(int numeroLocation){
		System.out.println("Controleur::enregistrerDepart()") ;
		this.modele.enregistrerDepartVehicule(numeroLocation) ;
		this.vuePrincipale.changerDeVue("Liste locations") ;
	}
	
	/** Enregistrer le retour d'un véhicule
	 * Fin d'une location
	 * @param numeroLocation Le numéro de la location
	 * @param nbKm Le nombre de km relevé
	 */
	/*public void enregistrerRetour(int numeroLocation, int nbKm){
		System.out.println("Controleur::enregistrerRetour()") ;
		this.modele.enregistrerRetourVehicule(numeroLocation,nbKm) ;
		this.vuePrincipale.changerDeVue("Liste locations") ;
	}
	
	/** Annuler une location
	 * Suppression de la location
	 * @param numeroLocation Le numéro de la location
	 */
	/*public void annulerLocation(int numeroLocation){
		System.out.println("Controleur::annulerLocation()") ;
		this.modele.supprimerLocation(numeroLocation) ;
		this.vuePrincipale.changerDeVue("Liste locations") ;
	}
	
	/** Quitter l'application
	 * 
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
		System.out.println("------------------- visiteur -----------------------------") ;
		for(Collaborateur visiteur : this.modele.getVisiteur()){
			System.out.println(visiteur) ;
		}
		System.out.println("------------------ Véhicules ----------------------------") ;
		/*for(Vehicule vehicule : this.modele.getVehicules()){
			System.out.println(vehicule) ;
		}*/
		System.out.println("") ;
	}
	
}
