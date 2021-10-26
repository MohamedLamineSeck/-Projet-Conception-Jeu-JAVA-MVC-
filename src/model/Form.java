package model;


public abstract class Form {
	
	public int x1;
	public int y1;
	public int x2;
	public int y2;

	public Point startPoint;

	public Point endPoint;
	
	public Form(Point startPoint, Point endPoint) {
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		
	}
/**
 * 
 * @return the start Point
 */
	public Point getStartPoint() {
		return this.startPoint;
	}
	/**
	 * 
	 * @return the end point.
	 */
	public Point getEndPoint() {
		return this.endPoint;
	}

	public void setStartPoint(Point point) {
		this.startPoint=point;
	}

	public void setEndPoint(Point point) {
		this.endPoint=point;
	}
	/**
	 * 
	 * @return the coordinate x of the start point.
	 */
	public int getX1() {
		return (int) this.startPoint.getX();
	}
	/**
	 * 
	 * @return the coordinate y of the start point.
	 */
	
	public int getY1() {
		return (int) this.startPoint.getY();
	}
	/**
	 * 
	 * @return the coordinate x of the end point.
	 */
	
	public int getX2() {
		return  (int) this.endPoint.getX();
	}
	/**
	 * 
	 * @return the coordinate y of the end point.
	 */
	public int getY2() {
		return (int) this.endPoint.getY();
	}
	public void setX1(int a) {
		this.startPoint.setX(a);
	}
	public void setY1(int b) {
		this.startPoint.setY(b);
	}
	
	public void setX2(int a) {
		this.endPoint.setX(a);
	}
	public void setY2(int b) {
		this.endPoint.setY(b);
	}
	
	public abstract double getSurface();
	
	
	protected abstract String getName();
}
