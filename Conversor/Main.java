package Conversor;

import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Screen screen = new Screen();
				screen.setVisible(true);
			}
		});

	}
}