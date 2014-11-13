package fr.gsbcr.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import fr.gsbcr.model.ModeleListeCR;

/** Ecouteur des boutons du tableau des locations
 * 
 * @author xilim
 *
 */
public class EcouteurBoutonCR implements ActionListener {

	private int row ;
	private int column ;
	private JTable table ;
	private JButton bouton ;
	
	/** Modifier l'indice de la ligne
	 * @param row L'indice de la ligne
	 */
	public void setRow(int row){
		//System.out.println("EcouteurBoutonLocation::setRow()") ;
		this.row = row ;
	}
	
	/** Modifier l'indice de la colonne
	 * 
	 * @param column L'indice de la colonne
	 */
	public void setColumn(int column){
		//System.out.println("EcouteurBoutonLocation::setColumn()") ;
		this.column = column ;
	}
	
	/** Modifier le tableau
	 * @param table Le nouveau tableau
	 */
	public void setTable(JTable table){
		//System.out.println("EcouteurBoutonLocation::setTable()") ;
		this.table = table ;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("EcouteurBoutonCR::actionPerformed()") ;
		String sBilan =  ((ModeleListeCR)this.table.getModel()).getBilan(this.row) ;
		String sMotif =((ModeleListeCR)this.table.getModel()).getMotif(this.row) ;
		int sNumRapport =((ModeleListeCR)this.table.getModel()).getNumRapport(this.row) ;
		
		switch(this.column){
			case 5 :
				System.out.println("----------------------------------------") ;
				System.out.println("[Afficher ]");
				Object[] content = {"Rapport numéro : "+sNumRapport,"\n","Bilan : "+sBilan,"Motif : "+sMotif,"\n"};
				JOptionPane.showOptionDialog(null,content, "Détails",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, null, null);
				break ;
		}
	}

}
