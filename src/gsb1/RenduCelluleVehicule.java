package rentaco ;

import java.awt.* ;
import javax.swing.table.* ;
import javax.swing.* ;

/** Rendu des cellules du tableau des véhicules
 * 
 * @author xilim
 *
 */
public class RenduCelluleVehicule extends DefaultTableCellRenderer {
	
	/** Créer le rendu
	 * 
	 */
	public RenduCelluleVehicule(){
		super() ;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.DefaultTableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
	 */
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, 
															boolean hasFocus, int row, int column){
		super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column) ;
		
		//System.out.println("RenduCelluleVehicule::getTableCellRendererComponent()") ;
		
		int situation = ((ModeleListeVehicules)table.getModel()).getSituation(row) ;
		
		switch(situation){
			case Vehicule.DISPONIBLE :
				setBackground(new Color(211,237,200,50)) ;
				break ;
			case Vehicule.RESERVE :
				setBackground(new Color(249,219,115,50)) ;
				break ;
			case Vehicule.LOUE :
				setBackground(new Color(237,200,200,50)) ;
				break ;
		}
		
		if(column == 4){			
			switch(situation){
				case Vehicule.DISPONIBLE :
					setText("Disponible") ;
					break ;
				case Vehicule.RESERVE :
					setText("Réservé") ;
					break ;
				case Vehicule.LOUE :
					setText("Loué") ;
					break ;
				default :
					setText("inconnue") ;
			}
		}
		
		if(column == 2 || column == 4){
			setHorizontalAlignment(JLabel.CENTER);
		}
		else if(column == 3){
			setHorizontalAlignment(JLabel.RIGHT);
		}
		else {
			setHorizontalAlignment(JLabel.LEFT);
		}
		
		return this ;
	}
	
}
