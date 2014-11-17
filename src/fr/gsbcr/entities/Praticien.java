package fr.gsbcr.entities;

/** Classe Praticien de l'application
 * @author rafina
 *
 */
public class Praticien {
	private int praNum;
	private String praNom;
	private String praPrenom;
	private String praAdresse;
	private int praCP;
	private String praVille;
	private float praCoefN;
	private int praCoefConf;
	
	
	/** Création du praticien
	 * @param praNum Numéro du praticien
	 * @param praNom Nom du praticien
	 * @param praPrenom Prénom du praticien
	 * @param praAdresse Adresse du praticien
	 * @param praCP Code postal du praticien
	 * @param praVille Ville du praticien
	 * @param praCoefN Coefficient de notoriété du praticien
	 * @param praCoefConf Coefficient de confiance du praticien
	 */
	public Praticien(int praNum, String praNom, String praPrenom,
			String praAdresse, int praCP, String praVille, float praCoefN,int praCoefConf) {
		super();
		this.praNum = praNum;
		this.praNom = praNom;
		this.praPrenom = praPrenom;
		this.praAdresse = praAdresse;
		this.praCP = praCP;
		this.praVille = praVille;
		this.praCoefN = praCoefN;
		this.praCoefConf = praCoefConf;
	}


	/** Obtenir le numéro du praticien
	 * @return le numéro du praticien
	 */
	public int getPraNum() {
		return praNum;
	}


	/** Modifier le numéro du praticien 
	 * @param praNum Le nouveau numéro 
	 */
	public void setPraNum(int praNum) {
		this.praNum = praNum;
	}


	/** Obtenir le nom du praticien
	 * @return le nom du praticien
	 */
	public String getPraNom() {
		return praNom;
	}


	/** Modifier le nom du praticien
	 * @param praNom Le nouveau nom 
	 */
	public void setPraNom(String praNom) {
		this.praNom = praNom;
	}


	/** Obtenir le prénom du praticien
	 * @return Le prénom du praticien
	 */
	public String getPraPrenom() {
		return praPrenom;
	}


	/** Modifier le prénom du praticien
	 * @param praPrenom Le nouveau prénom
	 */
	public void setPraPrenom(String praPrenom) {
		this.praPrenom = praPrenom;
	}


	/** Obtenir l'adresse du praticien 
	 * @return l'adresse du praticien
	 */
	public String getPraAdresse() {
		return praAdresse;
	}


	/** Modifier l'adresse du praticien
	 * @param praAdresse la nouvelle adresse
	 */
	public void setPraAdresse(String praAdresse) {
		this.praAdresse = praAdresse;
	}


	/** Obtenir le code postal du praticien
	 * @return le code postal 
	 */
	public int getPraCP() {
		return praCP;
	}


	/** Modifier le code postal du praticien
	 * @param praCP le nouveau code postal
	 */
	public void setPraCP(int praCP) {
		this.praCP = praCP;
	}


	/** Obtenir la ville du praticien
	 * @return La ville du praticien
	 */
	public String getPraVille() {
		return praVille;
	}


	/** Modifier la ville du praticien
	 * @param praVille La nouvelle ville
	 */
	public void setPraVille(String praVille) {
		this.praVille = praVille;
	}


	/** Obtenir le coefficient de notoriété du praticien
	 * @return le coefficient de notoriété du praticien
	 */
	public float getPraCoefN() {
		return praCoefN;
	}


	/** Modifier le coefficient de notoriété du praticien
	 * @param praCoefN Le nouveau coefficient de notoriété
	 */
	public void setPraCoefN(float praCoefN) {
		this.praCoefN = praCoefN;
	}


	/** Obtenir le coefficient de confiance du praticien
	 * @return le coefficient de confiance du praticien
	 */
	public int getPraCoefConf() {
		return praCoefConf;
	}


	/** Modifier le coefficient de confiance du praticien
	 * @param praCoefConf Le nouveau coefficient de confiance
	 */
	public void setPraCoefConf(int praCoefConf) {
		this.praCoefConf = praCoefConf;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Praticien [praNum=" + praNum + ", praNom=" + praNom
				+ ", praPrenom=" + praPrenom + ", praAdresse=" + praAdresse
				+ ", praCP=" + praCP + ", praVille=" + praVille + ", praCoefN="
				+ praCoefN + ", praCoefConf=" + praCoefConf + "]";
	}
	

}
