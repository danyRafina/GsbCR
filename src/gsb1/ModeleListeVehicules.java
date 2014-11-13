package gsb1 ;

import java.util.* ;
import javax.swing.* ;
import javax.swing.table.* ;

/** Modèle du tableau des véhicules
 * 
 * @author xilim
 *
 */
public class ModeleListeVehicules extends AbstractTableModel {
	private List<Vehicule> vehicules ;
	private final String[] entetes = {"Immatriculation","Modèle","Année","Compteur",""} ;
	
	private ModeleCompteRendu modele ;
	
	/** Créer le modèle de la liste des véhicules
	 * 
	 * @param modele Le modèle de l'application
	 */
	public ModeleListeVehicules(ModeleCompteRendu modele){
		super() ; 
		System.out.println("ModeleListeVehicules::ModeleListeVehicules()") ;
		this.modele = modele ;
		vehicules = new ArrayList<Vehicule>(modele.getVehicules()) ;
	}
	
	/** Obtenir le nombre de lignes
	 * 
	 * @return Le nombre de lignes
	 */
	public int getRowCount(){
		//System.out.println("ModeleListeVehicules::getRowCount()") ;
		return vehicules.size() ;
	}

	/** Obtenir le nombre de colonnes
	 * 
	 * @return Le nombre de colonnes
	 */
	public int getColumnCount(){
		//System.out.println("ModeleListeVehicules::getColumnCount()") ;
		return entetes.length ;
	}

	/** Obtenir le nom d'une colonne
	 * 
	 * @param indiceColonne L'indice de la colonne
	 * @return Le nom de la colonne
	 */
	public String getColumnName(int indiceColonne){
		//System.out.println("ModeleListeVehicules::getColumnName()") ;
		return entetes[indiceColonne] ;
	}
	
	/** Obtenir la valeur d'une cellule
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @param indiceColonne L'indice de la colonne
	 * @return La valeur de la cellule
	 */
	public Object getValueAt(int indiceLigne, int indiceColonne){
		//System.out.println("ModeleListeVehicules::getValueAt()") ;
		switch(indiceColonne){
			case 0 : 
				return vehicules.get(indiceLigne).getImmatriculation() ;
			case 1 : 
				return vehicules.get(indiceLigne).getModele() ;
			case 2 :
				return vehicules.get(indiceLigne).getAnnee() ;
			case 3 : 
				return vehicules.get(indiceLigne).getCompteur() + " km" ;
			case 4 : 
				return vehicules.get(indiceLigne).getSituation() ;
			default :
				return null ;
		}
	}
	
	/** Obtenir la situation du véhicule
	 * 
	 * @param indiceLigne L'indice de la ligne 
	 * @return La situation du véhicule
	 */
	public int getSituation(int indiceLigne){
		//System.out.println("ModeleListeVehicules::getSituation()") ;
		return vehicules.get(indiceLigne).getSituation() ;
	}

}
