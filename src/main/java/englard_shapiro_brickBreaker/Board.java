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
	private int score;
	private boolean dropping;

	public Board(BrickBreakerGame frame) {
		this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		this.setBackground(Color.black);
		paddle = new Paddle();
		ball = new Ball(BOARD_WIDTH / 2, (paddle.getY() - Paddle.PADDLE_HEIGHT) - 10);
		powerUp = new PowerUp(550, 170);
		bricks = new ArrayList<Piece>();
		dropping = true;

		//set up bricks
		for(int i = 0; i<=550; i+=50){
			bricks.add(new Piece(i, 50, Color.RED));
			bricks.add(new Piece(i, 80, Color.ORANGE));
			bricks.add(new Piece (i, 110, Color.YELLOW));
			bricks.add(new Piece (i, 140, Color.GREEN));
			bricks.add(new Piece(i, 170, Color.BLUE));
		}
		
		bricks.add(new Piece(550, 170, Color.CYAN)); //powerUpPiece

		livesLeft = 3;
		score = 0;
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
										Thread.sleep(2);
									
										//if hit paddle, 
										if(powerUp.checkHitPaddle(paddle.getX(), paddle.getY())){
											dropping = false;
											livesLeft++;
											frame.setLivesText(livesLeft);
											powerUp.dispose();
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
			int playAgain = JOptionPane.showConfirmDialog(null, "You win! Would you like to play again?",
					"Congratulations!!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(getClass().getResource("/winner.jpg")));
			if (playAgain == 0) {
				frame.restart();
			} else {
				frame.dispose();
				System.exit(0);
			}
		}
	}

	public int getScore() {
		return score;
	}

}
