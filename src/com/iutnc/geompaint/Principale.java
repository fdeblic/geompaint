package com.iutnc.geompaint;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.iutnc.geompaint.view.MenuAdd;

public class Principale {
	public static void main(String[] args) {
		JFrame fenetre=new JFrame("Test");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MenuAdd cont = new MenuAdd();
		cont.setPreferredSize(new Dimension(460,460));
		fenetre.setContentPane(cont);
		fenetre.pack();
		fenetre.setVisible (true);
		cont.requestFocus();
	}
}
