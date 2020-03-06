import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.*;

public class Q1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        //setup HBox layout
        HBox hBox = new HBox(5);
        hBox.setPadding(new Insets(5, 5, 5, 5));

        //initialize boxes for cards
        int numBoxes = 3;
        ArrayList<Integer> cards = randCards();
        //retrieve card images from specified directory
        for(int i = 0; i < numBoxes; i++){
            hBox.getChildren().add(new ImageView(new Image("image/card/" + cards.get(i) + ".png", 200, 300, false, false)));
        }
        //setup scene & stage
        Scene scene = new Scene(hBox, 620, 315);
        primaryStage.setTitle("Question 1 Solution");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Method which randomizes/shuffles the cards each time
    private ArrayList<Integer> randCards(){
        ArrayList<Integer> cards = new ArrayList<>();
        int numCards = 52;
        for(int i = 0; i < numCards; i++){
            cards.add(i + 1);
        }
        Collections.shuffle(cards);
        return cards;
    }
}