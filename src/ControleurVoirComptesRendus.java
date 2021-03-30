import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

public class ControleurVoirComptesRendus {
	
	private User connectedUser;
	
	public ControleurVoirComptesRendus(FenetreLogin f0, FenetreVoirCR f1, DAOVisites daovisites, User user) {
		this.connectedUser = user;
		
		List<Compte_rendu> data = null;
		data = daovisites.getallCR();
		ComptesRendusJTableModel modele = new ComptesRendusJTableModel(data, daovisites);
		f1.getTable().setModel(modele);
		
		f1.setVisible(true);
		
		f1.getBtnDeconnexion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				connectedUser=null;
				f0.getTxtLogin().setText("");
				f0.getPasswordField().setText("");
				f0.setVisible(true);
			}
		});
	}
}