import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ComptesRendusJTableModel extends DefaultTableModel{

	List<Compte_rendu> data;
	DAOVisites daovisites;
	String[] nomColonnes = {"Date du compte-rendu", "Note de confiance en GSB", "Commentaires", "Note sur les notices", "Commentaires", "Problèmes médicaments", "Autres commentaires"};
	int taille=0;
	
	public ComptesRendusJTableModel(List<Compte_rendu> l, DAOVisites daov) {
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
		Compte_rendu compteRendu = data.get(row);
		Object val=null;
		switch(column) {
		case 0:
			val=new SimpleDateFormat("dd/MM/yyyy").format(daovisites.getDateByCR(compteRendu.getIdVisite()));
			break;
		case 1:
			val=compteRendu.getConfianceGSB();
			break;
		case 2:
			val = compteRendu.getCommentaireConfiance();
			break;
		case 3:
			val = compteRendu.getNoteNotice();
			break;
		case 4:
			val = compteRendu.getCommentaireNotice();
			break;
		case 5:
			val = compteRendu.getMedicamentsProbleme();
			break;
		case 6:
			val = compteRendu.getAutresCommentaires();
			break;
		}
		return val;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
			return false;
	}

}
