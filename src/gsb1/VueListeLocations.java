package rentaco;

import java.awt.FlowLayout;

import java.awt.* ;
import javax.swing.* ;
import javax.swing.JTable.* ;

/** Vue dédiée à l'affichage de la liste des locations
 * 
 * @author xilim
 *
 */
public class VueListeLocations extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleCompteRendu modele ;
	
	private ModeleListeVisiteur modeleTableauLocations ;
	private JTable tableauLocations ;
	
	public VueListeLocations(ModeleCompteRendu modele, Controleur controleur) {
		super();
		System.out.println("VueListeLocations::VueListeLocations()") ;
		this.modele = modele;
		this.controleur = controleur ;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
				
		boxEtiquette.add(new JLabel("Locations :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
	
		modeleTableauLocations = new ModeleListeVisiteur(modele,controleur) ;
		tableauLocations = new JTable(modeleTableauLocations) ;
		tableauLocations.setRowHeight(30) ;
		
		this.appliquerRendu() ;

		JScrollPane spLocations = new JScrollPane(tableauLocations) ;
		//spLocations.setPreferredSize(new Dimension(1290,420)) ;
		spLocations.setPreferredSize(new Dimension(1090,420)) ;

		boxTableau.add(spLocations) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
	}
	
	public void actualiser(){
		System.out.println("VueListeLocations::actualiser()") ;
		modeleTableauLocations = new ModeleListeVisiteur(modele,controleur) ;
		tableauLocations.setModel(modeleTableauLocations);
		this.appliquerRendu();
	}
	
	private void appliquerRendu(){
		System.out.println("VueListeLocations::appliquerRendu()") ;
		this.tableauLocations.getColumn("Numéro").setCellRenderer(new RenduCelluleLocation()) ;
		this.tableauLocations.getColumn("Enregistrement").setCellRenderer(new RenduCelluleLocation()) ;
		this.tableauLocations.getColumn("Date départ").setCellRenderer(new RenduCelluleLocation()) ;
		this.tableauLocations.getColumn("Date retour").setCellRenderer(new RenduCelluleLocation()) ;
		this.tableauLocations.getColumn("Client").setCellRenderer(new RenduCelluleLocation()) ;
		this.tableauLocations.getColumn("Véhicule").setCellRenderer(new RenduCelluleLocation()) ;
		this.tableauLocations.getColumn("Départ").setCellRenderer(new RenduBoutonLocation()) ;
		this.tableauLocations.getColumn("Retour").setCellRenderer(new RenduBoutonLocation()) ;
		this.tableauLocations.getColumn("Annulation").setCellRenderer(new RenduBoutonLocation()) ;
		
		this.tableauLocations.getColumn("Départ").setCellEditor(new EditeurBoutonVisiteur(new JCheckBox())) ; 
		this.tableauLocations.getColumn("Retour").setCellEditor(new EditeurBoutonVisiteur(new JCheckBox())) ; 
		this.tableauLocations.getColumn("Annulation").setCellEditor(new EditeurBoutonVisiteur(new JCheckBox())) ; 
	}
	
}
