package fr.gsbcr.views ;

import java.awt.* ;

import javax.swing.table.* ;
import javax.swing.* ;

import fr.gsbcr.model.ModeleListeCR;

/** Rendu des cellules du tableau des comptes-rendus
 * 
 * @author rafina
 *
 */
public class RenduCelluleCR extends DefaultTableCellRenderer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4686133508487909123L;

	/** Créer le rendu
	 * 
	 */
	public RenduCelluleCR(){
		super() ;
		//System.out.println("RenduCelluleLocation::RenduCelluleLocation()") ;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
															boolean hasFocus, int row, int column){
		super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column) ;
		
		String etat = ((ModeleListeCR)table.getModel()).getEtat(row) ;
		
		switch(etat){
			case "NON LU" :
				setBackground(new Color(211,237,200,50)) ;
				break ;
			case "LU" :
				setBackground(new Color(0,150,1,50)) ;
				break ;
		}
		setHorizontalAlignment(JLabel.CENTER);
		return this ;
	}
	
}
