package state;

import command.DeleteObjectCommand;
import model.Model;
import model.Point;
import util.Controller;
import view.GUIGame;
import view.ViewObject;

public class DeleteState implements State{

	ViewObject object;
	Model model;
	
	public DeleteState(Model model) {
		this.model=model;
	}
	@Override
	public void mouseDragged(Point p) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Checking if the pressed point is contained by one of the object and than creating the DeleteCommand.
	 */
	@Override
	public void mousePressed(Point p) {
		
		for(ViewObject object: GUIGame.objects ) {
			if(object.getPoints().contains(p.getX(), p.getY())) {
				this.object=object;
				
			}
		}
		if(this.object != null) {
		Controller.handler.handle(new DeleteObjectCommand(this.object, model));
		}
		
	}
		

	@Override
	public void mouseReleased(Point p, Point p1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ViewObject make() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		return "delete";
	}

}
