import javafx.application.Application;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StudentRecord extends Application {

    public TableView<Person> table = new TableView<Person>();
    public static ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person(100100100, 80.0f, 64.0f, 56.25f),
                    new Person(100100101, 70.0f, 66.55f, 51.5f),
                    new Person(100100102, 10.0f, 58.0f, 93.5f),
                    new Person(100100103, 90.0f, 84.5f, 68.75f),
                    new Person(100100104, 72.25f, 74.75f, 68.25f),
                    new Person(100100105, 80.0f, 56.0f, 62.5f),
                    new Person(100100106, 70.0f, 66.5f, 61.75f),
                    new Person(100100107, 58.0f, 47.0f, 50.5f),
                    new Person(100100108, 40.0f, 92.5f, 27.75f),
                    new Person(100100109, 82.5f, 77.0f, 74.25f)
            );
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Lab 05 Solution");
        stage.setWidth(650);
        stage.setHeight(370);
        final Label label = new Label("Student Records:");
        label.setFont(new Font("Arial", 20));
        table.setEditable(true);
        table.setMinWidth(600);
        table.setMaxHeight(270);

        TableColumn sidCol = new TableColumn("SID");
        sidCol.setMinWidth(100);
        sidCol.setCellValueFactory(
                new PropertyValueFactory<Person, Integer>("studentID"));

        TableColumn assCol = new TableColumn("Assignments");
        assCol.setMinWidth(100);
        assCol.setCellValueFactory(
                new PropertyValueFactory<Person, Float>("assignment"));

        TableColumn midCol = new TableColumn("Midterm");
        midCol.setMinWidth(100);
        midCol.setCellValueFactory(
                new PropertyValueFactory<Person, Float>("midterm"));

        TableColumn examCol = new TableColumn("Final Exam");
        examCol.setMinWidth(100);
        examCol.setCellValueFactory(
                new PropertyValueFactory<Person, Float>("finalExam"));

        TableColumn markCol = new TableColumn("Final Mark");
        markCol.setMinWidth(100);
        markCol.setCellValueFactory(
                new PropertyValueFactory<Person, Float>("mark"));

        TableColumn gradeCol = new TableColumn("Letter Grade");
        gradeCol.setMinWidth(100);
        gradeCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("grade"));

        table.setItems(data);
        table.getColumns().addAll(sidCol, assCol, midCol, examCol, markCol, gradeCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 20));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
    public static class Person {

        private final SimpleIntegerProperty studentID;
        private final SimpleFloatProperty assignment;
        private final SimpleFloatProperty midterm;
        private final SimpleFloatProperty finalExam;

        private Person(Integer sid, Float ass, Float mid, Float exam) {
            this.studentID = new SimpleIntegerProperty(sid);
            this.assignment = new SimpleFloatProperty(ass);
            this.midterm = new SimpleFloatProperty(mid);
            this.finalExam = new SimpleFloatProperty(exam);
        }

        public int getStudentID() {
            return studentID.get();
        }

        public void setStudentID(Integer sid) {
            studentID.set(sid);
        }

        public float getAssignment() {
            return assignment.get();
        }

        public void setAssignment(Float ass) {
            assignment.set(ass);
        }

        public float getMidterm() {
            return midterm.get();
        }

        public void setMidterm(Float mid) {
            midterm.set(mid);
        }

        public float getFinalExam() {
            return finalExam.get();
        }

        public void setFinalExam(Float exam) {
            finalExam.set(exam);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}