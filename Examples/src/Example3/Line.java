package Example3;

import java.awt.Graphics;
import java.util.ArrayList;

public class Line {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	
	Line(int x, int y, int x1, int y1) {
		startX = x;
		startY = y;
		endX = x1;
		endY = y1;
	}
	
	public void paint(Graphics g) {
		g.drawLine(startY, startY, endX, endY);
	}
}
