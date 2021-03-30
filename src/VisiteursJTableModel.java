import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VisiteursJTableModel extends DefaultTableModel{

	List<Visite> data;
	DAOVisites daovisites;
	String[] nomColonnes = {"Date et heure", "Médecin", "Statut", "Commentaire"};
	int taille=0;
	
	public VisiteursJTableModel(List<Visite> l,  DAOVisites daov) {
		data = l;
		taille = data.size();
		daovisites = daov;
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
		Visite visite = data.get(row);
		Object val=null;
		switch(column) {
		case 0:
			val=new SimpleDateFormat("dd/MM/yyyy HH:mm").format(visite.getDatevisite());
			break;
		case 1:
			val = daovisites.getMedecinsbyId(visite.getIdmedecin());
			break;
		case 2:
			val = visite.getStatut();
			break;
		case 3:
			val = visite.getCommentaire();
			break;
		}
		return val;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}


}
