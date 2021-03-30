import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUser {

	private Connection cnx;
	private String salt = "afip123";
	
	public DAOUser(Connection connect) {
		this.cnx = connect;
	}
	
	public User checkAuth(String email, String motdepasse) {
		PreparedStatement pstatement;
		ResultSet rs;
		User user=null;
		
		motdepasse += salt;
		
		String SQL = "SELECT * FROM Users WHERE email=? AND motdepasse=SHA2(?,512)";
		try {
			pstatement = cnx.prepareStatement(SQL);
			pstatement.setString(1, email);
			pstatement.setString(2, motdepasse);
			
			rs = pstatement.executeQuery();
			
			user = new User();
			if(rs.next()==true) {
				user.setIduser(rs.getInt("idUser"));
				user.setNom(rs.getString("nomUser"));
				user.setPrenom(rs.getString("prenomUser"));
				user.setEmail(rs.getString("email"));
				user.setMotdepasse(rs.getString("motdepasse"));
				user.setStatut(rs.getString("statut"));
				user.setIdsecteur(rs.getInt("idSecteur"));
				user.setIdregion(rs.getInt("idRegion"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
	
	public List<User> getVisiteursByRegion(int region) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<User> allvisiteurs = new ArrayList<>();
		User user=null;
		String SQL="SELECT * FROM Users WHERE statut='Visiteur' AND idRegion=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, region);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setIduser(rs.getInt("idUser"));
				user.setNom(rs.getString("nomUser"));
				user.setPrenom(rs.getString("prenomUser"));
				user.setIdsecteur(rs.getInt("idSecteur"));
				user.setIdregion(region);
				user.setStatut("Visiteur");
				allvisiteurs.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allvisiteurs;
	}
	
	public List<User> getallUsersFromSecteur(int idsecteur) {
		PreparedStatement pStatement;
		ResultSet rs;
		List<User> allusers = new ArrayList<>();
		User user=null;
		String SQL="SELECT * FROM Users WHERE idSecteur=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, idsecteur);
			rs = pStatement.executeQuery();
			
			while(rs.next()) {
				user = new User();
				user.setIduser(rs.getInt("idUser"));
				user.setNom(rs.getString("nomUser"));
				user.setPrenom(rs.getString("prenomUser"));
				user.setEmail(rs.getString("email"));
				user.setIdsecteur(idsecteur);
				user.setIdregion(rs.getInt("idRegion"));
				user.setStatut(rs.getString("statut"));
				allusers.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allusers;
	}
	
	public void addUser(User user) {
		PreparedStatement pStatement;
		String SQL="INSERT INTO Users(nomUser,prenomUser,motdepasse,email,statut,idSecteur,idRegion) VALUES(?,?,SHA2(?,512),?,?,?,?)";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setString(1, user.getNom());
			pStatement.setString(2, user.getPrenom());
			pStatement.setString(3, user.getMotdepasse()+"afip123");
			pStatement.setString(4, user.getEmail());
			pStatement.setString(5, user.getStatut());
			pStatement.setInt(6, user.getIdsecteur());
			pStatement.setObject(7, user.getIdregion());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(User user) {
		PreparedStatement pStatement;
		String SQL="DELETE FROM Users WHERE idUser=?";
		try {
			pStatement = cnx.prepareStatement(SQL);
			pStatement.setInt(1, user.getIduser());
			pStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
