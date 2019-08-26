package model;

import java.util.Random;

public class BattleMatrix {
	private int[][] matrix;
	
	public BattleMatrix(boolean repeat,int rows, int columns) {
		createMatrix(rows, columns, repeat);
	}
	
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public void  createMatrix(int rows, int columns, boolean repeat) {
		matrix = new int[rows][columns];
		if(repeat==true) {
			randomRepitedNumbers();
		}else {
		 	randomUnRepitedNumbers(columns,rows);
		}
	}
	
	public void randomRepitedNumbers() {
		Random rnd=new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int rand = rnd.nextInt(100)+1;
				matrix[i][j]=rand;
			}
		}
	}
	
	public void randomUnRepitedNumbers(int columns, int rows) {
		int[] randoms = new int[columns*rows];
	 	randoms[0] = (int)(Math.random()*100);
	 	for (int i = 1; i < randoms.length; i++) {
			randoms[i]=(int)(Math.random()*100);
			for (int j = 0; j < 1; j++) {
				if(randoms[i]==randoms[j]) {
					i--;
				}
			}
		}
	 	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < randoms.length; k++) {
					matrix[i][j] = randoms[k];
				}
			}
		}
	}	
}
