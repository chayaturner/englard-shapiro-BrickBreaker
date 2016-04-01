package englard_shapiro_brickBreaker;

public class PowerUp {

	private int x;
	private int y;
	private final int diameter = 10;

	public PowerUp(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDiameter() {
		return diameter;
	}

}
