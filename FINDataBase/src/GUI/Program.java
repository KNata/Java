package GUI;

import javax.swing.JFrame;

public class Program {

	public static void main(String[] args) {
		Template theFrame = new Template();
		theFrame.setVisible(true);
		theFrame.setSize(800,700);
		theFrame.setLocation(100,100);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		theFrame.setVisible(true);
		//theFrame.repaint();
	}

}
