package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GUIInterface {
	     public BorderPane border = new BorderPane();
	    private  TextArea txtArea_result = new TextArea();
	    private  TextArea txtArea_path = new TextArea();
	    private static GraphWeighted<VertixCity> graph = new GraphWeighted<>();
	    private  byte selected = 0;
	    static ComboBox<String> sourcecomb;
	    static ComboBox<String> destcomb;
	    static CitiesData[] table;
	    List<VertixCity> countriesList = new ArrayList<>();
      public GUIInterface() throws Exception {
	 InputStream photoStream = new FileInputStream("C:\\Users\\odehl\\OneDrive\\Desktop\\Leen java Code\\DijkstraPhase3\\src\\application\\Capture.JPG");
      table = new CitiesData[graph.vertices.size()];
      int index = 0;
      for (VertixCity vertix : graph.vertices) {
          countriesList.add(vertix);
          table[index++] = new CitiesData();
      }
      fillTable();

      Image gazaMap = new Image(photoStream);
      ImageView view = new ImageView();
      view.setImage(gazaMap);
      view.setFitWidth(737);
      view.setFitHeight(872);
      border.getChildren().add(view);
      Label startlbl = new Label("Source: ");
      startlbl.setFont(Font.font(20));
      sourcecomb = new ComboBox<>();
      destcomb = new ComboBox<>();
      HBox hstart = new HBox(startlbl, sourcecomb);
      hstart.setSpacing(20);
      Label targetlbl = new Label("Destination:");
      targetlbl.setFont(Font.font(20));
   // First, get the city names using the readCityNamesFromFile method
      LinkedList<String> cityNames = readCityNamesFromFile("C:\\Users\\odehl\\OneDrive\\Desktop\\Leen java Code\\DijkstraPhase3\\src\\application\\LonLanTest");

   // Use the obtained cityNames list to populate the combo boxes
      sourcecomb.getItems().addAll(cityNames);
      destcomb.getItems().addAll(cityNames);

   // Now, associate the click events with your VertixCity objects
   for (VertixCity country : countriesList) {
       if (cityNames.contains(country.getName())) {
           // Display only cities (exclude streets)
           border.getChildren().add(country.stackPane);
           country.line.setVisible(false);
           country.c.setOnMouseClicked(e -> {
               if (selected == 0) {
            	   sourcecomb.setValue(country.getName());
                   selected++;
               } else {
            	   destcomb.setValue(country.getName());
                   selected = 0;
               }
           });
       }
   }



      HBox htarget = new HBox(targetlbl, destcomb);
      htarget.setSpacing(20);
      Button runbtn = new Button("Run");
      Button clearbtn = new Button("Clear");
      runbtn.setFont(Font.font(20));
      clearbtn.setFont(Font.font(20));
      HBox btn_box = new HBox(runbtn, clearbtn);
      btn_box.setSpacing(20);
      btn_box.setAlignment(Pos.CENTER);
      Label destlabel = new Label("Destance");
      destlabel.setFont(Font.font(20));
      txtArea_result.setPrefRowCount(5);
      txtArea_result.setPrefColumnCount(20);
      txtArea_result.setFont(Font.font(15));
      HBox desthbox = new HBox(destlabel, txtArea_result);
      desthbox.setSpacing(5);
      Label pathlabel = new Label("Path:");
      pathlabel.setFont(Font.font(20));
      txtArea_path.setPrefRowCount(5);
      txtArea_path.setPrefColumnCount(20);
      txtArea_path.setFont(Font.font(15));
      HBox pathhbox = new HBox(pathlabel, txtArea_path);
      pathhbox.setSpacing(5);
      ToggleGroup togroup = new ToggleGroup();
      RadioButton clickoption = new RadioButton("From Map");
	    clickoption.setToggleGroup(togroup);
	    clickoption.setFont(Font.font(20));
	    RadioButton comboption = new RadioButton("From Combo Box");
	    comboption.setFont(Font.font(20));
	    comboption.setToggleGroup(togroup);
	    togroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	          @Override
	          public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
	              if (togroup.getSelectedToggle() == clickoption) {
	                  // Disable ComboBoxes when "From Map" RadioButton is selected
	            	  sourcecomb.setDisable(true);
	            	  destcomb.setDisable(true);
	              } else {
	                  // Enable ComboBoxes for other RadioButtons
	            	  sourcecomb.setDisable(false);
	            	  destcomb.setDisable(false);
	              }
	          }
	      });
	    HBox radiohbox = new HBox(15);
	    radiohbox.getChildren().addAll(clickoption,comboption);
      VBox vbox = new VBox(radiohbox,hstart, htarget, btn_box, pathhbox,desthbox);
      vbox.setSpacing(50);
      border.setRight(vbox);
      border.setPadding(new Insets(40, 20, 20, 20));
      for (VertixCity city : countriesList) {
          if (cityNames.contains(city.getName())) {
              border.getChildren().add(city.c);
  
          }
         border.getChildren().add(city.line);
          city.line.setVisible(false);
      }
    
      readData("C:\\Users\\odehl\\OneDrive\\Desktop\\Leen java Code\\DijkstraPhase3\\src\\application\\LonLanTest");
      runbtn.setOnAction(e -> {
          try {
              OnStart();
          } catch (Exception exc) {
              exc.printStackTrace();
              System.out.println("Enter starting point and end point");
          }
      });
      clearbtn.setOnAction(e->{
    	  sourcecomb.getSelectionModel().clearSelection();
    	  destcomb.getSelectionModel().clearSelection();
 			txtArea_path.clear();
 			txtArea_result.clear();
 			 for (VertixCity city : countriesList) {
 				 city.line.setVisible(false);
 				 city.c.setFill(Color.BROWN);
 			 }

      });
}
private LinkedList<String> readCityNamesFromFile(String file)  {
    LinkedList<String> cityNames = new LinkedList<>();
     if(file != null) {
    	 try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	        String line;
    	        br.readLine();
    	        while ((line = br.readLine()) != null ) {
    	            String[] parts = line.split(",");
                    if (parts.length > 0 && parts[parts.length - 1].trim().equalsIgnoreCase("city")) {
    	                cityNames.addFirst(parts[0].trim());
    	            }
    	        }
    	    } catch (FileNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
     }
   
    return cityNames;
}

