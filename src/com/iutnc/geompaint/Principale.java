package com.iutnc.geompaint;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.iutnc.geompaint.view.*;

/**
 * 
 * @author Elise
 * @version 09/05/2018
 *
 */
public class Principale extends JPanel{

	public static void main(String[] args) {
		JFrame fenetre=new JFrame("GeomPoint");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel canvas = new JPanel();
		canvas.setBackground(Color.white);
		JPanel global = new JPanel(new BorderLayout());
		MenuAdd menuAdd = new MenuAdd();
		MenuEdit menuEdit = new MenuEdit();
		
		JPanel menus = new JPanel(new BorderLayout());
		menus.add(menuAdd,BorderLayout.NORTH);
		menus.add(menuEdit,BorderLayout.CENTER);
		global.add(canvas,BorderLayout.CENTER);
		global.add(menus,BorderLayout.WEST);
		
		fenetre.setPreferredSize(new Dimension(500,500));
		fenetre.setContentPane(global);
		fenetre.pack();
		fenetre.setVisible (true);
		fenetre.requestFocus();
	}
}
