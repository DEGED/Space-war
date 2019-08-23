package model;

import java.util.Random;

public class BattleMatrix {
	
	private SpaceCell[][] matrix;
	
	public BattleMatrix(int rows, int columns) {
		Random  rnd = new Random();
		matrix = new SpaceCell[rows][columns];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = new SpaceCell(i,j, rnd.nextInt());
				System.out.println("se crearon esas gonorreas");
			}
		}
	}
}
