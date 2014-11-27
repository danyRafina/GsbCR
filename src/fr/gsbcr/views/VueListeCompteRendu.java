package fr.gsbcr.views;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.gsbcr.controller.Controleur;
import fr.gsbcr.model.ModeleCompteRendu;
import fr.gsbcr.model.ModeleListeCR;


/** Vue dédiée à l'affichage de la liste des comptes-rendus
 * 
 * @author rafina
 *
 */
public class VueListeCompteRendu extends JPanel{

		private static final long serialVersionUID = 1L;
		private Controleur controleur ;
		private ModeleCompteRendu modele ;
		
		private ModeleListeCR modeleTableauCR ;
		private JTable tableauCR ;
		
		/** Créer la vue dédiée à l'affichage de la liste des comptes-rendus
		 * 
		 * @param modele Le modèle
		 * @param controleur Le contrôleur
		 */
		public VueListeCompteRendu(ModeleCompteRendu modele, Controleur controleur) {
			super();
			System.out.println("VueListeCR::VueListeCR()") ;
			
			this.modele = modele ;
			this.controleur = controleur ;
			
			Box boxPrincipal = Box.createVerticalBox() ;
			Box boxEtiquette = Box.createHorizontalBox() ;
			Box boxTableau = Box.createHorizontalBox() ;

			boxEtiquette.add(new JLabel("Compte Rendus  :")) ;
			boxEtiquette.add(Box.createHorizontalGlue()) ;			
			modeleTableauCR = new ModeleListeCR(modele, controleur) ;
			tableauCR = new JTable(modeleTableauCR) ;
			tableauCR.setRowHeight(30) ;
			
			JScrollPane spCR = new JScrollPane(tableauCR) ;
			spCR.setPreferredSize(new Dimension(1090,420)) ;
			boxTableau.add(spCR) ;
			
			boxPrincipal.add(boxEtiquette) ;
			boxPrincipal.add(boxTableau) ;
			
			this.add(boxPrincipal) ;
			
		}
		
		/** Actualiser le modèle du tableau
		 * 
		 */
		public void actualiser(){
			System.out.println("VueListeClients::actualiser()") ;
			modeleTableauCR = new ModeleListeCR(modele, controleur) ;
			tableauCR.setModel(modeleTableauCR) ;
			this.modele.sortListCR("Croissant");
			this.appliquerRendu();
		}
		/** Application d'un rendu sur les cellules
		 * 
		 */
		private void appliquerRendu(){
			System.out.println("VueListeCR::appliquerRendu()") ;
			this.tableauCR.getColumn("Nom praticien").setCellRenderer(new RenduCelluleCR()) ;
			this.tableauCR.getColumn("Ville praticien").setCellRenderer(new RenduCelluleCR()) ;
			this.tableauCR.getColumn("Date de visite").setCellRenderer(new RenduCelluleCR()) ;
			this.tableauCR.getColumn("Date de rédaction").setCellRenderer(new RenduCelluleCR()) ;
			this.tableauCR.getColumn("Lecture").setCellRenderer(new RenduCelluleCR()) ;
			this.tableauCR.getColumn("Affichage du rapport").setCellRenderer(new RenduCelluleCR()) ;
			
			
			this.tableauCR.getColumn("Affichage du rapport").setCellRenderer(new RenduBoutonCR()) ;
			this.tableauCR.getColumn("Affichage du rapport").setCellEditor(new EditeurBoutonCR(new JCheckBox()));
		}
		
}
