package com.iutnc.geompaint;

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
		fenetre.setVisible(true);
	}
}
