package General;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import java.awt.Font;

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
		setTitle("TextAdventures");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 514, 256);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);

		// label positioned on the left, displaying an image
		JLabel label_leftPicture = new JLabel("");
		label_leftPicture.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/General/images/mouth-watering.png")));
		label_leftPicture.setBounds(10, 11, 64, 100);
		getContentPane().add(label_leftPicture);

		// label positioned on the right, displaying an image
		JLabel label_rightPicture = new JLabel("");
		label_rightPicture.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/General/images/attached-shield.png")));
		label_rightPicture.setBounds(434, 11, 64, 100);
		getContentPane().add(label_rightPicture);

		// welcome label
		JLabel lblwelcomeToTextadventures = new JLabel("Welcome to TextAdventures");
		lblwelcomeToTextadventures.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblwelcomeToTextadventures.setHorizontalAlignment(SwingConstants.CENTER);
		lblwelcomeToTextadventures.setBounds(159, 11, 190, 32);
		getContentPane().add(lblwelcomeToTextadventures);
		
		// create the warrior button
		btnWarriorClass = new JButton("Warrior");
		btnWarriorClass.setBounds(209, 193, 89, 23);
		btnWarriorClass.addActionListener(this);
		btnWarriorClass.setFocusable(false);
		btnWarriorClass.setToolTipText("<html>Base Health: 16 <br />Base Attack: 16</html>");
		getContentPane().add(btnWarriorClass);
		
		
		// create the thief button
		btnThiefClass = new JButton("Thief");
		btnThiefClass.setBounds(110, 193, 89, 23);
		btnThiefClass.addActionListener(this);
		btnThiefClass.setFocusable(false);
		btnThiefClass.setToolTipText("<html>Base Health: 10 <br />Base Attack: 20</html>");
		getContentPane().add(btnThiefClass);
		
		
		// create the wizard button
		btnWizardClass = new JButton("Wizard");
		btnWizardClass.setBounds(308, 193, 89, 23);
		btnWizardClass.addActionListener(this);
		btnWizardClass.setFocusable(false);
		btnWizardClass.setToolTipText("<html>Base Health: 20 <br />Base Attack: 10</html>");
		getContentPane().add(btnWizardClass);
		
		enterName = new JLabel("Enter Player Name:");
		enterName.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		enterName.setBounds(159, 113, 190, 14);
		getContentPane().add(enterName);
		
		nameInput = new JTextField();
		nameInput.setBounds(159,138,190,25);
		getContentPane().add(nameInput);
		// set frame visible
		setVisible(true);

	}

	/*
	 * action listener
	 */
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource().equals(btnWarriorClass)) {
			player = new Character("Warrior", nameInput.getText(), 16, 16, 1);
			startGame(player);
			dispose();
		}
		else if(evt.getSource().equals(btnThiefClass)) {
			player = new Character("Thief" , nameInput.getText(), 10, 20, 1);
			startGame(player);
			dispose();
		}
		else if(evt.getSource().equals(btnWizardClass)) {
			player = new Character("Wizard", nameInput.getText(), 20, 10, 1);
			startGame(player);
			dispose();
		}
	}
	

	/*
	 * start the game from, and close this window
	 */
	public void startGame(Character player) {

		// safely start the game
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Core(player);
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
