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
public class EditeurBoutonCR extends DefaultCellEditor {

	private static final long serialVersionUID = 1L;
	protected JButton bouton ;
	private boolean isPushed ;
	private EcouteurBoutonCR ecouteur = new EcouteurBoutonCR() ;

	/** Créer l'éditeur
	 * 
	 * @param checkBox La case à cocher associée au bouton
	 */
	public EditeurBoutonCR(JCheckBox checkBox) {
		super(checkBox);
		System.out.println("EditeurBoutonCR::EditeurBoutonCR()") ;
		this.bouton = new JButton() ;
		System.out.println("EditeurBoutonCR::EditeurBoutonCR(2)") ;
		this.bouton.setOpaque(true) ;
		System.out.println("EditeurBoutonCR::EditeurBoutonCR(3)") ;
		this.bouton.addActionListener(this.ecouteur) ;
		System.out.println("EditeurBoutonCR::EditeurBoutonCR(4)") ;
	}

	/* (non-Javadoc)
	 * @see javax.swing.DefaultCellEditor#getTableCellEditorComponent(javax.swing.JTable, java.lang.Object, boolean, int, int)
	 */
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		
		System.out.println("EditeurBoutonCR::getTableCellEditorComponent()") ;
		this.ecouteur.setRow(row) ;
		System.out.println("EditeurBoutonCR::getTableCellEditorComponent(::1)") ;
		this.ecouteur.setColumn(column) ;
		System.out.println("EditeurBoutonCR::getTableCellEditorComponent(::2)"); 
		this.ecouteur.setTable(table) ;
		System.out.println("EditeurBoutonCR::getTableCellEditorComponent(::3)") ;
		
		if(value == null){
			this.bouton.setText("") ;
		}
		else {
			this.bouton.setText(value.toString()) ;
		}
		
		return this.bouton ;
	}

}
