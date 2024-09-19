package application;

public class CitiesData {
	boolean known;
	private double distance;
	VertixCity path;
	public VertixCity getPath() {
        return path;
    }

    public boolean isKnown() {
        return known;
    }
	public double getDistance() {
		double dis = (int) (distance * 100) / 100.0;
		return dis;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return path + " ";
	}

}
