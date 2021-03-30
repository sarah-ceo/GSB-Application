
public class App {

	public static void main(String[] args) {
		ControleurLogin ctrl1 = new ControleurLogin(new FenetreLogin(), new DAOUser(Singleton.getInstance().getConnection())); 
	}
}
