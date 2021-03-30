import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;

public class ControleurAccueilDelegue {
	
	private User connectedUser;
	private String dateDebut;
	private String dateFin;
	List<User> data = null;
	
	public ControleurAccueilDelegue(FenetreLogin f0, FenetreDelegue f1, DAOVisites daovisites, DAOUser daouser, User user) {
		this.connectedUser = user;
		
		data = daouser.getVisiteursByRegion(user.getIdregion());
		
		f1.getLabelRegion().setText(daovisites.getRegionbyId(user.getIdregion()));
		
		dateDebut = "2018-01-01";
		dateFin = "2018-12-31";
		
		try {
		f1.getSpinnerDebut().setValue(new SimpleDateFormat("yyyy-MM-dd").parse(dateDebut));
		f1.getSpinnerFin().setValue(new SimpleDateFormat("yyyy-MM-dd").parse(dateFin));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		VisitesParRegionJTableModel modele = new VisitesParRegionJTableModel(data, daovisites, dateDebut, dateFin);
		f1.getTable().setModel(modele);
		
		f1.setVisible(true);
		
		f1.getBtnActualiser().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dateDebut = new SimpleDateFormat("yyyy-MM-dd").format(f1.getSpinnerDebut().getValue());
				dateFin = new SimpleDateFormat("yyyy-MM-dd").format(f1.getSpinnerFin().getValue());
				
				VisitesParRegionJTableModel modele = new VisitesParRegionJTableModel(data, daovisites, dateDebut, dateFin);
				f1.getTable().setModel(modele);
			}
		});
		
		f1.getBtnDtailsParVisiteur().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControleurDetailsParVisiteurs ctrl2 = new ControleurDetailsParVisiteurs(f1, new FenetreDetailsParVisiteur(), data, daovisites, dateDebut, dateFin);
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
		
	}
	
}
