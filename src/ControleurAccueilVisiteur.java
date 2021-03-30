import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

public class ControleurAccueilVisiteur {
	
	private User connectedUser;
	
	public ControleurAccueilVisiteur(FenetreLogin f0, FenetreAccueil f1, DAOVisites daovisites, User user) {
		this.connectedUser = user;
		
		List<Visite> data = null;
		data = daovisites.getVisitesByVisiteur(user.getIduser());
		VisiteursJTableModel modele = new VisiteursJTableModel(data, daovisites);
		f1.getTable().setModel(modele);
		
		f1.setVisible(true);
		
		f1.getBtnAjouterUneVisite().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				ControleurAjoutModifVisite ctrl3 = new ControleurAjoutModifVisite(daovisites, user, f1);
				ctrl3.addVisite(new FenetreAjout());
			}
		});
		
		f1.getBtnModifierLeStatut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				ControleurAjoutModifVisite ctrl3 = new ControleurAjoutModifVisite(daovisites, user, f1);
				ctrl3.modifyVisite(new FenetreStatutVisite());
			}
		});
		
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
		
		f1.getBtnActualiser().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f1.setVisible(false);
				new ControleurAccueilVisiteur(f0, new FenetreAccueil(), daovisites, connectedUser);
			}
		});
		
	}
	
}
