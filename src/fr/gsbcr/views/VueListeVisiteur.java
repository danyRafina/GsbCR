package fr.gsbcr.views;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsbcr.controller.Controleur;
import fr.gsbcr.model.ModeleCompteRendu;
import fr.gsbcr.model.ModeleListeVisiteur;



/** Vue consacré à la liste des visiteurs
 * @author rafina
 *
 */
public class VueListeVisiteur extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleCompteRendu modele ;
	
	private ModeleListeVisiteur modeleTableauVisiteur ;
	private JTable tableauVisiteur ;
	
	/** Création de la vue
	 * 
	 * @param modele Modèle de l'application
	 * @param controleur Contrôleur de l'application
	 */
	public VueListeVisiteur(ModeleCompteRendu modele, Controleur controleur) {
		super();
		System.out.println("VueListeVisiteur::VueListeVisiteur()") ;
		this.modele = modele;
		this.controleur = controleur ;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;
		boxEtiquette.add(new JLabel("Visiteurs :")) ;
		modeleTableauVisiteur= new ModeleListeVisiteur(modele,controleur) ;
		tableauVisiteur= new JTable(modeleTableauVisiteur) ;
		tableauVisiteur.setRowHeight(30) ;
		System.out.println("VueListeVisiteur::milieu constructeur()") ;
		this.appliquerRendu() ;

		JScrollPane spVisiteur = new JScrollPane(tableauVisiteur) ;
		//spLocations.setPreferredSize(new Dimension(1290,420)) ;
		spVisiteur.setPreferredSize(new Dimension(1090,420)) ;
		boxTableau.add(spVisiteur) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
		System.out.println("VueListeVisiteur::Fin constructeur()") ;
	}
	
	/** Actualiser le modèle du tableau
	 * 
	 */

	public void actualiser(){
		System.out.println("VueListeVisiteur::actualiser()") ;
		modeleTableauVisiteur = new ModeleListeVisiteur(modele,controleur) ;
		System.out.println("VueListeVisiteur::new Modele Visiteur") ;
		tableauVisiteur.setModel(modeleTableauVisiteur);
		System.out.println("VueListeVisiteur::actualiser() END") ;
		this.appliquerRendu();
	}
	/** Application d'un rendu sur les cellules
	 * 
	 */ 
	private void appliquerRendu(){
		System.out.println("VueListeVisiteur::appliquerRendu()") ;
		
		this.tableauVisiteur.getColumn("Bouton de sélection").setCellRenderer(new RenduBoutonVisiteur()) ;
		this.tableauVisiteur.getColumn("Bouton de sélection").setCellEditor(new EditeurBoutonVisiteur(new JCheckBox()));
	}
}
