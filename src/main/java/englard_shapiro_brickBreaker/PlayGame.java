package englard_shapiro_brickBreaker;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;


public class PlayGame extends JFrame{

	private static final long serialVersionUID = 1L; // default

	@Inject
	public PlayGame(BrickBreakerGame game) {

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		// set up game
		container.add(game, BorderLayout.CENTER);

		setVisible(true);
	
	}
	
	public static void main(String[] args) {
		//BrickBrackerGame game = new BrickBrackerGame();
		
		//Guice
		Injector injector = Guice.createInjector(new GameModule());
		BrickBreakerGame game = injector.getInstance(BrickBreakerGame.class);
		
	}

}
