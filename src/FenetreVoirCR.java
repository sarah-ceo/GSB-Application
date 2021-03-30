import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class FenetreVoirCR extends JFrame {
	
	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnDeconnexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreVoirCR frame = new FenetreVoirCR();
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
	public FenetreVoirCR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1200, 550);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblComptesrendusDeVisites = new JLabel("Comptes-rendus de visites");
		lblComptesrendusDeVisites.setBounds(431, 9, 316, 25);
		lblComptesrendusDeVisites.setHorizontalAlignment(SwingConstants.CENTER);
		lblComptesrendusDeVisites.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblComptesrendusDeVisites);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 45, 1179, 466);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1159, 444);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(1067, 14, 117, 23);
		contentPane.add(btnDeconnexion);
		
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JTable getTable() {
		return table;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
}
