package fr.gsbcr.model ;
import fr.gsbcr.entities.CompteRendu;
import fr.gsbcr.model.ModeleCompteRendu;

import javax.swing.table.* ;

/** Modèle du tableau des détails sur le compte-rendu
 * 
 * @author rafina
 *
 */
public class ModeleInfoCR extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CompteRendu compteRenduSelected ;
	private final String[] entetes = {"Numéro du rapport","Nom du Visiteur","Nom du praticien","Date de visite","Date de rédaction","Coefficient de confiance","Bilan","Motif","Etat"} ;
	private ModeleCompteRendu modele ;
	
	
	/** Créer le modèle des détails sur le compte-rendu
	 * 
	 * @param modele Le modèle de l'application
	 */
	public ModeleInfoCR(ModeleCompteRendu modele){
		super() ; 
		System.out.println("ModeleInfoCR::ModeleInfoCR()") ;
		this.modele = modele ;
		compteRenduSelected = this.modele.getContreRenduSelected() ;
	}

	/** Obtenir le nombre de colonnes
	 * 
	 * @return Le nombre de colonnes
	 */
	public int getColumnCount(){
		return entetes.length ;
	}
	
	/** Obtenir le nom d'une colonne
	 * 
	 * @param indiceColonne L'indice de la colonne
	 * @return Le nom de la colonne
	 */
	public String getColumnName(int indiceColonne){
		return entetes[indiceColonne] ;
	}
	
	
	/** Obtenir la valeur d'une cellule
	 * @param indiceColonne L'indice de la colonne
	 * @return La valeur de la cellule
	 */
	
	public Object getValueAt(int indiceLigne,int indiceColonne){
		System.out.println("ModeleInfoCR::getValueAt()") ;
		switch(indiceColonne){
		case 0 : 
			return compteRenduSelected.getiNumCR() ;
		case 1 : 
			return compteRenduSelected.getCollaborateur().getsColNom();
		case 2 : 
			return compteRenduSelected.getPraticien().getPraNom() ;
		case 3 :
			return compteRenduSelected.getdDateVisite() ;
		case 4 : 
			return compteRenduSelected.getdDateCR();
		case 5 : 
			return compteRenduSelected.getiCoefConfCR();
		case 6 : 
			return compteRenduSelected.getsBilanCR();
		case 7 : 
			return compteRenduSelected.getsMotifCR();
		case 8 : 
			return compteRenduSelected.getByEstLuCR();
		default :
			return null ;
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 1;
	}


	
}
