package fr.gsbcr.views;

import java.awt.* ;

import javax.swing.* ;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import fr.gsbcr.controller.Controleur;
import fr.gsbcr.model.ModeleCompteRendu;
import fr.gsbcr.model.ModeleListePraticienH;

/** Vue dédiée à l'affichage de la liste des praticiens hésitants
 * 
 * @author rafina
 *
 */
public class VueListePraticienH extends JPanel {

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

		boxEtiquette.add(new JLabel("Praticiens Hésitants :")) ;
		boxEtiquette.add(Box.createHorizontalGlue()) ;
		
		modeleTableauPraticienH = new ModeleListePraticienH(modele) ;
		tableauPraticienH = new JTable(modeleTableauPraticienH) ;
		//tableauPraticienH.setAutoCreateRowSorter(true);
	
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modeleTableauPraticienH);
	    tableauPraticienH.setRowSorter(sorter);
		tableauPraticienH.getRowSorter().toggleSortOrder(1);
	    //((DefaultRowSorter<TableModel, Integer>) tableauPraticienH.getRowSorter()).setSortable(1,false);
	    sorter.setSortable(2, false);
	    sorter.setSortsOnUpdates(true);
	    //sorter.setComparator(5, modeleTableauPraticienH.compare(c1, c2));
	  
	    
        //Evenement : click sur une ligne du tableau
	  /*  tableauPraticienH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                //N° de la ligne séléctionnée
                int row =  tableauPraticienH.getSelectedRow();
                //N° de ligne du tableau trié
                int sortedRow =  tableauPraticienH.convertRowIndexToModel(row);
                Object pe =  tableauPraticienH.getModel().getValueAt(sortedRow, 0);
                Object pr =  tableauPraticienH.getModel().getValueAt(sortedRow, 1);
                Object px = tableauPraticienH.getModel().getValueAt(sortedRow, 2);
                String s=pe + " a pris un " + pr + " au prix de " + px + " Eur";
                System.out.println(s);
            }
        });*/



		tableauPraticienH.setRowHeight(30) ;
		
		JScrollPane spPraticienH = new JScrollPane(tableauPraticienH) ;
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
		modeleTableauPraticienH = new ModeleListePraticienH(modele) ;
		tableauPraticienH.setModel(modeleTableauPraticienH) ;
	}
	
}
