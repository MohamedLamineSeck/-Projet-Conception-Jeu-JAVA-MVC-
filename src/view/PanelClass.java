package view;

import model.*;
import util.Controller;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.RenderingHints;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;



@SuppressWarnings("exports")
public class PanelClass extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public static Point startDrag;
	
	public static Point endDrag;
	
	final int dim= 5;

	public ArrayList<Point> points;
	
	public ArrayList<Point> coveredPoints = new ArrayList<Point>();
	
	public Model model;
	public boolean solve = false;
	
	public ArrayList<ViewRectangle> rectangles = new ArrayList<ViewRectangle>();	
	
	 public PanelClass(Model model) {
		 this.model=model;
			this.setPreferredSize(new Dimension(500, 400));
	        this.setVisible(true);
	        this.points = model.getPoints();  
	        
	}
	

	 /**
	  * Method that paint the initial state of the panel.
	  */

	private void paintBackground(Graphics2D g2){
		this.coveredPoints.clear();
		paintInitialPoints(g2);
		
		if(GUIGame.objects.size()>=0) {
		  getCoveredPoints();
		  paintCoveredPoints(g2);}   
	 }
	/**
	 * Method that paint initial points made by the implemented Strategy.
	 */
	
	public void paintInitialPoints(Graphics2D g2) {
		
		 for (Point point: this.points) {
	    	  Rectangle2D rectangle = new Rectangle2D.Double(point.getX() , point.getY(), dim, dim);
	    	  g2.setPaint(Color.black);
	      	 g2.fill(rectangle);
	      }
	}
	
	/**
	 * Method painting the point that are covered by drawn forms.
	 */
	
	public void paintCoveredPoints(Graphics2D g2) {
	
			 for (Point point: this.coveredPoints) {
		    	  Rectangle2D rectangle = new Rectangle2D.Double(point.getX() , point.getY(), dim, dim);
		    	  g2.setPaint(Color.red);
		      	 g2.fill(rectangle);
	      }
	}
	
	
	
	
	public void paint(Graphics g) {
	      Graphics2D g2 = (Graphics2D) g;
	      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      paintForms(g2);
	      if(this.model.getSolve())
	    	  paintSolvedGameObject(g2);
	      paintBackground(g2);
	      // If there is object to be drawn the paint method is drawing in motion.
	     if (startDrag != null && endDrag != null &&!(Controller.state.toString()=="initial") && !(Controller.state.toString()=="adjustement") && !(Controller.state.toString()=="redemension")  && !(Controller.state.toString()=="delete")) { // TUka treba da napravish ako ne e vo adjustement state da moze da se crta sredi go toa i plus sredi redimension na site !
	        g2.setPaint(Color.LIGHT_GRAY);
	       ViewObject r = Controller.state.make();
	        r.draw(g2); 
	       
	      }   
	    }
	 
	 /**
	  * Method that checks if the points are covered by any of the forms drawn by the player.
	  */
	 public void getCoveredPoints() {
		  for (ViewObject s : GUIGame.objects) {
			  for (Point point: this.points ) {
				  if(s.getViewObject().contains(point.getX(), point.getY())) {
					  this.coveredPoints.add(point);
					
				  }
			  }
		  }
	 }
	 /**
	  * Method that paints the forms.
	  */
	 
	
	public void paintForms(Graphics2D g2) {
		

	      g2.setStroke(new BasicStroke(2));
	      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));

	      for (ViewObject s : GUIGame.objects) 
	      {
	    	 
	    	
	        g2.setPaint(Color.RED);
	        s.draw(g2);
	     
	      }
		 
	 }
	 /**
	  * Method that paint Forms calculated by the computer.
	  */
	
	public void paintSolvedGameObject(Graphics2D g2) {
		
		 for(int i = 0 ; i < this.model.getRectangles().size(); i++ ) {
			 if(this.model.rectangles.get(i) != null)
				 this.rectangles.add(new ViewRectangle(this.model.rectangles.get(i)));
		 }
		  g2.setStroke(new BasicStroke(2));
	      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));

	      for (ViewObject s : this.rectangles) 
	      {
	    	
	    	
	        g2.setPaint(Color.GREEN);
	        s.draw(g2);
	    	
	      }
	 }


	
}
	        

