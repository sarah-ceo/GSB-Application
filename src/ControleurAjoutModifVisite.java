import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ControleurAjoutModifVisite {
	FenetreAjout fAjout;
	FenetreStatutVisite fModif;
	DAOVisites daovisites;
	User user;
	FenetreAccueil f1;
	
	public ControleurAjoutModifVisite(DAOVisites daovisites, User user, FenetreAccueil f1) {
		super();
		this.daovisites = daovisites;
		this.user=user;
		this.f1 = f1;
	}
	
	public void addVisite(FenetreAjout fa) {
		this.fAjout=fa;
		List<Medecin> medecinsObj = daovisites.getMedecins();
		List<String> medecins = new ArrayList<>();
		
		for (Medecin med : medecinsObj) {
			String medecin = med.getPrenomMedecin()+" "+med.getNomMedecin()+" - "+med.getAdresseCabinet();
			medecins.add(medecin);
		}
		
		fAjout.getComboBox().setModel(new DefaultComboBoxModel<>(medecins.toArray()));
		
		fAjout.setVisible(true);
		fAjout.getBtnAjouter().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {  
				
				Visite visite = new Visite();
				
			    java.util.Date date = new java.util.Date();
			    java.util.Date time = (java.util.Date)fAjout.getSpinner().getValue();
			    date.setTime(time.getTime());
			    	
			    date.setDate(fAjout.getCalendar().getDayChooser().getDay());
			    date.setMonth(fAjout.getCalendar().getMonthChooser().getMonth());
			    date.setYear(fAjout.getCalendar().getYearChooser().getYear()-1900);
			    
			    java.sql.Timestamp dateVisite = new java.sql.Timestamp(date.getTime());
				visite.setDatevisite(dateVisite);
				
				int indexMedecin = fAjout.getComboBox().getSelectedIndex();
				Medecin medecinchoisi = medecinsObj.get(indexMedecin);
				visite.setIdmedecin(medecinchoisi.getIdMedecin());
			    
			    visite.setIdvisiteur(user.getIduser());
				visite.setStatut("Prévue");
			    
			    daovisites.addVisite(visite);
			    fAjout.setVisible(false);
			    f1.setVisible(true);
			}
		});
		fAjout.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fAjout.setVisible(false);
				f1.setVisible(true);
			}
		});
	}
	
	public void modifyVisite(FenetreStatutVisite fsv) {
		this.fModif=fsv;
		List<Visite> visitesObj = daovisites.getVisitesPrevuesByVisiteur(user.getIduser());
		List<String> visites = new ArrayList<>();
		
		for (Visite vis : visitesObj) {
			String dateVisite = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(vis.getDatevisite());
			String visite = dateVisite+" avec Dr. "+daovisites.getMedecinsbyId(vis.getIdmedecin());
			visites.add(visite);
		}
		
		fModif.getCbVisite().setModel(new DefaultComboBoxModel<>(visites.toArray()));
		
		List<String> statuts = new ArrayList<>();
		statuts.add("Realisee");
		statuts.add("Annulee");
		fModif.getCbStatut().setModel(new DefaultComboBoxModel<>(statuts.toArray()));
		
		this.fModif.setVisible(true);
		
		fModif.getBtnConfirmerEtRemplir().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int visiteIndex = fModif.getCbVisite().getSelectedIndex();
				Visite visiteToModif = visitesObj.get(visiteIndex);
				
				String statut = fModif.getCbStatut().getSelectedItem().toString();
				
				if(statut == "Realisee") {
					fModif.setVisible(false);
					ControleurAjoutCR ctrl4 = new ControleurAjoutCR(new FenetreNouveauCR(), visiteToModif, daovisites, user, f1, fModif, statut , fModif.getTextArea().getText());
				} else {
					daovisites.modifyVisite(visiteToModif, statut , fModif.getTextArea().getText());
					fModif.setVisible(false);
					f1.setVisible(true);
				}
			}
		});
		
		fModif.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fModif.setVisible(false);
				f1.setVisible(true);
			}
		});
		
	}
}
