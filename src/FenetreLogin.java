import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FenetreLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JButton btnConnexion;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreLogin frame = new FenetreLogin();
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
	public FenetreLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblAuthentification = new JLabel("Authentification");
		lblAuthentification.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthentification.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblAuthentification, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Email :");
		lblLogin.setBounds(38, 45, 67, 33);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblLogin);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMotDePasse.setHorizontalAlignment(SwingConstants.CENTER);
		lblMotDePasse.setBounds(10, 100, 120, 40);
		panel.add(lblMotDePasse);
		
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setBounds(151, 51, 245, 25);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setActionCommand("Connexion");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConnexion.setBounds(151, 170, 120, 33);
		panel.add(btnConnexion);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(151, 110, 245, 25);
		panel.add(passwordField);
	}
	public JTextField getTxtLogin() {
		return txtLogin;
	}
	public JButton getBtnConnexion() {
		return btnConnexion;
	}
	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
