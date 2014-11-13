package fr.gsbcr.entities;

import java.util.Date;

public class CompteRendu {
	private Collaborateur collaborateur;
	private int iNumCR;
	private Praticien praticien;
	private Date dDateCR;
	private Date dDateVisite;
	private String sBilanCR;
	private String sMotifCR;
	private int iCoefConfCR;
	private String byEstLuCR;
	
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


	public Date getdDateVisite() {
		return dDateVisite;
	}


	public void setdDateVisite(Date dDateVisite) {
		this.dDateVisite = dDateVisite;
	}


	public int getiNumCR() {
		return iNumCR;
	}

	public void setiNumCR(int iNumCR) {
		this.iNumCR = iNumCR;
	}

	public Collaborateur getCollaborateur() {
		return collaborateur;
	}


	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}


	public Praticien getPraticien() {
		return praticien;
	}


	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}


	public Date getdDateCR() {
		return dDateCR;
	}

	public void setdDateCR(Date dDateCR) {
		this.dDateCR = dDateCR;
	}

	public String getsBilanCR() {
		return sBilanCR;
	}

	public void setsBilanCR(String sBilanCR) {
		this.sBilanCR = sBilanCR;
	}

	public String getsMotifCR() {
		return sMotifCR;
	}

	public void setsMotifCR(String sMotifCR) {
		this.sMotifCR = sMotifCR;
	}

	public int getiCoefConfCR() {
		return iCoefConfCR;
	}

	public void setiCoefConfCR(int iCoefConfCR) {
		this.iCoefConfCR = iCoefConfCR;
	}

	public String getByEstLuCR() {
		return byEstLuCR;
	}

	public void setByEstLuCR(String byEstLuCR) {
		this.byEstLuCR = byEstLuCR;
	}
	
	

}
