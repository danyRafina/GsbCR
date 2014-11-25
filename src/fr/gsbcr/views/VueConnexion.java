package fr.gsbcr.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import fr.gsbcr.controller.Controleur;
import fr.gsbcr.model.ModeleCompteRendu;


/** Vue dédiée à l'affichage à la connexion
 * 
 * @author rafina
 *
 */
public class VueConnexion extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleCompteRendu modele ;
	private JTextField tfUserId = new JTextField(10);
	private JPasswordField pfUserPass = new JPasswordField(10);
	private JLabel lbUserId = new JLabel("Identifiant : ");
	private JLabel lbUserPass = new JLabel("Mot de passe : ");
	private JLabel lbText = new JLabel("Bienvenue sur l'application GSB");
	private JLabel lbText2 = new JLabel("Pour vous connecter , cliquez sur le bouton ci-dessous");
	private JLabel lbText1 = new JLabel("Veuillez entrez votre identifiant et mot de passe ");
	private JButton bSeConnecter = new JButton("Se Connecter");
	private JPanel panel = new JPanel();
	private GridLayout layout = new GridLayout(3,1);
	
	/** Création de la vue
	 * 
	 * @param modele Modèle de l'application
	 * @param controleur Controleur de l'application
	 */
	public VueConnexion(ModeleCompteRendu modele, Controleur controleur){
		super();
		System.out.println("VueConnexion::VueConnexion()") ;
		this.modele = modele;
		this.controleur = controleur ;
		System.out.println("VueConnexion::add model , add controler") ;
		this.panel.setLayout(layout);
		this.lbUserId.setLabelFor(tfUserId);
		this.lbUserPass.setLabelFor(pfUserPass);
		this.bSeConnecter.addActionListener(this);
		this.lbText.setForeground(Color.BLUE);
		this.lbText2.setForeground(Color.BLUE);
		panel.add(lbText);
		panel.add(lbText2);
		panel.add(bSeConnecter);
		this.add(this.panel);
		
	}

	/** Gérer les actions de l'utilisateur
	 * 
	 * @param event L'action de l'utilisateur
	 */

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent event) {
		System.out.println("VueConnexion::actionPerformed()") ;
		Object sourceEvt = event.getSource() ;
		if(sourceEvt == this.bSeConnecter){

			Object[] content = {lbText1,lbUserId,tfUserId,lbUserPass,pfUserPass};
			int iResultJP = JOptionPane.showOptionDialog(this,content, "Fenêtre de connexion",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
					null, null, null);
			if (iResultJP == JOptionPane.OK_OPTION){
				if( (tfUserId.getText().isEmpty() || pfUserPass.getText().isEmpty() ) == false  ){
					boolean success = false;
					try {
						success = this.controleur.seConnecter(tfUserId.getText(),pfUserPass.getText());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(success == false) {
						GuiGsbCR.showMessage("Erreur : Veuillez vérifer l'identifiant ou le mot de passe saisie ");
					}
				}
				else {
					GuiGsbCR.showMessage("Erreur : Les champs sont vides ! ");
				}
			
			}
			this.actualiser();
			
		}
		
	}
	/**  Actualiser les champs 
	 */
	public void actualiser(){
		System.out.println("VueConnexion::actualiser()") ;
		this.tfUserId.setText("");
		this.pfUserPass.setText("");
	}
	
	
}



