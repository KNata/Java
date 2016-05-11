package Example3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Paint extends Frame implements MouseListener, MouseMotionListener{
	
	Point start;
	
	ArrayList<Line> lineList = new ArrayList<Line>();
	int x;
	int y;
	
	public Paint(String title, int width, int heigth) {
		super(title);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.out.println(Thread.currentThread().getName() + "Paint");
				System.exit(0);
			}
		});
		this.setSize(width, heigth);
		this.add("West", new Button("Ok"));
		this.add("East", new Button("Cancel"));
		this.setBackground(Color.lightGray);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println(e.getX() + "" + e.getY());
		Line theLine = new Line(x, y, e.getX(), e.getY());
		lineList.add(theLine);
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (Line line : lineList) {
			line.paint(g);
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
