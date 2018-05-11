package com.iutnc.geompaint.view;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import com.iutnc.geompaint.controller.GeomPaint;

import java.awt.Insets;
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
	private GeomPaint controller;
	private JButton btnCercle;
	private JButton btnPolygone;
	private JButton btnRectangle;
	private JButton btnTriangle;
	
	/**
	 * Menu Add constructor
	 */
	public MenuAdd() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
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
		
		btnCercle = new JButton("Cercle");
		GridBagConstraints gbc_btnCercle = new GridBagConstraints();
		gbc_btnCercle.fill = GridBagConstraints.BOTH;
		gbc_btnCercle.insets = new Insets(0, 0, 5, 5);
		gbc_btnCercle.gridx = 1;
		gbc_btnCercle.gridy = 2;
		add(btnCercle, gbc_btnCercle);
		
		btnPolygone = new JButton("Polygone");
		GridBagConstraints gbc_btnPolygone = new GridBagConstraints();
		gbc_btnPolygone.fill = GridBagConstraints.BOTH;
		gbc_btnPolygone.insets = new Insets(0, 0, 5, 5);
		gbc_btnPolygone.gridx = 1;
		gbc_btnPolygone.gridy = 3;
		add(btnPolygone, gbc_btnPolygone);
		
		btnRectangle = new JButton("Rectangle");
		GridBagConstraints gbc_btnRectangle = new GridBagConstraints();
		gbc_btnRectangle.fill = GridBagConstraints.BOTH;
		gbc_btnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_btnRectangle.gridx = 1;
		gbc_btnRectangle.gridy = 4;
		add(btnRectangle, gbc_btnRectangle);
		
		btnTriangle = new JButton("Triangle");
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
		btnCercle.setEnabled(b);
		btnPolygone.setEnabled(b);
	}

}
