package gui;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.Scene;

public class NodeStyleRoateDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane pane = new StackPane();
        Button btOK = new Button("ok");
        btOK.setStyle("-fx-border-color: blue ; -fx-text-fill:red");    
        
        pane.getChildren().add(btOK);    
        pane.setRotate(45);
        pane.setStyle("-fx-border-color: red ; -fx-background-color: lightGray");
        
        Scene scene = new Scene(pane, 200,200);
        primaryStage.setTitle("Nodestyle");
        primaryStage.setScene(scene);
        primaryStage.show();
    
    }

}