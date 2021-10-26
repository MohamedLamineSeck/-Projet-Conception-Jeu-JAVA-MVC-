
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

import model.*;

import java.awt.geom.Rectangle2D;


@SuppressWarnings("exports")
public class ViewCercle implements ViewObject{
    Cercle cercle;
    Rectangle2D points;
    Ellipse2D viewCircle;
    /**
     * Construct of the view for the circle.
     * @param cercle The form of the circle.
     */
    public ViewCercle(Cercle cercle){
        this.cercle = cercle;
      
    }
   
    /**
     * Drawing method that paint the circle.
     */
	@Override
    public void draw(Graphics g) {
    	
    	int xStart = cercle.getX1();
    	int yStart= cercle.getY1();
    	
    	int xEnd = cercle.getX2();
    	int yEnd = cercle.getY2();
    	
    	
    	  Graphics2D g2 = (Graphics2D) g;
    	  
    	  this.points = new Rectangle2D.Double(cercle.getCenterX() , cercle.getCenterY() , 5, 5);
     	 g2.fill(points);
    	  g2.draw(makeCercle(xStart, yStart, xEnd, yEnd));
       
    }

	/**
	 * Method that creates the circle using {@link Ellipse2D}.
	 * @param xStart X coordinate of start Point
	 * @param yStart Y coordinate of the start Point
	 * @param xEnd  X coordinate of the end point.
	 * @param yEnd Y coordinate of the end point.
	 * @return
	 */
	private Ellipse2D.Double makeCercle(int xStart, int yStart, int xEnd, int yEnd) {
		this.viewCircle = new Ellipse2D.Double(Math.min(xStart, xEnd), Math.min(yStart, yEnd),Math.abs(xStart-xEnd), Math.abs(xStart-xEnd));
		
     	return (Double) this.viewCircle;
	
	}
	/**
	 * Return the circle form.
	 */
	@Override
	public Form getObject() {
		// TODO Auto-generated method stub
		return this.cercle;
	}

	/**
	 * Return the specific rectangle in the center of the circle used for adjustment redimension and deletion of the object.
	 */
	@Override
	public Rectangle2D getPoints() {
		// TODO Auto-generated method stub
		return this.points;
	}

	/**
	 * Return the view of the circle.
	 */
	@Override
	public Ellipse2D getViewObject() {
		// TODO Auto-generated method stub
		return this.viewCircle;
	}

	/**
	 * Creates and return a copy of the circle's view.
	 */
	@Override
	public ViewCercle getObjectCopy() {
		Cercle cercle = new Cercle(new Point(this.cercle.getX1(), this.cercle.getY1()), new Point( this.cercle.getX2(), this.cercle.getY2()));
		
		return new ViewCercle(cercle);
		
	}
    
}
