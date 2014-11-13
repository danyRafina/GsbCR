package gsb1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

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
		//this.bCancel.addActionListener(this);
		
		/*this.boxUserId.add(lbUserId);
		this.boxUserId.add(this.tfUserId);
		this.boxUserPass.add(lbUserPass);
		this.boxUserPass.add(this.pfUserPass);
		this.boxBouttons.add(this.bValidate);
		this.boxBouttons.add(this.bCancel);*/
		//this.boxPrincipal.add(boxUserId);
		//this.boxPrincipal.add(boxUserPass);
		//this.boxPrincipal.add(boxBouttons);*/
		this.lbText.setForeground(Color.BLUE);
		this.lbText2.setForeground(Color.BLUE);
		panel.add(lbText);
		panel.add(lbText2);
		panel.add(bSeConnecter);
	
		
		this.add(this.panel);
	
		System.out.println("VueConnexion::add all on pricipal box") ;
		
	}

	/** Gérer les actions de l'utilisateur
	 * 
	 * @param evenement L'action de l'utilisateur
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
				boolean success = this.controleur.seConnecter(tfUserId.getText(),pfUserPass.getText());
					if(success == false) {
						GuiGsbCR.showMessage("Erreur : Veuillez vérifer l'identifiant ou le mot de passe saisie ");
					}
				}
			this.actualiser();
		}
		
	}
	/** 
	 * 
	 */
	public void actualiser(){
		System.out.println("VueConnexion::actualiser()") ;
		this.tfUserId.setText("");
		this.pfUserPass.setText("");
	}
	
	
}



