package gsb1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.time.Year;
import java.util.* ;

/** Modèle de l'application
 * 
 * @author xilim
 *
 */
public class ModeleCompteRendu {
	//private List<Collaborateur> collaborateur = new ArrayList<Collaborateur>() ;
	private List<Collaborateur> visiteur = new ArrayList<Collaborateur>() ;
	private List<Collaborateur> delegue = new ArrayList<Collaborateur>() ;
	private List<Praticien> praticien = new ArrayList<Praticien>() ;
	private List<CompteRendu> compteRendus = new ArrayList<CompteRendu>();
	private ResultSet result = null;
	//private HashMap<int,String> collaborateur = new HashMap<Collaborateur>() ;
	
	/** Créer le modèle
	 * @throws SQLException 
	 * 
	 */
	public ModeleCompteRendu() throws SQLException{
		super() ;
		System.out.println("ModeleCompteRendu::ModeleCompteRendu()") ;
		this.init();
		
	}
	/** Peupler la base de données manipulée
	 * @throws SQLException 
	 * 
	 */
	private void init() throws SQLException {
		this.result = Queries.queryCollaborateur();
		while (result.next()) {
		   System.out.println("PASSAGE WHILE");
		   if(result.getString("TRA_ROLE").equals("VISITEUR")){
			this.visiteur.add(new Collaborateur(result.getString("COL_MATRICULE"),result.getString("COL_NOM"), result.getString("COL_PRENOM"), result.getString("COL_ADRESSE"), result.getInt("COL_CP"),result.getString("COL_VILLE"),result.getString("TRA_ROLE"),result.getString("COL_MDP")));
		   }
		   else {
			   this.delegue.add(new Collaborateur(result.getString("COL_MATRICULE"),result.getString("COL_NOM"), result.getString("COL_PRENOM"), result.getString("COL_ADRESSE"), result.getInt("COL_CP"),result.getString("COL_VILLE"),result.getString("TRA_ROLE"),result.getString("COL_MDP")));
		   }
		}
		this.result= Queries.queryPraticienH();
		while (result.next()) {
		   System.out.println("PASSAGE WHILE 2");
			this.praticien.add(new Praticien(result.getInt("PRA_NUM"),result.getString("PRA_NOM"), result.getString("PRA_PRENOM"), result.getString("PRA_ADRESSE"), result.getInt("PRA_CP"),result.getString("PRA_VILLE"),result.getFloat("PRA_COEFNOTORIETE"),result.getInt("PRA_CP")));
		}
		
		
	}
	
