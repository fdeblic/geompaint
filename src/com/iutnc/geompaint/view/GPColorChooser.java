package com.iutnc.geompaint.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GPColorChooser extends JPanel {
	private Color[] colors;
	
	public GPColorChooser() {
		colors = new Color[10];
		for (int i = 0 ; i < colors.length ; i++) {
			colors[i] = new Color(i*25, i*25, i*25);
		}
		setPreferredSize(new Dimension(200, 20));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for (int i = 0 ; i < colors.length ; i++) {
			g.setColor(colors[i]);
			g.fillRect(i*25, 0, 25, getHeight());
		}
	}
}
