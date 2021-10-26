package strategy;



import java.util.ArrayList;
import java.util.Random;

import model.Point;

public class CercleStrategy implements Strategy{

	ArrayList<Point> points = new ArrayList<Point>();
	
	/**
	 * Creates random imaginary circles and than places points inside of them. 
	 */
	@Override
	public void dispatchPoints() {
		 Random random=new Random();
		 for(int i=0; i<12; i++) {
			int x = random.nextInt(500);
			int y = random.nextInt(350);
			int radius = random.nextInt((50-30) + 1) +30;
			
			for (int j= 0 ; j<10; j++) {
			 double a = Math.random() * 2 * Math.PI;
	            double r = radius * Math.sqrt(Math.random());
	            int x1 = (int) (r * Math.cos(a) + radius + x);
	            int y1 = (int) (r * Math.sin(a) + radius + y);
	            Point point = new Point(x1, y1);
	            this.points.add(point);
			}
		
	}
	
	}

	/**
	 * Return the points created by dispatchPoints.
	 */
	@Override
	public ArrayList<Point> getPoints() {
		
		return this.points;
	}
	

	
	

}
