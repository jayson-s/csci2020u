import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Q3 extends Application {
    @Override
    public void start(Stage primaryStage) {
        //setup pane, stage, and scene
        Pane pane = new Setup();
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Question 3 Solution");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    //Superclass setup intializing all instances of circles, lines, and text for angles
    public static class Setup extends Pane{
        private Circle mainCircle, circle1, circle2, circle3;
        private double radius = 12.50;
        private Line line1 = new Line();
        private Line line2 = new Line();
        private Line line3 = new Line();
        private Text text1 = new Text();
        private Text text2 = new Text();
        private Text text3 = new Text();

        //Overloaded inner class to setup objects with attributes
        Setup() {
            setPadding(new Insets(5, 5, 5, 5));
            mainCircle = new Circle(200, 200, 150);
            circle1 = new Circle(150, 30, 8, Color.RED);
            circle2 = new Circle(75, 125, 8, Color.RED);
            circle3 = new Circle(225, 125, 8, Color.RED);
            //setting circle strokes and fills
            mainCircle.setFill(null);
            mainCircle.setStrokeWidth(1.50);
            mainCircle.setStroke(Color.BLUE);
            circle1.setStroke(Color.BLACK);
            circle2.setStroke(Color.BLACK);
            circle3.setStroke(Color.BLACK);
            //triangle circle vertices mapping onto main circle
            circle1.setCenterX(mainCircle.getCenterX() + mainCircle.getRadius() * Math.cos(1));
            circle1.setCenterY(mainCircle.getCenterY() - mainCircle.getRadius() * Math.sin(1));
            circle2.setCenterX(mainCircle.getCenterX() + mainCircle.getRadius() * Math.cos(2));
            circle2.setCenterY(mainCircle.getCenterY() - mainCircle.getRadius() * Math.sin(2));
            circle3.setCenterX(mainCircle.getCenterX() + mainCircle.getRadius() * Math.cos(3));
            circle3.setCenterY(mainCircle.getCenterY() - mainCircle.getRadius() * Math.sin(3));

            //bind triangle vertices to lines
            line1.startXProperty().bind(circle1.centerXProperty());
            line1.startYProperty().bind(circle1.centerYProperty());
            line1.endXProperty().bind(circle2.centerXProperty());
            line1.endYProperty().bind(circle2.centerYProperty());

            line2.startXProperty().bind(circle2.centerXProperty());
            line2.startYProperty().bind(circle2.centerYProperty());
            line2.endXProperty().bind(circle3.centerXProperty());
            line2.endYProperty().bind(circle3.centerYProperty());

            line3.startXProperty().bind(circle3.centerXProperty());
            line3.startYProperty().bind(circle3.centerYProperty());
            line3.endXProperty().bind(circle1.centerXProperty());
            line3.endYProperty().bind(circle1.centerYProperty());

            //bind angle texts to triangle vertices
            text1.layoutXProperty().bind(circle1.centerXProperty());
            text1.layoutYProperty().bind((circle1.centerYProperty().subtract(radius)));
            text2.layoutXProperty().bind(circle2.centerXProperty());
            text2.layoutYProperty().bind((circle2.centerYProperty().subtract(radius)));
            text3.layoutXProperty().bind(circle3.centerXProperty());
            text3.layoutYProperty().bind((circle3.centerYProperty().subtract(radius)));

            //call method when triangle vertices are clicked on and dragged
            clickAction(circle1);
            clickAction(circle2);
            clickAction(circle3);
            //update the angles displayed
            angleText();
            //add all objects to pane
            getChildren().addAll(mainCircle, line1, line2, line3, circle1, circle2, circle3, text1, text2, text3);
        }
        //Method for when triangle vertices are clicked on and dragged
        private void clickAction(Circle circ) {
            circ.setOnMouseDragged (e -> {
                double a = Math.PI / 2 - Math.atan2(e.getX() - mainCircle.getCenterX(), e.getY() - mainCircle.getCenterY());
                circ.setCenterX(mainCircle.getCenterX() + mainCircle.getRadius() * Math.cos(a));
                circ.setCenterY(mainCircle.getCenterY() + mainCircle.getRadius() * Math.sin(a));
                angleText();
            });
        }
        //Method for calculating and displaying angles as triangle vertices are dragged
        public void angleText() {
            double b = new Point2D(circle1.getCenterX(), circle1.getCenterY()).
                    distance(circle2.getCenterX(), circle2.getCenterY());
            double a = new Point2D(circle2.getCenterX(), circle2.getCenterY()).
                    distance(circle3.getCenterX(), circle3.getCenterY());
            double c = new Point2D(circle3.getCenterX(), circle3.getCenterY()).
                    distance(circle1.getCenterX(), circle1.getCenterY());

            double angle1 = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
            double angle2 = Math.acos((c * c - b * b - a * a) / (-2 * a * b));
            double angle3 = Math.acos((b * b - a * a - c * c) / (-2 * a * c));

            text1.setText(String.format("%.2f", Math.toDegrees(angle1)));
            text2.setText(String.format("%.2f", Math.toDegrees(angle2)));
            text3.setText(String.format("%.2f", Math.toDegrees(angle3)));
        }
    }
}