package command;

import model.*;
import view.GUIGame;
import view.ViewObject;
public class AdjustmentCommand implements OperationCommand{

	ViewObject object;
	ViewObject adjustObject;
	Model model;
	
	/**
	 * Construct new Adjustment command.
	 * @param object the object before the adjustment.
	 * @param adjustObject Object the adjusted object.
	 * @param model the model of the game.
	 */
	
	public AdjustmentCommand(ViewObject object, ViewObject adjustObject, Model model) {
		this.object=object;
		this.model=model;
		this.adjustObject = adjustObject;
	}
	
	/**
	 * Put the adjusted form in the list of forms and remove the old version. 
	 */
	@Override
	public void operate() {
		
		GUIGame.objects.add(this.adjustObject);
		this.model.addForme(this.adjustObject.getObject());
		
		GUIGame.objects.remove(this.object);
		this.model.removeForm(this.object.getObject());
		
	}
	/**
	 * Remove the adjusted form in the list of forms and put the old version. 
	 */
	@Override
	public void compensate() {
		
		GUIGame.objects.add(this.object);
		this.model.addForme(this.object.getObject());
		GUIGame.objects.remove(this.adjustObject);
		this.model.removeForm(this.adjustObject.getObject());
	}

}
