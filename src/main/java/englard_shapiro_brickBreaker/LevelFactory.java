package englard_shapiro_brickBreaker;

import java.awt.Color;
import java.util.ArrayList;

public class LevelFactory {

	private ArrayList<ArrayList<Piece>> levels;
		
	public LevelFactory() {
		levels = new ArrayList<ArrayList<Piece>>();
		
		// Level 1
		for(int i = 0; i < 10; i++){
			levels.add(new ArrayList<Piece>());
		}
		for(int i = 0; i < 12; i++){
			levels.get(1).add(new Piece(i * 50, 50, Color.RED));
		}
		for(int i = 0; i < 11; i++){
			levels.get(1).add(new Piece(i * 50 + 25, 80, Color.ORANGE));
		}
		for(int i = 0; i < 12; i++){
			levels.get(1).add(new Piece(i * 50, 110, Color.YELLOW));
		}
		for(int i = 0; i < 11; i++){
			levels.get(1).add(new Piece(i * 50 + 25, 140, Color.GREEN));
		}
		for(int i = 0; i < 11; i++){
			levels.get(1).add(new Piece(i * 50, 170, Color.BLUE));
		}
		
		levels.get(1).add(new Piece(550, 170, Color.CYAN)); // powerUpPiece 
		
		
		// Level 2
		levels.get(2).add(new Piece(125, 50, Color.WHITE));
		levels.get(2).add(new Piece(175, 50, Color.WHITE));
		levels.get(2).add(new Piece(100, 80, Color.WHITE));
		levels.get(2).add(new Piece(150, 80, Color.BLUE));
		levels.get(2).add(new Piece(200, 80, Color.WHITE));
		levels.get(2).add(new Piece(100, 110, Color.WHITE));
		levels.get(2).add(new Piece(150, 110, Color.BLUE));
		levels.get(2).add(new Piece(200, 110, Color.WHITE));
		levels.get(2).add(new Piece(100, 140, Color.WHITE));
		levels.get(2).add(new Piece(150, 140, Color.BLUE));
		levels.get(2).add(new Piece(200, 140, Color.WHITE));
		levels.get(2).add(new Piece(125, 170, Color.WHITE));
		levels.get(2).add(new Piece(175, 170, Color.WHITE));
		
		levels.get(2).add(new Piece(375, 50, Color.WHITE));
		levels.get(2).add(new Piece(425, 50, Color.WHITE));
		levels.get(2).add(new Piece(350, 80, Color.WHITE));
		levels.get(2).add(new Piece(400, 80, Color.BLUE));
		levels.get(2).add(new Piece(450, 80, Color.WHITE));
		levels.get(2).add(new Piece(350, 110, Color.WHITE));
		levels.get(2).add(new Piece(400, 110, Color.BLUE));
		levels.get(2).add(new Piece(450, 110, Color.WHITE));
		levels.get(2).add(new Piece(350, 140, Color.WHITE));
		levels.get(2).add(new Piece(400, 140, Color.BLUE));
		levels.get(2).add(new Piece(450, 140, Color.WHITE));
		levels.get(2).add(new Piece(375, 170, Color.WHITE));
		levels.get(2).add(new Piece(425, 170, Color.WHITE));
		
		
		levels.get(2).add(new Piece(250, 230, Color.GREEN));
		levels.get(2).add(new Piece(300, 230, Color.GREEN));
		
		
		levels.get(2).add(new Piece(125, 290, Color.RED));
		levels.get(2).add(new Piece(175, 290, Color.RED));
		levels.get(2).add(new Piece(375, 290, Color.RED));
		levels.get(2).add(new Piece(425, 290, Color.RED));
		
		levels.get(2).add(new Piece(150, 320, Color.RED));
		levels.get(2).add(new Piece(200, 320, Color.RED));
		levels.get(2).add(new Piece(350, 320, Color.RED));
		levels.get(2).add(new Piece(400, 320, Color.RED));
		
		levels.get(2).add(new Piece(175, 350, Color.RED));
		levels.get(2).add(new Piece(225, 350, Color.RED));
		levels.get(2).add(new Piece(275, 350, Color.RED));
		levels.get(2).add(new Piece(325, 350, Color.RED));
		levels.get(2).add(new Piece(375, 350, Color.RED));

		
		// Level 3
		
		
		// Level 4
		
		
		// Level 5
		
	}

	public ArrayList<Piece> getLevel(int levelNum) {
		return levels.get(levelNum);
	}
	
}
