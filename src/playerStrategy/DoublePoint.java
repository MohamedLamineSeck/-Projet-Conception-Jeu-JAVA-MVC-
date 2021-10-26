package playerStrategy;


import java.util.Random;

public class DoublePoint {

    private double x = 0;
    private double y = 0;
    private int cluster_number = 0;
    
    /**
     * Construct point with double x and y.
     * @param x
     * @param y
     */
    public DoublePoint(double x, double y)
    {
        this.setX(x);
        this.setY(y);
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getX()  {
        return this.x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setCluster(int n) {
        this.cluster_number = n;
    }
    
    public int getCluster() {
        return this.cluster_number;
    }
    
    /**
     * Calculates the distance between two double points.
     * @param point
     * @param point2
     * @return
     */
    protected static double distance(DoublePoint point, DoublePoint point2) {
        return Math.sqrt(Math.pow((point2.getY() - point.getY()), 2) + Math.pow((point2.getX() - point.getX()), 2));
    }
    
    /**
     * Creates random double point
     * @param min 
     * @param max
     * @return
     */
    protected static DoublePoint createRandomPoint(int min, int max) {
    	Random r = new Random();
    	double x = min + (max - min) * r.nextDouble();
    	double y = min + (max - min) * r.nextDouble();
    	return new DoublePoint(x,y);
    }
 
    public String toString() {
    	return "("+x+","+y+")";
    }
}