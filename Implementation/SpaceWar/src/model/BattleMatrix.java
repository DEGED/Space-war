package model;

import java.util.ArrayList;
import java.util.Random;

public class BattleMatrix {
	private int[][] matrix;
	private ArrayList<int[]> positions;
	
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
		Random rnd=new Random();
		matrix = new int[rows][columns];
		if(repeat==true) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					int rand = rnd.nextInt(100)+1;
					matrix[i][j]=rand;
				}
			}
			System.out.println("creo la matriz de combate");
		}else {
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

	public void isAShip(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int k = 0;
				for(int g = 1; g<matrix[i][j]-1;g++) {
					if(matrix[i][j]%g==0) {
						k++;
					}
				}
				if(k == 1) {
					int[] este = new int[2];
					este[0]=i;
					este[1]=j;
					positions.add(este);
				}
				
			}
		}
	}
	
}
