package gsb1;

import java.sql.ResultSet;
import java.sql.SQLException;
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
			this.praticien.add(new Praticien(result.getInt("PRA_NUM"),result.getString("PRA_NOM"), result.getString("PRA_PRENOM"), result.getString("PRA_ADRESSE"), result.getInt("PRA_CP"),result.getString("PRA_VILLE"),result.getFloat("PRA_COEFNOTORIETE")));
		}
		
	}
		
		//System.out.println("ModeleLocations::init()") ;
		/*this.vehicules.add(new Vehicule("AA-111-AA","Citroën C1",2014,1000)) ;
		this.vehicules.add(new Vehicule("BB-222-BB","Citroën C2",2011,22000)) ;
		this.vehicules.add(new Vehicule("CC-333-CC","Citroën C3",2012,3000)) ;
		this.vehicules.add(new Vehicule("DD-444-DD","Citroën C4",2012,40000)) ;
		this.vehicules.add(new Vehicule("EE-555-EE","Citroën C5",2011,100000)) ;
		this.vehicules.add(new Vehicule("FF-666-FF","Citroën C2",2013,52000)) ;
		this.vehicules.add(new Vehicule("GG-777-GG","Citroën C3",2013,48020)) ;
		this.vehicules.add(new Vehicule("HH-888-HH","Citroën C4",2013,59230)) ;
		this.vehicules.add(new Vehicule("II-999-II","Citroën C2",2012,70323)) ;
		this.vehicules.add(new Vehicule("JJ-010-JJ","Citroën C4",2011,55827)) ;
		this.vehicules.add(new Vehicule("KK-020-KK","Citroën C5",2014,1200)) ;
		
		this.clients.add(new Client(1,"GENPRI","Erwan","0682492032")) ;
		this.clients.add(new Client(2,"KERREH","Armèle","0638678858")) ;
		this.clients.add(new Client(3,"TEFFON","Christophe","0627032673")) ;
		this.clients.add(new Client(5,"ARAUZO","Julien","0639607542")) ;
		this.clients.add(new Client(6,"MILLET","Antoine","0619264309")) ;
		this.clients.add(new Client(7,"KIENTZEL","Louis","0729443875")) ;
		this.clients.add(new Client(8,"BELHADJ","Taslim","0640908628")) ;
		this.clients.add(new Client(9,"BELLAICHE","Mikaël","0631784099")) ;
		this.clients.add(new Client(10,"BRIATTE","Guillaume","0628365347")) ;
		this.clients.add(new Client(11,"COESNOM","Florian","0696784358")) ;
		this.clients.add(new Client(12,"HURON","Kévin","0721011728")) ;
		this.clients.add(new Client(13,"JACQUIER","Nicolas","0606293623")) ;
		this.clients.add(new Client(14,"N'DIAYE","Mamadou","0630879007")) ;
		this.clients.add(new Client(15,"POIRIER","Nicolas","0657398079")) ;
		this.clients.add(new Client(16,"RAFINA","Dany","0638586890")) ;
		this.clients.add(new Client(17,"ROSCO","Steve","0620184981")) ;
		this.clients.add(new Client(18,"UZAN","Alexis","0667838291")) ;
		this.clients.add(new Client(19,"WELLE","Guillaume","0659023320")) ;
		
		this.ajouterLocation("AA-111-AA",3,new GregorianCalendar(2014,6,1)) ;
		this.ajouterLocation("BB-222-BB",5,new GregorianCalendar(2014,6,5)) ;
		this.ajouterLocation("DD-444-DD",1,new GregorianCalendar(2014,6,2)) ;
		this.ajouterLocation("HH-888-HH",10,new GregorianCalendar(2014,6,3)) ;
		this.ajouterLocation("KK-020-KK",4,new GregorianCalendar(2014,6,2)) ;
		this.ajouterLocation("EE-555-EE",9,new GregorianCalendar(2014,6,3)) ;
		this.ajouterLocation("CC-333-CC",15,new GregorianCalendar(2014,6,2)) ;
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
	
	/** Enregistrer le retour d'un véhicule
	 * 
	 * @param numeroLocation Le numéro de la location
	 * @param nombreKm Le nombre de kilomètres au compteur
	 * @return true si l'enregistrement s'est déroulé avec succès et false dans le cas contraire
	 */
	/*public boolean enregistrerRetourVehicule(int numeroLocation, int nombreKm){
		System.out.println("ModeleLocations::enregistrerRetourVehicule()") ;
		Location location = rechercherLocation(numeroLocation) ;
		if(location != null){
			location.setEtat(Location.TERMINEE) ;
			location.setDateRetour(new GregorianCalendar()) ;
			location.getVehicule().setSituation(Vehicule.DISPONIBLE) ;
			location.getVehicule().setCompteur(nombreKm) ;
			return true ;
		}
		else {
			return false ;
		}
	}*/
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
