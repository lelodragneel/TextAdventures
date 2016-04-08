import javax.swing.JFrame;
import java.awt.GridBagLayout;

@SuppressWarnings("serial")
public class Map extends JFrame {
	
	public Map() {
		
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("World Map");
		setBounds(0, 0, 1000, 400);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		
		
		
		
		
		setVisible(false);
	}

	
}
