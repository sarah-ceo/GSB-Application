
public class Medecin {

	private int idMedecin;
	private String nomMedecin;
	private String prenomMedecin;
	private String adresseCabinet;
	private String email;
	private int idRegion;
	
	public Medecin() {
		
	}
	
	public Medecin(int idMedecin, String nomMedecin, String prenomMedecin, String adresseCabinet, String email, int idRegion) {
		this.idMedecin = idMedecin;
		this.nomMedecin = nomMedecin;
		this.prenomMedecin = prenomMedecin;
		this.adresseCabinet = adresseCabinet;
		this.email = email;
		this.idRegion = idRegion;
	}

	public int getIdMedecin() {
		return idMedecin;
	}

	public void setIdMedecin(int idMedecin) {
		this.idMedecin = idMedecin;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	public String getPrenomMedecin() {
		return prenomMedecin;
	}

	public void setPrenomMedecin(String prenomMedecin) {
		this.prenomMedecin = prenomMedecin;
	}

	public String getAdresseCabinet() {
		return adresseCabinet;
	}

	public void setAdresseCabinet(String adresseCabinet) {
		this.adresseCabinet = adresseCabinet;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

}
