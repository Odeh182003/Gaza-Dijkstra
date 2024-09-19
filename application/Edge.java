package application;

@SuppressWarnings("rawtypes")
public class Edge<T> implements Comparable<Edge> {
	private T connectedVertex;// Neighbor node
	private double weight;
	private T fromVertex;
    private T toVertex;
    public Edge(T fromVertex, T toVertex, double weight) {
        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = weight;
    }
	public Edge(T v, double w) {
		this.connectedVertex = v;
		this.weight = w;
	}

	public T getConnectedVertex() {
		return connectedVertex;
	}

	public void setConnectedVertex(T connectedVertex) {
		this.connectedVertex = connectedVertex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	

	@Override
	public String toString() {
		return "(" + connectedVertex + ";" + weight + ":In kilometers)\n";
	}

	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.weight, o.getWeight());
	}

}
