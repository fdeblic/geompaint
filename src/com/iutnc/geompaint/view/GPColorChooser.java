package com.iutnc.geompaint.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GPColorChooser extends JPanel implements MouseListener, MouseMotionListener {
	private GeomPaintFrame frame;
	
	public GPColorChooser(GeomPaintFrame frame) {
		this.frame = frame;
		setPreferredSize(new Dimension(200, 20));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(this);
		addMouseMotionListener(this);
		setToolTipText("<html>Clic gauche : couleur de bordure<br>Clic milieu : couleur de remplissage");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0 ; i < getWidth() ; i++) {
			g.setColor(Color.getHSBColor((float)i/getWidth(), 0.8f, 0.8f));
			g.fillRect(i, 0, 1, getHeight());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		updateColor(e);
	}

	private void updateColor(MouseEvent e) {
		if (frame != null) {
			if (SwingUtilities.isLeftMouseButton(e))
				frame.setBorderColor(Color.getHSBColor((float)e.getX()/getWidth(), 0.8f, 0.8f));
			else if (SwingUtilities.isMiddleMouseButton(e))
				frame.setFillColor(Color.getHSBColor((float)e.getX()/getWidth(), 0.8f, 0.8f));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		updateColor(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
