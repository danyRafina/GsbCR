package fr.gsbcr.views;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import fr.gsbcr.controller.Controleur;
import fr.gsbcr.model.ModeleCompteRendu;
import fr.gsbcr.model.ModeleException;
import fr.gsbcr.model.ModeleListeCR;
import fr.gsbcr.model.ModeleListeVisiteur;

/** Ecouteur des boutons du tableau des comptes-rendus
 * 
 * @author rafina
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
		ModeleCompteRendu modele = ((ModeleListeCR)this.table.getModel()).getModele() ;
		Controleur controleur = ((ModeleListeCR)this.table.getModel()).getControleur() ;
		//String sBilan =  ((ModeleListeCR)this.table.getModel()).getBilan(this.row) ;
		//String sMotif =((ModeleListeCR)this.table.getModel()).getMotif(this.row) ;
		int iNumRapport =((ModeleListeCR)this.table.getModel()).getNumRapport(this.row) ;
		String sColMatricule =((ModeleListeCR)this.table.getModel()).getMatricule(this.row) ;
		String sRapLu =  ((ModeleListeCR)this.table.getModel()).getEtat(this.row) ;
		
		try {
			switch(this.column){
				case 5 :
					System.out.println("----------------------------------------") ;
					System.out.println("[Afficher ]");
					if(sRapLu == "NON LU"){
						try {
							modele.setRapLu(iNumRapport);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					/*Object[] content = {"Rapport numéro : "+iNumRapport,"\n","Bilan : "+sBilan,"Motif : "+sMotif,"\n"};
					JOptionPane.showOptionDialog(null,content, "Détails",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, null, null);
					break ;*/
					modele.rechercherCR(sColMatricule, iNumRapport);
					controleur.visualiserInfoCR();
					
			}
		} catch (HeadlessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
