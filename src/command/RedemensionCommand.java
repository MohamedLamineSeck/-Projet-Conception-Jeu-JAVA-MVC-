package command;

import model.*;
import view.GUIGame;
import view.ViewObject;
public class RedemensionCommand implements OperationCommand{

	ViewObject object;
	ViewObject redemensionObject;
	Model model;
	/**
	 * 
	 * @param object
	 * @param redemensionObject
	 * @param model
	 */
	public RedemensionCommand(ViewObject object, ViewObject redemensionObject, Model model) {
		this.object=object;
		this.model=model;
		this.redemensionObject = redemensionObject;
	}
	
	/**
	 * Put the adjusted form in the list of forms and remove the old version. 
	 */
	@Override
	public void operate() {
		
		GUIGame.objects.add(this.redemensionObject);
		this.model.addForme(this.redemensionObject.getObject());
		
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
		
		GUIGame.objects.remove(this.redemensionObject);
		this.model.removeForm(this.redemensionObject.getObject());
	}

}
