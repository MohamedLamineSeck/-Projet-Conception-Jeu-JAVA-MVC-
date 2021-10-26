package playerStrategy;


import java.util.ArrayList;

import model.Model;
import model.Point;
import model.Rectangle;

public class NaiveStrategy implements PlayerStrategy{

	public Model model;
	public ArrayList<DoublePoint> points;
	
	private ArrayList<Rectangle> rectangles= new ArrayList<Rectangle>();
	private ArrayList<Point> points2d;
	
	public NaiveStrategy(Model model) {		
		this.model=model;
		this.points = new ArrayList<DoublePoint>();
		
	}
	/**
	 * Initialize the strategy by converting the points in DoublePoint
	 */
	@Override
	public void init() {
		points2d = this.model.getPoints();
    	for(int i = 0; i<points2d.size(); i++) {
    		points.add(new DoublePoint((int) points2d.get(i).getX(), (int) points2d.get(i).getY()));
    	}
    
	
		
	}
	/**
	 * Solving the game by searching for the smallest x and y as the start point
	 * and the biggest x and y as the end point.
	 */

	@Override
	public void solveGame() {
		int minX = 10000;
    	int minY = 10000;
    	int maxX= 0;
    	int maxY=0;
    	
    	for(int i =0; i<this.points.size(); i++) {
    		
    		if ( this.points.get(i).getX() < minX) {
    			minX= (int) this.points.get(i).getX();}
    		if ( this.points.get(i).getY() < minY) {
    			minY= (int) this.points.get(i).getY() ;
    		}
    	
    			
    		if (this.points.get(i).getX() > maxX ){
    			maxX= (int) this.points.get(i).getX();}
    		if( this.points.get(i).getY() > maxY) {
    			maxY= (int) this.points.get(i).getY() ;
    		}
    	}
    	Point startPoint = new Point(minX, minY);
    	Point endPoint = new Point(maxX+5, maxY+5);
    	Rectangle rectangle = new Rectangle(startPoint, endPoint);
    	this.rectangles.add(rectangle);
    
	}

	/**
	 * Returns the rectangle.
	 */
	@Override
	public ArrayList<Rectangle> getRectangles() {
		return this.rectangles;
	}
	/**
	 * Returns the score achieved by the strategy.
	 */
	@Override
	public double getScore() {
		int sum = 0;
    	for(Rectangle form: this.rectangles) {
    		if(form !=null) {
    		sum+= form.getSurface();}
    	}
    	return  (sum/Model.PANEL_SURFACE);
	}

}
