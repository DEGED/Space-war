package ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.BattleMatrix;

public class spaceWarController{

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
    
    private ArrayList<BattleMatrix> matrixs;
    
    private ArrayList<BattleMatrix> oldBattleMatrix;
    
    
    public boolean operable(int columnsA, int rowsB) {
    	boolean retu = false;
    	if(columnsA == rowsB) {
    		retu = true;
    	}
    	System.out.println("comprobando si son operables");
    	return retu;
    }

    public int[][] coeficientMatrix( int rowsCoe , int columns){
    	int[][] retu = new int[rowsCoe][columns];
    	for (int i = 0; i < retu.length; i++) {
			for (int j = 0; j < retu[i].length; j++){	
				int e = rnd.nextInt(5)+1;
				retu[i][j] = e;
			}
		}
    	return retu;
    }
    @FXML
    void genarateAndMultiply(ActionEvent event) {
    	int number = 0;
    	try{
    		number = Integer.parseInt(matrices.getText());
    	}catch(NumberFormatException e){
    		Alert helpOne = new Alert(AlertType.INFORMATION);
        	helpOne.setContentText("Please enter a number");
        	helpOne.setTitle("Help");
        	
        	helpOne.show();
    	}
    	multiplyManyMatrices(number);
    	
    }
    
    public void multiplyManyMatrices(int number) {
    	int cont = 0;
    	
    	int[][] battleMatrix = new int[5][5];
    	BattleMatrix battle = new BattleMatrix(true, 5, 5);
    	int[][] coefients = coeficientMatrix(5, 5);
    	oldBattleMatrix.add(battle);
    	while(cont<number) {
        	int[][] oldbattle = oldBattleMatrix.get(cont).getMatrix();	
        	System.out.println("nueva matriz agregada");
        		for (int i = 0; i < battleMatrix.length; i++){
        			for (int j = 0; j < battleMatrix[i].length; j++){
        				for (int k = 0; k < battleMatrix[0].length; k++){
        					battleMatrix[i][j] += oldbattle[i][k]*coefients[k][j];
    					}
        			}
        		}
        		BattleMatrix battleGeneric = new BattleMatrix(true, 5, 5);
        		battleGeneric.setMatrix(battleMatrix);
        		oldBattleMatrix.add(battleGeneric);
        	cont++;
    	}
    	fill(battleMatrix);
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
    	int coeficientRow = 0;
    	int coeficientColumn = 0;
    	boolean repeat2 = repeat.isSelected();
    	try{
    		rows = Integer.parseInt(rowMatrix.getText());
        	columns = Integer.parseInt(columnMatrix.getText());
        	coeficientRow = Integer.parseInt(rowCoefficient.getText());
        	coeficientColumn = Integer.parseInt(columnCoefficient.getText());
    	}catch(NumberFormatException e){
    		//alerta
    	}
    	simpleMultiply(repeat2, rows, columns, coeficientRow, coeficientColumn);
    }
    
    public void simpleMultiply(boolean repeat2, int rows, int columns, int coeficientRow, int coeficientColumn) {
    	BattleMatrix battle = new BattleMatrix(repeat2, rows, columns);
    	int[][] coefients = coeficientMatrix(coeficientRow, coeficientColumn);
    	int[][] oldbattle = battle.getMatrix();
    	int[][] battleMatrix = new int[rows][coeficientColumn];
    	
    	if(operable(rows, coeficientColumn)==true){
    		for (int i = 0; i < battleMatrix.length; i++){
    			for (int j = 0; j < battleMatrix[i].length; j++){
    				for (int k = 0; k < battleMatrix[0].length; k++) {
    					
    					battleMatrix[i][j] += oldbattle[i][k]*coefients[k][j];
					}
    			}
    		}
    	}else {
    		System.out.println("esa monda no se puede");
    	}
    	
    	fill(battleMatrix);
    }
    
    public void fill(int[][]battleMatrix) {
    	result.getChildren().clear();
    	
    	for (int i = 0; i < battleMatrix.length; i++) {
			for (int j = 0; j < battleMatrix[i].length; j++) {
				int n = battleMatrix[i][j];
				if(primeNumber(n)) {
					Image img = new Image("ui\\ship.png");
					ImageView im = new ImageView(img);
					im.setFitHeight(50);
					im.setFitWidth(50);
					result.add(im, j, i);
					
				}else{
					Label l = new Label(n+"");
					result.setMinWidth(30);
					result.add(l, j, i);
				}
				
				
			}
		}
    	result.setGridLinesVisible(true);
    }
    
    public boolean primeNumber(int n) {
    	boolean prime = false;
    	int k = 0;
		for(int g = 1; g<n-1;g++) {
			if(n%g==0) {
				k++;
			}
		}
		if(k == 1) {
			prime = true;
		}
    	
    	return prime;
    }

    @FXML
    void initialize() {
        rnd = new Random();
        oldBattleMatrix = new ArrayList<BattleMatrix>();
    }
}
