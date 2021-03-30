import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class FenetreNouveauCR extends JFrame {

	private JPanel contentPane;
	private JComboBox cbConfianceGSB;
	private JTextArea textAreaPourquoiConfiance;
	private JComboBox cbNotices;
	private JTextArea textAreaCommentaireNotices;
	private JTextArea textAreaCommentairePBMedicaments;
	private JTextArea textAreaAutresCommentaires;
	private JButton btnConfirmer;
	private JButton btnAnnuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreNouveauCR frame = new FenetreNouveauCR();
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
	public FenetreNouveauCR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblSaisirUnCompterendu = new JLabel("Saisir un compte-rendu");
		lblSaisirUnCompterendu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaisirUnCompterendu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblSaisirUnCompterendu, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		cbNotices = new JComboBox();
		cbNotices.setBounds(331, 115, 50, 20);
		panel.add(cbNotices);
		
		textAreaPourquoiConfiance = new JTextArea();
		textAreaPourquoiConfiance.setBounds(402, 21, 272, 68);
		panel.add(textAreaPourquoiConfiance);
		
		cbConfianceGSB = new JComboBox();
		cbConfianceGSB.setBounds(331, 33, 50, 20);
		panel.add(cbConfianceGSB);
		
		textAreaCommentaireNotices = new JTextArea();
		textAreaCommentaireNotices.setBounds(402, 100, 272, 66);
		panel.add(textAreaCommentaireNotices);
		
		textAreaCommentairePBMedicaments = new JTextArea();
		textAreaCommentairePBMedicaments.setBounds(294, 177, 380, 47);
		panel.add(textAreaCommentairePBMedicaments);
		
		textAreaAutresCommentaires = new JTextArea();
		textAreaAutresCommentaires.setBounds(294, 235, 380, 47);
		panel.add(textAreaAutresCommentaires);
		
		JLabel lblNotices = new JLabel("Notices (Note et commentaires) :");
		lblNotices.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotices.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNotices.setBounds(45, 113, 254, 20);
		panel.add(lblNotices);
		
		JLabel lblConfianceGSB = new JLabel("Confiance en GSB (Niveau et commentaires) :");
		lblConfianceGSB.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfianceGSB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfianceGSB.setBounds(0, 31, 334, 20);
		panel.add(lblConfianceGSB);
		
		JLabel lblCommentairesmdicaments = new JLabel("Commentaires \r\n(M\u00E9dicaments) :");
		lblCommentairesmdicaments.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommentairesmdicaments.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCommentairesmdicaments.setBounds(64, 187, 207, 27);
		panel.add(lblCommentairesmdicaments);
		
		JLabel lblAutresCommentaires = new JLabel("Autres commentaires :");
		lblAutresCommentaires.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutresCommentaires.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAutresCommentaires.setBounds(82, 243, 164, 27);
		panel.add(lblAutresCommentaires);
		
		btnConfirmer = new JButton("Confirmer");
		btnConfirmer.setBounds(151, 303, 138, 23);
		panel.add(btnConfirmer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(351, 303, 150, 23);
		panel.add(btnAnnuler);
	}
	public JComboBox getCbConfianceGSB() {
		return cbConfianceGSB;
	}
	public JTextArea getTextAreaPourquoiConfiance() {
		return textAreaPourquoiConfiance;
	}
	public JComboBox getCbNotices() {
		return cbNotices;
	}
	public JTextArea getTextAreaCommentaireNotices() {
		return textAreaCommentaireNotices;
	}
	public JTextArea getTextAreaCommentairePBMedicaments() {
		return textAreaCommentairePBMedicaments;
	}
	public JTextArea getTextAreaAutresCommentaires() {
		return textAreaAutresCommentaires;
	}
	public JButton getBtnConfirmer() {
		return btnConfirmer;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
}
