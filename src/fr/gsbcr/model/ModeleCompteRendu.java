package fr.gsbcr.model;
import fr.gsbcr.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.* ;

/** Modèle de l'application
 * 
 * @author rafina
 *
 */
public class ModeleCompteRendu  {
	private List<Collaborateur> visiteur = new ArrayList<Collaborateur>() ;
	private List<Praticien> praticien = new ArrayList<Praticien>() ;
	private List<CompteRendu> compteRendus = new ArrayList<CompteRendu>();
	private ResultSet result = null;
	private Date newDate = null ;
	private String sMatriculeDelegC = null;
	private CompteRendu contreRenduSelected = null;
	
	/** Créer le modèle
	 * @throws SQLException  Peut générer une exception sql
	 * 
	 */
	public ModeleCompteRendu() throws SQLException{
		super() ;
		System.out.println("ModeleCompteRendu::ModeleCompteRendu()") ;	
	}
	
	/** Peupler la liste des Praticiens hésitants
	 * @throws SQLException Peut générer une exception SQL
	 * @throws ParseException  
	 * 
	 */
	
	private void initListePraticienH() throws SQLException, ParseException {
		this.result= Queries.queryPraticienH();
		while (result.next()) {
			this.praticien.add(new Praticien(result.getInt("PRA_NUM"),result.getString("PRA_NOM"),result.getString("PRA_PRENOM"), result.getString("PRA_ADRESSE"), result.getInt("PRA_CP"),result.getString("PRA_VILLE"),result.getFloat("PRA_COEFNOTORIETE"),result.getInt("COEF_CONF"),0));
		}
		for(Praticien unPraticien : praticien){

			unPraticien.setiTpsEcouleDV(this.diffEnJour(unPraticien.getPraNum()));
		}
		
	}

	/** Rechercher l'équivalent du chiffre réprésentant l'état de lecture d'un compte rendu à une chaîne de caractère
	 * 
	 * @param number Chiffre réprésentant l'état de lecture d'un compte rendu
	 * @return L'équivalent du chiffre réprésentant l'état de lecture d'un compte rendu
	 */
	public String getEquivalent(Byte number){
		String sWord = null;
		if (number== 1){
			sWord = "LU";
		}
		else {
			sWord="NON LU";
		}
		return sWord;
	}
	
	
	/** Retourne la liste des comptes-rendus
	 * @return La liste des comptes-rendus
	 */
	public List<CompteRendu> getCompteRendus() {
		return compteRendus;
	}
	
	/** Rechercher un compte-rendu
	 * 
	 * @param sColMatricule Matricule du visiteur
	 * @param iNumCR Numéro du compte-rendu 
	 */
	public void rechercherCR(String sColMatricule, int iNumCR){
		for(CompteRendu unCompteRendu : compteRendus){
			if(sColMatricule == unCompteRendu.getCollaborateur().getsColMatricule() && iNumCR == unCompteRendu.getiNumCR()){
				this.contreRenduSelected  = unCompteRendu;
			}
		}
	}
	
	/** Rechercher un collaborateur
	 * 
	 * @param sColMatricule Matricule du collaborateur à rechercher
	 * @return Le collaborateur recherché
	 */
	public Collaborateur rechercherCollabo(String sColMatricule){
		Collaborateur collaborateur = null;
		for(Collaborateur unCollabo : visiteur){
			if(sColMatricule == unCollabo.getsColMatricule()){
				collaborateur = unCollabo;
			}
		}
		return collaborateur;
	}
	
	/** Rechercher un praticien
	 * 
	 * @param iPraNum Le numéro du praticien à rechercher
	 * @return Le praticien recherché
	 */
	public Praticien rechercherPraticien(int iPraNum){
		Praticien pratic = null;
		for(Praticien unPraticien : praticien){
			if(iPraNum == unPraticien.getPraNum()){
				pratic = unPraticien;
			}
		}
		return pratic;
	}
	
	/** Modifier l'état de lecture du compte-rendu
	 * 
	 * @param iRapNum Numéro du compte-rendu
	 * @throws SQLException  Peut générer une exception sql
	 */
	public void setRapLu(int iRapNum) throws SQLException{
		Queries.setRapLu(iRapNum);
	}

	/** Vérifier si le collaborateur est un visiteur
	 * 
	 * @param unCollaborateur Collaborateur à vérifier
	 * @return Vrai si le collaborateur est un visiteur
	 */
	public boolean estVisiteur(Collaborateur unCollaborateur){
		switch((unCollaborateur.getsColRole())) {
			case "VISITEUR" :
				return true;
		default :
				return false;
		}	
	}
	
