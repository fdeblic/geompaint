package com.iutnc.geompaint.view;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import com.iutnc.geompaint.controller.FigureAnalyzer;
import com.iutnc.geompaint.controller.GeomPaintController;
import com.iutnc.geompaint.model.*;

/**
 * Class for canvas
 * @author Elise
 * @version 09/05/2018
 */
public class Canvas extends JPanel implements MouseListener, MouseMotionListener, Observer {

	/**
	 * Attributs
	 */
	private static final long serialVersionUID = 3407451406157270690L;
	private GeomPaintController controller;
	private FigureDrawer drawer;
	private FigureAnalyzer analyzer;
	private Figure selectedFigure;
	private Point movingPoint;
	
		
	/**
	 * Canvas Constructor
	 * @param selectedFigure the selected figure, you want to modify
	 * @param movingPoint the point to move a figure
	 */
	public Canvas(GeomPaintController controller) {
		super();
		this.controller= controller; 
		setBackground(Color.white);
	}
	
	/**
	 * Figure selected to set
	 * @param selectedFigure the selected figure, you want to modify
	 */
	public boolean isSelected(Figure f) {
		// TODO tester par rapport à l'attribut associé
		return false;
	}
	
	/**
	 * Figure selected to set
	 * @param selectedFigure the selected figure, you want to modify
	 */
	private boolean isSelected(Point p) {
		// TODO tester par rapport à l'attribut movingPoint
		return false;
	}
	
	
	/**
	 * The figure is hover
	 * @param f the figure you want to check
	 * @return True if the figure is hover
	 */
	private boolean isHover(Figure f) {
		// TODO appel à FigureAnalyzer
		return false;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Figure[] figures = controller.getFigures();
		if (figures == null)
			return;
		
		// TODO dessin des figures
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO déplacement du point en cours ou de la figure
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO changer le style de la figure qui est survolée
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseReleased(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {
		/* Si clic sur une figure
		 * 		selectionner la figure
		 * sinon si clic sur du vide et canvas en mode ajout de point
		 * 		ajouter un point à la figure sélectionnée
		 * fin si
		*/
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

}
