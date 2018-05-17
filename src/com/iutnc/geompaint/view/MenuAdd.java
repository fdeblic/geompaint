package com.iutnc.geompaint.view;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Cursor;
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
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 97, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("- Ajout -");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		btnCircle = new JButton("Cercle", new ImageIcon(circleIcon));
		btnCircle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCircle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.createCircle();				
			}
		});
		btnCircle.setFocusable(false);
		GridBagConstraints gbc_btnCercle = new GridBagConstraints();
		gbc_btnCercle.fill = GridBagConstraints.BOTH;
		gbc_btnCercle.insets = new Insets(0, 0, 5, 5);
		gbc_btnCercle.gridx = 1;
		gbc_btnCercle.gridy = 2;
		add(btnCircle, gbc_btnCercle);
		
		btnPolygon = new JButton("Polygone", new ImageIcon(polygonIcon));
		btnPolygon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPolygon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.createPolygon();				
			}
		});
		btnPolygon.setFocusable(false);
		GridBagConstraints gbc_btnPolygone = new GridBagConstraints();
		gbc_btnPolygone.fill = GridBagConstraints.BOTH;
		gbc_btnPolygone.insets = new Insets(0, 0, 5, 5);
		gbc_btnPolygone.gridx = 1;
		gbc_btnPolygone.gridy = 3;
		add(btnPolygon, gbc_btnPolygone);
		
		btnRectangle = new JButton("Rectangle", new ImageIcon(rectangleIcon));
		btnRectangle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnRectangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.createRectangle();				
			}
		});
		btnRectangle.setFocusable(false);
		GridBagConstraints gbc_btnRectangle = new GridBagConstraints();
		gbc_btnRectangle.fill = GridBagConstraints.BOTH;
		gbc_btnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_btnRectangle.gridx = 1;
		gbc_btnRectangle.gridy = 4;
		add(btnRectangle, gbc_btnRectangle);
		
		btnTriangle = new JButton("Triangle", new ImageIcon(triangleIcon));
		btnTriangle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTriangle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.createTriangle();				
			}
		});
		btnTriangle.setFocusable(false);
		GridBagConstraints gbc_btnTriangle = new GridBagConstraints();
		gbc_btnTriangle.fill = GridBagConstraints.BOTH;
		gbc_btnTriangle.insets = new Insets(0, 0, 5, 5);
		gbc_btnTriangle.gridx = 1;
		gbc_btnTriangle.gridy = 5;
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
