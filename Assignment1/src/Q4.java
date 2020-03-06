import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Q4 extends Application {
    @Override
    //Set stages and scenes and panes
    public void start(Stage primaryStage) {
        Histogram histogram = new Histogram();
        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.setHgap(5);
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(0, 10,10, 10));
        pane.setCenter(histogram);
        pane.setBottom(grid);
        //set objects
        TextField file = new TextField();
        file.setPrefColumnCount(60);
        Button view = new Button("View");
        //add objects to pane
        grid.add(new Label("File-name:"), 0, 0);
        grid.add(file, 1, 0);
        grid.add(view, 2, 0);
        //set action for when button pressed
        file.setOnAction(e -> histogram.setCounts(file.getText()));
        view.setOnAction(e -> histogram.setCounts(file.getText()));

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question 4 Solution");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    //histogram class to count occurences and display graph
    public class Histogram extends Pane {
        private double[] counts = new double[26];
        public Histogram() {
            setPrefWidth(800);
            setPrefHeight(500);
        }
        public void setCounts(String filename) {
            try (Scanner input = new Scanner(new File(filename))) {
                while(input.hasNext()) {
                    String word = input.next();
                    for(int i = 0; i < word.length(); i++) {
                        char c = Character.toUpperCase(word.charAt(i));
                        if (c >= 'A' && c <= 'Z')
                            counts[c - 'A']++;
                    }
                }
                draw();
            } catch(FileNotFoundException ex) { }
        }
        private void normalize() {
            double sum = 0;
            for(int i = 0; i < counts.length; i++)
                sum += counts[i];
            for(int i = 0; i < counts.length; i++)
                counts[i] = counts[i] / sum;
        }
        private void draw() {
            getChildren().clear();
            normalize();
            int x = 10;
            double scale = 2.50;
            for(int i = 0; i < counts.length; i++) {
                Rectangle rec = new Rectangle(20, scale * getHeight() * counts[i]);
                rec.setX(x);
                rec.setY(getHeight() - rec.getHeight() - 30);
                rec.setFill(Color.WHITE);
                rec.setStroke(Color.BLACK);
                Text txt = new Text(x + rec.getWidth() / 2 - 3,
                        rec.getY() + rec.getHeight() + 20, Character.toString((char)(i + 'A')));
                getChildren().addAll(rec, txt);
                x += 30;
            }
        }
    }
}