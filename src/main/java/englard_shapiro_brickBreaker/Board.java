package englard_shapiro_brickBreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel {

	private static final long serialVersionUID = 1L;
	private Paddle paddle;
	private Ball ball;
	private PowerUp powerUp;
	private ArrayList<Piece> bricks;
	public static final int BOARD_HEIGHT = 600;
	public static final int BOARD_WIDTH = 600;
	private int livesLeft;
	private BrickBreakerGame frame;
	private static int score = 0;
	private boolean dropping;
	private LevelFactory factory;
	private static int levelNum = 0 ;
	
	public Board(BrickBreakerGame frame) {
		this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		this.setBackground(Color.black);
		paddle = new Paddle();
		ball = new Ball(BOARD_WIDTH / 2, (paddle.getY() - Paddle.PADDLE_HEIGHT) - 10);
		powerUp = new PowerUp(560, 170);
		factory = new LevelFactory();
		levelNum++;
		bricks = factory.getLevel(levelNum);
		dropping = true;

		livesLeft = 10;
		this.frame = frame;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.lightGray);
		g.fillRect(paddle.getX(), paddle.getY(), Paddle.PADDLE_LENGTH, Paddle.PADDLE_HEIGHT);
		g.setColor(Color.white);
		g.fillOval(ball.getX(), ball.getY(), Ball.BALL_DIAMETER, Ball.BALL_DIAMETER);
		// create loop to set up all pieces - make array of pieces
		for (int i = 0; i < bricks.size(); i++) {
			Piece brick = bricks.get(i);
			g.setColor(brick.getColor());
			g.fillRect(brick.getX(), brick.getY(), Piece.BRICK_LENGTH, Piece.BRICK_WIDTH);
			g.setColor(Color.BLACK);
			g.drawRect(brick.getX(), brick.getY(), Piece.BRICK_LENGTH, Piece.BRICK_WIDTH);
		}

		// power up life
		g.setColor(Color.CYAN);
		g.fillOval(powerUp.getX(), powerUp.getY(), powerUp.getDiameter(), powerUp.getDiameter());

	}

	public void movePaddleLeft() {
		paddle.moveLeft();
		repaint();
	}

	public void movePaddleRight() {
		paddle.moveRight();
		repaint();
	}

	public void moveBall() throws InterruptedException {

		if (ball.getY() > BOARD_HEIGHT) {
			// the ball died
			// pause time thread.sleep not working
			if (livesLeft == 0) {
				int playAgain = JOptionPane.showConfirmDialog(null, "Game over! Would you like to play again?",
						"Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(getClass().getResource("/gameOver.jpg")));
				if (playAgain == 0) {
					frame.restart();
				} else {
					frame.dispose();
					System.exit(0);
				}
			} else {
				// send in new ball , remove this ball
				livesLeft--;
				frame.setLivesText(livesLeft);
				ball = new Ball(paddle.getX() + Paddle.PADDLE_LENGTH / 2, (paddle.getY() - Paddle.PADDLE_HEIGHT) - 10);
			}
		} else {
			Piece hitBrick = ball.move(paddle.getX(), paddle.getY(), bricks);
			if (hitBrick != null) {
				Color brickColor = hitBrick.getColor();
				if (brickColor == Color.BLUE) {
					score += 100;
				} else if (brickColor == Color.GREEN) {
					score += 200;
				} else if (brickColor == Color.YELLOW) {
					score += 300;
				} else if (brickColor == Color.ORANGE) {
					score += 400;
				} else if (brickColor == Color.CYAN) { // powerUpPiece
					score += 100;
					
					//thread to drop power up
					Runnable drop = new Runnable() {

						@Override
						public void run() {
							while (dropping) {
								try {
										powerUp.drop();
										repaint();
										Thread.sleep(5);
									
										//if hit paddle, 
										if(powerUp.checkHitPaddle()){
											dropping = false;
											livesLeft++;
											frame.setLivesText(livesLeft);
										}
										
										
								} catch (InterruptedException e) {
									System.out.println("Interrupted thread exception");
								}
							}
						}

					};
					new Thread(drop).start();
					
					
					
					
					
				} else {
					score += 500;
				}
				frame.setScoreText();
				bricks.remove(hitBrick);
			}
		}
	}

	public void checkWinner() {
		if (bricks.size() == 0) {
			if(levelNum < 3){
				int nextLevel = JOptionPane.showConfirmDialog(null, "Great job! \nWould you like to go to the next level?",
						"Level Cleared", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (nextLevel == 0) {
					paddle.restart();
					ball.restart(); 
					powerUp = new PowerUp(560, 170);
					bricks.clear();
					dropping = true;
					frame.restart();
				} else {
					frame.dispose();
					System.exit(0);
				}
			}
			else{	//cleared 3rd level
					int playAgain = JOptionPane.showConfirmDialog(null, "Great job! \nWould you like to play again?",
						"Congratulations!!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
						new ImageIcon(getClass().getResource("/winner.jpg")));
				if (playAgain == 0) {
					levelNum = 0;
					paddle.restart();
					ball.restart(); 
					powerUp = new PowerUp(560, 170);
					bricks.clear();
					dropping = true;
					frame.restart();
				} else {
					frame.dispose();
					System.exit(0);
				}
				
			}
		}
	}

	public int getScore() {
		return score;
	}

}
