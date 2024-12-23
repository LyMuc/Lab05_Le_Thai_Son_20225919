package hust.soict.hedspi.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.event.ActionEvent;

// 20225651

public class PainterController {
    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton penRadioButton;
    @FXML
    private RadioButton eraserRadioButton;
    private Color currentColor = Color.BLACK;
    @FXML
    public void initialize() {
        ToggleGroup toolToggleGroup = new ToggleGroup();
        penRadioButton.setToggleGroup(toolToggleGroup);
        eraserRadioButton.setToggleGroup(toolToggleGroup);
    }
    @FXML
    public void drawingAreaMouseDragged(MouseEvent mouseEvent) {
        Circle newCircle = new Circle(mouseEvent.getX(), mouseEvent.getY(), 4, currentColor);
        drawingAreaPane.getChildren().add(newCircle);
    }
    @FXML
    public void clearButtonPressed(ActionEvent actionEvent) {
        drawingAreaPane.getChildren().clear();
    }
    @FXML
    public void penSelected(ActionEvent actionEvent) {
        currentColor = Color.BLACK;
    }
    @FXML
    public void eraserSelected(ActionEvent actionEvent) {
        currentColor = Color.WHITE;
    }
}