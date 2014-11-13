package gsb1 ;

import java.awt.* ;

import javax.swing.table.* ;
import javax.swing.* ;

/** Rendu des cellules du tableau des locations
 * 
 * @author xilim
 *
 */
public class RenduCelluleLocation extends DefaultTableCellRenderer {
	
	/** Créer le rendu
	 * 
	 */
	public RenduCelluleLocation(){
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
		
		//System.out.println("RenduCelluleLocation::getTableCellRendererComponent()") ;
		
		int etat = ((ModeleListeVisiteur)table.getModel()).getEtat(row) ;
		
		switch(etat){
			case Location.EN_ATTENTE :
				setBackground(new Color(211,237,200,50)) ;
				break ;
			case Location.EN_COURS :
				setBackground(new Color(249,219,115,50)) ;
				break ;
			case Location.TERMINEE :
				setBackground(new Color(237,200,200,50)) ;
				break ;
		}
		
		if(column >= 1 && column <= 3){
			setHorizontalAlignment(JLabel.CENTER);
		}
		else {
			setHorizontalAlignment(JLabel.LEFT);
		}
		
		return this ;
	}
	
}
