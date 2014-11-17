package fr.gsbcr.views;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.gsbcr.controller.Controleur;

/** Vue dédiée à l'affichage des informations de l'application
 * 
 * @author rafina
 *
 */

public class VueAPropos extends JPanel {
	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private JLabel lbText = new JLabel("Application GSB 2014");
	private JLabel lbText2 = new JLabel("Cette application est destinée aux délégués régionaux");
	
	/** Création de la vue 
	 * 
	 * @param controleur Controleur de l'application
	 */
	public VueAPropos(Controleur controleur){
		super();
		this.setControleur(controleur) ;
		System.out.println("VueConnexion::add model , add controler") ;
	
		this.lbText.setForeground(Color.BLUE);
		this.lbText2.setForeground(Color.BLUE);
		this.add(lbText);
		this.add(lbText2);
		
	}
	/** Obtenir le contrôleur 
	 * 
	 * @return le contrôleur de l'application
	 */
	public Controleur getControleur() {
		return controleur;
	}

	/** Modifier le contrôleur de l'application
	 * 
	 * @param controleur Nouveau contrôleur
	 */

	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}
	
	/**  Actualiser les champs 
	 */
	public void actualiser(){
		
	}

}
