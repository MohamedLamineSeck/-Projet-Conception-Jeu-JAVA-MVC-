
package model;



import java.util.ArrayList;

import playerStrategy.KMeansStrategy;

import playerStrategy.PlayerStrategy;

import strategy.RectangleStrategy;
import strategy.Strategy;
import util.*;



@SuppressWarnings("exports")
public class Model implements Observable{
	
	public static final double PANEL_SURFACE = 200000;
	public boolean solve;
	
	//Variable used when repainting has to be done;
	public boolean isPainting = false;
	
	public Strategy strategy;
	
	public PlayerStrategy kmeans;
	
    public ArrayList<Form> forms;
    
	public ArrayList<Point> initialPoints;
    
    
	public ArrayList<Observer> observers = new ArrayList<Observer>();
    

    
	public ArrayList<Rectangle> rectangles;
    public Model(){
    	
    	forms = new ArrayList<Form>();
        initialPoints = new ArrayList<Point>();
        
        
        makeStrategy();
        makePlayerStrategy();
    	
        
    	
   }
    
    public boolean getIsPainting() {
    	return this.isPainting;
    	
    }
    
    public void setIsPainting(boolean b) {
    	this.isPainting=b;
    	notifyObserver(observers);
    }
    /**
     * Method that checks if the user clicked the solve button.
     * @return
     */
    
    public boolean getSolve() {
    	return this.solve;
    }
    public void setSolve(boolean solve) {
    	this.solve=solve;
    	notifyObserver(observers);
    }
   
    /**
     * 
     * @return rectangles created by the playerStrategy;
     */
    public ArrayList<Rectangle> getRectangles(){
    	return this.rectangles;
    }
    
    /**
     * Method that add form to the list of forms.
     * @param form to be added
     */
      
    public void addForme(Form form){
        this.forms.add(form);
        this.notifyObserver(observers);
       
    }
    /**
     * Removes form from the list of forms.
     * @param form to be removed
     */
    public void removeForm(Form form) {
    	this.forms.remove(form);
    	this.notifyObserver(observers);
    }
    /**
     * 
     * @return all the forms.
     */
    public ArrayList<Form> getForms(){
        return this.forms;
    }
    

	@Override
	public void addObserver(Observer obs) {
		this.observers.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.remove(obs);
		
	}

	@Override
	public void notifyObserver(Object obj) {
		for(Observer obs: this.observers) {
			obs.update(obj);
		}
		
	}
	
	/**
	 * Makes the strategy for the initial points.
	 */
	
	public void makeStrategy() {
		
		this.strategy = new RectangleStrategy();
		strategy.dispatchPoints();
		this.initialPoints = strategy.getPoints();
		
	}
	/**
	 * Method that creates the Player Strategy;
	 */
	
	public void makePlayerStrategy() {
		 this.kmeans = new KMeansStrategy(this);
	     this.kmeans.init();
	   
	     this.kmeans.solveGame();
	     this.rectangles = kmeans.getRectangles();
	}
	

	/**
	 * 
	 * @return it returns the initial points.
	 */
	public ArrayList<Point> getPoints() {
		
		return this.initialPoints;
	}
	/**
	 * Function that check if the user can or not draw another form knowing that the user can draw only 4 forms.
	 */

	public boolean isDrawingAllowed() {
		if (this.forms.size()<4){
			return true;
		}
		return false;
	}
	/**
	 * Method returning total sum of forms surfaces.
	 * 
	 */

	 public double getFormsSurface(ArrayList<Form> forms) {
	    	int sum = 0;
	    	for(Form form: forms) {
	    		
	    		sum+=form.getSurface();
	    	}
	    	return sum;
	    } 
	 
	 /**
	  * Method returning the score. The final score is the sum of surfaces divided by the surface of the game panel.
	  */
	public double getScore() {
		return getFormsSurface(this.forms)/PANEL_SURFACE;
	}

	/**
	 * 
	 * @return player's strategy in the resolution of the game.
	 */
	public PlayerStrategy getPlayerStrategy() {
		
		return this.kmeans;
	}
	
	
	

	
}
