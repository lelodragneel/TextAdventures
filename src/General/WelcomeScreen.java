package General;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		setTitle("Alera Village");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 1200, 700);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
      
      		// welcome label
		JLabel lblwelcomeToTextadventures = new JLabel("Welcome to the ruins of Alera Village!");
		lblwelcomeToTextadventures.setFont(new Font("Georgia", Font.PLAIN, 24));
		lblwelcomeToTextadventures.setHorizontalAlignment(SwingConstants.CENTER);
		lblwelcomeToTextadventures.setBounds(360, 230, 490, 50);
		getContentPane().add(lblwelcomeToTextadventures);
		
		// create the warrior button
		btnWarriorClass = new JButton("Warrior");
		btnWarriorClass.setBounds(659, 343, 89, 23);
		btnWarriorClass.addActionListener(this);
		btnWarriorClass.setFocusable(false);
		btnWarriorClass.setToolTipText("<html>Base Health: 16 <br />Base Attack: 16</html>");
		getContentPane().add(btnWarriorClass);
		
		// create the thief button
		btnThiefClass = new JButton("Thief");
		btnThiefClass.setBounds(460, 343, 89, 23);
		btnThiefClass.addActionListener(this);
		btnThiefClass.setFocusable(false);
		btnThiefClass.setToolTipText("<html>Base Health: 10 <br />Base Attack: 20</html>");
		getContentPane().add(btnThiefClass);		
		
		// create the wizard button
		btnWizardClass = new JButton("Wizard");
		btnWizardClass.setBounds(558, 343, 89, 23);
		btnWizardClass.addActionListener(this);
		btnWizardClass.setFocusable(false);
		btnWizardClass.setToolTipText("<html>Base Health: 20 <br />Base Attack: 10</html>");
		getContentPane().add(btnWizardClass);
		
		// ask the player to input his name
		enterName = new JLabel("Enter your name then choose a class!");
		enterName.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		enterName.setBounds(509, 283, 290, 14);
		getContentPane().add(enterName);
		
		nameInput = new JTextField();
		nameInput.setBounds(509,308,190,25);
		getContentPane().add(nameInput);
		
      // label positioned on the right, displaying an image
		JLabel label_rightPicture = new JLabel("");
		label_rightPicture.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/General/images/village.png")));
		label_rightPicture.setBounds(0, 0, 1200, 700);
		getContentPane().add(label_rightPicture);
      
		// set frame visible
		setVisible(true);

	}

	/*
	 * action listener
	 */
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource().equals(btnWarriorClass)) {
			player = new Character("Warrior", nameInput.getText(), 160, 16, 1);
			startGame(player);
		}
		else if(evt.getSource().equals(btnThiefClass)) {
			player = new Character("Thief" , nameInput.getText(), 100, 20, 1);
			startGame(player);
		}
		else if(evt.getSource().equals(btnWizardClass)) {
			player = new Character("Wizard", nameInput.getText(), 200, 10, 1);
			startGame(player);
		}
	}
	

	/*
	 * start the game from, and close this window
	 */
	public void startGame(Character player) {

		// if textfield is empty, prompt
		if (nameInput.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "You must enter your name!");
		} else {

			// close this welcome frame
			dispose();

			// safely start the game
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new Core(player);
				}
			});
		}
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