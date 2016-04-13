package englard_shapiro_brickBreaker;

public class SpecialPiece {

	protected int xPos;
	protected int yPos;
	protected final int diameter = 20;
	protected boolean hit;

	public SpecialPiece(int x, int y) {
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

	public boolean checkHitPaddle(int x, int y) {

		if (checkTopPaddle(x, y) || checkSidePaddle(x, y)) {
			hit = true;
		}
		return hit;
	}

	private boolean checkTopPaddle(int x, int y) {
		if (yPos + diameter == (y)) {

			if (xPos < (x + Paddle.PADDLE_LENGTH) && xPos > x) {
				return true;
			}
		}
		return false;
	}

	private boolean checkSidePaddle(int x, int y) {

		if (((leftSide(x) || rightSide(x)) && yPos + diameter >= y && yPos + diameter <= (y + Paddle.PADDLE_HEIGHT))) {
			return true;
		}
		return false;

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

	public void drop() {
		yPos += 1;
	}

	public void dispose() {
		yPos = 610;
		xPos = 610;
	}
}
