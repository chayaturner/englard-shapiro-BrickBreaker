package englard_shapiro_brickBreaker;

public class GrowPaddle extends SpecialPiece {

	private Paddle paddle;
	
	public GrowPaddle(int x, int y, Paddle paddle){
		super(x, y);
		this.paddle = paddle;
	}
	
	@Override
	public void dispose(){
		xPos = 0;
		yPos = 1;
	}
	
	public void grow(){
		paddle.paddleGrow();
	}
}
