package rentaco;

/** Représenter un véhicule
 * 
 * @author xilim
 *
 */
public class Vehicule {
	
	public static final int DISPONIBLE = 1 ;
	public static final int RESERVE = 2 ;
	public static final int LOUE = 3 ;
	
	private String immatriculation ;
	private String modele ;
	private int annee ;
	private int compteur = 0 ;
	private int situation = DISPONIBLE ;
	
	/** Créer un véhicule
	 * Le nombre de kilomètres au compteur est de 0
	 * @param immatriculation L'immatriculation
	 * @param modele Le modèle constructeur
	 * @param annee L'année de mise en circulation
	 */
	public Vehicule(String immatriculation, String modele, int annee) {
		super();
		this.immatriculation = immatriculation;
		this.modele = modele;
		this.annee = annee ;
	}
	
	/** Créer un véhicule
	 * 
	 * @param immatriculation L'immatriculation
	 * @param modele Le modèle constructeur
	 * @param annee L'année de mise en circulation
	 * @param compteur Le nombre de kilomètres au compteur
	 */
	public Vehicule(String immatriculation, String modele, int annee, int compteur) {
		super();
		this.immatriculation = immatriculation;
		this.modele = modele;
		this.annee = annee ;
		this.compteur = compteur ;
	}

	/** Obtenir l'immatriculation
	 * 
	 * @return L'immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/** Modifier le numéro de la plaque d'immatriculation
	 * 
	 * @param immatriculation L'immatriculation
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/** Obtenir le modèle
	 * 
	 * @return Le modèle
	 */
	public String getModele() {
		return modele;
	}

	/** Modifier le modèle
	 * 
	 * @param modele Le modèle
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}
	
	/** Obtenir l'année de mise en circulation
	 * 
	 * @return L'année de mise en circulation
	 */
	public int getAnnee(){
		return this.annee ;
	}
	
	/** Modifier l'année de mise en circulation
	 * 
	 * @param annee L'année de mise en circulation
	 */
	public void setAnnee(int annee){
		this.annee = annee ;
	}

	/** Obtenir le nombre de kilomètres au compteur
	 * 
	 * @return Le nombre de kilomètres au compteur
	 */
	public int getCompteur() {
		return compteur;
	}

	/** Modifier le nombre de kilomètres au compteur
	 * 
	 * @param compteur Le nombre de kilomètres au compteur
	 */
	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	/** Obtenir la situation du véhicule
	 * DISPONIBLE : Véhicule disponible
	 * RESERVE : Véhicule réservé
	 * LOUE : Véhicule loué
	 * @return La situation du véhicule
	 */
	public int getSituation() {
		return situation;
	}

	/** Modifier la situation du véhicule
	 * DISPONIBLE : Véhicule disponible,
	 * RESERVE : Véhicule réservé,
	 * LOUE : Véhicule loué
	 * @param situation La situation du véhicule
	 */
	public void setSituation(int situation) {
		this.situation = situation;
	}
	
	/** Indique si le véhicule est disponible
	 * 
	 * @return true si le véhicule est disponible et false dans le cas contraire
	 */
	public boolean estDisponible(){
		if(this.situation == DISPONIBLE){
			return true ;
		}
		else {
			return false ;
		}
	}
	
	/** Indique si le véhicule est réservé
	 * 
	 * @return true si le véhicule est réservé et false dans le cas contraire
	 */
	public boolean estReserve(){
		if(this.situation == RESERVE){
			return true ;
		}
		else {
			return false ;
		}
	}

	/** Indique si le véhicule est loué
	 * 
	 * @return true si le véhicule est loué et false dans le cas contraire
	 */
	public boolean estEnLocation(){
		if(this.situation == LOUE){
			return true ;
		}
		else {
			return false ;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String saSituation ;
		if(this.situation == Vehicule.DISPONIBLE){
			saSituation = "Disponible" ;
		}
		else if(this.situation == Vehicule.LOUE){
			saSituation = "Loué" ;
		}
		else {
			saSituation = "Réservé" ;
		}
		return "Vehicule [immatriculation=" + immatriculation + ", modele="
				+ modele + ", année=" + annee
				+ ", compteur=" + compteur + ", situation="
				+ saSituation + "]";
	}
	
}
