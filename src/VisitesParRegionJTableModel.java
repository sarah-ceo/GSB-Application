import java.util.List;
import javax.swing.table.DefaultTableModel;


public class VisitesParRegionJTableModel extends DefaultTableModel{

	List<User> data;
	DAOVisites daovisites;
	String dateDebut;
	String dateFin;
	String[] nomColonnes = {"Visiteur", "Visites prévues", "Visites réalisées", "Visites annulées"};
	int taille=0;
	
	public VisitesParRegionJTableModel(List<User> l,  DAOVisites daov, String datedebut, String datefin) {
		data = l;
		taille = data.size();
		daovisites = daov;
		dateDebut=datedebut;
		dateFin=datefin;
	}
	
	@Override
	public int getColumnCount() {
		return nomColonnes.length;
	}

	@Override
	public String getColumnName(int column) {
		return nomColonnes[column];
	}

	@Override
	public int getRowCount() {
		return taille;
	}

	@Override
	public Object getValueAt(int row, int column) {
		User visiteur = data.get(row);
		Object val=null;
		switch(column) {
		case 0:
			val=visiteur.getPrenom() + " "+ visiteur.getNom();
			break;
		case 1:
			val = daovisites.getCountTypeVisitesByVisiteur(visiteur.getIduser(), "Prevue", dateDebut, dateFin);
			break;
		case 2:
			val = daovisites.getCountTypeVisitesByVisiteur(visiteur.getIduser(), "Realisee", dateDebut, dateFin);
			break;
		case 3:
			val = daovisites.getCountTypeVisitesByVisiteur(visiteur.getIduser(), "Annulee", dateDebut, dateFin);
			break;
		}
		return val;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
			return false;
	}

}
