package nestedcontrollerexample;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PersonViewer extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		Scene scene = new Scene(FXMLLoader.<Parent>load(getClass().getResource("PersonViewer.fxml")), 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