	/** Obtenir la liste des locations
	 * 
	 * @return La liste des locations
	 */
	/*public List<Location> getLocations(){
		System.out.println("ModeleLocations::getLocations()") ;
		return this.locations ;
	}
	
	/** Obtenir la liste des clients
	 * 
	 * @return La liste des clients
	 */
	/*public List<Client> getClients(){
		System.out.println("ModeleLocations::getClients()") ;
		return this.clients ;
	}
	
	/** Obtenir la liste des véhicules
	 * 
	 * @return La liste des véhicules
	 */
	/*public Set<Vehicule> getVehicules(){
		System.out.println("ModeleLocations::getVehicules()") ;
		return this.vehicules ;
	}
	
	/** Enregistrer une nouvelle location
	 * 
	 * @param immVehicule L'immatriculation du véhicule
	 * @param numClient Le numéro du client
	 * @param dateDepart La date de départ
	 * @return true si l'enregistrement de la location s'est déroulée avec succès et false dans le cas contraire
	 */
	/*public boolean ajouterLocation(String immVehicule, int numClient, GregorianCalendar dateDepart){
		System.out.println("ModeleLocations::ajouterLocation()") ;
		boolean ajoutOk = false ;
		Vehicule vehicule = rechercherVehicule(immVehicule) ;
		if(vehicule != null){
			Client client = rechercherClient(numClient) ;
			if(client != null){
				int numero = genererNumeroLocation() ;
				Location location = new Location(numero,vehicule,client,dateDepart) ;
				location.setEtat(Location.EN_ATTENTE) ;
				location.getVehicule().setSituation(Vehicule.RESERVE) ;
				this.locations.add(location) ;
				ajoutOk = true ;
			}
		}
		return ajoutOk ;
	}
	
	/** Enregistrer une nouvelle location avec départ le jour même
	 * 
	 * @param immVehicule L'immatriculation du véhicule
	 * @param numClient Le numéro du client
	 * @return true si l'enregistrement de la location s'est déroulée avec succès et false dans le cas contraire
	 */
	/*public boolean ajouterLocation(String immVehicule, int numClient){
		System.out.println("ModeleLocations::ajouterLocation()") ;
		boolean ajoutOk = false ;
		Vehicule vehicule = rechercherVehicule(immVehicule) ;
		if(vehicule != null){
			Client client = rechercherClient(numClient) ;
			if(client != null){
				int numero = genererNumeroLocation() ;
				Location location = new Location(numero,vehicule,client) ;
				location.setEtat(Location.EN_ATTENTE) ;
				location.getVehicule().setSituation(Vehicule.RESERVE) ;
				this.locations.add(location) ;
				ajoutOk = true ;
			}
		}
		return ajoutOk ;
	}
	
	/** Enregistrer un nouveau client
	 * 
	 * @param nom Le nom
	 * @param prenom Le prénom
	 * @param mobile Le numéro de mobile
	 */
	/*public void ajouterClient(String nom, String prenom, String mobile){
		System.out.println("ModeleLocations::ajouterClient()") ;
		int numero = genererNumeroClient() ;
		this.clients.add(new Client(numero,nom,prenom,mobile)) ;
	}
	
	/** Générer un numéro unique de client
	 * 
	 * @return Le numéro de client
	 */
	/*public int genererNumeroClient(){
		System.out.println("ModeleLocations::genererNumeroClient()") ;
		int numMax = 0 ;
		for(Client client : this.clients){
			if(client.getNumero() > numMax){
				numMax = client.getNumero() ;
			}
		}
		return numMax + 1 ;
	}
	
	/** Générer un numéro unique de location
	 * 
	 * @return Le numéro de location
	 */
	/*public int genererNumeroLocation(){
		System.out.println("ModeleLocations::genererNumeroLocation()") ;
		int numMax = 0 ;
		for(Location location : this.locations){
			if(location.getNumero() > numMax){
				numMax = location.getNumero() ;
			}
		}
		return numMax + 1 ;
	}
	
	/** Rechercher un client par son numéro
	 * 
	 * @param numero Le numéro du client
	 * @return Le client ou null si le client n'est pas recensé
	 */
	/*private Client rechercherClient(int numero){
		System.out.println("ModeleLocations::rechercherClient()") ;
		Client client = null ;
		int i = 0 ;
		while(i < this.clients.size() && client == null){
			if(this.clients.get(i).getNumero() == numero){
				client = this.clients.get(i) ;
			}
			else {
				i += 1 ;
			}
		}
		return client ;
	}
	
	/** Rechercher une location par son numéro
	 * 
	 * @param numero Le numéro de la location
	 * @return La location ou null si la location n'existe pas
	 */
	/*private Location rechercherLocation(int numero){
		System.out.println("ModeleLocations::rechercherLocation()") ;
		Location location = null ;
		int i = 0 ;
		while(i < this.locations.size() && location == null){
			if(this.locations.get(i).getNumero() == numero){
				location = this.locations.get(i) ;
			}
			else {
				i += 1 ;
			}
		}
		return location ;
	}
	
	/** Rechercher un véhicule par son immatriculation
	 * 
	 * @param immatriculation L'immatriculation du véhiculeazerty
	 * 
	 * @return Le véhicule ou null si le véhicule n'est pas recensé
	 */
	/*private Vehicule rechercherVehicule(String immatriculation){
		System.out.println("ModeleLocations::rechercherVehicule()") ;
		Vehicule vehicule = null ;
		for(Vehicule unVehicule : this.vehicules){
			if(unVehicule.getImmatriculation().equals(immatriculation)){
				vehicule = unVehicule ;
			}
		}
		return vehicule ;
	}
	
	/** Obtenir la liste des locations en cours
	 * 
	 * @return La liste des locations en cours
	 */
	/*public List<Location> getLocationsEnCours(){
		System.out.println("ModeleLocations::getLocationsEnCours()") ;
		List<Location> locationsEnCours = new ArrayList<Location>() ;
		for(Location location : this.locations){
			if(location.estEnCours()){
				locationsEnCours.add(location) ;
			}
		}
		return locationsEnCours ;
	}
	
	/** Obtenir la liste des locations en attente
	 * 
	 * @return La liste des locations en attente
	 */
	/*public List<Location> getLocationsEnAttente(){
		System.out.println("ModeleLocations::getLocationsEnAttente()") ;
		List<Location> locationsEnAttente = new ArrayList<Location>() ;
		for(Location location : this.locations){
			if(location.estEnAttente()){
				locationsEnAttente.add(location) ;
			}
		}
		return locationsEnAttente ;
	}
	
	/** Obtenir la liste des véhicules disponibles
	 * 
	 * @return La liste des véhicules disponibles
	 */
	/*public Set<Vehicule> getVehiculesDisponibles(){
		System.out.println("ModeleLocations::getVehiculesDisponibles()") ;
		Set<Vehicule> vehiculesDisponibles = new HashSet<Vehicule>() ;
		for(Vehicule vehicule : this.vehicules){
			if(vehicule.estDisponible()){
				vehiculesDisponibles.add(vehicule) ;
			}
		}
		return vehiculesDisponibles ;
	}
	
	/** Supprimer une location
	 * 
	 * @param numero Le numéro de la location
	 * @return true si la suppression de la location s'est déroulée avec succès et false dans le cas contraire
	 */
	/**public boolean supprimerLocation(int numero){
		System.out.println("ModeleLocations::supprimerLocation()") ;
		Location location = rechercherLocation(numero) ;
		if(location != null){
			location.getVehicule().setSituation(Vehicule.DISPONIBLE) ;
			this.locations.remove(location) ;
			return true ;
		}
		else {
			return false ;
		}
	}
	
	/** Enregistrer le départ d'un véhicule
	 * 
	 * @param numeroLocation Le numéro de la location
	 * @return true si l'enregistrement s'est déroulé avec succès et false dans le cas contraire
	 */
	/*public boolean enregistrerDepartVehicule(int numeroLocation){
		System.out.println("ModeleLocations::enregistrerDepartVehicule()") ;
		Location location = rechercherLocation(numeroLocation) ;
		if(location != null){
			location.setEtat(Location.EN_COURS) ;
			location.setDateDepart(new GregorianCalendar()) ;
			location.getVehicule().setSituation(Vehicule.LOUE) ;
			return true ;
		}
		else {
			return false ;
		}
	}**/
	
