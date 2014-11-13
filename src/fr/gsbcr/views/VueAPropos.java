package fr.gsbcr.views;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.gsbcr.controler.Controleur;

public class VueAPropos extends JPanel {
	private static final long serialVersionUID = 1L;
	private Controleur controleur ;
	private JLabel lbText = new JLabel("Application GSB 2014");
	private JLabel lbText2 = new JLabel("Cette application est destinée aux délégués régionaux");
	public VueAPropos(Controleur controleur){
		super();
		this.setControleur(controleur) ;
		System.out.println("VueConnexion::add model , add controler") ;
	
		this.lbText.setForeground(Color.BLUE);
		this.lbText2.setForeground(Color.BLUE);
		this.add(lbText);
		this.add(lbText2);
		
	}



	public void actualiser() {
		
	}



	public Controleur getControleur() {
		return controleur;
	}



	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}


}
