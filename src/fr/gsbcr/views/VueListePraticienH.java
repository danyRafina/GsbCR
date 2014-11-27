package fr.gsbcr.views;

import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.* ;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fr.gsbcr.controller.Controleur;
import fr.gsbcr.model.ModeleCompteRendu;
import fr.gsbcr.model.ModeleListePraticienH;
import fr.gsbcr.model.ModeleListeVisiteur;

/** Vue dédiée à l'affichage de la liste des praticiens hésitants
 * 
 * @author rafina
 *
 */
public class VueListePraticienH extends JPanel implements ItemListener {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleCompteRendu modele ;
	
	private ModeleListePraticienH modeleTableauPraticienH ;
	private JTable tableauPraticienH ;
	
	/** Créer la vue dédiée à l'affichage de la liste des praticiens hésitants
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
		Box boxEtiquetteSort = Box.createHorizontalBox();

		boxEtiquette.add(new JLabel("Praticiens Hésitants :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		boxEtiquetteSort.add(new JLabel("Trier par : "));
		JComboBox<String> combo = new JComboBox<String>();
		combo.addItem("Coefficient de confiance");
		combo.addItem("Temps écoulé");
		combo.addItem("Coefficient de notoriété");
		combo.addItemListener(this);
		boxEtiquetteSort.add(combo);
		boxEtiquetteSort.add(Box.createHorizontalGlue()) ;
		Box boxVide = Box.createHorizontalBox();
		boxVide.add(Box.createHorizontalGlue()) ;
		modeleTableauPraticienH = new ModeleListePraticienH(modele) ;
		tableauPraticienH = new JTable(modeleTableauPraticienH) ;
		//tableauPraticienH.setAutoCreateRowSorter(true);
	
		/*TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modeleTableauPraticienH);
	    tableauPraticienH.setRowSorter(sorter);
		tableauPraticienH.getRowSorter().toggleSortOrder(1);
	    //sorter.setSortsOnUpdates(true);*/
		tableauPraticienH.setRowHeight(30) ;
		
		
		JScrollPane spPraticienH = new JScrollPane(tableauPraticienH) ;
		spPraticienH.setPreferredSize(new Dimension(1090,420)) ;
		
		boxPrincipal.add(boxEtiquetteSort) ;
		boxPrincipal.add(boxVide);
		boxTableau.add(spPraticienH) ;
		boxPrincipal.add(boxEtiquette) ;
		boxPrincipal.add(boxTableau) ;
		
		this.add(boxPrincipal) ;
		
	}
	  
	
	/** Actualiser le modèle du tableau
	 * 
	 */
	public void actualiser(){
		modeleTableauPraticienH = new ModeleListePraticienH(modele) ;
		tableauPraticienH.setModel(modeleTableauPraticienH) ;
	}
	
	public void itemStateChanged(ItemEvent e) {
		String choix = (String) e.getItem();
		if(choix == "Coefficient de confiance"){
			System.out.println("CoefC");
			modele.sortListPraticien("coefC");
			this.actualiser();
		}
		else if (choix == "Coefficient de notoriété"){
			//DESC
			System.out.println("CoefN");
			modele.sortListPraticien("coefN");
			this.actualiser();
		}
		else if (choix == "Temps écoulé"){
			//DESC
			System.out.println("TpsC");
			modele.sortListPraticien("TpsC");
			this.actualiser();
		}

	}

	
}
