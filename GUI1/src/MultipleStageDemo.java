import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MultipleStageDemo extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene (new Button("OK"), 200, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MyJavaFX");
		primaryStage.show();
		
		Stage stage = new Stage();
		stage.setScene(new Scene(new Button("New Stage Button"), 200, 200));
		stage.setTitle("Second Stage");
		stage.show();
	}
}