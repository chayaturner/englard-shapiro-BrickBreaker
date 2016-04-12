package englard_shapiro_brickBreaker;

public class GrowPaddle extends SpecialPiece {

	public GrowPaddle(int x, int y){
		super(x, y);
	}
	
	@Override
	public void dispose(){
		xPos = 0;
		yPos = 1;
	}
}
