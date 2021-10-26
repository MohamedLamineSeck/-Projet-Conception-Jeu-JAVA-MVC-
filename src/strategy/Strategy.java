package strategy;



import java.util.ArrayList;

import model.Point;

public interface Strategy {
	
	public void dispatchPoints();
	public ArrayList<Point> getPoints();
}
