package com.xross.tools.xstate.editor.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;

import com.xross.tools.xstate.editor.model.StateMachineConstants;

public class StateMachineFigure extends Figure implements StateMachineConstants{
	private Label label;
	private IFigure figure;
    public StateMachineFigure() {
//      figure = new FreeformLayer();
//      figure.setLayoutManager(new FreeformLayout());

        figure = new Figure();
        figure.setLayoutManager(new XYLayout());
        figure.setBorder(new LineBorder(ColorConstants.lightGray, 10));
//        figure.setMinimumSize(new Dimension(500, 500));
        figure.setPreferredSize(new Dimension(700, 400));

        label = new Label();

    	ToolbarLayout layout= new ToolbarLayout();
    	layout.setSpacing(TOP_LEVEL_SPACE);
    	setLayoutManager(layout);
    	
        label.setLabelAlignment(PositionConstants.LEFT);
        label.setForegroundColor(ColorConstants.blue);

        
        add(label);
        add(figure);
    }

    public void setName(String name, String toolTip) {
    	label.setText(name);
    	label.setToolTip(new Label(toolTip));
        repaint();
    }
    
    public IFigure getFigure(){
    	return figure;
    }
}