package strategy;


import java.util.ArrayList;
import java.util.Random;

import model.Point;

public class RectangleStrategy implements Strategy{

	ArrayList<Point> points = new ArrayList<Point>();
	

	/**
	 * Creates random points in the rectangles created by makeTempRectangles.
	 */ 
	@Override
	public void dispatchPoints() {
		Random r = new Random();
		ArrayList<int[]> tempRectangles = makeTempRectangles();
		for(int[] rect: tempRectangles) {
			int x1 = rect[0];
			int x2 = rect[2];
			int y1 = rect[1];
			int y2 = rect[3];			
			for (int i=0; i<10; i++) {
				int x = r.nextInt((x2 - x1)+1)+ x1;
				int y = r.nextInt((y2 - y1)+1)  + y1;				
				Point point = new Point(x,y);
				points.add(point);
			}
			
			
		}
	}
	
	/**
	 * Function that provides temporary rectangles used to define initial points.
	 * 
	 */
	public ArrayList<int[]> makeTempRectangles() {
		 Random random=new Random();
		ArrayList<int[]> tempRectangles = new ArrayList<int[]>();
		
		for(int i=0; i<12; i++) {
			int x = random.nextInt(500);
			int y = random.nextInt(350);
			int p = x + random.nextInt((100 - 80) + 1) + 80;
			int q = y + random.nextInt((100 - 80) + 1) + 80;
			
			int[] list = new int[] {x,y,p,q};
			tempRectangles.add(list);
		}
		return tempRectangles;
	}
	/**
	 * Returns the list of points created by dispatchPoints function.
	 */
	@Override
	public ArrayList<Point> getPoints() {
		return this.points;
	}
	
	

}
