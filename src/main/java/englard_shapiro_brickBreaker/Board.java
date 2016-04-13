package englard_shapiro_brickBreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel {

	private static final long serialVersionUID = 1L;
	private Paddle paddle;
	private Ball ball;
	private PowerUpPiece powerUp;
	private ResizePaddlePiece growPaddle;
	private ResizePaddlePiece shrinkPaddle;
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
		powerUp = new PowerUpPiece(200, 80); // orange
		growPaddle = new ResizePaddlePiece(500, 170, paddle); // blue
		shrinkPaddle = new ResizePaddlePiece(400, 140, paddle); // green
		bricks = new ArrayList<Piece>();
		dropping = true;

		// set up bricks
		for (int i = 0; i <= 550; i += 50) {
			bricks.add(new Piece(i, 50, Color.RED));
			bricks.add(new Piece(i, 80, Color.ORANGE));
			bricks.add(new Piece(i, 110, Color.YELLOW));
			bricks.add(new Piece(i, 140, Color.GREEN));
			bricks.add(new Piece(i, 170, Color.BLUE));
		}

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
		// paddle grow
		g.setColor(Color.PINK);
		g.fillOval(growPaddle.getX(), growPaddle.getY(), growPaddle.getDiameter(), growPaddle.getDiameter());
		// paddle shrink
		g.setColor(Color.MAGENTA);
		g.fillOval(shrinkPaddle.getX(), shrinkPaddle.getY(), shrinkPaddle.getDiameter(), shrinkPaddle.getDiameter());

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
				int hitX = hitBrick.getX();
				int hitY = hitBrick.getY();
				if (brickColor == Color.BLUE) {
					score += 100;

					// HIT GROW PADDLE
					if (hitX == 500 && hitY == 170) {
						hitGrow();
					}

				} else if (brickColor == Color.GREEN) {
					score += 200;

					// HIT SHRINK PADDLE
					if (hitX == 400 && hitY == 140) {
						hitShrink();
					}

				} else if (brickColor == Color.YELLOW) {
					score += 300;
				} else if (brickColor == Color.ORANGE) {
					score += 400;

					// HIT POWER UP PIECE
					if (hitX == 200 && hitY == 80) {
						hitPowerUp();
					}

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

	private void hitShrink() {

		Runnable drop = new Runnable() {

			@Override
			public void run() {
				while (dropping) {
					try {
						shrinkPaddle.drop();
						repaint();
						Thread.sleep(3);

						// check if caught
						if (shrinkPaddle.checkHitPaddle(paddle.getX(), paddle.getY())) {
							score += 100;
							dropping = false;
							shrinkPaddle.shrink();
							shrinkPaddle.dispose();
						}

					} catch (InterruptedException e) {
						System.out.println("Interrupted thread exception");
					}
				}
			}

		};
		new Thread(drop).start();
		dropping = true; // reset

		// Reset paddle size after 20 seconds
		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {

				shrinkPaddle.reset();
				this.cancel();
			}
		}, 20000L);
	}

	private void hitGrow() {
		Runnable drop = new Runnable() {

			@Override
			public void run() {
				while (dropping) {
					try {
						growPaddle.drop();
						repaint();
						Thread.sleep(3);

						// check if caught
						if (growPaddle.checkHitPaddle(paddle.getX(), paddle.getY())) {
							score += 100;
							dropping = false;
							growPaddle.grow();
							growPaddle.dispose();
						}

					} catch (InterruptedException e) {
						System.out.println("Interrupted thread exception");
					}
				}
			}

		};
		new Thread(drop).start();
		dropping = true; // reset

		// Reset paddle size after 20 seconds
		Timer t = new Timer();
		t.schedule(new TimerTask() {

			@Override
			public void run() {

				growPaddle.reset();
				this.cancel();

			}
		}, 20000L);
	}

	private void hitPowerUp() {
		// thread to drop power up
		Runnable drop = new Runnable() {

			@Override
			public void run() {
				while (dropping) {
					try {
						powerUp.drop();
						repaint();
						Thread.sleep(3);

						// check if caught
						if (powerUp.checkHitPaddle(paddle.getX(), paddle.getY())) {
							dropping = false;
							score += 100;
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
		dropping = true; // reset
	}
}
