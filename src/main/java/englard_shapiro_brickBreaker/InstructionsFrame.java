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
		setSize(200, 300);
		setTitle("Instructions");
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		setInstructions();
	}

	private void setInstructions() {
		instLbl = new JLabel("<html>Instructions:<br>" + "Hit all the bricks before your lives run out.<br>"
				+ "If you hit a special brick, <br>" + "catch the dropping ball to get:<br>"
				+ "- An extra life + 100 points<br>" + "- Grow your paddle for 20 seconds + 100 points<br>"
				+ "Be careful, there are also paddle shrinkers!<br>" + "Press P to Pause game.<br>"
				+ "Press R to Resume game.<br>" + "</html>", SwingConstants.CENTER);
		instLbl.setForeground(Color.WHITE);
		add(instLbl, BorderLayout.NORTH);

	}

}
