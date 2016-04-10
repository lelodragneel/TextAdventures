package General;

import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

@SuppressWarnings("serial")
public class Map extends JFrame {
	
	public Map() {
		
		setTitle("World Map");
		setAlwaysOnTop(true);	
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(0, 0, 1000, 400);
		getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(3, 3, 3, 3);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = gbc.weighty = 1.0;
	
		
		
		
		setVisible(false);
	}

	
}
