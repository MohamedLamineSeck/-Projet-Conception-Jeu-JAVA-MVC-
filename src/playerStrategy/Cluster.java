package playerStrategy;

import java.util.ArrayList;


public class Cluster {
	
	public ArrayList<DoublePoint> points;
	public DoublePoint centroid;
	public int id;
	
	/**
	 * Creates a new Cluster
	 * @param id the number of the cluster
	 */
	public Cluster(int id) {
		this.id = id;
		this.points = new ArrayList<DoublePoint>();
		this.centroid = null;
	}

	public ArrayList<DoublePoint> getPoints() {
		return points;
	}
	
	public void addPoint(DoublePoint point) {
		points.add(point);
	}

	public void setPoints(ArrayList<DoublePoint> points) {
		this.points = points;
	}

	public DoublePoint getCentroid() {
		return centroid;
	}

	public void setCentroid(DoublePoint centroid) {
		this.centroid = centroid;
	}

	public int getId() {
		return id;
	}
	
	public void clear() {
		points.clear();
	}
	
	public ArrayList<DoublePoint> getCluster(){
		return this.points;
	}
	

}