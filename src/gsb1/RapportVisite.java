package gsb1;

import java.util.GregorianCalendar;

public class RapportVisite {
	private Collaborateur colMatricule;
	private int iRapNum;
	private Praticien praNum;
	private GregorianCalendar rapDate;
	private String sRapBilan ;
	private String sRapMotif;
	private float fCoefConf;
	private boolean bRapEstLu;
	public RapportVisite(Collaborateur colMatricule, int iRapNum,
			Praticien praNum, GregorianCalendar rapDate, String sRapBilan,
			String sRapMotif, float fCoefConf, boolean bRapEstLu) {
		super();
		this.colMatricule = colMatricule;
		this.iRapNum = iRapNum;
		this.praNum = praNum;
		this.rapDate = rapDate;
		this.sRapBilan = sRapBilan;
		this.sRapMotif = sRapMotif;
		this.fCoefConf = fCoefConf;
		this.bRapEstLu = bRapEstLu;
	}
	public Collaborateur getColMatricule() {
		return colMatricule;
	}
	public void setColMatricule(Collaborateur colMatricule) {
		this.colMatricule = colMatricule;
	}
	public int getiRapNum() {
		return iRapNum;
	}
	public void setiRapNum(int iRapNum) {
		this.iRapNum = iRapNum;
	}
	public Praticien getPraNum() {
		return praNum;
	}
	public void setPraNum(Praticien praNum) {
		this.praNum = praNum;
	}
	public GregorianCalendar getRapDate() {
		return rapDate;
	}
	public void setRapDate(GregorianCalendar rapDate) {
		this.rapDate = rapDate;
	}
	public String getsRapBilan() {
		return sRapBilan;
	}
	public void setsRapBilan(String sRapBilan) {
		this.sRapBilan = sRapBilan;
	}
	public String getsRapMotif() {
		return sRapMotif;
	}
	public void setsRapMotif(String sRapMotif) {
		this.sRapMotif = sRapMotif;
	}
	public float getfCoefConf() {
		return fCoefConf;
	}
	public void setfCoefConf(float fCoefConf) {
		this.fCoefConf = fCoefConf;
	}
	public boolean isbRapEstLu() {
		return bRapEstLu;
	}
	public void setbRapEstLu(boolean bRapEstLu) {
		this.bRapEstLu = bRapEstLu;
	}
	@Override
	public String toString() {
		return "RapportVisite [colMatricule=" + colMatricule + ", iRapNum="
				+ iRapNum + ", praNum=" + praNum + ", rapDate=" + rapDate
				+ ", sRapBilan=" + sRapBilan + ", sRapMotif=" + sRapMotif
				+ ", fCoefConf=" + fCoefConf + ", bRapEstLu=" + bRapEstLu + "]";
	}
	
	
	

}
