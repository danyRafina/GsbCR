package fr.gsbcr.views;

import java.awt.* ;

import javax.swing.* ;

import fr.gsbcr.controler.Controleur;
import fr.gsbcr.model.ModeleCompteRendu;
import fr.gsbcr.model.ModeleListePraticienH;

/** Vue dédiée à l'affichage de la liste des clients
 * 
 * @author xilim
 *
 */
public class VueListePraticienH extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleCompteRendu modele ;
	
	private ModeleListePraticienH modeleTableauPraticienH ;
	private JTable tableauPraticienH ;
	
	/** Créer la vue dédiée à l'affichage de la liste des clients
	 * 
	 * @param modele Le modèle
	 * @param controleur Le contrôleur
	 */
	public VueListePraticienH(ModeleCompteRendu modele, Controleur controleur) {
		super();
		System.out.println("VueListePraticienH::VueListePraticienH()") ;
		
		this.modele = modele ;
		this.controleur = controleur ;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;

		boxEtiquette.add(new JLabel("Praticiens Hésitants :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		modeleTableauPraticienH = new ModeleListePraticienH(modele) ;
		tableauPraticienH = new JTable(modeleTableauPraticienH) ;
		tableauPraticienH.setRowHeight(30) ;
		
		JScrollPane spPraticienH = new JScrollPane(tableauPraticienH) ;
		//spClients.setPreferredSize(new Dimension(1290,420)) ;
		spPraticienH.setPreferredSize(new Dimension(1090,420)) ;
		
		boxTableau.add(spPraticienH) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
		
	}
	
	/** Actualiser le modèle du tableau
	 * 
	 */
	public void actualiser(){
		System.out.println("VueListeClients::actualiser()") ;
		modeleTableauPraticienH = new ModeleListePraticienH(modele) ;
		tableauPraticienH.setModel(modeleTableauPraticienH) ;
	}
	
}
