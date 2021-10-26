package command;

import java.util.ArrayList;

public class CommandHandler {
	
	OperationCommand operation;

	
	ArrayList<OperationCommand> listeUndo;
	ArrayList<OperationCommand> listeRedo;
	
	/**
	 * Constructor that creates Command Handler 
	 */
	public CommandHandler() {
		this.listeUndo = new ArrayList<OperationCommand>();
		this.listeRedo = new ArrayList<OperationCommand>();
	}
	/**
	 *Method that handles the command and add to the list undo.
	 * @param command
	 */
	
	public void handle(OperationCommand command) {
		listeUndo.add(command);
		listeUndo.get(listeUndo.size()-1).operate();
		listeRedo.clear();
	}
	/**
	 * Method that undo the last handled command by its compensate method.
	 */
	public void undo() {
		if (!(listeUndo.size()==0)) {
		listeUndo.get(listeUndo.size()-1).compensate();
		listeRedo.add(listeUndo.get(listeUndo.size()-1));
		listeUndo.remove(listeUndo.size()-1);}
	}
	/**
	 * Method that undo the last command added to the redo list by its operate method .
	 */
	public void redo() {
		if (!(listeRedo.size()==0)) {
		listeRedo.get(listeRedo.size()-1).operate();
		listeUndo.add(listeRedo.get(listeRedo.size()-1));
		listeRedo.remove(listeRedo.size()-1);
		}
	}
	


}
