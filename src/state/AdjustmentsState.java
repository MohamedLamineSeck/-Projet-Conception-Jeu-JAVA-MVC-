package state;

import command.AdjustmentCommand;
import model.*;
import util.Controller;
import view.GUIGame;
import view.PanelClass;
import view.ViewCercle;
import view.ViewObject;

public class AdjustmentsState implements State {
	
	ViewObject object;
	ViewObject adjustObject;
    Model model;
	
    /**
     * Constructor 
     * @param model of the game.
     */
	public AdjustmentsState(Model model) {
		this.model=model;
	}

	/**
	 * Method that check whether to object to be adjusted is circle or rectangle.
	 */
	@Override
	public void mouseDragged(Point p) {
		
		PanelClass.endDrag =p;
		
		if(this.adjustObject!=null) {
			if(this.adjustObject instanceof ViewCercle) {
			cercleAdjusting(p);}
			else 
				rectangleAdjusting(p);	
		}
		
	}
	/**
	 * Method that reposition the points  of the circle as well as the center.
	 */
	public void cercleAdjusting(Point p ) {
		
		this.adjustObject.getObject().setX2((int) (this.adjustObject.getObject().getX2()+ p.getX() - ((Cercle) this.adjustObject.getObject()).getCenterX()));
		this.adjustObject.getObject().setY2((int) (this.adjustObject.getObject().getY2()+ p.getY() - ((Cercle) this.adjustObject.getObject()).getCenterY()));
		
		this.adjustObject.getObject().setX1((int) (this.adjustObject.getObject().getX1()+ p.getX() - ((Cercle) this.adjustObject.getObject()).getCenterX()) );
		this.adjustObject.getObject().setY1((int) (this.adjustObject.getObject().getY1()+ p.getY() - ((Cercle) this.adjustObject.getObject()).getCenterY()));
		
		((Cercle) this.adjustObject.getObject()).setCenterX( p.getX());
		((Cercle) this.adjustObject.getObject()).setCenterY( p.getY());
		
	}
	/**
	 * Method that reposition the points of the rectangle.
	 */
	public void rectangleAdjusting(Point p) {
		int x1= p.getX()-this.adjustObject.getObject().getX2();
		int y1= p.getY()-this.adjustObject.getObject().getY2();
		
		this.adjustObject.getObject().setX2(p.getX());
		this.adjustObject.getObject().setY2(p.getY());
		
		this.adjustObject.getObject().setX1(this.adjustObject.getObject().getX1()+x1);
		this.adjustObject.getObject().setY1(this.adjustObject.getObject().getY1()+y1);
	}

	@Override
	public void mouseReleased(Point p1, Point p2) {
		
		this.adjustObject=null;
		
	}
	/**
	 * Checks if there has been object selected looping through the list of objects by comparing the pressed point with 
	 * the specific square that every object has.
	 */
	@Override
	public void mousePressed(Point p) {
		for(ViewObject object: GUIGame.objects ) {
			if(object.getPoints().contains(p.getX(), p.getY())) {
				this.object=object;
				this.adjustObject = object.getObjectCopy();
				AdjustmentCommand adjustCommand = new AdjustmentCommand(this.object,this.adjustObject ,this.model);
				Controller.handler.handle(adjustCommand);
			}
			break;
		}
		
		
	}

	@Override
	public ViewObject make() {
		return null;
	}
	
	public String toString() {
		return "adjustement";
		
	}
	
	

}
