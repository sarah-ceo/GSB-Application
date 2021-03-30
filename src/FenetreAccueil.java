import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FenetreAccueil extends JFrame {
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnAjouterUneVisite;
	private JButton btnModifierLeStatut;
	private JButton btnDeconnexion;
	private JButton btnActualiser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAccueil frame = new FenetreAccueil();
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
	public FenetreAccueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnActualiser = new JButton("Actualiser");
		btnActualiser.setBounds(10, 10, 117, 23);
		contentPane.add(btnActualiser);
		
		JLabel lblVisites = new JLabel("Visites");
		lblVisites.setBounds(165, 5, 353, 25);
		lblVisites.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVisites.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblVisites);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(560, 10, 117, 23);
		contentPane.add(btnDeconnexion);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 48, 641, 282);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 621, 260);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		btnAjouterUneVisite = new JButton("Ajouter une visite");
		btnAjouterUneVisite.setBounds(119, 335, 183, 23);
		contentPane.add(btnAjouterUneVisite);
		
		btnModifierLeStatut = new JButton("Modifier le statut d'une visite");
		btnModifierLeStatut.setBounds(377, 335, 209, 23);
		contentPane.add(btnModifierLeStatut);
	}
	
	public JTable getTable() {
		return table;
	}
	public JButton getBtnAjouterUneVisite() {
		return btnAjouterUneVisite;
	}
	public JButton getBtnModifierLeStatut() {
		return btnModifierLeStatut;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
	public JButton getBtnActualiser() {
		return btnActualiser;
	}
}
