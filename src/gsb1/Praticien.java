package gsb1;

public class Praticien {
	private int praNum;
	private String praNom;
	private String praPrenom;
	private String praAdresse;
	private int praCP;
	private String praVille;
	private float praCoefN;
	public Praticien(int praNum, String praNom, String praPrenom,
			String praAdresse, int praCP, String praVille, float praCoefN) {
		super();
		this.praNum = praNum;
		this.praNom = praNom;
		this.praPrenom = praPrenom;
		this.praAdresse = praAdresse;
		this.praCP = praCP;
		this.praVille = praVille;
		this.praCoefN = praCoefN;
	}
	public int getPraNum() {
		return praNum;
	}
	public void setPraNum(int praNum) {
		this.praNum = praNum;
	}
	public String getPraNom() {
		return praNom;
	}
	public void setPraNom(String praNom) {
		this.praNom = praNom;
	}
	public String getPraPrenom() {
		return praPrenom;
	}
	public void setPraPrenom(String praPrenom) {
		this.praPrenom = praPrenom;
	}
	public String getPraAdresse() {
		return praAdresse;
	}
	public void setPraAdresse(String praAdresse) {
		this.praAdresse = praAdresse;
	}
	public int getPraCP() {
		return praCP;
	}
	public void setPraCP(int praCP) {
		this.praCP = praCP;
	}
	public String getPraVille() {
		return praVille;
	}
	public void setPraVille(String praVille) {
		this.praVille = praVille;
	}
	public float getPraCoefN() {
		return praCoefN;
	}
	public void setPraCoefN(float praCoefN) {
		this.praCoefN = praCoefN;
	}
	@Override
	public String toString() {
		return "Praticien [praNum=" + praNum + ", praNom=" + praNom
				+ ", praPrenom=" + praPrenom + ", praAdresse=" + praAdresse
				+ ", praCP=" + praCP + ", praVille=" + praVille + ", praCoefN="
				+ praCoefN + "]";
	}
	
	

}
