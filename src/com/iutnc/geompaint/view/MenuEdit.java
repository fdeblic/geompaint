package com.iutnc.geompaint.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Elise
 * @version 09/05/2018
 *
 */
public class MenuEdit extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8937470125516171462L;
	/**
	 * Attributs
	 */
	private JButton btnFill;
	private JButton btnColor;
	private JButton btnClone;
	private JButton btnDelete;
	private GeomPaintFrame frame;
	private JButton btnUp;
	private JButton btnDown;
	private BufferedImage fillIcon;
	private BufferedImage colorIcon;
	private BufferedImage cloneIcon;
	private BufferedImage deleteIcon;
	private BufferedImage upIcon;
	private BufferedImage downIcon;
	private JLabel lblHint;
	
	/**
	 * Menu Edit constructor 
	 * @param view 
	 */
	public MenuEdit(GeomPaintFrame view) {
		frame = view;
		try {
			BufferedImage icons = ImageIO.read(new File("./img/icons.png"));
			fillIcon = icons.getSubimage(64, 0, 64, 64);
			colorIcon = icons.getSubimage(64, 64, 64, 64);
			cloneIcon = icons.getSubimage(64, 128, 64, 64);
			deleteIcon = icons.getSubimage(64, 192, 64, 64);
			upIcon = icons.getSubimage(128, 0, 64, 64);
			downIcon = icons.getSubimage(128, 64, 64, 64);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Impossible de charger l'image img/icons.png", "Icones manquantes", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{95, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("- Edition -");
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(5, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		btnFill = new GPButton("Remplir");
		if (fillIcon != null) btnFill.setIcon(new ImageIcon(fillIcon));
		btnFill.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnFill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.fillFigure();
			}
		});
		GridBagConstraints gbc_btnFill = new GridBagConstraints();
		gbc_btnFill.fill = GridBagConstraints.BOTH;
		gbc_btnFill.insets = new Insets(0, 0, 5, 0);
		gbc_btnFill.gridx = 0;
		gbc_btnFill.gridy = 1;
		add(btnFill, gbc_btnFill);
		
		btnColor = new GPButton("Couleur");
		if (colorIcon != null) btnColor.setIcon(new ImageIcon(colorIcon));
		btnColor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changeFigureColor();
				
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.fill = GridBagConstraints.BOTH;
		gbc_btnColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnColor.gridx = 0;
		gbc_btnColor.gridy = 2;
		add(btnColor, gbc_btnColor);
		
		btnClone = new GPButton("Dupliquer");
		if (cloneIcon != null) btnClone.setIcon(new ImageIcon(cloneIcon));
		btnClone.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnClone.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.cloneFigure();
				
			}
		});
		GridBagConstraints gbc_btnClone = new GridBagConstraints();
		gbc_btnClone.fill = GridBagConstraints.BOTH;
		gbc_btnClone.insets = new Insets(0, 0, 5, 0);
		gbc_btnClone.gridx = 0;
		gbc_btnClone.gridy = 3;
		add(btnClone, gbc_btnClone);
		
		btnDelete = new GPButton("Supprimer");
		if (deleteIcon != null) btnDelete.setIcon(new ImageIcon(deleteIcon));
		btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.deleteFigure();
				
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 4;
		add(btnDelete, gbc_btnDelete);
		
		btnUp = new GPButton("Monter");
		if (upIcon != null) btnUp.setIcon(new ImageIcon(upIcon));
		btnUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.moveUp();
				
			}
		});
		GridBagConstraints gbc_btnUp = new GridBagConstraints();
		gbc_btnUp.fill = GridBagConstraints.BOTH;
		gbc_btnUp.insets = new Insets(0, 0, 5, 0);
		gbc_btnUp.gridx = 0;
		gbc_btnUp.gridy = 5;
		add(btnUp, gbc_btnUp);
		
		btnDown = new GPButton("Descendre");
		if (downIcon != null) btnDown.setIcon(new ImageIcon(downIcon));
		btnDown.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.moveDown();
				
			}
		});
		GridBagConstraints gbc_btnDown = new GridBagConstraints();
		gbc_btnDown.insets = new Insets(0, 0, 5, 0);
		gbc_btnDown.fill = GridBagConstraints.BOTH;
		gbc_btnDown.gridx = 0;
		gbc_btnDown.gridy = 6;
		add(btnDown, gbc_btnDown);
		
		lblHint = new JLabel("<html><body style='text-align:center'>Ajoutez / s\u00E9lectionnez<br>une figure...");
		lblHint.setFont(new Font("Calibri", Font.BOLD, 12));
		lblHint.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblHint = new GridBagConstraints();
		gbc_lblHint.gridx = 0;
		gbc_lblHint.gridy = 7;
		gbc_lblHint.insets = new Insets(10, 0, 0, 0);
		add(lblHint, gbc_lblHint);
	}
	
	/**
	 * Enable the menu 
	 * @param b choice selected
	 */
	public void setEnabled(boolean b) {
		btnClone.setEnabled(b);
		btnDelete.setEnabled(b);
		btnColor.setEnabled(b);
		btnFill.setEnabled(b);
		btnUp.setEnabled(b);
		btnDown.setEnabled(b);
		lblHint.setVisible(!b);
	}
}
