package com.iutnc.geompaint.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iutnc.geompaint.controller.GeomPaint;

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
	private GeomPaint controller;
	private JButton btnFill;
	private JButton btnColor;
	private JButton btnClone;
	private JButton btnDelete;
	
	/**
	 * Menu Edit constructor 
	 */
	public MenuEdit() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("- Editer -");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		btnFill = new JButton("Remplir");
		GridBagConstraints gbc_btnCercle = new GridBagConstraints();
		gbc_btnCercle.fill = GridBagConstraints.BOTH;
		gbc_btnCercle.insets = new Insets(0, 0, 5, 5);
		gbc_btnCercle.gridx = 1;
		gbc_btnCercle.gridy = 2;
		add(btnFill, gbc_btnCercle);
		
		btnColor = new JButton("Couleur");
		GridBagConstraints gbc_btnPolygone = new GridBagConstraints();
		gbc_btnPolygone.fill = GridBagConstraints.BOTH;
		gbc_btnPolygone.insets = new Insets(0, 0, 5, 5);
		gbc_btnPolygone.gridx = 1;
		gbc_btnPolygone.gridy = 3;
		add(btnColor, gbc_btnPolygone);
		
		btnClone = new JButton("Dupliquer");
		GridBagConstraints gbc_btnRectangle = new GridBagConstraints();
		gbc_btnRectangle.fill = GridBagConstraints.BOTH;
		gbc_btnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_btnRectangle.gridx = 1;
		gbc_btnRectangle.gridy = 4;
		add(btnClone, gbc_btnRectangle);
		
		btnDelete = new JButton("Supprimer");
		GridBagConstraints gbc_btnTriangle = new GridBagConstraints();
		gbc_btnTriangle.fill = GridBagConstraints.BOTH;
		gbc_btnTriangle.insets = new Insets(0, 0, 5, 5);
		gbc_btnTriangle.gridx = 1;
		gbc_btnTriangle.gridy = 5;
		add(btnDelete, gbc_btnTriangle);
	}
	
	/**
	 * Enable the menu 
	 * @param b choice selected
	 */
	public void setEnabled(boolean b) {}
}
