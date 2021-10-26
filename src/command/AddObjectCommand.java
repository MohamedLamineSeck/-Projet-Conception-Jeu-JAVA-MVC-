package command;

import model.*;
import view.GUIGame;
import view.ViewObject;
public class AddObjectCommand implements OperationCommand{

	ViewObject object;
	Model model;

    /**
     * Constructs a new Add object command.
     *
     * @param object the object to be added.
     * @param model the model of the game.
     */
	public AddObjectCommand(ViewObject object, Model model) {
		this.object=object;
		this.model=model;
	}
	
	/**
	 * Method that put the new object in the list of forms and it's viewComponent in the list of objects.
	 */
	
	@Override
	public void operate() {
		
		GUIGame.objects.add(this.object);
		this.model.addForme(this.object.getObject());
		
	}

	/**
	 * Method that remove the object form both lists.
	 */
	@Override
	public void compensate() {
		
		GUIGame.objects.remove(this.object);
		this.model.removeForm(this.object.getObject());
	}

}
