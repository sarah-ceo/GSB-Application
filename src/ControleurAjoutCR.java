import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

public class ControleurAjoutCR {
	
	public ControleurAjoutCR(FenetreNouveauCR fNewCR, Visite visiteConcernee, DAOVisites daovisites, User user, FenetreAccueil f1, FenetreStatutVisite fModif, String nouveauStatut, String Commentaires) {
		super();
	
		List<String> notes = new ArrayList<>();
		notes.add("1");
		notes.add("2");
		notes.add("3");
		notes.add("4");
		notes.add("5");
		
		fNewCR.getCbConfianceGSB().setModel(new DefaultComboBoxModel<>(notes.toArray()));
		fNewCR.getCbNotices().setModel(new DefaultComboBoxModel<>(notes.toArray()));
		
		fNewCR.setVisible(true);
		
		fNewCR.getBtnConfirmer().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Compte_rendu newCR = new Compte_rendu();
				
				newCR.setIdVisite(visiteConcernee.getIdvisite());
				newCR.setConfianceGSB(fNewCR.getCbConfianceGSB().getSelectedItem().toString());
				newCR.setCommentaireConfiance(fNewCR.getTextAreaPourquoiConfiance().getText());
				newCR.setNoteNotice(fNewCR.getCbNotices().getSelectedItem().toString());
				newCR.setCommentaireNotice(fNewCR.getTextAreaCommentaireNotices().getText());
				newCR.setMedicamentsProbleme(fNewCR.getTextAreaCommentairePBMedicaments().getText());
				newCR.setAutresCommentaires(fNewCR.getTextAreaAutresCommentaires().getText());
				
				daovisites.modifyVisite(visiteConcernee, nouveauStatut , Commentaires);
				daovisites.addCR(newCR);
				fNewCR.setVisible(false);
				f1.setVisible(true);
			}
		});
		
		fNewCR.getBtnAnnuler().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fNewCR.setVisible(false);
				fModif.setVisible(true);
			}
		});
	}
}