	/** Essayer de se connecter
	 * 
	 * @param login Identifiant de l'utilisateur
	 * @param mdp Mot de passe de l'utilisateur
	 * @return Vrai si l'identifiant et le mot de passe correspondent
	 * @throws SQLException  Peut générer une exception sql
	 * @throws ParseException Peut générer une exception
	 */
	public boolean seConnecter(String login, String mdp) throws SQLException, ParseException {
		boolean bToAccess = false;
		this.result = Queries.queryDelegue(login,mdp);
		while (result.next()) {
			if(login.equals(result.getString("COL_MATRICULE"))) {
				if(mdp.equals(result.getString("COL_MDP"))) {
					bToAccess = true;
					this.setDelegueConnecter(result.getString("COL_MATRICULE"));
					this.initListeVis();
					this.initListePraticienH();
				}
			}
		}
		return bToAccess;
	}
	/** Récupérer le compte-rendu
	 * 
	 * @param year L'année de rédaction du compte-rendu
	 * @param month Mois de rédaction du compte-rendu
	 * @param colMatricule Matricule du Visiteur
	 * @return Vrai si le compte rendu existe
	 * @throws SQLException  Peut générer une exception sql
	 */
	public boolean getCR(int year,int month,String colMatricule) throws SQLException{
		this.compteRendus.clear();
		boolean bSuccess = false;
		this.compteRendus.clear();
		this.result= Queries.queryCompteRendu(colMatricule,year,month);
		while (this.result.next()) {
		   System.out.println("PASSAGE WHILE 3");
		   Collaborateur collabo = rechercherCollabo(colMatricule);
		   Praticien pra = rechercherPraticien(result.getInt("PRA_NUM"));
		   
			this.compteRendus.add(new CompteRendu(collabo,result.getInt("RAP_NUM"), pra, result.getDate("RAP_DATE"),result.getDate("DATE_VISITE"),result.getString("RAP_BILAN"),result.getString("MOT_LABEL"),result.getInt("COEF_CONF"),getEquivalent(result.getByte("RAP_EST_LU"))));
			System.out.println(collabo.getsColMatricule()+" ");
		}
		if(compteRendus.size() == 0){
			bSuccess = true;
		}
		return bSuccess;
	}
	
	/** Obtenir la liste des praticien hésitants
	 * @return La liste des praticien hésitants
	 */
	public List<Praticien> getPraticienH() {
		// TODO Auto-generated method stub
		return this.praticien;
	}

	/** Obtenir la liste des visiteurs
	 * @return la lsite des visiteurs
	 */
	public List<Collaborateur> getVisiteur() {
		return visiteur;
	}
	
	/** Obtenir le temps écoulé entre la date de visite du praticien et la date actuelle
	 * 
	 * @param iPraNum Numéro du praticien
	 * @return Nombre de jour de différence
	 * @throws SQLException Peut générer une exception sql
	 * @throws ParseException Peut généré une erreur de conversion
	 */
	public long diffEnJour(int iPraNum) throws SQLException, ParseException{
		this.result = Queries.getDateVisite(iPraNum);
		while(result.next()){
			String sDateVisite = this.result.getString("DATE_VISITE");
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");;
	        newDate = formatter.parse(sDateVisite +" 00:00:00");
	        System.out.println(newDate);
	     }
	     Date today = new Date();
	     long diff = today.getTime( ) - newDate.getTime( );
	     long resultDate = diff / (1000*60*60*24);
	     return resultDate;
	}
	
	/** Obtenir le matricule du délégué connecté
	 * 
	 * @return Matricule du délégué connecté
	 */
	public String getDelegueConnecter(){
		return this.sMatriculeDelegC;
	}
	
	/** Définir un matricule du délégué connecté
	 * 
	 * @param sMatriculeDelegC Matricule du délégué
	 */
	public void setDelegueConnecter(String sMatriculeDelegC){
		this.sMatriculeDelegC = sMatriculeDelegC;
	}
	
	/** Initialisation de la liste des visiteurs en fonction du délégué connecté
	 * 
	 * @throws SQLException Peut générer une exception SQL
	 */
	public void initListeVis() throws SQLException{
		
		this.result = Queries.queryVisiteur(this.getDelegueConnecter());
		while (result.next()) {

			this.visiteur.add(new Collaborateur(result.getString("COL_MATRICULE"),result.getString("COL_NOM"), result.getString("COL_PRENOM"), result.getString("COL_ADRESSE"), result.getInt("COL_CP"),result.getString("COL_VILLE"),result.getString("TRA_ROLE"),result.getString("COL_MDP")));
		}
	}
	
	/** Réinitialiser tous les attributs de la classe
	 * 
	 */
	public void autoReset(){
		this.visiteur = new ArrayList<Collaborateur>() ;
		this.praticien = new ArrayList<Praticien>();
		this.compteRendus = new ArrayList<CompteRendu>();
		this.result = null;
		this.newDate = null ;
		this.sMatriculeDelegC = null;
		this.contreRenduSelected = null;
	}

	/** Retourne le compte-rendu sélectionné
	 * @return Le contre-rendu sélectionné
	 */
	public CompteRendu getContreRenduSelected() {
		return contreRenduSelected;
	}

	/** Modifier le compte-rendu séléctionné
	 * @param contreRenduSelected Le compte-rendu à définir
	 */
	public void setContreRenduSelected(CompteRendu contreRenduSelected) {
		this.contreRenduSelected = null;
		this.contreRenduSelected = contreRenduSelected;
	}
	
	/** Trier la liste des praticiens hésitants
	 * 
	 * @param critere Critère de tri
	 */
	public void sortListPraticien(String critere){
		switch(critere){
		case "coefN":
			Collections.sort(this.praticien,Praticien.COEFN_COMPARATOR.reversed());
			break;
		case "coefC":
			Collections.sort(this.praticien,Praticien.COEFCF_COMPARATOR.reversed());
			break;
		case "TpsC":
			Collections.sort(this.praticien,Praticien.TPSE_COMPARATOR.reversed());
			break;
		}
		
		
	}
	
	/** Trier la liste des comptes-rendus
	 * 
	 * @param critere Critère de tri
	 */
	public void sortListCR(String critere){
		switch(critere){
		case "Croissant":
			Collections.sort(this.compteRendus);
			break;
		/*case "Décroissant":
			Collections.sort(this.compteRendus,Collections.reverseOrder());
			break;*/
		}
		
		
	}


}
