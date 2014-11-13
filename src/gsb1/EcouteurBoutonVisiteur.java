package gsb1;

import javax.swing.table.AbstractTableModel ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/** Ecouteur des boutons du tableau des locations
 * 
 * @author xilim
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
		String iColMatricule = ((ModeleListeVisiteur)this.table.getModel()).getMatriculeCollaborateur(this.row) ;
		
		switch(this.column){
			case 6 :
				System.out.println("----------------------------------------") ;
				System.out.println("[Afficher ]") ;
				JOptionPane.showInputDialog(null,"Saisir la valeur du compteur kilométrique :","Compteur kilométrique",JOptionPane.QUESTION_MESSAGE) ;
				//JOptionPane.p
				//controleur.enregistrerDepart(numeroLocation) ;
				break ;
			/*case 7 :
				System.out.println("----------------------------------------") ;
				System.out.println("[Enregistrer le retour]") ;
				String saisieKm ;
				int nbKm = -1 ;
				boolean finSaisie = false ;
				do {
					saisieKm = JOptionPane.showInputDialog(null,"Saisir la valeur du compteur kilométrique :","Compteur kilométrique",JOptionPane.QUESTION_MESSAGE) ;
					if(saisieKm != null){
						try {
							nbKm = Integer.parseInt(saisieKm) ;
							if(nbKm < 0){
								JOptionPane.showMessageDialog(null,"La valeur saisie n'est pas correcte.","Compteur kilométrique",JOptionPane.ERROR_MESSAGE) ;
							}
							else {
								//Vehicule vehicule = ((ModeleListeVisiteur)this.table.getModel()).getVehicule(this.row) ;
								//if(nbKm < vehicule.getCompteur()){
									JOptionPane.showMessageDialog(null,"La valeur saisie n'est pas correcte.","Compteur kilométrique",JOptionPane.ERROR_MESSAGE) ;
								//}
								//else {
									finSaisie = true ;
								///}
							}
						}
						catch(NumberFormatException exception){
							JOptionPane.showMessageDialog(null,"La valeur saisie n'est pas correcte.","Compteur kilométrique",JOptionPane.ERROR_MESSAGE) ;
						}
					}
					else {
						finSaisie = true ;
					}
				} while(! finSaisie) ;
				if(saisieKm != null && nbKm != -1){
					//controleur.enregistrerRetour(numeroLocation,nbKm) ;
				}
				break ;
			case 8 :
				System.out.println("----------------------------------------") ;
				System.out.println("[Annuler la location]") ;
				//controleur.annulerLocation(numeroLocation) ;
				break ;*/
		}
	}

}
