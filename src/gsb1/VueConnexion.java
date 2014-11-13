package gsb1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
	private JLabel lbText = new JLabel("Entrez votre identifiant et mot de passe pour acc�der � l'application");
	private Box boxPrincipal = Box.createVerticalBox() ;
	private Box boxUserId= Box.createHorizontalBox() ;
	private Box boxUserPass = Box.createHorizontalBox() ;
	private Box boxBouttons = Box.createHorizontalBox() ;
	private Box boxText = Box.createVerticalBox();
	private JButton bCancel = new JButton("Annuler");
	private JButton bValidate = new JButton("Valider");
	
	public VueConnexion(ModeleCompteRendu modele, Controleur controleur){
		super();
		System.out.println("VueConnexion::VueConnexion()") ;
		this.modele = modele;
		this.controleur = controleur ;
		System.out.println("VueConnexion::add model , add controler") ;
		
		this.bValidate.addActionListener(this);
		this.bCancel.addActionListener(this);
		
		
		this.boxUserId.add(lbUserId);
		this.boxUserId.add(this.tfUserId);
		this.boxUserPass.add(lbUserPass);
		this.boxUserPass.add(this.pfUserPass);
		this.boxBouttons.add(this.bValidate);
		this.boxBouttons.add(this.bCancel);
		this.boxText.add(this.lbText);

		this.boxPrincipal.add(boxUserId);
		this.boxPrincipal.add(boxUserPass);
		this.boxPrincipal.add(boxBouttons);
		//this.add(this.boxText);
		this.add(this.boxPrincipal);
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
		if(sourceEvt == this.bValidate){
			System.out.println(tfUserId.getText() +" "+pfUserPass.getText()) ;
			this.controleur.seConnecter(tfUserId.getText(),pfUserPass.getText());
			this.actualiser();
			
		}
		if(sourceEvt == this.bCancel){
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



