import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;

public class FenetreDelegue extends JFrame {

	private JTable table;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnDtailsParVisiteur;
	private JSpinner spinnerFin;
	private JSpinner spinnerDebut;
	private JButton btnActualiser;
	private JLabel label;
	private JButton btnDeconnexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreDelegue frame = new FenetreDelegue();
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
	public FenetreDelegue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccueil = new JLabel("Visites par r\u00E9gion");
		lblAccueil.setBounds(203, 5, 319, 25);
		lblAccueil.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccueil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblAccueil);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 39, 679, 322);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 659, 224);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		
		btnDtailsParVisiteur = new JButton("D\u00E9tails par visiteur");
		btnDtailsParVisiteur.setBounds(223, 288, 235, 23);
		panel.add(btnDtailsParVisiteur);
		
		JLabel lblRgion = new JLabel("R\u00E9gion :");
		lblRgion.setHorizontalAlignment(SwingConstants.CENTER);
		lblRgion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRgion.setBounds(10, 19, 63, 23);
		panel.add(lblRgion);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(72, 19, 138, 23);
		panel.add(label);
		
		JLabel lblEntreLe = new JLabel("Entre le :");
		lblEntreLe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntreLe.setBounds(220, 25, 56, 14);
		panel.add(lblEntreLe);
		
		JLabel lblEtLe = new JLabel("Et le :");
		lblEtLe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtLe.setBounds(380, 25, 46, 14);
		panel.add(lblEtLe);
		
		spinnerDebut = new JSpinner(new SpinnerDateModel());
		spinnerDebut.setBounds(286, 22, 84, 23);
		JSpinner.DateEditor de_spinnerDebut = new JSpinner.DateEditor(spinnerDebut, "dd/MM/yyyy");
		spinnerDebut.setEditor(de_spinnerDebut);
		spinnerDebut.setValue(new Date());
		panel.add(spinnerDebut);
		
		spinnerFin = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor de_spinnerFin = new JSpinner.DateEditor(spinnerFin, "dd/MM/yyyy");
		spinnerFin.setEditor(de_spinnerFin);
		spinnerFin.setValue(new Date());
		spinnerFin.setBounds(425, 22, 84, 23);
		panel.add(spinnerFin);
		
		btnActualiser = new JButton("Actualiser");
		btnActualiser.setBounds(519, 19, 150, 23);
		panel.add(btnActualiser);
		
		btnDeconnexion = new JButton("Deconnexion");
		btnDeconnexion.setBounds(532, 5, 152, 23);
		contentPane.add(btnDeconnexion);
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JButton getBtnDtailsParVisiteur() {
		return btnDtailsParVisiteur;
	}
	public JSpinner getSpinnerFin() {
		return spinnerFin;
	}
	public JSpinner getSpinnerDebut() {
		return spinnerDebut;
	}
	public JTable getTable() {
		return table;
	}
	public JButton getBtnActualiser() {
		return btnActualiser;
	}
	public JLabel getLabelRegion() {
		return label;
	}
	public JButton getBtnDeconnexion() {
		return btnDeconnexion;
	}
}
