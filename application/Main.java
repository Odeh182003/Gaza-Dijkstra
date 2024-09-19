package application;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class Main extends Application {
	//static GUIInterface gui;
	Button dijkstrabtn = new Button("Dijkstra");
    @Override
    public void start(Stage primaryStage) throws Exception {
    	try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,500);
			Label lbl = new Label("In Honor Of Our Heros We Wish You The Best");
			lbl.setFont(Font.font(18));
			root.setTop(lbl);
			root.setBottom(getMain());
			root.setCenter(getimage());
			 Stage stage = new Stage();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			dijkstrabtn.setOnAction(e->{
				 try {
					 GUIInterface	gui = new GUIInterface();
				      Scene sce = new Scene(gui.border, 1800, 750);
				      stage.setFullScreen(true);
				      stage.setScene(sce);
				      stage.show();
				//	primaryStage.setScene(new Scene(gui.border,950,650));
				//	primaryStage.setFullScreen(true);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
   

	private ImageView getimage() {
		ImageView img = new ImageView(new Image("C:\\Users\\odehl\\OneDrive\\Desktop\\Leen java Code\\DijkstraPhase3\\src\\application\\images.jpg"))	;
		img.setFitHeight(350);
		img.setFitWidth(400);
		img.setLayoutX(200);
		img.setLayoutY(200);
		return img;
		}
		//puts the button and Align the Scene
		private BorderPane getMain() {
			BorderPane pane = new BorderPane();
			HBox hbox = new HBox(10);
			hbox.setAlignment(Pos.BOTTOM_CENTER);
			pane.setBottom(hbox);
			dijkstrabtn.setPrefSize(200, 50);
			hbox.getChildren().addAll(dijkstrabtn);
			return pane;
		}
    public static void main(String[] args) {
        try {
            GUIInterface.readData("C:\\Users\\odehl\\OneDrive\\Desktop\\Leen java Code\\DijkstraPhase3\\src\\application\\LonLanTest");
            launch(args);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
