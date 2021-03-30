
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ControleurDetailsParVisiteurs {

	public ControleurDetailsParVisiteurs(FenetreResponsable f1, FenetreDetailsParVisiteur f2, List<User> visiteursObj, DAOVisites daovisites, String datedebut, String datefin) {

		List<String> visiteurs = new ArrayList<>();
		
		for (User vis : visiteursObj) {
			String visiteur = vis.getPrenom()+" "+vis.getNom();
			visiteurs.add(visiteur);
		}
		f2.getComboBox().setModel(new DefaultComboBoxModel<>(visiteurs.toArray()));
		
		f2.getComboBox().setSelectedIndex(0);
		
		int visiteurid = f2.getComboBox().getSelectedIndex();
		User visiteurChoisi = visiteursObj.get(visiteurid);
		
		List<Visite> data = null;
		data = daovisites.getVisitesByVisiteurWithDate(visiteurChoisi.getIduser(), datedebut, datefin);
		VisiteursJTableModel modele = new VisiteursJTableModel(data, daovisites);
		f2.getTable().setModel(modele);
		
		f2.setVisible(true);
		
		f2.getComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int visiteurid = f2.getComboBox().getSelectedIndex();
				User visiteurChoisi = visiteursObj.get(visiteurid);
				
				List<Visite> data = null;
				data = daovisites.getVisitesByVisiteur(visiteurChoisi.getIduser());
				VisiteursJTableModel modele = new VisiteursJTableModel(data, daovisites);
				f2.getTable().setModel(modele);
			}
		});
		
		f2.getBtnOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(false);
				f1.setVisible(true);
			}
		});
	}
	public ControleurDetailsParVisiteurs(FenetreDelegue f1, FenetreDetailsParVisiteur f2, List<User> visiteursObj, DAOVisites daovisites, String datedebut, String datefin) {
		
		List<String> visiteurs = new ArrayList<>();
		
		for (User vis : visiteursObj) {
			String visiteur = vis.getPrenom()+" "+vis.getNom();;
			visiteurs.add(visiteur);
		}
		f2.getComboBox().setModel(new DefaultComboBoxModel<>(visiteurs.toArray()));
		
		f2.getComboBox().setSelectedIndex(0);
		
		int visiteurid = f2.getComboBox().getSelectedIndex();
		User visiteurChoisi = visiteursObj.get(visiteurid);
		
		List<Visite> data = null;
		data = daovisites.getVisitesByVisiteurWithDate(visiteurChoisi.getIduser(), datedebut, datefin);
		VisiteursJTableModel modele = new VisiteursJTableModel(data, daovisites);
		f2.getTable().setModel(modele);
		
		f2.setVisible(true);
		
		f2.getComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int visiteurid = f2.getComboBox().getSelectedIndex();
				User visiteurChoisi = visiteursObj.get(visiteurid);
				
				List<Visite> data = null;
				data = daovisites.getVisitesByVisiteur(visiteurChoisi.getIduser());
				VisiteursJTableModel modele = new VisiteursJTableModel(data, daovisites);
				f2.getTable().setModel(modele);
			}
		});
		
		f2.getBtnOk().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f2.setVisible(false);
				f1.setVisible(true);
			}
		});
	}
	
}

