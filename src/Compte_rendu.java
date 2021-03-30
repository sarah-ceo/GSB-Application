import java.sql.Timestamp;

public class Compte_rendu {
	private int idCompte_rendus;
	private int idVisite;
	private String confianceGSB;
	private String commentaireConfiance;
	private String noteNotice;
	private String commentaireNotice;
	private String medicamentsProbleme;
	private String autresCommentaires;
	
	public Compte_rendu() {
		
	}
	
	public Compte_rendu(int idCompte_rendus, int idVisite, String confianceGSB, String commentaireConfiance, String noteNotice, String commentaireNotice, String medicamentsProbleme, String autresCommentaires) {
		this.idCompte_rendus = idCompte_rendus;
		this.idVisite = idVisite;
		this.confianceGSB = confianceGSB;
		this.commentaireConfiance = commentaireConfiance;
		this.noteNotice = noteNotice;
		this.commentaireNotice = commentaireNotice;
		this.medicamentsProbleme = medicamentsProbleme;
		this.autresCommentaires = autresCommentaires;
	}

	public int getIdCompte_rendus() {
		return idCompte_rendus;
	}

	public void setIdCompte_rendus(int idCompte_rendus) {
		this.idCompte_rendus = idCompte_rendus;
	}

	public int getIdVisite() {
		return idVisite;
	}

	public void setIdVisite(int idVisite) {
		this.idVisite = idVisite;
	}

	public String getConfianceGSB() {
		return confianceGSB;
	}

	public void setConfianceGSB(String confianceGSB) {
		this.confianceGSB = confianceGSB;
	}

	public String getCommentaireConfiance() {
		return commentaireConfiance;
	}

	public void setCommentaireConfiance(String commentaireConfiance) {
		this.commentaireConfiance = commentaireConfiance;
	}

	public String getNoteNotice() {
		return noteNotice;
	}

	public void setNoteNotice(String noteNotice) {
		this.noteNotice = noteNotice;
	}

	public String getCommentaireNotice() {
		return commentaireNotice;
	}

	public void setCommentaireNotice(String commentaireNotice) {
		this.commentaireNotice = commentaireNotice;
	}

	public String getMedicamentsProbleme() {
		return medicamentsProbleme;
	}

	public void setMedicamentsProbleme(String medicamentsProbleme) {
		this.medicamentsProbleme = medicamentsProbleme;
	}

	public String getAutresCommentaires() {
		return autresCommentaires;
	}

	public void setAutresCommentaires(String autresCommentaires) {
		this.autresCommentaires = autresCommentaires;
	}
}
