package Example5;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class ExitListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
	}
	
}

class AboutListener implements ActionListener{

	private JFrame parent;
	
	AboutListener(JFrame p){
		parent = p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("About  " + e.getActionCommand());
		JDialog jd = new JDialog(parent,"Dialog");
		JTextArea ta = new JTextArea("Text area");
		ta.setBounds(5, 5, 100, 50);
		jd.setBounds(10, 10, 200, 100);
		jd.add(ta);
		jd.setVisible(true);
		
	}
	
}

public class MyAWTFrame extends JFrame {

	private JButton MyButton = null;
	private Button exitButton = null;

	private JMenuBar menu = null;
	private JMenu help = null;
	private JMenu file = null;
	private JMenuItem itemAbout = null;
	private JMenuItem itemExit = null;
	private ExitListener el = new ExitListener();
	private AboutListener al = new AboutListener(this);
	
	private JMenuBar getMenu(){
		if (menu==null){
			menu = new JMenuBar();
			file = new JMenu("File");
			help = new JMenu("Help");
			itemAbout = new JMenuItem("About");
			itemAbout.addActionListener(al);
			itemAbout.setActionCommand("about");
			itemExit = new JMenuItem("Exit");
			itemExit.addActionListener(el);
			file.add(itemExit);
			help.add(itemAbout);
			menu.add(file);
			menu.add(help);
		}
	
		return menu;
	}
	
	private JButton getMyButton() {
		if (MyButton == null) {
			MyButton = new JButton();
			MyButton.setPreferredSize(new Dimension(34, 20));
			MyButton.setText("Test");
			MyButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("actionPerformed()");
				}
			});
		}
		return MyButton;
	}

	private Button getExitButton() {
		if (exitButton == null) {
			exitButton = new Button();
			exitButton.setLabel("Exit");
			exitButton.addActionListener(el);
		}
		return exitButton;
	}
	public static void main(String[] args) {
		MyAWTFrame frame = new MyAWTFrame("My AWT");
		frame.setVisible(true);
	}
	public MyAWTFrame(String owner) {
		super(owner);
		initialize();
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.out.println(Thread.currentThread().getName()+ " MyAwtÿ");
				System.exit(0);
			}
		});
	}
	private void initialize() {
		this.setSize(300, 200);
                this.setLocationByPlatform(true);
		this.add(getMyButton(), BorderLayout.NORTH);
		this.add(getExitButton(), BorderLayout.SOUTH);
		this.setJMenuBar(getMenu());
	}
}
