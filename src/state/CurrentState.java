package state;



import model.Point;
import view.ViewObject;

public class CurrentState implements State {
	
	State state;
	/**
	 * 
	 * Constructor of the current state declaring it InitialState at first.
	 */
	
	public CurrentState() {
		this.state = new InitialState();
	}
	
	public void setState( State state) {
		this.state= state;
	}
	
	public State getstate() {
		return this.state;
	}

	/**
	 * Calling the state mouse drag function.
	 */
	@Override
	public void mouseDragged(Point p) {
		this.state.mouseDragged(p);
		
	}
	/**
	 * Calling the state's mouse released function.
	 */
	@Override
	public void mouseReleased(Point p1, Point p2) {
		this.state.mouseReleased(p1, p2);
		
	}
	/**
	 * Calling the state's mouse pressed function.
	 */
	@Override
	public void mousePressed(Point p) {
		this.state.mousePressed(p);
		
	}
	/**
	 * Calling the state's make function.
	 */
	@Override
	public ViewObject make() {
		
		ViewObject object = this.state.make();
		return object;
	}

	public String toString() {
		return this.state.toString();
	}
	

	
}
