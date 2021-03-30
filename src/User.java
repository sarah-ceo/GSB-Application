
public class User {

	private int iduser;
	private String nom;
	private String prenom;
	private String motdepasse;
	private String email;
	private String statut;
	private int idsecteur;
	private Integer idregion;
	
	public User() {
		
	}
	public User(int iduser, String nom, String prenom, String email, String motdepasse, String statut, int idsecteur, int idregion) {
		this.iduser = iduser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motdepasse = motdepasse;
		this.statut = statut;
		this.idsecteur = idsecteur;
		this.idregion = idregion;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getIdsecteur() {
		return idsecteur;
	}

	public void setIdsecteur(int idsecteur) {
		this.idsecteur = idsecteur;
	}
	
	public Integer getIdregion() {
		return idregion;
	}

	public void setIdregion(Integer idregion) {
		this.idregion = idregion;
	}
	
	
}
