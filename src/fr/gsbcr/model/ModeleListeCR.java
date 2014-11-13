package fr.gsbcr.model;
import fr.gsbcr.entities.CompteRendu;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import fr.gsbcr.controler.Controleur;

public class ModeleListeCR extends AbstractTableModel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CompteRendu> compteRendus ;
	private final String[] entetes = {"Nom praticien","Ville praticien","Date de visite","Date de rédaction","Lecture","Affichage du rapport"} ;
	private ModeleCompteRendu modele ;
	private Controleur controleur;
	
	/** Créer le modèle de la liste des clients
	 * 
	 * @param modele Le modèle de l'application
	 */
	public ModeleListeCR(ModeleCompteRendu modele,Controleur controleur){
		super() ; 
		System.out.println("ModeleListeCR::ModeleListeCR()") ;
		this.modele = modele ;
		this.controleur = controleur;
		compteRendus = modele.getCompteRendus() ;
	}
	
	/** Obtenir le nombre de lignes
	 * 
	 * @return Le nombre de lignes
	 */
	public int getRowCount(){
		//System.out.println("ModeleListeClients::getRowCount()") ;
		return compteRendus.size() ;
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
				return compteRendus.get(indiceLigne).getPraticien().getPraNom() ;
			case 1 : 
				return compteRendus.get(indiceLigne).getPraticien().getPraVille() ;
			case 2 :
				return compteRendus.get(indiceLigne).getdDateVisite() ;
			case 3 : 
				return compteRendus.get(indiceLigne).getdDateCR();
			case 4 : 
				return compteRendus.get(indiceLigne).getByEstLuCR();
			case 5 : 
				return "Voir Contenu";
			default :
				return null ;
		}
	}

	public Controleur getControleur() {
		// TODO Auto-generated method stub
		return controleur;
	}

	public String getBilan(int indiceLigne) {
		return compteRendus.get(indiceLigne).getsBilanCR() ;
	}
	
	public String getEtat(int indiceLigne) {
		return compteRendus.get(indiceLigne).getByEstLuCR() ;
	}
	
	public String getMotif(int indiceLigne) {
		return compteRendus.get(indiceLigne).getsMotifCR() ;
	}
	
	public int getNumRapport(int indiceLigne) {
		return compteRendus.get(indiceLigne).getiNumCR() ;
	}
	
	/** Spécifier si une cellule est éditable
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @param indiceColonne L'indice de la colonne
	 * @return true si la cellule est éditable, et false dans le cas contraire
	 */
	@Override
	public boolean isCellEditable(int indiceLigne, int indiceColonne){
		//System.out.println("ModeleListeLocations::isCellEditable()") ;
		switch(indiceColonne){
			case 5 :
				return true ;
		default :
				return false;
		}

	}

}
