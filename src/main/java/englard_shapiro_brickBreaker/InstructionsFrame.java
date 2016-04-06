package englard_shapiro_brickBreaker;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class InstructionsFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel instLbl;

	public InstructionsFrame() {
		setSize(200, 150);
		setTitle("Instructions");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setInstructions();
	}

	private void setInstructions() {
		instLbl = new JLabel(
				"<html>Instructions:<br>" + "Hit all the bricks before your lives run out.<br>"
						+ "If you hit a Power Up brick, <br>" + "catch the ball to gain an extra life!<br>" + "</html>",
				SwingConstants.CENTER);
		instLbl.setForeground(Color.BLUE);
		add(instLbl, BorderLayout.NORTH);

	}

}
