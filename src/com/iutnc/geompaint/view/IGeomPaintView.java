package com.iutnc.geompaint.view;

import com.iutnc.geompaint.model.Figure;

public interface IGeomPaintView {
	/**
	 * The figure is selected or not
	 * @param f
	 * @return true or false if figure is selected
	 */
	public boolean isSelectedFigure(Figure f);
	
	/**
	 * Set the figure selected
	 * @param f the figure to select
	 */
	public void setSelectedFigure(Figure f);
	
	/**
	 * Enable the edition mode
	 * @param b the edition mode is enable or not
	 */
	public void enableEdition(boolean b);
	
	/**
	 * Enable the adding mode
	 * @param b the adding mode is enable or not
	 */
	public void enableAdding(boolean b);

	public Canvas getCanvas();
}