private void OnStart() {
    String start = sourcecomb.getValue();
    String end = destcomb.getValue();

    // Check if start and end vertices are valid
    VertixCity startVertex = getCountryByName(start);
    VertixCity endVertex = getCountryByName(end);
    
    if (startVertex == null || endVertex == null) {
        System.out.println("Invalid start or end vertex.");
        return;
    }

    Dijkstra(startVertex, endVertex, graph);

    StringBuilder path = new StringBuilder("");
    	 printPath(endVertex, path);
 	    txtArea_path.setText(path.toString());  
     int endVertexNum = endVertex.getNum();
   
         txtArea_result.setText("Distance to go from " + start + " to " + end + "\n=" + table[endVertexNum].getDistance() + "km");
    
	  
}

private void printPath(VertixCity start, StringBuilder builder) {
	if (table[start.getNum()].path != null) {
	    table[start.getNum()].path.line.setEndX(start.c.getTranslateX());
	    table[start.getNum()].path.line.setEndY(start.c.getTranslateY());
	    table[start.getNum()].path.line.setVisible(true);
	    table[start.getNum()].path.c.setFill(Color.BLUE);
	    printPath(table[start.getNum()].path, builder);
	    builder.append("to :");
	    // Set color for the current city as well
	    start.line.setVisible(true);
	    start.c.setFill(Color.BLUE);
	}
	if(table[start.getNum()].path == null) {
		builder.append("there is no path");
	   	txtArea_path.setText(builder.toString());
	   }else {
			builder.append(start + " Distance: " + table[start.getNum()].getDistance() + " km\n");
 
	   }
}

private void fillTable() {
    for (int i = 0; i < table.length; i++) {
        table[i] = new CitiesData();
        table[i].known = false;
        table[i].path = null;
        table[i].setDistance(Double.MAX_VALUE);
    }
}

private void Dijkstra(VertixCity start, VertixCity end, GraphWeighted<VertixCity> graph) {
    for (int i = 0; i < table.length; i++) {
        table[i].known = false;
        if (table[i].path != null) {
            table[i].path.line.setVisible(false);
            table[i].path.c.setFill(Color.BROWN);
        }
        table[i].path = null;
        table[i].setDistance(Double.MAX_VALUE);
    }

    PriorityQueue<Edge<VertixCity>> pq = new PriorityQueue<>();
    pq.add(new Edge<>(start, 0));
    table[start.getNum()].setDistance(0); 

    while (!pq.isEmpty()) {
        VertixCity u = pq.poll().getConnectedVertex();
       // System.out.println("Visiting: " + u.getName() + ", Distance: " + table[u.getNum()].getDistance());

        if (table[u.getNum()] != null && table[u.getNum()].known) {
            continue;
        }

        table[u.getNum()].known = true;

        if (u.equals(end)) {
            break;
        }

        neigbours(u, table, pq, graph);
    }
}

