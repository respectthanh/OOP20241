package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));
		
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("Painter.fxml"));
//		loader.setController(new PainterController());
//		Parent root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Painter");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}