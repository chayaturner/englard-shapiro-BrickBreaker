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
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		setInstructions();
	}

	private void setInstructions() {
		instLbl = new JLabel(
				"<html>Instructions:<br>" + "Hit all the bricks before your lives run out.<br>"
						+ "If you hit a Power Up brick, <br>" + "catch the ball to gain an extra life!<br>"
						+ "Press P to Pause game.<br>" + "Press R to Resume game.<br>" + "</html>",
				SwingConstants.CENTER);
		instLbl.setForeground(Color.WHITE);
		add(instLbl, BorderLayout.NORTH);

	}

}
