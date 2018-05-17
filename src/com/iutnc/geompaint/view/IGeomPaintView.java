package com.iutnc.geompaint.view;

import java.util.Observer;

public interface IGeomPaintView {
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

	public Observer getObserver();
}
