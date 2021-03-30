import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Date;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JLocaleChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FenetreAjout extends JFrame {

	private JPanel contentPane;
	private JButton btnAjouter;
	private JButton btnAnnuler;
	private JSpinner spinner;
	private JComboBox comboBox;
	private JCalendar calendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAjout frame = new FenetreAjout();
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
	public FenetreAjout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 400);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNouvelleVisite = new JLabel("Nouvelle visite");
		lblNouvelleVisite.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNouvelleVisite.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNouvelleVisite, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		spinner = new JSpinner( new SpinnerDateModel() );
		spinner.setBounds(327, 193, 57, 20);
		JSpinner.DateEditor de_spinner = new JSpinner.DateEditor(spinner, "HH:mm");
		spinner.setEditor(de_spinner);
		spinner.setValue(new Date());
		panel.add(spinner);
		
		comboBox = new JComboBox();
		comboBox.setBounds(184, 245, 380, 20);
		panel.add(comboBox);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(117, 108, 46, 14);
		panel.add(lblDate);
		
		JLabel lblHeure = new JLabel("Heure :");
		lblHeure.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeure.setBounds(113, 193, 57, 17);
		panel.add(lblHeure);
		
		JLabel lblMdecin = new JLabel("M\u00E9decin :");
		lblMdecin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMdecin.setBounds(100, 245, 64, 17);
		panel.add(lblMdecin);
		
		calendar = new JCalendar();
		calendar.setBounds(260, 35, 189, 146);
		panel.add(calendar);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(160, 289, 134, 23);
		panel.add(btnAjouter);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(402, 289, 134, 23);
		panel.add(btnAnnuler);
		
	}
	public JButton getBtnAjouter() {
		return btnAjouter;
	}
	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}
	public JSpinner getSpinner() {
		return spinner;
	}
	public JComboBox getComboBox() {
		return comboBox;
	}
	public JCalendar getCalendar() {
		return calendar;
	}
}
