import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;


public class DAOVisites {
	
	private Connection cnx;
	
	public DAOVisites(Connection connect) {
		this.cnx = connect;
	}
	
	public List<Visite> getVisitesByVisiteur(int visiteurId) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<Visite> allvisites = new ArrayList<>();
		Visite visite=null;
		String SQL="SELECT * FROM Visites WHERE IdVisiteur=? ORDER BY Date_visite DESC";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, visiteurId);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				visite = new Visite();
				visite.setIdvisite(rs.getInt("idVisite"));
				visite.setIdvisiteur(rs.getInt("IdVisiteur"));
				visite.setIdmedecin(rs.getInt("IdMedecin"));
				visite.setDatevisite(rs.getTimestamp("Date_visite"));
				visite.setStatut(rs.getString("statutVisite"));
				visite.setCommentaire(rs.getString("Commentaires"));
				allvisites.add(visite);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allvisites;
	}
	
	public List<Visite> getVisitesPrevuesByVisiteur(int visiteurId) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<Visite> allvisites = new ArrayList<>();
		Visite visite=null;
		String SQL="SELECT * FROM Visites WHERE IdVisiteur=? AND statutVisite='Prevue' ORDER BY Date_visite DESC";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, visiteurId);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				visite = new Visite();
				visite.setIdvisite(rs.getInt("idVisite"));
				visite.setIdvisiteur(rs.getInt("IdVisiteur"));
				visite.setIdmedecin(rs.getInt("IdMedecin"));
				visite.setDatevisite(rs.getTimestamp("Date_visite"));
				visite.setStatut(rs.getString("statutVisite"));
				visite.setCommentaire(rs.getString("Commentaires"));
				allvisites.add(visite);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allvisites;
	}
	
	public void addVisite(Visite visite) {
		PreparedStatement pStatement;
		String SQL="INSERT INTO Visites(IdVisiteur,IdMedecin,Date_visite,statutVisite,Commentaires) VALUES(?,?,?,?,?)";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, visite.getIdvisiteur());
			pStatement.setInt(2, visite.getIdmedecin());
			pStatement.setTimestamp(3, visite.getDatevisite());
			pStatement.setString(4, visite.getStatut());
			pStatement.setString(5, visite.getCommentaire());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifyVisite(Visite visite, String nouveauStatut, String Commentaires) {
		PreparedStatement pStatement;
		String SQL="UPDATE Visites SET statutVisite=?, Commentaires=? WHERE IdVisite=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setString(1, nouveauStatut);
			pStatement.setString(2, Commentaires);
			pStatement.setInt(3, visite.getIdvisite());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Medecin> getMedecins() {
		PreparedStatement pStatement;
		ResultSet rs;
		List<Medecin> allmedecins = new ArrayList<>();
		Medecin medecin=null;
		String SQL="SELECT * FROM Medecins";
		try {
			pStatement = cnx.prepareStatement(SQL);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				medecin = new Medecin();
				medecin.setIdMedecin(rs.getInt("idMedecin"));
				medecin.setNomMedecin(rs.getString("nomMedecin"));
				medecin.setPrenomMedecin(rs.getString("prenomMedecin"));
				medecin.setAdresseCabinet(rs.getString("adresseCabinet"));
				medecin.setEmail(rs.getString("email"));
				medecin.setIdRegion(rs.getInt("idRegion"));
				allmedecins.add(medecin);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allmedecins;
	}
	
	public void addCR(Compte_rendu CR) {
		PreparedStatement pStatement;
		String SQL="INSERT INTO Compte_rendus(idVisite,confianceGSB,commentaireConfiance,noteNotice,commentaireNotice,medicamentsProbleme,autresCommentaires) VALUES(?,?,?,?,?,?,?)";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, CR.getIdVisite());
			pStatement.setString(2, CR.getConfianceGSB());
			pStatement.setString(3, CR.getCommentaireConfiance());
			pStatement.setString(4, CR.getNoteNotice());
			pStatement.setString(5, CR.getCommentaireNotice());
			pStatement.setString(6, CR.getMedicamentsProbleme());
			pStatement.setString(7, CR.getAutresCommentaires());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getMedecinsbyId(int idmedecin) {
		PreparedStatement pStatement;
		ResultSet rs;
		String medecin="";
		String SQL="SELECT * FROM Medecins WHERE idMedecin=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idmedecin);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				medecin = rs.getString("prenomMedecin") + " " + rs.getString("nomMedecin") + " - "+ rs.getString("adresseCabinet");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medecin;
	}
	
	public int getCountTypeVisitesByVisiteur(int idvisiteur, String statutVisite, String datedebut, String datefin) {
		PreparedStatement pStatement;
		ResultSet rs;
		int nbvisites=0;
		String SQL="SELECT COUNT(*) AS nbVisites FROM Visites WHERE idVisiteur=? AND statutVisite=? AND Date_visite >= ? AND Date_visite <= ?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idvisiteur);
			pStatement.setString(2, statutVisite);
			pStatement.setString(3, datedebut);
			pStatement.setString(4, datefin);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				nbvisites = rs.getInt("nbVisites");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nbvisites;
	}
	
	public List<Visite> getVisitesByVisiteurWithDate(int visiteurId, String datedebut, String datefin) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<Visite> allvisites = new ArrayList<>();
		Visite visite=null;
		String SQL="SELECT * FROM Visites WHERE IdVisiteur=? AND Date_visite >= ? AND Date_visite <= ? ORDER BY Date_visite DESC";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, visiteurId);
			pStatement.setString(2, datedebut);
			pStatement.setString(3, datefin);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				visite = new Visite();
				visite.setIdvisite(rs.getInt("idVisite"));
				visite.setIdvisiteur(rs.getInt("IdVisiteur"));
				visite.setIdmedecin(rs.getInt("IdMedecin"));
				visite.setDatevisite(rs.getTimestamp("Date_visite"));
				visite.setStatut(rs.getString("statutVisite"));
				visite.setCommentaire(rs.getString("Commentaires"));
				allvisites.add(visite);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allvisites;
	}
	
	public String getRegionbyId(int idregion) {
		PreparedStatement pStatement;
		ResultSet rs;
		String region="";
		String SQL="SELECT * FROM Regions WHERE idRegion=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idregion);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				region = rs.getString("nomRegion");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return region;
	}
	
	public List<String> getRegionbySecteur(int idsecteur) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<String> regions = new ArrayList<>();
		String region="";
		String SQL="SELECT * FROM Regions WHERE idSecteur=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idsecteur);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				region = rs.getString("nomRegion");
				regions.add(region);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regions;
	}
	
	public int getRegionbyName(String Nomregion) {
		PreparedStatement pStatement;
		ResultSet rs;
		int region=0;
		String SQL="SELECT * FROM Regions WHERE nomRegion=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setString(1, Nomregion);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				region = rs.getInt("idRegion");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return region;
	}
	
	public List<Compte_rendu> getallCR() {
		PreparedStatement pStatement;
		ResultSet rs;
		List<Compte_rendu> allCR = new ArrayList<>();
		Compte_rendu cr=null;
		String SQL="SELECT * FROM Compte_rendus INNER JOIN Visites ON Visites.idVisite=Compte_rendus.idVisite ORDER BY Date_visite DESC";
		try {
			pStatement = cnx.prepareStatement(SQL);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				cr = new Compte_rendu();
				cr.setIdCompte_rendus(rs.getInt("idCompte_rendus"));
				cr.setIdVisite(rs.getInt("idVisite"));
				cr.setConfianceGSB(rs.getString("confianceGSB"));
				cr.setCommentaireConfiance(rs.getString("commentaireConfiance"));
				cr.setNoteNotice(rs.getString("noteNotice"));
				cr.setCommentaireNotice(rs.getString("commentaireNotice"));
				cr.setMedicamentsProbleme(rs.getString("medicamentsProbleme"));
				cr.setAutresCommentaires(rs.getString("autresCommentaires"));
				allCR.add(cr);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allCR;
	}
	
	public Timestamp getDateByCR(int idVisite) {
		PreparedStatement pStatement;
		ResultSet rs;
		Timestamp date=null;
		String SQL="SELECT * FROM Visites WHERE idVisite=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idVisite);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				date = rs.getTimestamp("Date_visite");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
}
