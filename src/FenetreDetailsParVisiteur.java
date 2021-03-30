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
import javax.swing.JComboBox;

public class FenetreDetailsParVisiteur extends JFrame {

	private JTable table;
	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnOk;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreDetailsParVisiteur frame = new FenetreDetailsParVisiteur();
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
	public FenetreDetailsParVisiteur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblDtailParVisiteur = new JLabel("D\u00E9tail par visiteur");
		lblDtailParVisiteur.setHorizontalAlignment(SwingConstants.CENTER);
		lblDtailParVisiteur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblDtailParVisiteur, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 664, 254);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(291, 303, 110, 23);
		panel.add(btnOk);
		
		comboBox = new JComboBox();
		comboBox.setBounds(249, 11, 188, 20);
		panel.add(comboBox);
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public JButton getBtnOk() {
		return btnOk;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JTable getTable() {
		return table;
	}
}
