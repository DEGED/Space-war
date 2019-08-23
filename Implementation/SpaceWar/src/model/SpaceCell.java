package model;

public class SpaceCell {
	private int posX;
	private int posY;
	private int value;
	private boolean enemy;
	
	public SpaceCell(int px, int py, int v) {
		this.posX = px;
		this.posY = py;
		this.value = v;
		this.enemy = isEnemy();
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean getEnemy() {
		return enemy;
	}

	public boolean isEnemy() {
		int ref = 0;
		for (int i = 1; i < value-1; i++) {
			if(value%i==0) {
				ref+=1;
			}
		}
				
		if(ref==1) {
			enemy = true;
		}else {
			enemy = false;
		}
		return enemy;
	}

	public void setEnemy(boolean enemy) {
		this.enemy = enemy;
	}
}
