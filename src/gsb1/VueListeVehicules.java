package rentaco;

import java.awt.* ;
import javax.swing.* ;
import javax.swing.JTable.* ;

/** Vue dédiée à l'affichage de la liste des véhicules
 * 
 * @author xilim
 *
 */
public class VueListeVehicules extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleLocations modele ;
	
	private ModeleListeVehicules modeleTableauVehicules ;
	private JTable tableauVehicules ;a
	
	/** Créer la vue dédiée à l'affichage de la liste des véhicules
	 * 
	 * @param modele Le modèle
	 * @param controleur Le contrôleur
	 */
	public VueListeVehicules(ModeleLocations modele, Controleur controleur) {
		super();
		System.out.println("VueListeVehicules::VueListeVehicules()") ;
		this.modele = modele;
		this.controleur = controleur ;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;

		boxEtiquette.add(new JLabel("Véhicules :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		modeleTableauVehicules = new ModeleListeVehicules(modele) ;
		tableauVehicules = new JTable(modeleTableauVehicules) ;
		tableauVehicules.setRowHeight(30) ;
		
		this.appliquerRendu() ;
		JScrollPane spVehicules = new JScrollPane(tableauVehicules) ;
		//spVehicules.setPreferredSize(new Dimension(1290,420)) ;
		spVehicules.setPreferredSize(new Dimension(1090,420)) ;
		
		boxTableau.add(spVehicules) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
	}
	
	/** Actualiser le tableau
	 * 
	 */
	public void actualiser(){
		System.out.println("VueListeVehicules::actualiser()") ;
		modeleTableauVehicules = new ModeleListeVehicules(modele) ;
		tableauVehicules.setModel(modeleTableauVehicules) ;
		this.appliquerRendu() ; 
	}
	
	/** Appliquer le "rendu" au tableau
	 * 
	 */
	private void appliquerRendu(){
		System.out.println("VueListeVehicules::appliquerRendu()") ;
		tableauVehicules.setDefaultRenderer(Object.class,new RenduCelluleVehicule()) ;
	}

}
