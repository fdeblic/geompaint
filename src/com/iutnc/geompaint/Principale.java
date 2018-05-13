package com.iutnc.geompaint;
import javax.swing.JPanel;
import com.iutnc.geompaint.controller.GeomPaintController;
import com.iutnc.geompaint.view.*;

/**
 * 
 * @author Elise
 * @version 09/05/2018
 *
 */
public class Principale extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7979198717497973220L;

	public static void main(String[] args) {
		IGeomPaintView fenetre = new GeomPaintFrame();
		GeomPaintController controller = new GeomPaintController(fenetre);
		controller.run();
	}
}
