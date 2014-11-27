package fr.gsbcr.views;

import java.awt.* ;

import javax.swing.* ;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fr.gsbcr.controller.Controleur;
import fr.gsbcr.model.ModeleCompteRendu;
import fr.gsbcr.model.ModeleInfoCR;
import fr.gsbcr.model.ModeleListePraticienH;

/** Vue dédiée à l'affichage des détails sur le compte-rendu
 * 
 * @author rafina
 *
 */
public class VueInfoCR extends JPanel {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleCompteRendu modele ;
	
	private ModeleInfoCR modeleTableauInfoCR ;
	private JTable tableauInfoCR ;
	
	/** Créer la vue dédiée à l'affichage des détails sur le compte-rendu
	 * 
	 * @param modele Le modèle
	 * @param controleur Le contrôleur
	 */
	public VueInfoCR(ModeleCompteRendu modele, Controleur controleur) {
		super();
		System.out.println("VueInfoCR::VueInfoCR()") ;
		
		this.modele = modele ;
		this.controleur = controleur ;
		
		Box boxPrincipal = Box.createVerticalBox() ;
		Box boxEtiquette = Box.createHorizontalBox() ;
		Box boxTableau = Box.createHorizontalBox() ;

		boxEtiquette.add(new JLabel("Détails sur le compte-rendu"));
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		modeleTableauInfoCR = new ModeleInfoCR(modele) ;
		tableauInfoCR = new JTable(modeleTableauInfoCR) ;
		tableauInfoCR.setRowHeight(30) ;
		
		JScrollPane spInfoCR = new JScrollPane(tableauInfoCR) ;
		spInfoCR.setPreferredSize(new Dimension(1090,420)) ;
		
		boxTableau.add(spInfoCR) ;
		
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
		
	}
	  
	
	/** Actualiser le modèle du tableau
	 * 
	 */
	public void actualiser(){
		modeleTableauInfoCR = new ModeleInfoCR(modele) ;
		tableauInfoCR .setModel(modeleTableauInfoCR) ;
	}
	
}
