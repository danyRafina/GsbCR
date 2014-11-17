package fr.gsbcr.model;

import fr.gsbcr.views.GuiGsbCR;

/** Classe de génération d'exception
 * @author rafina
 *
 */
public class ModeleException extends Throwable{

	private static final long serialVersionUID = 2576946996186413405L;
	private String exception;
	
	/** Création de l'exception
	 * 
	 * @param exception Message contenant l'exception
	 */
	public ModeleException(String exception) {
		super();
		this.exception = exception;
		GuiGsbCR.displayError(this.exception);
	}
	
	
	
}
