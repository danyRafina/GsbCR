package fr.gsbcr.model;

import javax.swing.JOptionPane;

import fr.gsbcr.views.GuiGsbCR;

public class ModeleException extends Throwable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2576946996186413405L;
	private String exception;

	public ModeleException(String exception) {
		super();
		this.exception = exception;
		GuiGsbCR.displayError(this.exception);
	}
	
	
	
}
