package com.iutnc.geompaint.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GPButton extends JButton implements MouseListener {

	private Color
	colNormal = Color.decode("#689fdc"),
		colHover = Color.decode("#145391"),
		colDisabled = Color.decode("#eeeeee");
	
	public GPButton(String string) {
		super(string);
		setDefaultStyle();
	}

	@Override
	public void setIcon(Icon icon) {
		if (icon != null) {
			Image image = ((ImageIcon) icon).getImage(); // transform it 
			Image newimg = image.getScaledInstance(32, 32,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			icon = new ImageIcon(newimg);  // transform it back
		}
		super.setIcon(icon);
	}
	
	private void setDefaultStyle() {
		setForeground(Color.WHITE);
		setBackground(colNormal);
		addMouseListener(this);
		setFocusable(false);
		setFont(new Font("Calibri", Font.BOLD, 16));
		setHorizontalAlignment(SwingConstants.LEFT);
		//setBorderPainted(false);
		//setContentAreaFilled(false);
	}
	
	@Override
	public void setEnabled(boolean b) {
		super.setEnabled(b);
		setBackground(b ? colNormal : colDisabled);
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (isEnabled()) {
			setBackground(colHover);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (isEnabled()) {
			setBackground(colNormal);
		}
	}
}
