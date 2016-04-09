import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class WelcomeScreen extends JFrame implements ActionListener {

	/*
	 * initialize variables
	 */
	private JButton btnStart;

	public WelcomeScreen() {
		setAlwaysOnTop(true);
		
		/*
		 * build the welcome frame with all components
		 */
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(0, 0, 514, 256);
		getContentPane().setLayout(null);

		// create the submit button
		btnStart = new JButton("Play");
		btnStart.setBounds(209, 193, 89, 23);
		btnStart.setFocusable(false);
		btnStart.addActionListener(this);
		getContentPane().add(btnStart);

		// label positioned on the left, displaying an image
		JLabel label_leftPicture = new JLabel("");
		label_leftPicture.setBounds(10, 11, 100, 100);
		getContentPane().add(label_leftPicture);

		// label positioned on the right, displaying an image
		JLabel label_rightPicture = new JLabel("");
		label_rightPicture.setBounds(388, 11, 100, 100);
		getContentPane().add(label_rightPicture);

		// welcome label
		JLabel label_welcome = new JLabel("<html>Welcome to <br/>TextAdventures</html>");
		label_welcome.setHorizontalAlignment(SwingConstants.CENTER);
		label_welcome.setBounds(159, 11, 190, 32);
		getContentPane().add(label_welcome);

		// set frame visible
		setVisible(true);

	}

	/*
	 * action listener
	 */
	public void actionPerformed(ActionEvent evt) {

		if (evt.getSource().equals(btnStart))
			startGame();

	}

	/*
	 * start the game from, and close this window
	 */
	public void startGame() {

		// safely start the game
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Core();
				dispose();
			}
		});
	}
	
	/*
	 * <<<<<main static method>>>>>
	 */
	public static void main(String[] args) {

		// safely start the welcome frame
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WelcomeScreen();
			}
		});

	}

}
