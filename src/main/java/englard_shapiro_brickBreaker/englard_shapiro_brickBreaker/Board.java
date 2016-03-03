package englard_shapiro_brickBreaker.englard_shapiro_brickBreaker;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel {

	private Paddle paddle;
	private Ball ball;
	private Piece brick;
	public static int BOARD_HEIGHT = 600;
	public static int BOARD_WIDTH = 600;
	private int livesUsed;
	private Frame frame;

	public Board(Frame frame) {
		this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		paddle = new Paddle();
		ball = new Ball(BOARD_WIDTH / 2,
				(paddle.getY() - Paddle.PADDLE_HEIGHT) - 10);
		brick = new Piece(100, 100, Color.RED);
		livesUsed = 0;
		this.frame = frame;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillRect(paddle.getX(), paddle.getY(), Paddle.PADDLE_LENGTH,
				Paddle.PADDLE_HEIGHT);
		g.setColor(Color.BLACK);
		g.fillOval(ball.getX(), ball.getY(), Ball.BALL_DIAMETER,
				Ball.BALL_DIAMETER);
		// create loop to set up all pieces - make 2d-array of pieces
		g.setColor(brick.getColor());
		g.fillRect(brick.getX(), brick.getY(), brick.getLength(),
				brick.getWidth());
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
			if (livesUsed == 3) {
				int playAgain = JOptionPane.showConfirmDialog(null,
						"Game over! Would you like to play again?",
						"Game Over", JOptionPane.YES_NO_OPTION);
				if (playAgain == 0) {
					frame.restart();
				} else {
					frame.dispose();
					System.exit(0);
				}
			}

			// send in new ball , remove this ball
			ball = new Ball(paddle.getX(),
					(paddle.getY() - Paddle.PADDLE_HEIGHT) - 10);

			livesUsed++;
		} else {
			ball.move(paddle.getX(), paddle.getY(), brick);
		}
	}

}
