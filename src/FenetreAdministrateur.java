import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;

public class FenetreAdministrateur extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldEmail;
	private JButton btnDeconnexion;
	private JButton btnActualiser;
	private JButton btnAjouterLutilisateur;
	private JButton btnSupprimerLutilisateurChoisi;
	private JComboBox comboBoxUtilisateurs;
	private JComboBox comboBoxRegion;
	private JComboBox comboBoxStatut;
	private JLabel lblSecteurConcerne;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAdministrateur frame = new FenetreAdministrateur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenetreAdministrateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAjouterOuSupprimer = new JLabel("Ajouter ou supprimer un utilisateur");
		lblAjouterOuSupprimer.setBounds(137, 5, 422, 25);
		lblAjouterOuSupprimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterOuSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblAjouterOuSupprimer);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(560, 10, 117, 23);
		contentPane.add(btnDeconnexion);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(27, 86, 57, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom :");
		lblPrnom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrnom.setBounds(27, 123, 68, 14);
		contentPane.add(lblPrnom);
		
		btnActualiser = new JButton("Actualiser");
		btnActualiser.setBounds(10, 10, 117, 23);
		contentPane.add(btnActualiser);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(27, 158, 57, 14);
		contentPane.add(lblEmail);
		
		JLabel lblStatut = new JLabel("Statut :");
		lblStatut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatut.setBounds(27, 196, 68, 14);
		contentPane.add(lblStatut);
		
		JLabel lblSecteur = new JLabel("Secteur :");
		lblSecteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecteur.setBounds(27, 229, 68, 14);
		contentPane.add(lblSecteur);
		
		JLabel lblRgionoptionnel = new JLabel("R\u00E9gion :");
		lblRgionoptionnel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRgionoptionnel.setBounds(27, 254, 68, 25);
		contentPane.add(lblRgionoptionnel);
		
		btnAjouterLutilisateur = new JButton("Ajouter l'utilisateur");
		btnAjouterLutilisateur.setBounds(92, 314, 184, 23);
		contentPane.add(btnAjouterLutilisateur);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(94, 85, 142, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(94, 122, 143, 20);
		contentPane.add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(94, 158, 142, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblswissgalaxycom = new JLabel("@swiss-galaxy.com");
		lblswissgalaxycom.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblswissgalaxycom.setBounds(239, 154, 134, 25);
		contentPane.add(lblswissgalaxycom);
		
		comboBoxStatut = new JComboBox();
		comboBoxStatut.setBounds(94, 193, 182, 20);
		contentPane.add(comboBoxStatut);
		
		comboBoxRegion = new JComboBox();
		comboBoxRegion.setBounds(94, 258, 182, 20);
		contentPane.add(comboBoxRegion);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(384, 67, 5, 270);
		contentPane.add(separator);
		
		JLabel lblUtilisateur = new JLabel("Utilisateurs :");
		lblUtilisateur.setHorizontalAlignment(SwingConstants.CENTER);
		lblUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUtilisateur.setBounds(500, 158, 92, 14);
		contentPane.add(lblUtilisateur);
		
		comboBoxUtilisateurs = new JComboBox();
		comboBoxUtilisateurs.setBounds(401, 195, 276, 20);
		contentPane.add(comboBoxUtilisateurs);
		
		btnSupprimerLutilisateurChoisi = new JButton("Supprimer l'utilisateur choisi");
		btnSupprimerLutilisateurChoisi.setBounds(427, 314, 244, 23);
		contentPane.add(btnSupprimerLutilisateurChoisi);
		
		lblSecteurConcerne = new JLabel("");
		lblSecteurConcerne.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSecteurConcerne.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecteurConcerne.setBounds(92, 223, 144, 24);
		contentPane.add(lblSecteurConcerne);
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
	public JButton getBtnActualiser() {
		return btnActualiser;
	}
	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}
	public JTextField getTextFieldNom() {
		return textFieldNom;
	}
	public JButton getBtnAjouterLutilisateur() {
		return btnAjouterLutilisateur;
	}
	public JTextField getTextFieldPrenom() {
		return textFieldPrenom;
	}
	public JButton getBtnSupprimerLutilisateurChoisi() {
		return btnSupprimerLutilisateurChoisi;
	}
	public JComboBox getComboBoxUtilisateurs() {
		return comboBoxUtilisateurs;
	}
	public JComboBox getComboBoxRegion() {
		return comboBoxRegion;
	}
	public JPanel getContentPane() {
		return contentPane;
	}
	public JComboBox getComboBoxStatut() {
		return comboBoxStatut;
	}
	public JLabel getLblSecteurConcerne() {
		return lblSecteurConcerne;
	}
}
