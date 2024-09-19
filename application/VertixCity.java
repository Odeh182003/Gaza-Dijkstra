package application;

import java.util.LinkedList;
import java.util.List;

//import java.util.Objects;

import javafx.scene.control.Tooltip;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class VertixCity {
private  String name;
private double latitude;
private double longitude;
private String status;
Circle c;
Tooltip toolTipTxt;
private int i;
 Line line;
 StackPane stackPane = new StackPane();
 Text cityNameText;
 private List<Edge<VertixCity>> edges = new LinkedList<>();
 public VertixCity(String name, double latitude, double longitude) {
	    super();
	    this.name = name;
	    this.latitude = latitude;
	    this.longitude = longitude;
	    createCircle();
        this.edges = new LinkedList<>();

	}

	public VertixCity(String name) {
	    this.name = name;
	    createCircle();
        this.edges = new LinkedList<>();

	}

public VertixCity(String name, double latitude, double longitude,String status) {
	super();
	this.name = name;
	this.latitude = latitude;
	this.longitude = longitude;
	this.status=status;
}
public  String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getLatitude() {
	return latitude;
}
public void setLatitude(double latitude) {
	this.latitude = latitude;
}
public double getLongitude() {
	return longitude;
}
public void setLongitude(double longitude) {
	this.longitude = longitude;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getNum() {
	return i;
}
public void setNum(int i) {
	this.i = i;
}
public void newCountry(int num) {
	this.i = num;
}
public void addEdge(Edge<VertixCity> edge) {
    edges.add(edge);
}

// Add a method to get the list of edges
public List<Edge<VertixCity>> getEdges() {
    return edges;
}

private void placeOnMap() {
    // Assuming that org_xMin, org_xMax, org_yMin, and org_yMax are the boundaries of your map
    double org_xMin = 34.1707489947603;
    double org_xMax = 34.575060834817954;
    double org_yMin = 31.208163033163977;
    double org_yMax = 31.614521165206845;

    // Calculate the x and y positions based on the map boundaries
    double xPosition = (737.0 / (org_xMax - org_xMin)) * (this.longitude - org_xMin);
    double yPosition = (872.0 / (org_yMax - org_yMin)) * (org_yMax - this.latitude);

    // Set the translation properties for the object 'c'
    c.setTranslateX(xPosition);
    c.setTranslateY(yPosition);

    // Set the translated coordinates for the line (if needed)
    line.setStartX(xPosition);
    line.setStartY(yPosition);

    // Set the translated coordinates for the Text node based on the circle's position
    cityNameText.setTranslateX(xPosition + 5); 
    cityNameText.setTranslateY(yPosition - 5); 
}



private void createCircle() {
    line = new Line();
    cityNameText = new Text(this.name);
    line.toFront();
    line.setStroke(Color.BLACK);
    line.setStrokeWidth(2);
    c = new Circle(3);
    c.setFill(Color.BROWN);
    c.setTranslateZ(4);
    placeOnMap();
    line.setStartX(c.getTranslateX());
    line.setStartY(c.getTranslateY());
    line.setEndX(c.getTranslateX());  
    line.setEndY(c.getTranslateY());

    // Create and position the Text node
    cityNameText.setFill(Color.BLACK);
    placeOnMap();
   
    Tooltip toolTipTxt = new Tooltip(this.name);
    // Setting the tool tip to the text field
    Tooltip.install(c, toolTipTxt);

    c.setOnMouseEntered(e -> {
        c.setRadius(10);
    });
    c.setOnMouseExited(e -> {
        c.setRadius(3);
    });

    // Create a StackPane to hold both the Circle and Text
    stackPane.getChildren().addAll(c, cityNameText);

    
}


public Line getLine() {
    return line;
}
@Override
public String toString() {
	return name ;
}
/*public void removeEdge(VertixCity vertex) {
    // Your logic to remove the edge between this vertex and the specified vertex
    Edge<VertixCity> edgeToRemove = null;

    for (Edge<VertixCity> edge : edges) {
        if (edge.getConnectedVertex().equals(vertex)) {
            edgeToRemove = edge;
            break;
        }
    }

    if (edgeToRemove != null) {
        edges.remove(edgeToRemove);
    }
}
public boolean hasEdge(VertixCity vertex) {
    for (Edge<VertixCity> edge : edges) {
        if (edge.getConnectedVertex().equals(vertex)) {
            return true;
        }
    }
    return false;
}*/

/*public boolean equals(VertixCity obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    VertixCity otherCity = (VertixCity) obj;
    return Objects.equals(name, otherCity.name) &&
           Double.compare(otherCity.latitude, latitude) == 0 &&
           Double.compare(otherCity.longitude, longitude) == 0;
}

@Override
public int hashCode() {
    return Objects.hash(name, latitude, longitude);
}*/

}
