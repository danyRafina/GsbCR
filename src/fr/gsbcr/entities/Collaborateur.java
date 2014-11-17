package fr.gsbcr.entities;

import java.util.GregorianCalendar;

/** Classe Collaborateur de l'application 
 * @author rafina
 */

public class Collaborateur {
	
	private String sColMatricule ;
	private String sColNom;
	private String sColPrenom;
	private String sColAdresse;
	private int iColCP;
	private String sColVille;
	private  GregorianCalendar gcColDateEmbauche;
	private String sColRole ;
	private String sColMdp;
	
	
	/** Création d'un collaborateur
	 * @param sColMatricule Matricule du collaborateur
	 * @param sColNom Nom du collaborateur
	 * @param sColPrenom Prénom du collaborateur
	 * @param sColAdresse Adresse du collaborateur
	 * @param iColCP Code postal du collaborateur
	 * @param sColVille Ville du collaborateur
	 * @param sColRole Role du collaborateur
	 * @param sColMdp Mot de passe du collaborateur
	 */
	public Collaborateur(String sColMatricule, String sColNom,
			String sColPrenom, String sColAdresse, int iColCP,
			String sColVille,
			String sColRole,String sColMdp) {
		super();
		this.sColMatricule = sColMatricule;
		this.sColNom = sColNom;
		this.sColPrenom = sColPrenom;
		this.sColAdresse = sColAdresse;
		this.iColCP = iColCP;
		this.sColVille = sColVille;
		this.sColRole = sColRole;
		this.sColMdp = sColMdp;
	}

	
	/** Obtenir le mot de passe du collaborateur
	 * @return sColMdp Mot de passe du collaborateur
	 */
	public String getsColMdp() {
		return sColMdp;
	}
	
	/** Modifier le mot de passe du collaborateur
	 * @param sColMdp Mot de passe du collaborateur
	 */
	public void setsColMdp(String sColMdp) {
		this.sColMdp = sColMdp;
	}
	
	/** Obtenir le matricule du collaborateur
	 * @return sColMatricule Matricule du collaborateur
	 */
	public String getsColMatricule() {
		return sColMatricule;
	}
	
	/** Modifier le matricule du collaborateur
	 * @param sColMatricule Matricule du collaborateur
	 */
	public void setsColMatricule(String sColMatricule) {
		this.sColMatricule = sColMatricule;
	}
	/** Obtenir le nom du collaborateur
	 * 
	 * @return sColNom Nom du collaborateur
	 */
	public String getsColNom() {
		return sColNom;
	}
	/** Modifier le nom du collaborateur
	 * 
	 * @param sColNom Nom du collaborateur
	 */
	public void setsColNom(String sColNom) {
		this.sColNom = sColNom;
	}
	/** Obtenir le prénom du collaborateur
	 * 
	 * @return sColPrenom du collaborateur
	 */
	public String getsColPrenom() {
		return sColPrenom;
	}
	
	/** Modifier le prénom du collaborateur
	 * 
	 * @param sColPrenom Prénom du collaborateur
	 */
	public void setsColPrenom(String sColPrenom) {
		this.sColPrenom = sColPrenom;
	}
	
	/** Obtenir l'adresse du collaborateur
	 * 
	 * @return sColAdresse Adresse du collaborateur
	 */
	public String getsColAdresse() {
		return sColAdresse;
	}
	
	/** Modifier l'adresse du collaborateur
	 * 
	 * @param sColAdresse Adresse du collaborateur
	 */
	public void setsColAdresse(String sColAdresse) {
		this.sColAdresse = sColAdresse;
	}
	
	/** Obtenir le code postal du collaborateur
	 * 
	 * @return Code postal du collaborateur
	 */
	public int getiColCP() {
		return iColCP;
	}
	
	/** Modifier le code postal du collaborateur
	 * 
	 * @param iColCP Code postal du collaborateur
	 */
	public void setiColCP(int iColCP) {
		this.iColCP = iColCP;
	}
	
	/** Obtenir la ville du collaborateur
	 * 
	 * @return sColVille Ville du collaborateur
	 */
	public String getsColVille() {
		return sColVille;
	}
	
	/** Modifier la ville du collaborateur
	 * 
	 * @param sColVille Ville du collaborateur
	 */
	
	public void setsColVille(String sColVille) {
		this.sColVille = sColVille;
	}
	
	/** Obtenir la date d'embauche du collaborateur 
	 * 
	 * @return Date d'embauche du collaborateur
	 */
	
	public GregorianCalendar getGcColDateEmbauche() {
		return gcColDateEmbauche;
	}
	
	/** Modiifier la date d'embauche du collaborateur
	 * 
	 * @param gcColDateEmbauche Date d'embauche du collaborateur
	 */
	public void setGcColDateEmbauche(GregorianCalendar gcColDateEmbauche) {
		this.gcColDateEmbauche = gcColDateEmbauche;
	}
	
	/** Obtenir le rôle du collaborateur
	 * 
	 * @return sColRole Rôle du collaborateur
	 */

	public String getsColRole() {
		return sColRole;
	}

	/** Modifier le rôle du collaborateur
	 * 
	 * @param sColRole Rôle du collaborateur
	 */
	public void setsColRole(String sColRole) {
		this.sColRole = sColRole;
	}
	
	@Override
	/** Réprésentation d'un collaborateur sous forme textuelle
	 * @retun forme textuelle d'un collaborateur
	 */
	public String toString() {
		return "Collaborateur [sColMatricule=" + sColMatricule + ", sColNom="
				+ sColNom + ", sColPrenom=" + sColPrenom + ", sColAdresse="
				+ sColAdresse + ", iColCP=" + iColCP + ", sColVille="
				+ sColVille + ", gcColDateEmbauche=" + gcColDateEmbauche
				+ ", sColRole=" + sColRole +  "]";
	}

	
}