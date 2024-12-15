package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML private Pane drawingAreaPane;
    @FXML private RadioButton penButton;
    @FXML private RadioButton eraserButton;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
    
    @FXML
    void penSelected(MouseEvent event) {
    	penButton.setSelected(true);
    }
    
    @FXML
    void eraserSelected(MouseEvent event) {
    	eraserButton.setSelected(true);
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Color ink;
    	if (penButton.isSelected()) {
    		ink = Color.BLACK;
    	} else {
    		ink = Color.WHITE;
    	}
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, ink);
    	drawingAreaPane.getChildren().add(newCircle);
    }

}