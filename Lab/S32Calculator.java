import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class S32Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Create a TextField for displaying input and results
        TextField display = new TextField();
        display.setEditable(false);
        display.setPrefSize(200, 50);
        gridPane.add(display, 0, 0, 4, 1); // Spanning across 4 columns

        // Button labels for calculator
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        // Add buttons to the GridPane
        int row = 1; // Start from row 1 as row 0 is for the display
        int col = 0;
        for (String label : buttonLabels) {
            Button button = new Button(label);
            button.setPrefSize(50, 50);

            // Add button click handling
            button.setOnAction(e -> {
                String buttonText = button.getText();
                if (buttonText.equals("C")) {
                    display.clear(); // Clear display
                } else if (buttonText.equals("=")) {
                    try {
                        double result = evaluateExpression(display.getText());
                        display.setText(String.valueOf(result));
                    } catch (Exception ex) {
                        display.setText("Error");
                    }
                } else {
                    display.appendText(buttonText);
                }
            });

            gridPane.add(button, col, row);
            col++;
            if (col > 3) { // Move to the next row after 4 columns
                col = 0;
                row++;
            }
        }

        // Create the Scene and set it on the Stage
        Scene scene = new Scene(gridPane, 240, 300);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to evaluate a simple mathematical expression
    private double evaluateExpression(String expression) {
        return calculate(expression);
    }

    // Simple evaluator for basic mathematical expressions
    private double calculate(String expression) {
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);

            switch (operator) {
                case "+" -> result += operand;
                case "-" -> result -= operand;
                case "*" -> result *= operand;
                case "/" -> result /= operand;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