private void neigbours(VertixCity city, CitiesData[] table, PriorityQueue<Edge<VertixCity>> pq, GraphWeighted<VertixCity> graph) {
    double edgeDis = -1;
    double newDis = -1;
    int cityIndex = graph.vertices.indexOf(city);

    List<Edge<VertixCity>> neighbors = graph.edges.get(cityIndex);

    for (Edge<VertixCity> edge : neighbors) {
        VertixCity connectedVertex = edge.getConnectedVertex();
        int connectedVertexIndex = graph.vertices.indexOf(connectedVertex);

        // Check if connected vertex is present in graph.vertices
        if (connectedVertexIndex != -1) {
            // if current vertex hasn't been processed
            if (!table[connectedVertexIndex].known) {
                edgeDis = edge.getWeight();
                newDis = table[city.getNum()].getDistance() + edgeDis;

                // if new distance is cheaper
                if (newDis < table[connectedVertexIndex].getDistance()) {
                    table[connectedVertexIndex].setDistance(newDis);
                    table[connectedVertexIndex].path = city;
                }

                // Add current node to the queue
                pq.add(new Edge<>(connectedVertex, table[connectedVertexIndex].getDistance()));
            }
        }
    }
}

private VertixCity getCountryByName(String name) {
    for (VertixCity city : countriesList) {
        if (city.getName().equals(name)) {
            return city;
        }
    }
    return null;
}
private static double calculateDistance(VertixCity c1, VertixCity c2) {
    double loncity1 = Math.toRadians(c1.getLongitude());
    double latcity1 = Math.toRadians(c1.getLatitude());
    double loncity2 = Math.toRadians(c2.getLongitude());
    double latcity2 = Math.toRadians(c2.getLatitude());

    // Haversine Formula
    double dlon = loncity2 - loncity1;
    double dlat = latcity2 - latcity1;
    double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(latcity1) * Math.cos(latcity2) * Math.pow(Math.sin(dlon / 2), 2);
    double c = 2 * Math.asin(Math.sqrt(a));
    double r = 6371;
    double d = c * r;
   
    return d;
}


public static void readData(String fileName) {
    File file = new File(fileName);
    try (Scanner input = new Scanner(file)) {
        String numOfData = input.nextLine();
        String[] str = numOfData.split(",");
        int countries = Integer.valueOf(str[0]);
        int edges = Integer.valueOf(str[1]);
        int countriesRead = 0;
        int edgesRead = 0;

        while (input.hasNext()) {
            if (countriesRead < countries) {
                String countryData = input.nextLine();// to skip the numbers at the first line
                String[] tok = countryData.split(",");
                VertixCity coun = new VertixCity(tok[0].strip(), Double.parseDouble(tok[1].strip()),
                        Double.parseDouble(tok[2].strip()));
                graph.addVertices(coun);
                countriesRead++;
            } else if (edgesRead < edges) {
                String edgesData = input.nextLine();
                String[] tok = edgesData.split(",");
             //   System.out.println("Adding edge from: " + tok[0] + " to " + tok[1]);

                // Get the existing VertixCity instances from the graph
                VertixCity from = getVertixCityByName(graph, tok[0]);
                VertixCity to = getVertixCityByName(graph, tok[1]);

                if (from != null && to != null) {
                	//bidirectional
                    graph.addEdge(from, to, calculateDistance(from, to));
                    graph.addEdge(to, from, calculateDistance(to, from));

                    edgesRead++;
                } 
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error: No Data Was Entered");
    } catch (Exception e) {
        System.out.println("Formatting error");
        e.printStackTrace();
    }
}

private static VertixCity getVertixCityByName(GraphWeighted<VertixCity> graph, String name) {
    for (VertixCity vertex : graph.vertices) {
        if (vertex.getName().equals(name)) {
            return vertex;
        }
    }
    return null;
}


   }
