package gsb1;

import javax.swing.JOptionPane;

public class LoadingDriver {
	
	private String sDriverInf ="com.mysql.jdbc.Driver";
	
	public LoadingDriver() throws ClassNotFoundException {
		try {
			Class.forName(this.sDriverInf);
		}
		catch (ClassNotFoundException event){
			JOptionPane.showMessageDialog(null,"Error loading driver "+ event.getMessage());
		}
	}

}
