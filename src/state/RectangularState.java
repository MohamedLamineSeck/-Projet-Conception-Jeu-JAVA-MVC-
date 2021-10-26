package state;


import command.AddObjectCommand;
import command.OperationCommand;
import model.Model;
import model.Point;
import model.Rectangle;
import util.Controller;
import view.PanelClass;
import view.ViewObject;
import view.ViewRectangle;

public class RectangularState implements State{
	
	Model model;
	/**
	 * Constructor 
	 * @param model of the game.
	 */
	
	public RectangularState(Model model) {
		this.model=model;
	}


	/**
	 * Change the static variable endDrag from the class PanelClass can start drawing.
	 */
	@Override
	public void mouseDragged(Point p) {
		PanelClass.endDrag = p;
		
	}

	/**
	 * Method that creates the rectangle by creating it's form and passing it to the AddObjctCommand.
	 */

	@Override
	public void mouseReleased(Point p1, Point p2) {

		Rectangle r1 = new Rectangle(p1, p2);
        ViewRectangle r = new ViewRectangle(r1);
        
    	OperationCommand command = new AddObjectCommand(r,model);
	    Controller.handler.handle(command);
		
	}

	@Override
	public void mousePressed(Point p) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Creating and return ViewRectangle.
	 */
	public ViewObject make() {
		
		 Rectangle rectangle = new Rectangle( PanelClass.startDrag,PanelClass.endDrag);
	        ViewRectangle r = new ViewRectangle(rectangle);
	    return r;
	}


	


	}



