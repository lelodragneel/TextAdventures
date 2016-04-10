package General;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class WelcomeScreen extends JFrame implements ActionListener {

	/*
	 * initialize variables
	 */
	
	private JButton btnWarriorClass;
	private JButton btnWizardClass;
	private JButton btnThiefClass;
	private JTextField nameInput;
	private Character player;
	private JLabel enterName;

	public WelcomeScreen() {
		
		/*
		 * build the welcome frame with all components
		 */
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(0, 0, 514, 256);
		getContentPane().setLayout(null);

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
		
		// create the warrior button
		btnWarriorClass = new JButton("Warrior");
		btnWarriorClass.setBounds(209, 129, 89, 23);
		btnWarriorClass.addActionListener(this);
		getContentPane().add(btnWarriorClass);
		
		
		// create the thief button
		btnThiefClass = new JButton("Thief");
		btnThiefClass.setBounds(110, 129, 89, 23);
		btnThiefClass.addActionListener(this);
		getContentPane().add(btnThiefClass);
		
		
		// create the wizard button
		btnWizardClass = new JButton("Wizard");
		btnWizardClass.setBounds(308, 129, 89, 23);
		btnWizardClass.addActionListener(this);
		getContentPane().add(btnWizardClass);
		
		enterName = new JLabel("Enter Player Name:");
		enterName.setBounds(50, 60, 150, 50);
		getContentPane().add(enterName);
		
		nameInput = new JTextField();
		nameInput.setBounds(212,70,125,25);
		getContentPane().add(nameInput);
		// set frame visible
		setVisible(true);

	}

	/*
	 * action listener
	 */
	public void actionPerformed(ActionEvent evt) {

			
		if(evt.getSource().equals(btnWarriorClass)) {
			player = new Character("Warrior", nameInput.getText(), "none", 15, 15, false, 0, 0);
			startGame();
		}
		else if(evt.getSource().equals(btnThiefClass)) {
			player = new Character("Thief" , nameInput.getText(), "none", 10, 20, false, 0,0);
			startGame();
		}
		else if(evt.getSource().equals(btnWizardClass)) {
			player = new Character("Wizard",nameInput.getText(), "none", 20, 10, false, 0, 0);
			startGame();
		}
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
