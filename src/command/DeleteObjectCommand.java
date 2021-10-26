package command;

import model.Model;
import view.GUIGame;
import view.ViewObject;

public class DeleteObjectCommand implements OperationCommand{

	ViewObject object;
	Model model;
	/**
	 * Construct the Delete object command
	 * @param object object to be deleted.
	 * @param model the model of the game.
	 */
	public DeleteObjectCommand(ViewObject object, Model model) {
		this.object=object;
		this.model=model;
	}
	
	/**
	 * Override operate method that remove the form from the game's list of forms
	 */
	@Override
	public void operate() {
		
		this.model.removeForm(this.object.getObject());
		GUIGame.objects.remove(this.object);
		
		
	}
	/**
	 * Override method that add the form in the game's list of forms.
	 * 
	 */
	@Override
	public void compensate() {
		this.model.addForme(this.object.getObject());
		GUIGame.objects.add(this.object);
	}

}

