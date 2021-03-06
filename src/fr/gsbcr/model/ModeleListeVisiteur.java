package fr.gsbcr.model ;
import fr.gsbcr.entities.Collaborateur;

import javax.swing.* ;
import javax.swing.table.* ;

import fr.gsbcr.controller.Controleur;


/** Modèle du tableau des Visiteurs
 * 
 * @author rafina
 *
 */
public class ModeleListeVisiteur extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.util.List<Collaborateur> visiteur ;
	
	private final String[] entetes = {"Matricule","Nom","Prénom","Adresse","Code postal","Ville","Bouton de sélection"} ;
	
	private ModeleCompteRendu modele ;
	private Controleur controleur ;
	
	/** Créer le modèle de la liste des visiteurs
	 * 
	 * @param modele Le modèle de l'application
	 * @param controleur Le contrôleur de l'application
	 */
	public ModeleListeVisiteur(ModeleCompteRendu modele, Controleur controleur){
		super() ; 
		System.out.println("ModeleListeVisiteur::ModeleListeVisiteur()") ;
		this.modele = modele ;
		this.controleur = controleur ;
		visiteur = modele.getVisiteur() ;
	}
	
	/** Obtenir le modèle de l'application
	 * @param modele Modèle de l'application
	 */
	public void setModele(ModeleCompteRendu modele) {
		this.modele = modele;
	}

	/** Obtenir le contrôleur
	 * 
	 * @return Le contrôleur
	 */
	public Controleur getControleur(){
		//System.out.println("ModeleListeLocations::getControleur()") ;
		return this.controleur ;
	}
	
	/** Obtenir le modèle de l'application
	 * 
	 * @return Le modèle de l'application
	 */
	public ModeleCompteRendu getModele(){
		//System.out.println("ModeleListeLocations::getModele()") ;
		return this.modele ;
	}
	
	/** Obtenir le matricule du visiteur
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @return Le matricule du visiteur
	 */
	public String getMatriculeCollaborateur(int indiceLigne){
		return visiteur.get(indiceLigne).getsColMatricule() ;
	}
	
	/** Obtenir le nom du visiteur
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @return Le nom du visiteur
	 */
	public String getNomCollaborateur(int indiceLigne){
		//System.out.println("ModeleListeLocations::getNumeroLocation()") ;
		return visiteur.get(indiceLigne).getsColNom() ;
	}
	
	/** Obtenir le prénom du visiteur
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @return Le prénom du visiteur
	 */
	public String getPrenomCollaborateur(int indiceLigne){
		//System.out.println("ModeleListeLocations::getNumeroLocation()") ;
		return visiteur.get(indiceLigne).getsColPrenom() ;
	}
	
	/** Obtenir le nombre de lignes
	 * 
	 * @return Le nombre de lignes
	 */
	@Override
	public int getRowCount(){
		//System.out.println("ModeleListeLocations::getRowCount()") ;
		return visiteur.size() ;
	}

	/** Obtenir le nombre de colonnes
	 * 
	 * @return Le nombre de colonnes
	 */
	@Override
	public int getColumnCount(){
		//System.out.println("ModeleListeLocations::getColumnCount()") ;
		return entetes.length ;
	}
	
	/** Obtenir le nom d'une colonne
	 * 
	 * @param indiceColonne L'indice de la colonne
	 * @return Le nom de la colonne
	 */
	@Override
	public String getColumnName(int indiceColonne){
		//System.out.println("ModeleListeLocations::getColumnName()") ;
		return entetes[indiceColonne] ;
	}
	
	/** Obtenir la classe d'une colonne
	 * 
	 * @param indiceColonne Le numéro de la colonne
	 * @return La classe de la colonne
	 */
	@Override
	public Class getColumnClass(int indiceColonne){
		System.out.println("ModeleListeVisiteur::getColumnClass()") ;
		switch(indiceColonne){
			case 0 :
				return String.class ;
			case 1 :
				return String.class ;
			case 2 : 
				return String.class ;
			case 3 :
				return String.class ;
			case 4 :
				return Integer.class ;
			case 5 :
				return String.class ;
			case 6 :
				return JButton.class;
			default :
				return Object.class ;
		}
	}
	
	/** Obtenir la valeur d'une cellule
	 * 
	 * @param indiceLigne L'indice de la ligne
	 * @param indiceColonne L'indice de la colonne
	 * @return La valeur de la cellule
	 */
	@Override
	public Object getValueAt(int indiceLigne, int indiceColonne){
		System.out.println("ModeleListeVisiteur::getControleur()") ;
		switch(indiceColonne){
			case 0 : 
				return visiteur.get(indiceLigne).getsColMatricule() ;
			case 1 : 
				return visiteur.get(indiceLigne).getsColNom() ;
			case 2 :
				return visiteur.get(indiceLigne).getsColPrenom() ;
			case 3 : 
				return visiteur.get(indiceLigne).getsColAdresse() ;	
			case 4 : 
				return visiteur.get(indiceLigne).getiColCP();
			case 5 :
				return visiteur.get(indiceLigne).getsColVille() ;			
			case 6 :
				return "Sélectionner" ;
			default :
				return null ;
		}
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
			case 6 :
				return true ;
		default :
				return false;
		}

	}
	
	
}
