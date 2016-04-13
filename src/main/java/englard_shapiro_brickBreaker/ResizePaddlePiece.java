package englard_shapiro_brickBreaker;

public class ResizePaddlePiece extends SpecialPiece {

	private Paddle paddle;

	public ResizePaddlePiece(int x, int y, Paddle paddle) {
		super(x, y);
		this.paddle = paddle;
	}

	@Override
	public void dispose() {
		xPos = 20;
		yPos = 0;
	}

	public void grow() {
		paddle.paddleGrow();
	}

	public void shrink() {
		paddle.paddleShrink();
	}

	public void reset() {
		paddle.resetPaddle();
	}
}
