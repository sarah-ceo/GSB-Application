import java.sql.Timestamp;

public class Visite {

	private int idvisite;
	private int idvisiteur;
	private int idmedecin;
	private Timestamp datevisite;
	private String statut;
	private String commentaire;
	
	public Visite() {
		
	}
	
	public Visite(int idvisite, int idvisiteur, int idmedecin, Timestamp datevisite, String statut, String commentaire) {
		this.idvisite = idvisite;
		this.idvisiteur = idvisiteur;
		this.idmedecin = idmedecin;
		this.datevisite = datevisite;
		this.statut = statut;
		this.commentaire = commentaire;
	}

	public int getIdvisiteur() {
		return idvisiteur;
	}

	public void setIdvisite(int idvisite) {
		this.idvisite = idvisite;
	}
	
	public void setIdvisiteur(int idvisiteur) {
		this.idvisiteur = idvisiteur;
	}

	public int getIdmedecin() {
		return idmedecin;
	}

	public void setIdmedecin(int idmedecin) {
		this.idmedecin = idmedecin;
	}

	public Timestamp getDatevisite() {
		return datevisite;
	}

	public void setDatevisite(Timestamp datevisite) {
		this.datevisite = datevisite;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getIdvisite() {
		return idvisite;
	}
	
}
