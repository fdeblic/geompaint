package com.iutnc.geompaint;
import java.awt.Dimension;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import com.iutnc.geompaint.view.MenuAdd;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
