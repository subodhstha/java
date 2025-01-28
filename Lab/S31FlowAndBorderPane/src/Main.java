import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class S31FlowAndBorderPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a BorderPane layout
        BorderPane borderPane = new BorderPane();

        // Create a MenuBar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");

        fileMenu.getItems().addAll(openItem, saveItem, exitItem);
        menuBar.getMenus().add(fileMenu);

        // Add MenuBar to the top of the BorderPane
        borderPane.setTop(menuBar);

        // Create a FlowPane for buttons
        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(10));
        flowPane.setHgap(10);
        flowPane.setVgap(10);

        // Add buttons to the FlowPane
        for (int i = 1; i <= 5; i++) {
            Button button = new Button("Button " + i);
            flowPane.getChildren().add(button);
        }

        // Add FlowPane to the center of the BorderPane
        borderPane.setCenter(flowPane);

        // Create a Scene and set it on the Stage
        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setTitle("FlowPane and BorderPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
