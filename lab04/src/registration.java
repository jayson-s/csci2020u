import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.time.*;

public class registration extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.getColumnConstraints().add(new ColumnConstraints(100));
        pane.getColumnConstraints().add(new ColumnConstraints(175));
        pane.getColumnConstraints().add(new ColumnConstraints(200));
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 20, 10, 20));
        pane.setVgap(5);
        pane.setHgap(5);

        DatePicker d = new DatePicker();
        d.setShowWeekNumbers(false);
        TextField user = new TextField();
        PasswordField pass = new PasswordField();
        TextField fName = new TextField();
        TextField email = new TextField();
        TextField phone = new TextField();

        pane.add(new Label("Username:"), 0, 0);
        pane.add(user, 1, 0);
        pane.add(new Label("Password:"), 0, 1);
        pane.add(pass, 1, 1);
        pane.add(new Label("Full Name:"), 0, 2);
        pane.add(fName, 1, 2);
        pane.add(new Label("E-Mail:"), 0, 3);
        pane.add(email, 1, 3);
        pane.add(new Label("Phone #:"), 0, 4);
        pane.add(phone, 1, 4);
        pane.add(new Label("Date of Birth:"), 0, 5);
        pane.add(d, 1, 5);

        Button btn = new Button("Register");
        pane.add(btn, 1, 6);
        GridPane.setHalignment(btn, HPos.LEFT);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("Username: " + user.getText());
                System.out.println("Password: " + pass.getText());
                System.out.println("Full Name: " + fName.getText());
                System.out.println("E-Mail: " + email.getText());
                System.out.println("Phone #: " + phone.getText());
                System.out.println("Date of Birth: " + d.getValue());
            }});

        final TextField textField = new TextField();
        textField.setManaged(false);
        textField.setVisible(false);
        CheckBox checkBox = new CheckBox("Show/Hide Password");
        textField.managedProperty().bind(checkBox.selectedProperty());
        textField.visibleProperty().bind(checkBox.selectedProperty());
        pass.managedProperty().bind(checkBox.selectedProperty().not());
        pass.visibleProperty().bind(checkBox.selectedProperty().not());
        textField.textProperty().bindBidirectional(pass.textProperty());
        pane.add(checkBox, 2, 6);
        GridPane.setHalignment(btn, HPos.LEFT);
        pane.add(textField, 1, 1);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Lab 04 Solution");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}