package Meteo;

import java.awt.EventQueue;

import javax.swing.AbstractAction;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit; 
import javax.swing.ImageIcon;

import javax.swing.JComboBox;

public class fenêtre extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6312420591838409456L;
	private JFrame frame;

	/**creates an image*/
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}

	
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
	 * 
	 * @throws Exception
	 */
	public fenêtre() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		ImageIcon rosace = createImageIcon("images/Brosen.png","");
		ImageIcon VVert = createImageIcon("images/vvert.png","");
		ImageIcon VRouge = createImageIcon("images/vrouge.png","");
		ImageIcon flècheH = createImageIcon("images/flecheh.png","");
		ImageIcon flècheM = createImageIcon("images/flechem.png","");
		ImageIcon flècheB = createImageIcon("images/flecheb.png","");

		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 400);
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
			final Capteur_base capteur = Capteur_base.capteurs.get(i);
			JLabel lblImageEtat = new JLabel("");
			lblImageEtat.setIcon(VVert);
			GridBagConstraints gbc_lblImageEtat = new GridBagConstraints();
			gbc_lblImageEtat.insets = new Insets(0, 0, 0, 5);
			gbc_lblImageEtat.gridx = 0;
			gbc_lblImageEtat.gridy = i;
			panel_1.add(lblImageEtat, gbc_lblImageEtat);

			final JLabel lblValeur = new JLabel(capteur.getValeur());
			GridBagConstraints gbc_lblValeur = new GridBagConstraints();
			gbc_lblValeur.insets = new Insets(0, 0, 0, 5);
			gbc_lblValeur.anchor = GridBagConstraints.EAST;
			gbc_lblValeur.gridx = 2;
			gbc_lblValeur.gridy = i;
			panel_1.add(lblValeur, gbc_lblValeur);

			JButton btnNomCapteur = new JButton(
					new AbstractAction(capteur.name) {

						private static final long serialVersionUID = 4096066833790772722L;

						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								lblValeur.setText("" + capteur.getValeur());
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}

					});
			GridBagConstraints gbc_btnNomCapteur = new GridBagConstraints();
			gbc_btnNomCapteur.insets = new Insets(0, 0, 0, 5);
			gbc_btnNomCapteur.gridx = 1;
			gbc_btnNomCapteur.gridy = i;
			panel_1.add(btnNomCapteur, gbc_btnNomCapteur);

			Object[] elements = capteur.getUnités();
			JComboBox comboBox = new JComboBox(elements);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 0, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 3;
			gbc_comboBox.gridy = i;
			panel_1.add(comboBox, gbc_comboBox);

			if (Capteur_base.capteurs.get(i) instanceof Capteur_pm) {

				Capteur_pm capteur_pm = (Capteur_pm) Capteur_base.capteurs
						.get(i);
				JLabel lblDpassement;
				if (capteur_pm.dépasse_max())
					lblDpassement = new JLabel("d\u00E9passement max");
				else if (capteur_pm.dépasse_min())
					lblDpassement = new JLabel("d\u00E9passement min");
				else
					lblDpassement = new JLabel("");

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

				final Capteur_pmt capteur_pmt = (Capteur_pmt) Capteur_base.capteurs
						.get(i);
				float trend = capteur_pmt.get_trend();
				JLabel lblTrend = new JLabel("" + trend);
				if (trend > 0)
					lblTrend.setIcon(flècheH);
				if (trend < 0)
					lblTrend.setIcon(flècheB);
				if (trend == 0)
					lblTrend.setIcon(flècheM);
				GridBagConstraints gbc_lblTrend = new GridBagConstraints();
				gbc_lblTrend.insets = new Insets(0, 0, 0, 5);
				gbc_lblTrend.gridwidth = 2;
				gbc_lblTrend.gridx = 6;
				gbc_lblTrend.gridy = i;
				panel_1.add(lblTrend, gbc_lblTrend);

				JButton btnClearTendance = new JButton(new AbstractAction(
						"Clear Trend") {
					private static final long serialVersionUID = 389447219738703044L;

					@Override
					public void actionPerformed(ActionEvent e) {
						capteur_pmt.clear_trend();
					}

				});
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
		label_5.setIcon(rosace);
		panel_2.add(label_5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
