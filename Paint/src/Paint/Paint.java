package Paint;
import javax.swing.JApplet;
import javax.swing.JFrame;


public class Paint extends JApplet {
	   
	   
	   public static void main(String[] args) {
	      JFrame window = new JFrame("Paint");
	      SimplePaintPanel content = new SimplePaintPanel();
	      window.setContentPane(content);
	      window.setSize(800,700);
	      window.setLocation(100,100);
	      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	      window.setVisible(true);
	      window.repaint();
	   }
	   
	  
	   public void init() {
	      setContentPane( new SimplePaintPanel() );
	   }
}
	   
