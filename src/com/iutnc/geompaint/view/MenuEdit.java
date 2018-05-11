package com.iutnc.geompaint.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iutnc.geompaint.controller.GeomPaintController;

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
	private GeomPaintController controller;
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
		GridBagConstraints gbc_btnFill = new GridBagConstraints();
		gbc_btnFill.fill = GridBagConstraints.BOTH;
		gbc_btnFill.insets = new Insets(0, 0, 5, 5);
		gbc_btnFill.gridx = 1;
		gbc_btnFill.gridy = 2;
		add(btnFill, gbc_btnFill);
		
		btnColor = new JButton("Couleur");
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.fill = GridBagConstraints.BOTH;
		gbc_btnColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnColor.gridx = 1;
		gbc_btnColor.gridy = 3;
		add(btnColor, gbc_btnColor);
		
		btnClone = new JButton("Dupliquer");
		GridBagConstraints gbc_btnClone = new GridBagConstraints();
		gbc_btnClone.fill = GridBagConstraints.BOTH;
		gbc_btnClone.insets = new Insets(0, 0, 5, 5);
		gbc_btnClone.gridx = 1;
		gbc_btnClone.gridy = 4;
		add(btnClone, gbc_btnClone);
		
		btnDelete = new JButton("Supprimer");
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 5;
		add(btnDelete, gbc_btnDelete);
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
	}
}
