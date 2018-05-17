package com.iutnc.geompaint.view;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author moreau96u
 * @version 09/05/2018
 * 
 */

public class MenuAdd extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5724502981418760926L;
	/**
	 * Attributs
	 */
	private JButton btnCircle;
	private JButton btnPolygon;
	private JButton btnRectangle;
	private JButton btnTriangle;
	private GeomPaintFrame frame;
	private BufferedImage circleIcon;
	private BufferedImage rectangleIcon;
	private BufferedImage polygonIcon;
	private BufferedImage triangleIcon;
	
	/**
	 * Menu Add constructor
	 * @throws IOException 
	 */
	public MenuAdd(GeomPaintFrame view) {
		frame = view;
		try {
			BufferedImage icons = ImageIO.read(new File("./img/icons.png"));
			circleIcon = icons.getSubimage(0, 0, 64, 64);
			rectangleIcon = icons.getSubimage(0, 64, 64, 64);
			polygonIcon = icons.getSubimage(0, 128, 64, 64);
			triangleIcon = icons.getSubimage(0, 192, 64, 64);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Impossible de charger l'image img/icons.png", "Icones manquantes", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}


		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{97, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAjout = new JLabel("- Ajout -");
		lblAjout.setFont(new Font("Calibri", Font.BOLD, 20));
		GridBagConstraints gbc_lblAjout = new GridBagConstraints();
		gbc_lblAjout.insets = new Insets(5, 0, 5, 0);
		gbc_lblAjout.gridx = 0;
		gbc_lblAjout.gridy = 0;
		add(lblAjout, gbc_lblAjout);
		
		btnCircle = new GPButton("Cercle");
		if (circleIcon != null) btnCircle.setIcon(new ImageIcon(circleIcon));
		btnCircle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCircle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.createCircle();				
			}
		});
		GridBagConstraints gbc_btnCercle = new GridBagConstraints();
		gbc_btnCercle.fill = GridBagConstraints.BOTH;
		gbc_btnCercle.insets = new Insets(0, 0, 5, 0);
		gbc_btnCercle.gridx = 0;
		gbc_btnCercle.gridy = 1;
		add(btnCircle, gbc_btnCercle);
		
		btnPolygon = new GPButton("Polygone");
		if (polygonIcon != null) btnPolygon.setIcon(new ImageIcon(polygonIcon));
		btnPolygon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPolygon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.createPolygon();				
			}
		});
		GridBagConstraints gbc_btnPolygone = new GridBagConstraints();
		gbc_btnPolygone.fill = GridBagConstraints.BOTH;
		gbc_btnPolygone.insets = new Insets(0, 0, 5, 0);
		gbc_btnPolygone.gridx = 0;
		gbc_btnPolygone.gridy = 2;
		add(btnPolygon, gbc_btnPolygone);
		
		btnRectangle = new GPButton("Rectangle");
		if (rectangleIcon != null) btnRectangle.setIcon(new ImageIcon(rectangleIcon));
		btnRectangle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.createRectangle();				
			}
		});
		GridBagConstraints gbc_btnRectangle = new GridBagConstraints();
		gbc_btnRectangle.fill = GridBagConstraints.BOTH;
		gbc_btnRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_btnRectangle.gridx = 0;
		gbc_btnRectangle.gridy = 3;
		add(btnRectangle, gbc_btnRectangle);
		
		btnTriangle = new GPButton("Triangle");
		if (triangleIcon != null) btnTriangle.setIcon(new ImageIcon(triangleIcon));
		btnTriangle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTriangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.createTriangle();				
			}
		});
		GridBagConstraints gbc_btnTriangle = new GridBagConstraints();
		gbc_btnTriangle.fill = GridBagConstraints.BOTH;
		gbc_btnTriangle.gridx = 0;
		gbc_btnTriangle.gridy = 4;
		add(btnTriangle, gbc_btnTriangle);
	}
	
	
	/**
	 * Enable the menu 
	 * @param b choice selected
	 */
	public void setEnabled(boolean b){
		btnTriangle.setEnabled(b);
		btnRectangle.setEnabled(b);
		btnCircle.setEnabled(b);
		btnPolygon.setEnabled(b);
	}

}
