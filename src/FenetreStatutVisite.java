import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class FenetreStatutVisite extends JFrame {

	private JPanel contentPane;
	private JComboBox cbVisite;
	private JComboBox cbStatut;
	private JTextArea textArea;
	private JButton btnConfirmerEtRemplir;
	private JButton btnAnnuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreStatutVisite frame = new FenetreStatutVisite();
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
	public FenetreStatutVisite() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblChangementDeStatut = new JLabel("Changement de statut d'une visite");
		lblChangementDeStatut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChangementDeStatut.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblChangementDeStatut, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		cbVisite = new JComboBox();
		cbVisite.setBounds(187, 39, 453, 20);
		panel.add(cbVisite);
		
		cbStatut = new JComboBox();
		cbStatut.setBounds(214, 123, 115, 20);
		panel.add(cbStatut);
		
		btnConfirmerEtRemplir = new JButton("Confirmer");
		btnConfirmerEtRemplir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConfirmerEtRemplir.setBounds(133, 303, 154, 23);
		panel.add(btnConfirmerEtRemplir);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(377, 303, 142, 23);
		panel.add(btnAnnuler);
		
		JLabel lblVisite = new JLabel("Visite :");
		lblVisite.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblVisite.setBounds(119, 38, 58, 19);
		panel.add(lblVisite);
		
		JLabel lblStatut = new JLabel("Nouveau statut :");
		lblStatut.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatut.setBounds(83, 123, 121, 17);
		panel.add(lblStatut);
		
		JLabel lblCommentaires = new JLabel("Commentaires :");
		lblCommentaires.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCommentaires.setBounds(83, 224, 110, 20);
		panel.add(lblCommentaires);
		
		textArea = new JTextArea();
		textArea.setBounds(210, 198, 407, 66);
		panel.add(textArea);
	}
	public JComboBox getCbVisite() {
		return cbVisite;
	}
	public JComboBox getCbStatut() {
		return cbStatut;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public JButton getBtnConfirmerEtRemplir() {
		return btnConfirmerEtRemplir;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
}
