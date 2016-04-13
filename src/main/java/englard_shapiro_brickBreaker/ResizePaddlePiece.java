package englard_shapiro_brickBreaker;

public class ResizePaddlePiece extends SpecialPiece {

	private Paddle paddle;

	public ResizePaddlePiece(int x, int y, Paddle paddle) {
		super(x, y);
		this.paddle = paddle;
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
