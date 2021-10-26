package strategy;

import java.util.ArrayList;

import model.Point;

public class RandomStrategy implements Strategy{
	
	ArrayList<Point> points = new ArrayList<Point>();
	@Override
	/**
	 * Creates random points.
	 */
	public void dispatchPoints() {
		for(int i=0; i<50; i++) {
			 int x = (int) (Math.random()*750);
			 int y = (int) (Math.random()*390);
			 points.add(new Point(x, y));
		 }
	}
	/**
	 * return the points created by dispatchPoints.
	 */
	public ArrayList<Point> getPoints(){
		return this.points;
	}
}
