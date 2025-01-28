// 33. Create a form with Label, TextField, Button, and CheckBox. Display the
// entered data on a button click.
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class S33Form extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create labels and input fields
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        
        Label subscribeLabel = new Label("Subscribe to newsletter:");
        CheckBox subscribeCheckBox = new CheckBox();

        // Create a button to submit the form
        Button submitButton = new Button("Submit");
        Label resultLabel = new Label();

        // Handle button click
        submitButton.setOnAction(event -> {
            String name = nameField.getText();
            String email = emailField.getText();
            boolean isSubscribed = subscribeCheckBox.isSelected();

            // Display the entered data
            String result = "Name: " + name + "\nEmail: " + email + "\nSubscribed: " + (isSubscribed ? "Yes" : "No");
            resultLabel.setText(result);
        });

        // Layout
        VBox layout = new VBox(10); // Vertical box layout with spacing
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
            nameLabel, nameField,
            emailLabel, emailField,
            subscribeLabel, subscribeCheckBox,
            submitButton, resultLabel
        );

        // Create the Scene and add it to the Stage
        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setTitle("Form Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
