package Meteo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;

public class fenêtre {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void draw(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fenêtre window = new fenêtre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public fenêtre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 757, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new GridLayout(Capteur_base.count_observers() + 1, 1,
				0, 0));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblHautGauche = new JLabel("haut gauche date");
		GridBagConstraints gbc_lblHautGauche = new GridBagConstraints();
		gbc_lblHautGauche.insets = new Insets(0, 0, 0, 5);
		gbc_lblHautGauche.gridx = 0;
		gbc_lblHautGauche.gridy = 0;
		panel_3.add(lblHautGauche, gbc_lblHautGauche);

		JLabel lblHautDroiteHeure = new JLabel("haut droite heure");
		GridBagConstraints gbc_lblHautDroiteHeure = new GridBagConstraints();
		gbc_lblHautDroiteHeure.gridx = 1;
		gbc_lblHautDroiteHeure.gridy = 0;
		panel_3.add(lblHautDroiteHeure, gbc_lblHautDroiteHeure);

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		for (int i = 0; i < Capteur_base.count_observers(); i++) {

			JLabel lblImageEtat = new JLabel("image etat");
			lblImageEtat.setIcon(null);
			GridBagConstraints gbc_lblImageEtat = new GridBagConstraints();
			gbc_lblImageEtat.insets = new Insets(0, 0, 0, 5);
			gbc_lblImageEtat.gridx = 0;
			gbc_lblImageEtat.gridy = i;
			panel_1.add(lblImageEtat, gbc_lblImageEtat);

			JButton btnNomCapteur = new JButton(
					Capteur_base.capteurs.get(i).name);
			GridBagConstraints gbc_btnNomCapteur = new GridBagConstraints();
			gbc_btnNomCapteur.insets = new Insets(0, 0, 0, 5);
			gbc_btnNomCapteur.gridx = 1;
			gbc_btnNomCapteur.gridy = i;
			panel_1.add(btnNomCapteur, gbc_btnNomCapteur);

			JLabel lblValeur = new JLabel(""
					+ Capteur_base.capteurs.get(i).valeur);
			GridBagConstraints gbc_lblValeur = new GridBagConstraints();
			gbc_lblValeur.insets = new Insets(0, 0, 0, 5);
			gbc_lblValeur.anchor = GridBagConstraints.EAST;
			gbc_lblValeur.gridx = 2;
			gbc_lblValeur.gridy = i;
			panel_1.add(lblValeur, gbc_lblValeur);

			JComboBox comboBox = new JComboBox();
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 0, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 3;
			gbc_comboBox.gridy = i;
			panel_1.add(comboBox, gbc_comboBox);

			if (Capteur_base.capteurs.get(i) instanceof Capteur_pm) {
				
				Capteur_pm capteur_pm = (Capteur_pm) Capteur_base.capteurs.get(i);
				JLabel lblDpassement;
				if (capteur_pm.dépasse_max()) lblDpassement = new JLabel("d\u00E9passement max");
				else if (capteur_pm.dépasse_min()) lblDpassement = new JLabel("d\u00E9passement min");
				else lblDpassement = new JLabel("");
				
				GridBagConstraints gbc_lblDpassement = new GridBagConstraints();
				gbc_lblDpassement.insets = new Insets(0, 0, 0, 5);
				gbc_lblDpassement.gridx = 4;
				gbc_lblDpassement.gridy = i;
				panel_1.add(lblDpassement, gbc_lblDpassement);

				JButton btnResetMinmax = new JButton("reset min/max");
				GridBagConstraints gbc_btnResetMinmax = new GridBagConstraints();
				gbc_btnResetMinmax.insets = new Insets(0, 0, 0, 5);
				gbc_btnResetMinmax.gridx = 5;
				gbc_btnResetMinmax.gridy = i;
				panel_1.add(btnResetMinmax, gbc_btnResetMinmax);
			}

			if (Capteur_base.capteurs.get(i) instanceof Capteur_pmt) {

				Capteur_pmt capteur_pmt = (Capteur_pmt) Capteur_base.capteurs.get(i);
				float trend = capteur_pmt.get_trend();
				JLabel lblTrend = new JLabel("" + trend);
				if (trend>0) lblTrend.setIcon(null);
				if (trend<0) lblTrend.setIcon(null);
				if (trend==0) lblTrend.setIcon(null);
				GridBagConstraints gbc_lblTrend = new GridBagConstraints();
				gbc_lblTrend.insets = new Insets(0, 0, 0, 5);
				gbc_lblTrend.gridwidth = 2;
				gbc_lblTrend.gridx = 6;
				gbc_lblTrend.gridy = i;
				panel_1.add(lblTrend, gbc_lblTrend);

				JButton btnClearTendance = new JButton("clear tendance");
				GridBagConstraints gbc_btnClearTendance = new GridBagConstraints();
				gbc_btnClearTendance.insets = new Insets(0, 0, 0, 5);
				gbc_btnClearTendance.gridx = 8;
				gbc_btnClearTendance.gridy = i;
				panel_1.add(btnClearTendance, gbc_btnClearTendance);
			}
		}
		JPanel panel_2 = new JPanel();
		splitPane.setLeftComponent(panel_2);

		JLabel label_5 = new JLabel("");
		label_5.setIcon(null);
		panel_2.add(label_5);
	}

}
