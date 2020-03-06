import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;

public class Q2 extends Application {
    //declare all textfields and button to be used within subclasses
    private TextField investmentAmount = new TextField();
    private TextField years = new TextField();
    private TextField interestRate = new TextField();
    private TextField futureValue = new TextField();
    private Button calculate = new Button("Calculate");

    @Override
    public void start(Stage primaryStage) {
        //declare layout to use
        GridPane pane = new GridPane();
        pane.setVgap(5); pane.setHgap(5);
        //add all objects and label to pane
        pane.add(new Label("Investment Amount"), 0, 0);
        pane.add(investmentAmount, 1, 0);
        pane.add(new Label("Years"), 0, 1);
        pane.add(years, 1, 1);
        pane.add(new Label("Annual Interest Rate"), 0, 2);
        pane.add(interestRate, 1, 2);
        pane.add(new Label("Future Value"), 0, 3);
        pane.add(futureValue, 1, 3);
        pane.add(calculate, 1, 4);
        //set alignment of all objects
        pane.setAlignment(Pos.CENTER);
        investmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
        years.setAlignment(Pos.BOTTOM_RIGHT);
        interestRate.setAlignment(Pos.BOTTOM_RIGHT);
        futureValue.setAlignment(Pos.BOTTOM_RIGHT);
        futureValue.setEditable(false);
        pane.setHalignment(calculate, HPos.RIGHT);
        pane.setPadding(new Insets(10, 10, 10, 10));
        //when button pressed, calculate future value by calling method
        calculate.setOnAction(e -> futureValue());
        //setup scene and stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Question 2 Solution");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    //Method to calculate future value by using user-
    //entered values in formula
    private void futureValue() {
        double investmentAmount = Double.parseDouble(this.investmentAmount.getText());
        int years = Integer.parseInt(this.years.getText());
        double monthlyInterestRate =
                Double.parseDouble(interestRate.getText()) / 1200;
        futureValue.setText(String.format("%.2f",
                (investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12))));
    }
}