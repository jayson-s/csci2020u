package gui;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Font;    

public class FontDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new StackPane();
        Circle circle = new Circle();
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(new Color(0.5,0.5,0.5,.1));
        
        pane.getChildren().add(circle);
        Label label = new Label("JavaFx");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD,FontPosture.ITALIC,20));
  
        pane.getChildren().add(label);
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Font Demo");
        primaryStage.show();
    }
}