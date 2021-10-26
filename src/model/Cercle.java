
package model;

public class Cercle extends Form {

	public int centerX;
	public int centerY;
	

	public Cercle(Point startPoint, Point endPoint) {
		super(startPoint, endPoint);
		
		 setCenterX((int) ((startPoint.getX()+endPoint.getX())/2));
		 setCenterY((int) ((startPoint.getY()+endPoint.getY())/2));
	}

	/**
	 * 
	 * @return the coordinate x of the center.
	 */
	
	public int getCenterX() {
		return centerX;
	}


	/**
	 * Setter for the coordinate x of the center;
	 * @param centerX
	 */
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}


	/**
	 * 
	 * @return the coordinate y of the center.
	 */
	public int getCenterY() {
		return centerY;
	}

	/**
	 * Setter for the coordinate y of the center;
	 * @param centerY
	 */
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}




	/**
	 * Returns the surface occupied by the circle.
	 */
	@Override
	public double getSurface() {
		
		double r = Math.abs(this.x1-this.x2)/2;
		
		double surface = (int) (Math.PI * Math.pow(r, 2));
		
		return surface;
	}
	
	/**
	 * Return the name of the form.
	 */
	@Override
	protected String getName() {
		
		return "Cercle";
	}
    
}
