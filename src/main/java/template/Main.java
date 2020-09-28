package template;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The main entry point for this application.
 * This app serves as a template for creating JavaFX HTML GUI based applications.
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("FXML form GUI");

		Parent root = FXMLLoader.load(getClass().getResource("fxml_main.fxml"));

		Scene scene = new Scene(root, 600, 400);
		stage.setScene(scene);

		stage.show();
	}
}
