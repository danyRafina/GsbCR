package fr.gsbcr.views;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/** Rendu des boutons du tableau des locations
 * 
 * @author xilim
 *
 */
public class RenduBoutonCR extends JButton implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		//System.out.println("RenduBoutonLocation::getTableCellRendererComponent()") ;
		if(value != null){
			this.setText(value.toString()) ;
			
		}
		else {
			this.setText("") ;
		}
		this.setEnabled(true) ;
		
		return this ;
	}
	
	

}
