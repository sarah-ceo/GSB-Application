import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ControleurAdministrateurs {

	private User connectedUser;
	private FenetreAdministrateur fAdmin;
	
	public ControleurAdministrateurs(FenetreAdministrateur fa, DAOUser daouser, DAOVisites daovisites, User theUser, FenetreLogin f0) {
		connectedUser=theUser;
		fAdmin = fa;
		
		List<User> usersObj = daouser.getallUsersFromSecteur(connectedUser.getIdsecteur());
		List<String> users = new ArrayList<>();
		for (User us : usersObj) {
			String user = us.getPrenom()+" "+us.getNom()+" - "+us.getStatut();
			users.add(user);
		}
		fAdmin.getComboBoxUtilisateurs().setModel(new DefaultComboBoxModel<>(users.toArray()));
		
		List<String> regions = daovisites.getRegionbySecteur(connectedUser.getIdsecteur());
		regions.add(0, "Aucune");
		fAdmin.getComboBoxRegion().setModel(new DefaultComboBoxModel<>(regions.toArray()));
		
		List<String> statuts = new ArrayList<>();
		statuts.add("Visiteur");
		statuts.add("Delegue regional");
		statuts.add("Responsable secteur");
		statuts.add("Service redaction");
		statuts.add("Service labo-recherche");
		statuts.add("Administrateur");
		fAdmin.getComboBoxStatut().setModel(new DefaultComboBoxModel<>(statuts.toArray()));
		
		fAdmin.setVisible(true);
		
		fAdmin.getBtnAjouterLutilisateur().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				User newUser = new User();
				
				String nom = fAdmin.getTextFieldNom().getText();
				String prenom = fAdmin.getTextFieldPrenom().getText();
				String email = fAdmin.getTextFieldEmail().getText();
				String statut = fAdmin.getComboBoxStatut().getSelectedItem().toString();
				Integer region;
				switch(fAdmin.getComboBoxRegion().getSelectedItem().toString()) {
				case "Aucune":
					region=null;
					break;
				default:
					region = daovisites.getRegionbyName(fAdmin.getComboBoxRegion().getSelectedItem().toString());
					break;
				}
				
				if(nom.equals("") || prenom.equals("") || email.equals("")){
					JOptionPane.showMessageDialog(fAdmin, "Merci de remplir tous les champs !");
				}else {
					email+="@swiss-galaxy.com";
					
					String motdepasse = "";
					
					switch(statut) {
					case "Visiteur":
						motdepasse="azerty";
						break;
					case "Delegue regional":
						motdepasse="123456";
						break;
					case "Responsable secteur":
						motdepasse="123+aze";
						break;
					case "Service redaction":
						motdepasse="456+rty";
						break;
					case "Service labo-recherche":
						motdepasse="789+uio";
						break;
					case "Administrateur":
						motdepasse="qsdfgh";
						break;
					}
				
					newUser.setNom(nom);
					newUser.setPrenom(prenom);
					newUser.setStatut(statut);
					newUser.setEmail(email);
					newUser.setMotdepasse(motdepasse);
					newUser.setIdsecteur(connectedUser.getIdsecteur());
					newUser.setIdregion(region);
					
					daouser.addUser(newUser);
					fAdmin.setVisible(false);
					new ControleurAdministrateurs(new FenetreAdministrateur(), daouser, daovisites, connectedUser, f0);
				}
			}
		});
		
		fAdmin.getBtnSupprimerLutilisateurChoisi().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				User selectedUser = usersObj.get(fAdmin.getComboBoxUtilisateurs().getSelectedIndex());
				int confirmation = confirmationSuppression();
				if(confirmation !=1) {
					daouser.deleteUser(selectedUser);
					fAdmin.setVisible(false);
					new ControleurAdministrateurs(new FenetreAdministrateur(), daouser, daovisites, connectedUser, f0);
				}
			}
		});
		
		fAdmin.getBtnDeconnexion().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fAdmin.setVisible(false);
				connectedUser=null;
				f0.getTxtLogin().setText("");
				f0.getPasswordField().setText("");
				f0.setVisible(true);
			}
		});
		
		fAdmin.getBtnActualiser().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fAdmin.setVisible(false);
				new ControleurAdministrateurs(new FenetreAdministrateur(), daouser, daovisites, connectedUser, f0);
			}
		});
	}
	
	private int confirmationSuppression() {
		int choix = 1;
		Object[] options = {"Confirmer","Annuler"};
		choix = JOptionPane.showOptionDialog(fAdmin,
			"Souhaitez-vous vraiment supprimer cet utilisateur?",
			"Confirmer la suppression",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.WARNING_MESSAGE,
			null,
			options,
			options[1]);
		return choix;
	}
}
