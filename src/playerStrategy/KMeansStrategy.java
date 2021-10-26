package playerStrategy;
 


import java.util.ArrayList;

import model.Model;
import model.Point;
import model.Rectangle;

public class KMeansStrategy implements PlayerStrategy {
 
	/**
	 * Number of Clusters.
	 */
    private int NUM_CLUSTERS = 4;    
   
    private ArrayList<DoublePoint> points;
    private ArrayList<Point> points2d;
    private ArrayList<Cluster> clusters;
    public Model model;
    public ArrayList<ArrayList<DoublePoint>> clusterPoints = new ArrayList<ArrayList<DoublePoint>>();
    
    public ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
    /**
     * Constructs the strategy
     * @param model the model of the game.
     */
    public KMeansStrategy(Model model) {
    	this.model=model;
    	this.points = new ArrayList<DoublePoint>();
    	this.clusters = new ArrayList<Cluster>();    	
    }
    /**
     * Return the rectangles for the resolution of the game.
     */
    public ArrayList<Rectangle> getRectangles(){
    	return this.rectangles;
    }
    
   
    /**
     * Initializes the process
     */
    public void init() {
    	//Create  double Points
    	points2d = this.model.getPoints();
    	for(int i = 0; i<points2d.size(); i++) {
    		points.add(new DoublePoint( points2d.get(i).getX(), points2d.get(i).getY()));
    	}
    	
    	
    	//Create Clusters
    	//Set Random Centroids
    	for (int i = 0; i<NUM_CLUSTERS; i++) {
    		Cluster cluster = new Cluster(i);
    		DoublePoint centroid = DoublePoint.createRandomPoint(1,10);
    		cluster.setCentroid(centroid);
    		clusters.add(cluster);
    	}
    	
    	 calculate();
    	
    }
    public ArrayList<Cluster> getClusters(){
    	return this.clusters;
    }
 
	
    
	/**
	 * The process to calculate the K Means, with iterating method.
	 */
    public void calculate() {
        boolean finish = false;
        
        // Add in new data, one at a time, recalculating centroids with each new one. 
        while(!finish) {
        	//Clear cluster state
        	clearClusters();
        	
        	ArrayList<DoublePoint> lastCentroids = getCentroids();
        	
        	//Assign points to the closer cluster
        	assignCluster();
            
            //Calculate new centroids.
        	calculateCentroids();
       
        	
        	ArrayList<DoublePoint> currentCentroids = getCentroids();
        	
        	//Calculates total distance between new and old Centroids
        	double distance = 0;
        	for(int i = 0; i<lastCentroids.size(); i++) {
        		distance += DoublePoint.distance(lastCentroids.get(i),currentCentroids.get(i));
        	}
        	if(distance == 0) {
        		finish = true;
        		
        	}
        }
        
    }
    
    private void clearClusters() {
    	for(Cluster cluster : clusters) {
    		cluster.clear();
    	}
    }
    
    private ArrayList<DoublePoint> getCentroids() {
    	ArrayList<DoublePoint> centroids = new ArrayList<DoublePoint>(NUM_CLUSTERS);
    	for(Cluster cluster : this.clusters) {
    		DoublePoint aux = cluster.getCentroid();
    		DoublePoint point = new DoublePoint(aux.getX(),aux.getY());
    		centroids.add(point);
    	}
    	return (ArrayList<DoublePoint>) centroids;
    }
    
    private void assignCluster() {
        double max = Double.MAX_VALUE;
        double min = max; 
        int cluster = 0;                 
        double distance = 0.0; 
        
        for(DoublePoint point : points) {
        	min = max;
            for(int i = 0; i< NUM_CLUSTERS; i++) {
            	Cluster c = clusters.get(i);
                distance = DoublePoint.distance(point, c.getCentroid());
                if(distance < min){
                    min = distance;
                    cluster = i;
                }
            }
           point.setCluster(cluster);
            clusters.get(cluster).addPoint(point);
        }
        
    }
    
    private void calculateCentroids() {
        for(Cluster cluster : clusters) {
            double sumX = 0;
            double sumY = 0;
            ArrayList<DoublePoint> list = (ArrayList<DoublePoint>) cluster.getPoints();
            int n_points = list.size();
            
            for(DoublePoint point : list) {
            	sumX += point.getX();
                sumY += point.getY();
            }
            
            DoublePoint centroid = cluster.getCentroid();
            if(n_points > 0) {
            	double newX = sumX / n_points;
            	double newY = sumY / n_points;
                centroid.setX(newX);
                centroid.setY(newY);
            }
        }
    }
    /**
     * Calculates Rectangles by searching for the smallest and biggest x and y that the points of the cluster have and
     * puts them as the new rectangle's coordinates.
     * @param cluster
     * @return
     */
    public Rectangle calculateRectangles(Cluster cluster) {
    	if(cluster.getPoints().size()!=0) {
    	int minX = 10000;
    	int minY = 10000;
    	int maxX= 0;
    	int maxY=0;
    	
    	for(int i =0; i<cluster.getPoints().size(); i++) {
    		
    		if ( cluster.getPoints().get(i).getX() < minX) {
    			minX= (int) cluster.getPoints().get(i).getX();}
    		if ( cluster.getPoints().get(i).getY() < minY) {
    			minY= (int) cluster.getPoints().get(i).getY() ;
    		}
    	
    			
    		if ( cluster.getPoints().get(i).getX() > maxX ){
    			maxX= (int) cluster.getPoints().get(i).getX();}
    		if( cluster.getPoints().get(i).getY() > maxY) {
    			maxY= (int) cluster.getPoints().get(i).getY() ;
    		}
    	}
    	Point startPoint = new Point(minX, minY);
    	Point endPoint = new Point(maxX+5, maxY+5);
    	Rectangle rectangle = new Rectangle(startPoint, endPoint);
    	return rectangle;
    	}
		return null;

    }
    /**
     * Calculating rectangles for different clusters.
     */
    public void solveGame(){
    	
    	for(int i = 0; i<this.clusters.size(); i++) {
    		Rectangle rectangle = calculateRectangles(clusters.get(i));
    		this.rectangles.add(rectangle);
    	}
    
    }
    /**
     * Calculates the score achieved by the strategy.
     */
    public double getScore() {
    	int sum = 0;
    	for(Rectangle form: this.rectangles) {
    		if(form !=null) {
    		sum+= form.getSurface();}
    	}
    	return  (sum/Model.PANEL_SURFACE);
    }
}