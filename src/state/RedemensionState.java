
package state;




import command.RedemensionCommand;
import model.Cercle;
import model.Model;
import model.Point;
import util.Controller;
import view.GUIGame;
import view.PanelClass;
import view.ViewCercle;
import view.ViewObject;

public class RedemensionState implements State {
	
	ViewObject object;
	
	ViewObject redemensionObject;
	
    Model model;

    /**
     * Constructor 
     * @param model of the game.
     */
	public RedemensionState(Model model) {
		this.model=model;
	}


	/**
	 * Method that check whether to object to be redimensioned is circle or rectangle.
	 */
	@Override
	public void mouseDragged(Point p) {
		
		if(this.redemensionObject!=null) {
		PanelClass.endDrag = p;
		
		if(this.redemensionObject instanceof ViewCercle) {
			cercleRedimension(p);}
		else {
		
		this.redemensionObject.getObject().setX2(p.getX());
		this.redemensionObject.getObject().setY2(p.getY());
		}
	}
	}
	/**
	 * Method that reposition the end point of the circle as well as the center.
	 */
   public void cercleRedimension(Point p ) {
		
		this.redemensionObject.getObject().setX2(this.redemensionObject.getObject().getX2()+ 2*(p.getX() - ((Cercle) this.redemensionObject.getObject()).getCenterX()));
		this.redemensionObject.getObject().setY2(this.redemensionObject.getObject().getY2()+ 2*(p.getX() - ((Cercle) this.redemensionObject.getObject()).getCenterX()));
		
		
		((Cercle) this.redemensionObject.getObject()).setCenterX(p.getX());
		((Cercle) this.redemensionObject.getObject()).setCenterY(p.getY());
		
	}

	@Override
	public void mouseReleased(Point p1, Point p2) {
		
		this.redemensionObject = null;
		
	}
	/**
	 * Checks if there has been object selected looping through the list of objects by comparing the pressed point with 
	 * the specific square that every object has and than calling the redemensionCommand.
	 */
	@Override
	public void mousePressed(Point p) {
	
		for(ViewObject object: GUIGame.objects ) {
			
			if(object.getPoints().contains(p.getX(), p.getY())) {
				this.object=object;
				this.redemensionObject = this.object.getObjectCopy();
			RedemensionCommand redemensionCommand = new RedemensionCommand(this.object,this.redemensionObject ,this.model);
			Controller.handler.handle(redemensionCommand);
			}
			break;
		}
		
	}

	@Override
	public ViewObject make() {
		return null;
	}

	public String toString() {
		return "redemension";
		
	}
	
	

}




