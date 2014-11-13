package rentaco;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

/** Vue dédiée à la saisie des informations d'un nouveau client
 * 
 * @author xilim
 *
 */
public class VueNouveauClient extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private ModeleCompteRendu modele ;
	
	private JTextField tfNom = new JTextField() ;
	private JTextField tfPrenom = new JTextField() ;
	private JTextField tfMobile = new JTextField() ;
	
	private JButton bEnregistrer = new JButton("Enregistrer") ;
	private JButton bAnnuler = new JButton("Annuler") ;
	
	/** Créer la vue de saisie d'un nouveau client
	 * 
	 * @param modele Le modèle
	 * @param controleur Le contrôleur
	 */
	public VueNouveauClient(ModeleCompteRendu modele, Controleur controleur) {
		super();
		System.out.println("VueNouveauClient::VueNouveauClient()") ;
		this.modele = modele ;
		this.controleur = controleur ;
		
		this.bEnregistrer.addActionListener(this) ;
		
		// A compléter
	}
	
	/** Gérer les actions de l'utilisateur
	 * 
	 * @param evenement L'action de l'utilisateur
	 */
	@Override
	public void actionPerformed(ActionEvent evenement) {
		System.out.println("VueNouveauClient::actionPerformed()") ;
		Object sourceEvt = evenement.getSource() ;
		if(sourceEvt == this.bEnregistrer){
			// A compléter
		}
		// A compléter
	}
	
}
