package ui;

import java.net.URL;
import java.util.Random;
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
    
    private Random rnd;
    
    private BattleMatrix matrix;

    @FXML
    void genarateAndMultiply(ActionEvent event) {
    	int number = 0;
    	try {
    		number = Integer.parseInt(matrices.getText());
    	}catch(NumberFormatException e){
    		Alert helpOne = new Alert(AlertType.INFORMATION);
        	helpOne.setContentText("Please enter a number");
        	helpOne.setTitle("Help");
        	
        	helpOne.show();
    	}
    	for (int i = 0; i < number; i++) {
			matrix = new BattleMatrix(rnd.nextInt(), rnd.nextInt());
		}
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
    	int rows = 0;
    	int columns = 0;
    	try {
    		rows = Integer.parseInt(rowMatrix.getText());
        	columns = Integer.parseInt(columnMatrix.getText());
        	
    	}catch(NumberFormatException e) {
    		Alert helpOne = new Alert(AlertType.INFORMATION);
        	helpOne.setContentText("Please enter a number");
        	helpOne.setTitle("Help");
        	
        	helpOne.show();
    	}
    	
    	matrix = new BattleMatrix(rows, columns);
    }

    @FXML
    void initialize() {
        
    }
}
