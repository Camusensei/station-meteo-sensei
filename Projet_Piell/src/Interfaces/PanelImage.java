package Interfaces;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelImage extends JPanel {
	private Image image;
	private ImageIcon icon;
	private double radian;
	
	public void setImage (String name) {
		icon = new ImageIcon(name);
		image = icon.getImage();
		repaint();
	}
	
	public void setRadian (double val_rad) {
		radian = val_rad;
	}

	public PanelImage(String name) {
		icon = new ImageIcon(name);
		image = icon.getImage();
		radian = 1000;
	}
	
	public PanelImage(String name,int height, int width) {
		setSize(height,width);
		icon = new ImageIcon(name);
		image = icon.getImage();
		radian = 1000;
	}
	
	public PanelImage(String name,double val_rad) {
		icon = new ImageIcon(name);
		image = icon.getImage();
		radian = val_rad;
	}

	@Override
	public void paintComponent(Graphics g) {
		Dimension dim = getSize(null);
		int m = (int) Math.min(dim.width, dim.height);
		int haut = 0;
		int cote = 0;
		if (m != dim.width) {
			cote = dim.width/2-m/2;
		}
		if (m != dim.height) {
			haut
			
			= dim.height/2-m/2;
		}
		g.setColor(Color.RED);
		g.clearRect(0,0, dim.width, dim.height);
		g.drawImage(image, cote, haut,m+cote,m+haut,0,0,icon.getIconHeight(),icon.getIconWidth(), this);
		if (radian != 1000) {
			g.drawLine(dim.width/2,dim.height/2,(int) (Math.sin(radian+Math.PI/4)*m/3)+dim.height/2,(int) (Math.cos(radian+Math.PI/4)*m/3)+dim.width/2);
			g.fillOval((int) (Math.sin(radian+Math.PI/4)*m/3+dim.height/2-4), (int) (Math.cos(radian+Math.PI/4)*m/3+dim.width/2-4), 8, 8);
		}
	}
}