package com.iutnc.geompaint.view;

import com.iutnc.geompaint.model.Figure;

public interface IGeomPaintView {
	public boolean isSelectedFigure(Figure f);
	public void setSelectedFigure(Figure f);
	public void addFigure(Figure f);
	public void enableEdition(boolean b);
	public void enableAdding(boolean b);
}
