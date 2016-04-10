package General;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/*
 * CSCI group project
 * all code is subject to change
 */

@SuppressWarnings("serial")
public class GamePanel extends JFrame implements ActionListener {
	
	/*
	 * initialize variables
	 */
	private String enteredText;
	private JTextField txtPleaseTypeAll;
	private JTextArea textArea_displayEvents;
	private JProgressBar progBar_playerHealth;
	private JProgressBar progBar_enemyHealth;
	private JButton btn_showMap;
	private JLabel lbl_playerName;
	private JLabel lbl_enemyName;
	private JLabel lbl_locationName;
	private Map map;
	
	// constructor
	public GamePanel() {
		setAlwaysOnTop(true);
		
		/*
		 * create new world map
		 */
		map = new Map();
		
		/*
		 * build main frame
		 */
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setTitle("TextAdventures - CSCI Group Project");
		setBounds(0, 0, 950, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setResizable(false);
				
		/*
		 * create the player panel
		 */
		JPanel panel_player = new JPanel();
		panel_player.setBounds(0, 0, 210, 371);
		panel_player.setLayout(null);
		getContentPane().add(panel_player);
		
		// create player's health bar
		progBar_playerHealth = new JProgressBar();
		progBar_playerHealth.setForeground(Color.BLUE);
		progBar_playerHealth.setBounds(10, 11, 190, 14);
		progBar_playerHealth.setValue(100);
		progBar_playerHealth.setBorderPainted(false);
		panel_player.add(progBar_playerHealth);
		
		// create label to display player's name
		lbl_playerName = new JLabel("player name filler");
		lbl_playerName.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lbl_playerName.setBounds(10, 30, 190, 14);
		panel_player.add(lbl_playerName);
		
		// create panel to display player's collected items
		JPanel subpanel_items = new JPanel();
		subpanel_items.setBorder(new TitledBorder(null, "Items", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_items.setBounds(10, 248, 200, 112);
		panel_player.add(subpanel_items);
		subpanel_items.setLayout(new GridLayout(0, 4, 3, 3));
		
		/* create 8 label to represent the collected items */
		JLabel lbl_item1 = new JLabel("+");
		lbl_item1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_item1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_item1.setHorizontalAlignment(SwingConstants.CENTER);
		subpanel_items.add(lbl_item1);
		
		JLabel lbl_item2 = new JLabel("+");
		lbl_item2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_item2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_item2.setHorizontalAlignment(SwingConstants.CENTER);
		subpanel_items.add(lbl_item2);
		
		JLabel lbl_item3 = new JLabel("+");
		lbl_item3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_item3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_item3.setHorizontalAlignment(SwingConstants.CENTER);
		subpanel_items.add(lbl_item3);
		
		JLabel lbl_item4 = new JLabel("+");
		lbl_item4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_item4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_item4.setHorizontalAlignment(SwingConstants.CENTER);
		subpanel_items.add(lbl_item4);
		
		JLabel lbl_item5 = new JLabel("+");
		lbl_item5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_item5.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_item5.setHorizontalAlignment(SwingConstants.CENTER);
		subpanel_items.add(lbl_item5);
		
		JLabel lbl_item6 = new JLabel("+");
		lbl_item6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_item6.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_item6.setHorizontalAlignment(SwingConstants.CENTER);
		subpanel_items.add(lbl_item6);
		
		JLabel lbl_item7 = new JLabel("+");
		lbl_item7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_item7.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_item7.setHorizontalAlignment(SwingConstants.CENTER);
		subpanel_items.add(lbl_item7);
		
		JLabel lbl_item8 = new JLabel("+");
		lbl_item8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_item8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_item8.setHorizontalAlignment(SwingConstants.CENTER);
		subpanel_items.add(lbl_item8);
		
		// create subpanel to display the player's stats
		JPanel subpanel_stats = new JPanel();
		subpanel_stats.setBorder(new TitledBorder(null, "Stats", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		subpanel_stats.setBounds(10, 147, 200, 90);
		panel_player.add(subpanel_stats);
		subpanel_stats.setLayout(null);
		
		/* create labels to represent the player's stats */
		JLabel lblArmor = new JLabel("Armor:");
		lblArmor.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblArmor.setBounds(10, 70, 111, 14);
		subpanel_stats.add(lblArmor);
		
		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblStrength.setBounds(10, 45, 111, 14);
		subpanel_stats.add(lblStrength);
		
		JLabel lblHealth = new JLabel("Health:");
		lblHealth.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lblHealth.setBounds(10, 20, 111, 14);
		subpanel_stats.add(lblHealth);
		
		JLabel lbl_playerHealth = new JLabel("0");
		lbl_playerHealth.setBounds(131, 20, 46, 14);
		subpanel_stats.add(lbl_playerHealth);
		
		JLabel lbl_playerStrength = new JLabel("0");
		lbl_playerStrength.setBounds(131, 45, 46, 14);
		subpanel_stats.add(lbl_playerStrength);
		
		JLabel lbl_playerArmor = new JLabel("0");
		lbl_playerArmor.setBounds(131, 70, 46, 14);
		subpanel_stats.add(lbl_playerArmor);
		
		// create label to represent the player's picture
		JLabel lbl_playerPicture = new JLabel("");
		lbl_playerPicture.setBounds(10, 55, 190, 81);
		panel_player.add(lbl_playerPicture);
		
		/*
		 * create the enemy panel
		 */
		JPanel panel_enemy = new JPanel();
		panel_enemy.setBounds(734, 0, 210, 371);
		getContentPane().add(panel_enemy);
		panel_enemy.setLayout(null);
		
		// create enemy health bar
		progBar_enemyHealth = new JProgressBar();
		progBar_enemyHealth.setForeground(Color.RED);
		progBar_enemyHealth.setBounds(10, 11, 190, 14);
		progBar_enemyHealth.setValue(100);
		progBar_enemyHealth.setBorderPainted(false);
		panel_enemy.add(progBar_enemyHealth);
		
		// create label to display the enemy's name
		lbl_enemyName = new JLabel("boss name filler");
		lbl_enemyName.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lbl_enemyName.setBounds(10, 30, 190, 14);
		panel_enemy.add(lbl_enemyName);
		
		// create a label to display the current location's picture
		JLabel lbl_locationPicture = new JLabel("");
		lbl_locationPicture.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_locationPicture.setBounds(0, 215, 200, 145);
		panel_enemy.add(lbl_locationPicture);
		
		/* create label to display the name of current location */
		JLabel lblArea = new JLabel("Area:");
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		lblArea.setBounds(0, 200, 45, 14);
		panel_enemy.add(lblArea);
		
		lbl_locationName = new JLabel("filler");
		lbl_locationName.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		lbl_locationName.setBounds(55, 201, 155, 14);
		panel_enemy.add(lbl_locationName);
		
		// create label to display the boss's picture
		JLabel lbl_bossPicture = new JLabel("");
		lbl_bossPicture.setBounds(-1, 55, 201, 134);
		panel_enemy.add(lbl_bossPicture);
		
		/*
		 * create the middle area to display events and information of everything
		 */
		textArea_displayEvents = new JTextArea();
		textArea_displayEvents.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea_displayEvents.setLineWrap(true);
		textArea_displayEvents.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea_displayEvents);
		scroll.setBounds(220, 60, 504, 260);
		textArea_displayEvents.setBounds(220, 200, 454, 110);
		getContentPane().add(scroll);
		
		// create the text field which accepts user input
		txtPleaseTypeAll = new JTextField();
		txtPleaseTypeAll.setEditable(false);
		txtPleaseTypeAll.setText("Please type all commands in the console. This text field is obsolete.");
		txtPleaseTypeAll.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtPleaseTypeAll.setBounds(220, 331, 504, 29);
		txtPleaseTypeAll.setColumns(10);
		txtPleaseTypeAll.addActionListener(this);
		getContentPane().add(txtPleaseTypeAll);
		
		/*
		 * create miscellaneous components displayed at the top above the textArea
		 */
		// create button that toggles map visibility
		btn_showMap = new JButton("Map");
		btn_showMap.setFont(new Font("DejaVu Sans", Font.PLAIN, 11));
		btn_showMap.setBounds(684, 11, 40, 40);
		btn_showMap.setMargin(new Insets(1, 1, 1, 1));
		btn_showMap.addActionListener(this);
		btn_showMap.setFocusable(false);
		getContentPane().add(btn_showMap);

		// finally, set frame visible
		setVisible(true);
		
	}

	/*
	 * action listener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// if map button was clicked, toggle map visibility
		if (e.getSource().equals(btn_showMap)){
			map.setVisible(!map.isVisible());
		}
		
	}

	// method that appends text to the text area
	public void appendMessage(String s) {
		textArea_displayEvents.append("> " + s + "\n");
	}
	
	// return the textArea_displayEvents
	public JTextArea getTextArea_displayEvents() {
		return textArea_displayEvents;
	}

	// return the enteredText
	public String getEnteredText() {
		return enteredText;
	}

	// set the enteredText
	public void setEnteredText(String enteredText) {
		this.enteredText = enteredText;
	}

	// return the textField_cmdInput's input as string
	public String getInput() {
		return txtPleaseTypeAll.getText();
	}
	
}
