package fr.gsbcr.views;

import java.awt.Component;

import javax.swing.DefaultCellEditor ;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/** Editeur des boutons du tableau des locations
 * 
 * @author xilim
 *
 */
public class EditeurBoutonVisiteur extends DefaultCellEditor {

	private static final long serialVersionUID = 1L;
	protected JButton bouton ;
	private boolean isPushed ;
	private EcouteurBoutonVisiteur ecouteur = new EcouteurBoutonVisiteur() ;

	/** Créer l'éditeur
	 * 
	 * @param checkBox La case à cocher associée au bouton
	 */
	public EditeurBoutonVisiteur(JCheckBox checkBox) {
		super(checkBox);
		System.out.println("EditeurBoutonVisiteur::EditeurBoutonVisiteur()") ;
		this.bouton = new JButton() ;
		System.out.println("EditeurBoutonVisiteur::EditeurBoutonVisiteur(2)") ;
		this.bouton.setOpaque(true) ;
		System.out.println("EditeurBoutonVisiteur::EditeurBoutonVisiteur(3)") ;
		this.bouton.addActionListener(this.ecouteur) ;
		System.out.println("EditeurBoutonVisiteur::EditeurBoutonVisiteur(4)") ;
	}

	/* (non-Javadoc)
	 * @see javax.swing.DefaultCellEditor#getTableCellEditorComponent(javax.swing.JTable, java.lang.Object, boolean, int, int)
	 */
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		System.out.println("EditeurBoutonVisiteur::getTableCellEditorComponent()") ;
		this.ecouteur.setRow(row) ;
		System.out.println("EditeurBoutonVisiteur::getTableCellEditorComponent(::1)") ;
		this.ecouteur.setColumn(column) ;
		System.out.println("EditeurBoutonVisiteur::getTableCellEditorComponent(::2)"); 
		this.ecouteur.setTable(table) ;
		System.out.println("EditeurBoutonVisiteur::getTableCellEditorComponent(::3)") ;
		
		if(value == null){
			this.bouton.setText("") ;
		}
		else {
			this.bouton.setText(value.toString()) ;
		}
		
		return this.bouton ;
	}

}
