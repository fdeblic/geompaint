package com.iutnc.geompaint;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import com.iutnc.geompaint.controller.GeomPaintController;
import com.iutnc.geompaint.view.*;

/**
 * 
 * @author Elise
 * @version 09/05/2018
 *
 */
public class Principale {
	public static void main(String[] args) {
		GeomPaintController controller = new GeomPaintController();
		GeomPaintFrame fenetre = new GeomPaintFrame(controller);
		
		if (!new File("img/icons.png").exists())
			JOptionPane.showMessageDialog(fenetre, "Impossible de trouver l'image img/icons.png", "Icônes manquantes", JOptionPane.WARNING_MESSAGE);
		
		// Ouvre la fenêtre
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("img/font/calibrib.ttf")));
		} catch (IOException|FontFormatException e) {
			JOptionPane.showMessageDialog(fenetre, "Impossible de trouver la police img/font/calibrib.ttf", "Police manquante", JOptionPane.WARNING_MESSAGE);
		}
		controller.setView(fenetre);
		fenetre.setVisible(true);
	}
}
