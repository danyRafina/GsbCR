package fr.gsbcr.views;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fr.gsbcr.controler.Controleur;
import fr.gsbcr.model.ModeleCompteRendu;

/** Vue principale 
 * 
 * @author xilim
 *
 */
public class GuiGsbCR extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private ModeleCompteRendu modele ;
	private Controleur controleur ;
		
	private JMenuItem itemQuitter ;
	private JMenuItem itemVisualiserVisiteur ;
	private JMenuItem itemVisualiserPraticien ;
	private JMenuItem itemAPropos ;
	private JMenuItem itemDeconnexion;
	private JMenuBar barreMenus;
	private JMenu menuVisiteur;
	private JMenu menuPraticien;
	private JMenu menuCompte;
	private JMenu menuAide;
	
	private VueListePraticienH vueVisualiserPraticien;
	private VueConnexion vueConnexion ;
	private VueListeVisiteur vueVisualiserVisiteurs ;
	private VueListeCompteRendu vueVisualiserCR ;
	private VueAPropos vueAPropos ;
	
	private CardLayout vues ;
	private Container conteneur ;
	

	/** Construire la vue principale de l'application
	 * 
	 * @param modele Le modèle
	 * @param controleur Le contrôleur
	 */
	public GuiGsbCR(ModeleCompteRendu modele, Controleur controleur) {
		super();
		System.out.println("GuiGsbCR::GuiGsbCR()") ;
		this.modele = modele;
		this.controleur = controleur ;
		this.controleur.setVuePrincipales(this);
		
		this.setTitle("Application GSB") ;
		//this.setSize(1300,500) ; 
		this.setSize(1120,520) ;
		this.setLocationRelativeTo(null) ;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		
		this.vues = new CardLayout(2,2) ;
		this.conteneur = this.getContentPane() ;
		this.conteneur.setLayout(this.vues) ;
		
		vueVisualiserPraticien = new VueListePraticienH(modele,controleur) ;
		vueVisualiserVisiteurs = new VueListeVisiteur(modele,controleur) ;
		vueConnexion = new VueConnexion(modele,controleur) ;
		vueVisualiserCR = new VueListeCompteRendu(modele,controleur) ;
		vueAPropos = new VueAPropos(controleur) ;
		
		this.conteneur.add(vueVisualiserPraticien,"Liste praticiens hesitants") ;
		this.conteneur.add(vueVisualiserVisiteurs,"Liste des Visiteurs") ;
		this.conteneur.add(vueVisualiserCR,"Liste des Comptes Rendus") ;
		this.conteneur.add(vueConnexion,"Vue Connexion") ;
		
		this.vues.show(this.conteneur,"Vue Connexion");
		
		this.menuBar() ;
		this.setVisible(true) ;
		
	}
	
	
	/** Obtenir le contrôleur
	 * 
	 * @return Le contrôleur
	 */
	public Controleur getControleur() {
		System.out.println("GuiRentaco::getControleur()") ;
		return this.controleur;
	}

	/** Modifier le contrôleur
	 * 
	 * @param controleur Le nouveau contrôleur
	 */
	public void setControleur(Controleur controleur) {
		System.out.println("GuiRentaco::setControleur()") ;
		this.controleur = controleur;
	}

	/** Obtenir le modèle
	 * 
	 * @return Le modèle
	 */
	public ModeleCompteRendu getModele() {
		System.out.println("GuiRentaco::getModele()") ;
		return this.modele;
	}

	/** Modifier le modèle
	 * 
	 * @param modele Le nouveau modèle
	 */
	public void setModele(ModeleCompteRendu modele) {
		System.out.println("GuiRentaco::setModele()") ;
		this.modele = modele;
	}

	/** Créer la barre de menus
	 * 
	 */
	private void menuBar(){
		System.out.println("GUI::menuBAr()") ;
		JMenuBar barreMenus = new JMenuBar() ;
		
		JMenu menuFichier = new JMenu("Fichier") ;
		this.itemQuitter = new JMenuItem("Quitter") ;
		this.itemQuitter.addActionListener(this) ;
		menuFichier.add(this.itemQuitter) ;
		
		menuPraticien = new JMenu("Praticien") ;
		menuVisiteur = new JMenu("Visiteur") ;
		menuCompte = new JMenu("Compte") ;
		this.itemDeconnexion = new JMenuItem("Déconnexion") ;
		this.itemDeconnexion.addActionListener(this);
		menuCompte.add(this.itemDeconnexion);
		this.menuAide = new JMenu("Aide") ;
		this.itemAPropos = new JMenuItem("A propos") ;
		this.menuAide.add(this.itemAPropos) ;
		this.itemAPropos.addActionListener(this) ;
		this.itemVisualiserVisiteur = new JMenuItem("Liste des Visiteurs") ;
		this.itemVisualiserVisiteur.addActionListener(this) ;
		menuVisiteur.add(this.itemVisualiserVisiteur) ;
		this.itemVisualiserPraticien = new JMenuItem("Liste des praticiens hésitants") ;
		this.itemVisualiserPraticien.addActionListener(this) ;
		menuPraticien.add(this.itemVisualiserPraticien) ;
		
		menuPraticien.setEnabled(false);
		menuVisiteur.setEnabled(false);
		this.menuCompte.setEnabled(false);
		this.menuAide.setEnabled(false);
		barreMenus.add(menuFichier) ;
		barreMenus.add(menuPraticien);
		barreMenus.add(menuVisiteur);
		barreMenus.add(menuCompte) ;
		barreMenus.add(menuAide) ;
		
		this.setJMenuBar(barreMenus) ;
	}
	
	public JMenu getMenuAide() {
		return menuAide;
	}


	public JMenu getMenuCompte() {
		return menuCompte;
	}

	public void setMenuCompte(JMenu menuCompte) {
		this.menuCompte = menuCompte;
	}

	public JMenuItem getItemDeconnexion() {
		return itemDeconnexion;
	}

	public void setItemDeconnexion(JMenuItem itemDeconnexion) {
		this.itemDeconnexion = itemDeconnexion;
	}



	public JMenuBar getBarreMenus() {
		return barreMenus;
	}

	public void setBarreMenus(JMenuBar barreMenus) {
		this.barreMenus = barreMenus;
	}

	public JMenu getMenuVisiteur() {
		return menuVisiteur;
	}

	public void setMenuVisiteur(JMenu menuVisiteur) {
		this.menuVisiteur = menuVisiteur;
	}

	public JMenu getMenuPraticien() {
		return menuPraticien;
	}

	public void setMenuPraticien(JMenu menuPraticien) {
		this.menuPraticien = menuPraticien;
	}

	/** Basculer sur l'une des vues
	 * 
	 * @param nomVue La vue qui doit passer au premier plan
	 */
	public void changerDeVue(String nomVue){
		System.out.println("GuiRentaco::changerVue()") ;
		if(nomVue.equals("Vue Connexion")){
			this.vueConnexion.actualiser() ;
		}
		else if(nomVue.equals("Liste praticiens hesitants")){
			this.vueVisualiserPraticien.actualiser() ;
		}
		else if(nomVue.equals("Liste des Visiteurs")){
			this.vueVisualiserVisiteurs.actualiser() ;
			
		}
		else if(nomVue.equals("Liste des Comptes Rendus")){
			this.vueVisualiserCR.actualiser() ;
			
		}
		else if(nomVue.equals("A propos")){
			this.vueAPropos.actualiser() ;
			
		}
		System.out.println("GuiRentaco::changerVue()::show name of view : "+ nomVue ) ;
		this.vues.show(this.conteneur,nomVue) ;
		System.out.println("GuiRentaco::changerVue()::show execute") ;
	}
	
	public void changeStateMenu(int num){
		if( num == 1) {
			this.getMenuPraticien().setEnabled(true);
			this.getMenuVisiteur().setEnabled(true);
			this.getMenuCompte().setEnabled(true);
			this.getMenuAide().setEnabled(true);
		}
		else {
			this.getMenuPraticien().setEnabled(false);
			this.getMenuVisiteur().setEnabled(false);
			this.getMenuCompte().setEnabled(false);
			this.getMenuAide().setEnabled(false);
		}
	}
	
	public static void showMessage(String error){
		JOptionPane.showMessageDialog(null,error);
	}

	/** Gérer les actions de l'utilisateur
	 * 
	 * @param evenement L'événement utilisateur
	 */
	@Override
	public void actionPerformed(ActionEvent evenement) {
		System.out.println("----------------------------------------") ;
		System.out.println("::actionPerformed()") ;
		Object sourceEvt = evenement.getSource() ;
		
		if(sourceEvt == this.itemQuitter ){
			try {
				int iSelected = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment quitter l'application ?", "Quitter ", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
				if(iSelected == JOptionPane.OK_OPTION) {
					this.controleur.deconnexion();
					this.controleur.quitterApplication() ;
				}
			} catch (SQLException e) {
				GuiGsbCR.displayError(e.getMessage());
				e.printStackTrace();
			}
		}
		else if(sourceEvt == this.itemDeconnexion){
			try {
				int iSelected = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment vous déconnecter ?", "Déconnexion", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
				if(iSelected == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(null,"Vous êtes dorénavent déconnecté", "Déconnexion réussie",JOptionPane.INFORMATION_MESSAGE);
					this.controleur.deconnexion() ;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(sourceEvt == this.itemVisualiserPraticien){
			this.controleur.visualiserPraticienH() ;
		}
		else if(sourceEvt == this.itemVisualiserVisiteur){
			this.controleur.visualiserVisit() ;
		}
		else if(sourceEvt == this.itemAPropos){
			this.controleur.visualiserAPropos() ;
		}
		
		/*else if(sourceEvt == this.itemVisualiserVehicules){
			this.controleur.visualiserVehicules() ;
		}*/
		
	}
	
	public static void displayError(String e){
		JOptionPane.showMessageDialog(null,"Une erreur à été détetée \n"+ e,"Message d'erreur", JOptionPane.ERROR_MESSAGE, null);
	}
}
	
