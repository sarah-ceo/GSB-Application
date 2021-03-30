import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControleurLogin {
	FenetreLogin f0;
	DAOUser daouser;
	User connectedUser;
	
	public ControleurLogin(FenetreLogin f0, DAOUser daouser) {
		super();
		this.f0 = f0;
		this.daouser = daouser;
		
		f0.setVisible(true);
		
		f0.getBtnConnexion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = f0.getTxtLogin().getText();
				char[] motdepasseField = f0.getPasswordField().getPassword();
				String motdepasse = String.valueOf(motdepasseField);
				
				connectedUser = daouser.checkAuth(email, motdepasse);
				
				if (connectedUser.getIduser() == 0) {
					JOptionPane.showMessageDialog(f0, "Email ou mot de passe incorrect !");
				} else {
					f0.setVisible(false);
					switch(connectedUser.getStatut()) {
						case "Visiteur":
							ControleurAccueilVisiteur ctrl2 = new ControleurAccueilVisiteur(f0, new FenetreAccueil(), new DAOVisites(Singleton.getInstance().getConnection()), connectedUser);
							break;
						case "Delegue regional":
							ControleurAccueilDelegue ctrl2D = new ControleurAccueilDelegue(f0, new FenetreDelegue(), new DAOVisites(Singleton.getInstance().getConnection()), daouser, connectedUser);
							break;
						case "Responsable secteur":
							ControleurAccueilResponsable ctrl2R = new ControleurAccueilResponsable(f0, new FenetreResponsable(), new DAOVisites(Singleton.getInstance().getConnection()), daouser, connectedUser);
							break;
						case "Service redaction":
							ControleurVoirComptesRendus ctrl2S = new ControleurVoirComptesRendus(f0, new FenetreVoirCR(), new DAOVisites(Singleton.getInstance().getConnection()), connectedUser);
							break;
						case "Service labo-recherche":
							ControleurVoirComptesRendus ctrl2L = new ControleurVoirComptesRendus(f0, new FenetreVoirCR(), new DAOVisites(Singleton.getInstance().getConnection()), connectedUser);
							break;
						case "Administrateur":
							ControleurAdministrateurs ctrl2A = new ControleurAdministrateurs(new FenetreAdministrateur(), daouser, new DAOVisites(Singleton.getInstance().getConnection()), connectedUser, f0);
							break;
					}
				}
				
			}
		});
		
	}
	
}
