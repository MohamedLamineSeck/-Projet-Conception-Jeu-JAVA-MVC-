
package model;


public class Rectangle extends Form {

	
	public Rectangle(Point startPoint, Point endPoint) {
		super(startPoint, endPoint);
	}
	/**
	 * Function that returns the surface of a rectangle in cm^2
	 * 
	 */
	
	public double getSurface() {
		
		double height = Math.abs(this.getX1() - this.getX2());
		double width = Math.abs(this.getY1() - this.getY2());
		return height*width;
		
	
	}

	/**
	 * Function that returns the name of the form.
	 */
	@Override
	protected String getName() {
		return "Rectangle";
	}
	
}
