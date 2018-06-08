package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	private Stage primaryStage;
	
	@SuppressWarnings("static-access")
	@Override
	public void start(Stage primaryStage) {
		 try {
			 
			 this.primaryStage = primaryStage;
			 this.primaryStage.setTitle("Ticket Bestellen Live Demo");
			 System.out.println("Class Path :");
			
			 System.out.println(getClass().getResource("/application/Gui_Demo.fxml").getPath());
			 
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(getClass().getResource("/application/Gui_Demo.fxml"));
	          //  loader.setController(basicCTRL);
	            Object rootLayout = loader.load();
	            
	            // Show the scene containing the root layout.
	            Scene scene = new Scene((Parent) rootLayout);
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public static void main(String[] args) {
		
		launch(args);
		new Controller();
		
	}
}
