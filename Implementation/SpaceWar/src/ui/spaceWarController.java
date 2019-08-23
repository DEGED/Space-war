package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.BattleMatrix;

public class spaceWarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField rowMatrix;

    @FXML
    private TextField columnMatrix;

    @FXML
    private TextField rowCoefficient;

    @FXML
    private TextField columnCoefficient;

    @FXML
    private CheckBox repeat;

    @FXML
    private TextField matrices;

    @FXML
    private GridPane result;
    
    private BattleMatrix matrix;

    @FXML
    void genarateAndMultiply(ActionEvent event) {
    	  	
    }

    @FXML
    void helpOne(MouseEvent event) {
    	Alert helpOne = new Alert(AlertType.INFORMATION);
    	helpOne.setContentText("");
    	helpOne.setTitle("Help");
    	
    	helpOne.show();
    }

    @FXML
    void helpTwo(MouseEvent event) {
    	Alert helpTwo = new Alert(AlertType.INFORMATION);
    	helpTwo.setContentText("");
    	helpTwo.setTitle("Help");
    	
    	helpTwo.show();
    }

    @FXML
    void multiply(ActionEvent event) {
    	try {
    		int rows = Integer.parseInt(rowMatrix.getText());
        	int columns = Integer.parseInt(columnMatrix.getText());
        	matrix = new BattleMatrix(rows, columns);
    	}catch(NumberFormatException e) {
    		Alert helpOne = new Alert(AlertType.INFORMATION);
        	helpOne.setContentText("Stop Playing man, only freaking numbers");
        	helpOne.setTitle("Help");
        	
        	helpOne.show();
    	}
    }

    @FXML
    void initialize() {
        assert rowMatrix != null : "fx:id=\"rowMatrix\" was not injected: check your FXML file 'spaceWar.fxml'.";
        assert columnMatrix != null : "fx:id=\"columnMatrix\" was not injected: check your FXML file 'spaceWar.fxml'.";
        assert rowCoefficient != null : "fx:id=\"rowCoefficient\" was not injected: check your FXML file 'spaceWar.fxml'.";
        assert columnCoefficient != null : "fx:id=\"columnCoefficient\" was not injected: check your FXML file 'spaceWar.fxml'.";
        assert repeat != null : "fx:id=\"repeat\" was not injected: check your FXML file 'spaceWar.fxml'.";
        assert matrices != null : "fx:id=\"matrices\" was not injected: check your FXML file 'spaceWar.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file 'spaceWar.fxml'.";

    }
}
