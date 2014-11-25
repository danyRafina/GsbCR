package fr.gsbcr.views;

import javax.swing.table.AbstractTableModel ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import fr.gsbcr.controller.Controleur;
import fr.gsbcr.model.ModeleCompteRendu;
import fr.gsbcr.model.ModeleListeVisiteur;

/** Ecouteur des boutons du tableau des visiteurs
 * 
 * @author rafina
 *
 */
public class EcouteurBoutonVisiteur implements ActionListener {

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
		System.out.println("EcouteurBoutonVisiteur::actionPerformed()") ;
		Controleur controleur = ((ModeleListeVisiteur)this.table.getModel()).getControleur() ;
		ModeleCompteRendu modele = ((ModeleListeVisiteur) this.table.getModel()).getModele() ;
		String sColMatricule = ((ModeleListeVisiteur)this.table.getModel()).getMatriculeCollaborateur(this.row) ;
		String sColNom = ((ModeleListeVisiteur)this.table.getModel()).getNomCollaborateur(this.row) ;
		String sColPrenom = ((ModeleListeVisiteur)this.table.getModel()).getPrenomCollaborateur(this.row) ;
		switch(this.column){
			case 6 :
				System.out.println("----------------------------------------") ;
				System.out.println("[Choix mois et année ]") ;
				JMonthChooser mcMonth = new JMonthChooser();
				JYearChooser ycYear = new JYearChooser();
				JLabel lbMois = new JLabel("Mois");
				JLabel lbAnnee = new JLabel("Année");
				lbMois.setLabelFor(mcMonth);
				lbAnnee.setLabelFor(ycYear);
				String sMsgHeader = "Choisir le mois et l'année du compte-rendu pour : "+sColNom + " "+ sColPrenom;
				Object[] content = {sMsgHeader,lbMois,mcMonth,lbAnnee,ycYear};
				int iResultJP = JOptionPane.showOptionDialog(null,content, "Choix",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, null, null);
				if (iResultJP == JOptionPane.YES_OPTION){
					try {
						System.out.println("YEAR "+ycYear.getYear()+" "+ mcMonth.getMonth());
						mcMonth.setMonth(mcMonth.getMonth() + 1);
						boolean success = modele.getCR(ycYear.getYear(),mcMonth.getMonth(),sColMatricule);
						if(success == true){
							JOptionPane.showMessageDialog(null,"Désolé, mais il n'y a pas de compte-rendu rédigé à cette date . Merci de réesayer ","Erreur",JOptionPane.WARNING_MESSAGE);
							this.actionPerformed(e);
						}
						else {
							controleur.visualiserCR();
						}
					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				break ;
		}
	}

}
