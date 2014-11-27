package fr.gsbcr.entities;

import java.util.Date;

/** Classe Compre Rendu de l'application
 * @author rafina
 */
/**
 * @author rafina
 *
 */
public class CompteRendu implements Comparable<CompteRendu>{
	private Collaborateur collaborateur;
	private int iNumCR;
	private Praticien praticien;
	private Date dDateCR;
	private Date dDateVisite;
	private String sBilanCR;
	private String sMotifCR;
	private int iCoefConfCR;
	private String byEstLuCR;
	
	
	/**Création d'un compte rendu
	 * 
	 * @param collaborateur collaborateur ayant rédiger le compte rendu
	 * @param iNumCR Numéro du compte rendu
	 * @param praticien Praticien concerné par le compte rendu
	 * @param dDateCR Date de rédaction du compte rendu	
	 * @param dDateVisite Date de visite 
	 * @param sBilanCR Bilan contenu dans le compte rendu
	 * @param sMotifCR Motif du compte rendu
	 * @param iCoefConfCR Coefficient de confiance 
	 * @param byEstLuCR Etat de lecture du compte rendu
	 */
	public CompteRendu(Collaborateur collaborateur, int iNumCR, Praticien praticien,
			Date dDateCR,Date dDateVisite,String sBilanCR, String sMotifCR, int iCoefConfCR,
			String byEstLuCR) {
		super();
		this.collaborateur = collaborateur;
		this.iNumCR = iNumCR;
		this.praticien = praticien;
		this.dDateCR = dDateCR;
		this.dDateVisite = dDateVisite;
		this.sBilanCR = sBilanCR;
		this.sMotifCR = sMotifCR;
		this.iCoefConfCR = iCoefConfCR;
		this.byEstLuCR = byEstLuCR;
	}


	/** Obtenir le collaborateur 
	 * @return le collaborateur
	 */
	public Collaborateur getCollaborateur() {
		return collaborateur;
	}


	/** Définir un collaborateur
	 * @param collaborateur Le nouveau collaborateur à définir
	 */
	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}


	/** Obtenir le numéro du compte rendu
	 * @return Le numéro du compte rendu
	 */
	public int getiNumCR() {
		return iNumCR;
	}


	/** Modifier le numéro du compte rendu
	 * @param iNumCR Le nouveau numéro du compte rendu
	 */
	public void setiNumCR(int iNumCR) {
		this.iNumCR = iNumCR;
	}


	/** Obtenir le praticien 
	 * @return Le praticien
	 */
	public Praticien getPraticien() {
		return praticien;
	}


	/** Définir un praticien 
	 * @param praticien Le nouveau praticien à définir
	 */
	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}


	/** Obtenir la date de rédaction du compte rendu
	 * @return La date de rédaction
	 */
	public Date getdDateCR() {
		return dDateCR;
	}


	/** Modifier la date de rédaction du compte rendu
	 * @param dDateCR La nouvelle date de rédaction
	 */
	public void setdDateCR(Date dDateCR) {
		this.dDateCR = dDateCR;
	}


	/** Obtenir la date de visite
	 * @return La date de visite
	 */
	public Date getdDateVisite() {
		return dDateVisite;
	}


	/** Modifier la date de visite
	 * @param dDateVisite La nouvelle date de visite 
	 */
	public void setdDateVisite(Date dDateVisite) {
		this.dDateVisite = dDateVisite;
	}


	/** Obtenir le bilan du compte rendu
	 * @return Le bilan du compte rendu
	 */
	public String getsBilanCR() {
		return sBilanCR;
	}


	/** Modifier le bilan du compte rendu
	 * @param sBilanCR Le nouveau bilan
	 */
	public void setsBilanCR(String sBilanCR) {
		this.sBilanCR = sBilanCR;
	}


	/** Obtenir le motif du compte rendu
	 * @return Le motif du compte rendu
	 */
	public String getsMotifCR() {
		return sMotifCR;
	}


	/** Modifier le motif du compte rendu
	 * @param sMotifCR Le nouveau motif 
	 */
	public void setsMotifCR(String sMotifCR) {
		this.sMotifCR = sMotifCR;
	}


	/** Obtenir le coefficient de confiance 
	 * @return Le coefficient de confiance
	 */
	public int getiCoefConfCR() {
		return iCoefConfCR;
	}


	/** Modifier le coefficient de confiance
	 * @param iCoefConfCR Le nouveau coefficient de confiance
	 */
	public void setiCoefConfCR(int iCoefConfCR) {
		this.iCoefConfCR = iCoefConfCR;
	}


	/** Obtenir l'état de lecture du compte rendu
	 * @return l'état de lecture
	 */
	public String getByEstLuCR() {
		return byEstLuCR;
	}


	/** Modifier l'état de lecture du compte rendu
	 * @param byEstLuCR l'état de lecture
	 */
	public void setByEstLuCR(String byEstLuCR) {
		this.byEstLuCR = byEstLuCR;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CompteRendu [collaborateur=" + collaborateur + ", iNumCR="
				+ iNumCR + ", praticien=" + praticien + ", dDateCR=" + dDateCR
				+ ", dDateVisite=" + dDateVisite + ", sBilanCR=" + sBilanCR
				+ ", sMotifCR=" + sMotifCR + ", iCoefConfCR=" + iCoefConfCR
				+ ", byEstLuCR=" + byEstLuCR + "]";
	}
	
	@Override
	public int compareTo(CompteRendu o) {
			if(this.getdDateVisite().before(o.getdDateVisite())){
				return -1;
			}
			else if(this.getdDateVisite().after(o.getdDateVisite())){
				return 1;
			}
			else{
				return 0;
			}
	}
	
}
