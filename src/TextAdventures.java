import javax.swing.SwingUtilities;

public class TextAdventures {

	public static void main(String[] args) {

		// safely start the welcome frame
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WelcomeScreen();
			}
		});

	}

}
