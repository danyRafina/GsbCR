package fr.gsbcr.model ;
import fr.gsbcr.entities.Praticien;
import fr.gsbcr.model.ModeleCompteRendu;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.* ;

import javax.swing.table.* ;

/** Modèle du tableau des praticiens hésitants
 * 
 * @author rafina
 *
 */
public class ModeleListePraticienH extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Praticien> praticienH ;
	private final String[] entetes = {"Nom","Prénom","Ville","Coefficient de notoriété","Coefficient de confiance","Temps écoulé depuis la dernière visite"} ;
	private ModeleCompteRendu modele ;
	
	/** Créer le modèle de la liste des praticiens hésitants
	 * 
	 * @param modele Le modèle de l'application
	 */
	public ModeleListePraticienH(ModeleCompteRendu modele){
		super() ; 
		System.out.println("ModeleListePraticienH::ModeleListePraticienH()") ;
		this.modele = modele ;
		praticienH = modele.getPraticienH() ;
		
	}
	
	/** Obtenir le nombre de lignes
	 * 
	 * @return Le nombre de lignes
	 */
	public int getRowCount(){
		//System.out.println("ModeleListeClients::getRowCount()") ;
		return praticienH.size() ;
	}

	/** Obtenir le nombre de colonnes
	 * 
	 * @return Le nombre de colonnes
	 */
	public int getColumnCount(){
		//System.out.println("ModeleListeClients::getColumnCount()") ;
		return entetes.length ;
	}
	
	/** Obtenir le nom d'une colonne
	 * 
	 * @param indiceColonne L'indice de la colonne
	 * @return Le nom de la colonne
	 */
	public String getColumnName(int indiceColonne){
		//System.out.println("ModeleListeClients::getColumnName()") ;
		return entetes[indiceColonne] ;
	}
	
	/** Obtenir la valeur d'une cellule
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @param indiceColonne L'indice de la colonne
	 * @return La valeur de la cellule
	 */
	public Object getValueAt(int indiceLigne, int indiceColonne){
		System.out.println("ModeleListePraticienH::getValueAt()") ;
		switch(indiceColonne){
			case 0 : 
				return praticienH.get(indiceLigne).getPraNom() ;
			case 1 : 
				return praticienH.get(indiceLigne).getPraPrenom() ;
			case 2 : 
				return praticienH.get(indiceLigne).getPraVille();
			case 3 : 
				return praticienH.get(indiceLigne).getPraCoefN();
			case 4 : 
				return praticienH.get(indiceLigne).getPraCoefConf() ;
			case 5 : 
			try {
				return modele.diffEnJour(praticienH.get(indiceLigne).getPraNum()) +" jour(s)";
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			default :
				return null ;
		}
	}
	
}
