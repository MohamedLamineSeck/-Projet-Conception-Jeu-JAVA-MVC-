package state;


import command.*;
import model.Cercle;
import model.Model;
import model.Point;
import util.Controller;
import view.PanelClass;
import view.ViewCercle;
import view.ViewObject;

public class CercleState implements State{

	public Model model;
	
	/**
	 * Constructor 
	 * @param model of the game.
	 */
	public CercleState(Model model) {
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
	 * Method that creates the circle by creating it's form and passing it to the AddObjctCommand.
	 */
	@Override
	public void mouseReleased(Point p1, Point p2) {
		
		  int x1 = Math.min(p1.getX(), p2.getX());
		  int x2 = Math.max(p1.getX(), p2.getX());
		  int y1 = Math.min(p1.getY(), p2.getY());
		  int y2 = Math.min(p1.getY(), p2.getY()) + Math.abs(p1.getX()-p2.getX());
		  
		  Point startPoint = new Point(x1, y1);
		  Point endPoint = new Point(x2, y2);
			  
		  Cercle c = new Cercle(startPoint, endPoint);
		 
		  
	      ViewCercle r = new ViewCercle(c); 
	     
	      OperationCommand command = new AddObjectCommand(r, model);
	      Controller.handler.handle(command);
	   
		
	}


	@Override
	public void mousePressed(Point p) {
	
	}

	/**
	 * Creating and return ViewCercle.
	 */
	@Override
	public ViewObject make() {
		 Cercle cercle = new Cercle(PanelClass.startDrag, PanelClass.endDrag);
	        ViewCercle c = new ViewCercle(cercle);
		return c;
	}



}
