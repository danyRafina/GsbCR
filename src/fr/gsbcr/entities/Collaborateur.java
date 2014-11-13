package fr.gsbcr.entities;

import java.util.GregorianCalendar;

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
		//this.gcColDateEmbauche = gcColDateEmbauche;
		this.sColRole = sColRole;
		this.sColMdp = sColMdp;
	}

	@Override
	public String toString() {
		return "Collaborateur [sColMatricule=" + sColMatricule + ", sColNom="
				+ sColNom + ", sColPrenom=" + sColPrenom + ", sColAdresse="
				+ sColAdresse + ", iColCP=" + iColCP + ", sColVille="
				+ sColVille + ", gcColDateEmbauche=" + gcColDateEmbauche
				+ ", sColRole=" + sColRole +  "]";
	}

	public String getsColMdp() {
		return sColMdp;
	}

	public void setsColMdp(String sColMdp) {
		this.sColMdp = sColMdp;
	}

	public String getsColMatricule() {
		return sColMatricule;
	}

	public void setsColMatricule(String sColMatricule) {
		this.sColMatricule = sColMatricule;
	}

	public String getsColNom() {
		return sColNom;
	}

	public void setsColNom(String sColNom) {
		this.sColNom = sColNom;
	}

	public String getsColPrenom() {
		return sColPrenom;
	}

	public void setsColPrenom(String sColPrenom) {
		this.sColPrenom = sColPrenom;
	}

	public String getsColAdresse() {
		return sColAdresse;
	}

	public void setsColAdresse(String sColAdresse) {
		this.sColAdresse = sColAdresse;
	}

	public int getiColCP() {
		return iColCP;
	}

	public void setiColCP(int iColCP) {
		this.iColCP = iColCP;
	}

	public String getsColVille() {
		return sColVille;
	}

	public void setsColVille(String sColVille) {
		this.sColVille = sColVille;
	}

	public GregorianCalendar getGcColDateEmbauche() {
		return gcColDateEmbauche;
	}

	public void setGcColDateEmbauche(GregorianCalendar gcColDateEmbauche) {
		this.gcColDateEmbauche = gcColDateEmbauche;
	}

	public String getsColRole() {
		return sColRole;
	}

	public void setsColRole(String sColRole) {
		this.sColRole = sColRole;
	}
	
}