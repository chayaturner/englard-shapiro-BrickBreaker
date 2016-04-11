package englard_shapiro_brickBreaker;

import java.awt.Color;
import java.util.ArrayList;

import com.google.inject.Singleton;

//@Singleton
public class LevelFactory {

	private ArrayList<ArrayList<Piece>> levels;
		
	public LevelFactory() {
		levels = new ArrayList<ArrayList<Piece>>();
		
		//Will have ten levels
		for(int i = 0; i < 10; i++){
			levels.add(new ArrayList<Piece>());
		}

		/*levels.get(1).add(new Piece(0, 50, Color.RED));
		levels.get(1).add(new Piece(50, 50, Color.RED));
		levels.get(1).add(new Piece(100, 50, Color.RED));
		levels.get(1).add(new Piece(150, 50, Color.RED));
		levels.get(1).add(new Piece(200, 50, Color.RED));
		levels.get(1).add(new Piece(250, 50, Color.RED));
		levels.get(1).add(new Piece(300, 50, Color.RED));
		levels.get(1).add(new Piece(350, 50, Color.RED));
		levels.get(1).add(new Piece(400, 50, Color.RED));
		levels.get(1).add(new Piece(450, 50, Color.RED));
		levels.get(1).add(new Piece(500, 50, Color.RED));
		levels.get(1).add(new Piece(550, 50, Color.RED));
		levels.get(1).add(new Piece(0, 80, Color.ORANGE));
		levels.get(1).add(new Piece(50, 80, Color.ORANGE));
		levels.get(1).add(new Piece(100, 80, Color.ORANGE));
		levels.get(1).add(new Piece(150, 80, Color.ORANGE));
		levels.get(1).add(new Piece(200, 80, Color.ORANGE));
		levels.get(1).add(new Piece(250, 80, Color.ORANGE));
		levels.get(1).add(new Piece(300, 80, Color.ORANGE));
		levels.get(1).add(new Piece(350, 80, Color.ORANGE));
		levels.get(1).add(new Piece(400, 80, Color.ORANGE));
		levels.get(1).add(new Piece(450, 80, Color.ORANGE));
		levels.get(1).add(new Piece(500, 80, Color.ORANGE));
		levels.get(1).add(new Piece(550, 80, Color.ORANGE));
		levels.get(1).add(new Piece(0, 110, Color.YELLOW));
		levels.get(1).add(new Piece(50, 110, Color.YELLOW));
		levels.get(1).add(new Piece(100, 110, Color.YELLOW));
		levels.get(1).add(new Piece(150, 110, Color.YELLOW));
		levels.get(1).add(new Piece(200, 110, Color.YELLOW));
		levels.get(1).add(new Piece(250, 110, Color.YELLOW));
		levels.get(1).add(new Piece(300, 110, Color.YELLOW));
		levels.get(1).add(new Piece(350, 110, Color.YELLOW));
		levels.get(1).add(new Piece(400, 110, Color.YELLOW));
		levels.get(1).add(new Piece(450, 110, Color.YELLOW));
		levels.get(1).add(new Piece(500, 110, Color.YELLOW));
		levels.get(1).add(new Piece(550, 110, Color.YELLOW));
		levels.get(1).add(new Piece(0, 140, Color.GREEN));
		levels.get(1).add(new Piece(50, 140, Color.GREEN));
		levels.get(1).add(new Piece(100, 140, Color.GREEN));
		levels.get(1).add(new Piece(150, 140, Color.GREEN));
		levels.get(1).add(new Piece(200, 140, Color.GREEN));
		levels.get(1).add(new Piece(250, 140, Color.GREEN));
		levels.get(1).add(new Piece(300, 140, Color.GREEN));
		levels.get(1).add(new Piece(350, 140, Color.GREEN));
		levels.get(1).add(new Piece(400, 140, Color.GREEN));
		levels.get(1).add(new Piece(450, 140, Color.GREEN));
		levels.get(1).add(new Piece(500, 140, Color.GREEN));
		levels.get(1).add(new Piece(550, 140, Color.GREEN));
		levels.get(1).add(new Piece(0, 170, Color.BLUE));
		levels.get(1).add(new Piece(50, 170, Color.BLUE));
		levels.get(1).add(new Piece(100, 170, Color.BLUE));
		levels.get(1).add(new Piece(150, 170, Color.BLUE));
		levels.get(1).add(new Piece(200, 170, Color.BLUE));
		levels.get(1).add(new Piece(250, 170, Color.BLUE));
		levels.get(1).add(new Piece(300, 170, Color.BLUE));
		levels.get(1).add(new Piece(350, 170, Color.BLUE));
		levels.get(1).add(new Piece(400, 170, Color.BLUE));
		levels.get(1).add(new Piece(450, 170, Color.BLUE));
		levels.get(1).add(new Piece(500, 170, Color.BLUE));*/
		levels.get(1).add(new Piece(550, 170, Color.CYAN)); // powerUpPiece 
		
		
		/*levels.get(2).add(new Piece(0, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(50, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(100, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(150, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(200, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(250, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(300, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(350, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(400, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(450, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(500, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(550, 50, Color.MAGENTA));
		levels.get(2).add(new Piece(0, 80, Color.ORANGE));
		levels.get(2).add(new Piece(50, 80, Color.ORANGE));
		levels.get(2).add(new Piece(100, 80, Color.ORANGE));
		levels.get(2).add(new Piece(150, 80, Color.ORANGE));
		levels.get(2).add(new Piece(200, 80, Color.ORANGE));
		levels.get(2).add(new Piece(250, 80, Color.ORANGE));
		levels.get(2).add(new Piece(300, 80, Color.ORANGE));
		levels.get(2).add(new Piece(350, 80, Color.ORANGE));
		levels.get(2).add(new Piece(400, 80, Color.ORANGE));
		levels.get(2).add(new Piece(450, 80, Color.ORANGE));
		levels.get(2).add(new Piece(500, 80, Color.ORANGE));
		levels.get(2).add(new Piece(550, 80, Color.ORANGE));
		levels.get(2).add(new Piece(0, 110, Color.YELLOW));
		levels.get(2).add(new Piece(50, 110, Color.YELLOW));
		levels.get(2).add(new Piece(100, 110, Color.YELLOW));
		levels.get(2).add(new Piece(150, 110, Color.YELLOW));
		levels.get(2).add(new Piece(200, 110, Color.YELLOW));
		levels.get(2).add(new Piece(250, 110, Color.YELLOW));
		levels.get(2).add(new Piece(300, 110, Color.YELLOW));
		levels.get(2).add(new Piece(350, 110, Color.YELLOW));
		levels.get(2).add(new Piece(400, 110, Color.YELLOW));
		levels.get(2).add(new Piece(450, 110, Color.YELLOW));
		levels.get(2).add(new Piece(500, 110, Color.YELLOW));
		levels.get(2).add(new Piece(550, 110, Color.YELLOW));
		levels.get(2).add(new Piece(0, 140, Color.GREEN));
		levels.get(2).add(new Piece(50, 140, Color.GREEN));
		levels.get(2).add(new Piece(100, 140, Color.GREEN));
		levels.get(2).add(new Piece(150, 140, Color.GREEN));
		levels.get(2).add(new Piece(200, 140, Color.GREEN));
		levels.get(2).add(new Piece(250, 140, Color.GREEN));
		levels.get(2).add(new Piece(300, 140, Color.GREEN));
		levels.get(2).add(new Piece(350, 140, Color.GREEN));
		levels.get(2).add(new Piece(400, 140, Color.GREEN));
		levels.get(2).add(new Piece(450, 140, Color.GREEN));
		levels.get(2).add(new Piece(500, 140, Color.GREEN));
		levels.get(2).add(new Piece(550, 140, Color.GREEN));
		levels.get(2).add(new Piece(0, 170, Color.BLUE));
		levels.get(2).add(new Piece(50, 170, Color.BLUE));
		levels.get(2).add(new Piece(100, 170, Color.BLUE));
		levels.get(2).add(new Piece(150, 170, Color.BLUE));
		levels.get(2).add(new Piece(200, 170, Color.BLUE));
		levels.get(2).add(new Piece(250, 170, Color.BLUE));
		levels.get(2).add(new Piece(300, 170, Color.BLUE));
		levels.get(2).add(new Piece(350, 170, Color.BLUE));
		levels.get(2).add(new Piece(400, 170, Color.BLUE));
		levels.get(2).add(new Piece(450, 170, Color.BLUE));*/
		levels.get(2).add(new Piece(500, 170, Color.BLUE));
		levels.get(2).add(new Piece(550, 170, Color.CYAN)); // powerUpPiece 
		
		
		
		
	}

	public ArrayList<Piece> getLevel(int levelNum) {
		return levels.get(levelNum);
	}
	
}
