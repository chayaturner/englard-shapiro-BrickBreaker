package englard_shapiro_brickBreaker;

public class PowerUp {

	private int xPos;
	private int yPos;
	private final int diameter = 20;
	private boolean hit;

	public PowerUp(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}

	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}

	public int getDiameter() {
		return diameter;
	}

	private void checkHitPaddle(int x, int y) {
		checkTopPaddle(x, y);
		checkSidePaddle(x, y);

	}

	private void checkTopPaddle(int x, int y) {
		if (yPos + diameter == (y)) {

			if (xPos < (x + Paddle.PADDLE_LENGTH) && xPos > x) {
				hit = true;
			}
		}
	}

	private void checkSidePaddle(int x, int y) {

		if (((leftSide(x) || rightSide(x)) && yPos + diameter >= y && yPos + diameter <= (y + Paddle.PADDLE_HEIGHT))) {
			hit = true;
		}
	}

	private boolean rightSide(int x) {
		return xPos == (x + Paddle.PADDLE_LENGTH);
	}

	private boolean leftSide(int x) {
		return (((xPos + diameter) >= x) && (xPos < x));
	}

	public boolean getHit() {
		return hit;
	}

}