	public String getEquivalent(Byte number){
		String word = null;
		if (number== 1){
			word = "LU";
		}
		else {
			word="NON LU";
		}
		return word;
	}
	
	public List<CompteRendu> getCompteRendus() {
		return compteRendus;
	}
	
	public Collaborateur rechercherCollabo(String sColMatricule){
		Collaborateur collaborateur = null;
		for(Collaborateur unCollabo : visiteur){
			if(sColMatricule == unCollabo.getsColMatricule()){
				collaborateur = unCollabo;
			}
		}
		return collaborateur;
	}
	
	
	public Praticien rechercherPraticien(int iPraNum){
		Praticien pratic = null;
		for(Praticien unPraticien : praticien){
			if(iPraNum == unPraticien.getPraNum()){
				pratic = unPraticien;
			}
		}
		return pratic;
	}
	
	public boolean seConnecter() {
		System.out.println("ModeleCompteRendu::seConnecter()") ;
		return true;
	}

/*
 * (non-Javadoc)
 * @see java.lang.Object#toString()
 */

/*public String toString() {
	System.out.println("ModeleLocations::toString()") ;
	return "MetierLocations [locations=" + locations + "]";
}*/
	public boolean estVisiteur(Collaborateur unCollaborateur){
		switch((unCollaborateur.getsColRole())) {
			case "VISITEUR" :
				return true;
		default :
				return false;
		}	
	}

	public boolean seConnecter(String login, String mdp) {
		boolean bToAccess = false;
		for(Collaborateur delegue : this.delegue) {
			if(login.equals(delegue.getsColMatricule())) {
				
				if(mdp.equals(delegue.getsColMdp())) {
					bToAccess = true;
				}
			}
		}
		System.out.println(bToAccess+ " ");
		return bToAccess;
		
		// TODO Auto-generated method stub
		
	}
	
	public boolean getCR(int year,int month,String colMatricule) throws SQLException{
		boolean bSuccess = false;
		this.compteRendus.clear();
		this.result= Queries.queryCompteRendu(colMatricule,year,month);
		while (this.result.next()) {
		   System.out.println("PASSAGE WHILE 3");
		   Collaborateur collabo = rechercherCollabo(result.getString("COL_MATRICULE"));
		  Praticien pra = rechercherPraticien(result.getInt("PRA_NUM"));
		   
			this.compteRendus.add(new CompteRendu(collabo,result.getInt("RAP_NUM"), pra, result.getDate("RAP_DATE"),result.getDate("DATE_VISITE"),result.getString("RAP_BILAN"),result.getString("MOT_LABEL"),result.getInt("COEF_CONF"),getEquivalent(result.getByte("RAP_EST_LU"))));
		}
		if(compteRendus.size() == 0){
			System.out.println("CR LIST SIZE "+ compteRendus.size());
			bSuccess = true;
		}
		return bSuccess;
	}
	public List<Praticien> getPraticienH() {
		// TODO Auto-generated method stub
		return this.praticien;
	}
	/*public List<Collaborateur> getCollaborateurs() {
		// TODO Auto-generated method stub
		return this.collaborateur;
	}*/
	public List<Collaborateur> getVisiteur() {
		return visiteur;
	}
	public void setVisiteur(List<Collaborateur> visiteur) {
		this.visiteur = visiteur;
	}
	public List<Collaborateur> getDelegue() {
		return delegue;
	}
	public void setDelegue(List<Collaborateur> delegue) {
		this.delegue = delegue;
	}
	
	
}
