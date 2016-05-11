package NewPaint;


import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.lang.Math.*;
import java.text.*;
import java.io.*;
import java.awt.Scrollbar.*;

public class Paint extends Applet implements ActionListener, AdjustmentListener, MouseListener, MouseMotionListener
{
 /* Maximum X and Maximum Y coordinate values. */
 private final int MAX_X           = 800;
 private final int MAX_Y           = 600;

 /* Operation Constants */
 private final int  NO_OP          = 0;
 private final int  PEN_OP         = 1;
 private final int  LINE_OP        = 2;
 private final int  ERASER_OP      = 3;
 private final int  CLEAR_OP       = 4;
 private final int  RECT_OP        = 5;
 private final int  OVAL_OP        = 6;
 private final int  FRECT_OP       = 7;
 private final int  FOVAL_OP       = 8;

 /* Current mouse coordinates */
 private int mousex                = 0;
 private int mousey                = 0;

 /* Previous mouse coordinates */
 private int prevx                 = 0;
 private int prevy                 = 0;

 /* Initial state falgs for operation */
 private boolean initialPen        = true;
 private boolean initialLine       = true;
 private boolean initialRect       = true;
 private boolean initialOval       = true;
 private boolean initialFRect      = true;
 private boolean initialFOval      = true;

 /* Main Mouse X and Y coordiante variables */
 private int  Orx                  = 0;
 private int  Ory                  = 0;
 private int  OrWidth              = 0;
 private int  OrHeight             = 0;
 private int  drawX                = 0;
 private int  drawY                = 0;
 private int  udefRedValue         = 255;
 private int  udefGreenValue       = 255;
 private int  udefBlueValue        = 255;

 /* Primitive status & color variables */
 private int    opStatus           = PEN_OP;
 private int    colorStatus        = 1;
 private Color  mainColor          = new Color(0,0,0);
 private Color  xorColor           = new Color(255,255,255);
 private Color  statusBarColor     = new Color(166,166,255);
 private Color  userDefinedColor   = new Color(udefRedValue,udefGreenValue,udefBlueValue);

 /* Operation Button definitions */
 private Button lineButton         = new Button("Line");
 private Button clearButton        = new Button("Clear");
 private Button rectButton         = new Button("Rectangle");
 private Button ovalButton         = new Button("Oval");
 private Button fillRectButton     = new Button("Filled Rectangle");
 private Button fillOvalButton     = new Button("Filled Oval");

 /* Color Button definitions */
 private Button blackButton        = new Button("Black");
 private Button blueButton         = new Button("Blue");
 private Button redButton          = new Button("Red");
 private Button greenButton        = new Button("Green");

 /* User defined Color variables */
 private Scrollbar redSlider       = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 255);
 private Scrollbar blueSlider      = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 255);
 private Scrollbar greenSlider     = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 255);

 /* Assorted status values for different variables */
 private TextField colorStatusBar  = new TextField(20);
 private TextField opStatusBar     = new TextField(20);
 private TextField mouseStatusBar  = new TextField(10);
 private TextField redValue        = new TextField(3);
 private TextField greenValue      = new TextField(3);
 private TextField blueValue       = new TextField(3);

 /* Labels for operation and color fields */
 private Label operationLabel      = new Label("   Tool mode:");
 private Label colorLabel          = new Label("   Color mode:");
 private Label cursorLabel         = new Label("   Cursor:");

 /* Sub panels of the main applet */
 private Panel controlPanel        = new Panel(new GridLayout(11,2,0,0));
 private Panel drawPanel           = new Panel();
 private Panel statusPanel         = new Panel();
 private Panel udefcolPanel        = new Panel(new GridLayout(3,2,0,0));
 private Panel udefdemcolPanel     = new Panel();


 public void init()
 {
    setLayout(new BorderLayout());
    this.setSize(1000, 1000);
    /* setup color buttons */
    controlPanel.add(blackButton);
    controlPanel.add(blueButton);
    controlPanel.add(redButton);
    controlPanel.add(greenButton);

    blueButton.setBackground(Color.blue);
    redButton.setBackground(Color.red);
    greenButton.setBackground(Color.green);


    /* setup operation buttons */
    controlPanel.add(lineButton);
    controlPanel.add(clearButton);
    controlPanel.add(rectButton);
    controlPanel.add(ovalButton);
    

    controlPanel.setBounds(0,0,100,300);
    controlPanel.add(udefcolPanel);
    controlPanel.add(udefdemcolPanel);

    /* Add user-defined RGB buttons to panel */
    udefcolPanel.add(redValue);
    udefcolPanel.add(redSlider);

    udefcolPanel.add(greenValue);
    udefcolPanel.add(greenSlider);

    udefcolPanel.add(blueValue);
    udefcolPanel.add(blueSlider);


    /* Add label and color text field */
    statusPanel.add(colorLabel);
    statusPanel.add(colorStatusBar);

    /* Add label and operation text field */
    statusPanel.add(operationLabel);
    statusPanel.add(opStatusBar);

    /* Add label and cursor text field */
    statusPanel.add(cursorLabel);
    statusPanel.add(mouseStatusBar);

    /* Set not editable */
    colorStatusBar.setEditable(false);
    opStatusBar.setEditable(false);
    mouseStatusBar.setEditable(false);

    statusPanel.setBackground(statusBarColor);
    controlPanel.setBackground(Color.white);
    drawPanel.setBackground(Color.white);
    add(statusPanel, "North");
    add(controlPanel, "West");
    add(drawPanel, "Center");

    /* Setup action listener */
    lineButton.addActionListener(this);
    
    clearButton.addActionListener(this);
    rectButton.addActionListener(this);
    ovalButton.addActionListener(this);
    

    blackButton.addActionListener(this);
    blueButton.addActionListener(this);
    redButton.addActionListener(this);
    greenButton.addActionListener(this);
   

    redSlider.addAdjustmentListener(this);
    blueSlider.addAdjustmentListener(this);
    greenSlider.addAdjustmentListener(this);

    /* Adding component listeners to main panel (applet) */
    drawPanel.addMouseMotionListener(this);
    drawPanel.addMouseListener(this);
    this.addMouseListener(this);
    this.addMouseMotionListener(this);

    updateRGBValues();

    colorStatusBar.setText("Black");
 }


 
 public void actionPerformed(ActionEvent e)
 {
   
    if (e.getActionCommand() == "Line")
       opStatus = LINE_OP;

    if (e.getActionCommand() == "Clear")
       opStatus = CLEAR_OP;

    if (e.getActionCommand() == "Rectangle")
       opStatus = RECT_OP;

    if (e.getActionCommand() == "Oval")
       opStatus = OVAL_OP;

    if (e.getActionCommand() == "Black")
       colorStatus = 1;

    if (e.getActionCommand() == "Blue")
       colorStatus = 2;

    if (e.getActionCommand() == "Green")
       colorStatus = 3;

    if (e.getActionCommand() == "Red")
       colorStatus = 4;

    
       switch (opStatus) {
       case LINE_OP  : opStatusBar.setText("Line");
                       break;

       
       case CLEAR_OP : clearPanel(drawPanel);
                       break;

       case RECT_OP  : opStatusBar.setText("Rectangle");
                       break;

       case OVAL_OP  : opStatusBar.setText("Oval");
                       break;

    }
 
    /* Update Color status bar, with current color */
    switch (colorStatus)
    {
       case  1: colorStatusBar.setText("Black");
                break;

       case  2:  colorStatusBar.setText("Blue");
                 break;

       case  3:  colorStatusBar.setText("Green");
                 break;

       case  4:  colorStatusBar.setText("Red");
                 break;

  
    }
    /*
      Set main color, to equivelent colorStatus value */
   
    setMainColor();
    updateRGBValues();
 }
    

 public void adjustmentValueChanged(AdjustmentEvent e)
 {
    updateRGBValues();
 }


 
 public void clearPanel(Panel p)
 {
    opStatusBar.setText("Clear");
    Graphics g = p.getGraphics();
    g.setColor(p.getBackground());
    g.fillRect(0,0,p.getBounds().width,p.getBounds().height);
  }


 
 public void penOperation(MouseEvent e)
 {
    Graphics g  = drawPanel.getGraphics();
    g.setColor(mainColor);

    /*
      In initial state setup default values
      for mouse coordinates
    */
    if (initialPen)
    {
       setGraphicalDefaults(e);
       initialPen = false;
       g.drawLine(prevx,prevy,mousex,mousey);
    }

    
    if (mouseHasMoved(e))
    {
       
       mousex = e.getX();
       mousey = e.getY();

       
       g.drawLine(prevx,prevy,mousex,mousey);

      
       prevx = mousex;
       prevy = mousey;
    }
 }


 /*
   Method will emulate a line drawing graphic.
   By drawing a shadow line for an origin mouse
   coordinate pair to a moving mouse coordinate pair, until the mouse has been release from dragmode.
 */
 public void lineOperation(MouseEvent e)
 {
    Graphics g  = drawPanel.getGraphics();
    g.setColor(mainColor);

   
    if (initialLine)
    {
       setGraphicalDefaults(e);
       g.setXORMode(xorColor);
       g.drawLine(Orx,Ory,mousex,mousey);
       initialLine=false;
    }

   
    if (mouseHasMoved(e))
    {
       
       g.setXORMode(xorColor);
       g.drawLine(Orx,Ory,mousex,mousey);

       /* Update new mouse coordinates */
       mousex = e.getX();
       mousey = e.getY();

       /* Draw line shadow */
       g.drawLine(Orx,Ory,mousex,mousey);
    }
 }


 /*
   Method will emulate a rectangle drawing graphic.
   By drawing a shadow rectangle for an origin mouse
   coordinate pair to a moving mouse coordinate pair, until the mouse has been release from  dragmode.
 */
 public void rectOperation(MouseEvent e)
 {
    Graphics g  = drawPanel.getGraphics();
    g.setColor(mainColor);

    if (initialRect)
    {
       setGraphicalDefaults(e);
       initialRect = false;
    }

    if (mouseHasMoved(e))
    {
      
       g.setXORMode(drawPanel.getBackground());
       g.drawRect(drawX,drawY,OrWidth,OrHeight);

       mousex = e.getX();
       mousey = e.getY();

       setActualBoundry();

       g.drawRect(drawX,drawY,OrWidth,OrHeight);

    }

 }


 /*
   Method will emulate a oval drawing graphic.
   By drawing a shadow oval for an origin mouse coordinate pair to a moving mouse coordinate pair, until the mouse has been release from
   dragmode.
 */
 public void ovalOperation(MouseEvent e)
 {
    Graphics g  = drawPanel.getGraphics();
    g.setColor(mainColor);

   
    if (initialOval)
    {
       setGraphicalDefaults(e);
       initialOval=false;
    }

    if (mouseHasMoved(e))
    {
      
       g.setXORMode(xorColor);
       g.drawOval(drawX,drawY,OrWidth,OrHeight);

      
       mousex = e.getX();
       mousey = e.getY();

       setActualBoundry();

       g.drawOval(drawX,drawY,OrWidth,OrHeight);
    }
 }


 
 public boolean mouseHasMoved(MouseEvent e)
 {
    return (mousex != e.getX() || mousey != e.getY());
 }



 public void setActualBoundry()
 {
      
       if (mousex < Orx || mousey < Ory)
       {
          
          if (mousex < Orx)
          {
             OrWidth = Orx - mousex;
             drawX   = Orx - OrWidth;
          }
          else
          {
             drawX    = Orx;
             OrWidth  = mousex - Orx;

          }
         
          if (mousey < Ory)
          {
             OrHeight = Ory - mousey;
             drawY    = Ory - OrHeight;
          }
          else
          {
             drawY    = Ory;
             OrHeight = mousey - Ory;
          }
       }
       
       else
       {
          drawX    = Orx;
          drawY    = Ory;
          OrWidth  = mousex - Orx;
          OrHeight = mousey - Ory;
       }
 }


 
 public void setGraphicalDefaults(MouseEvent e)
 {
    mousex   = e.getX();
    mousey   = e.getY();
    prevx    = e.getX();
    prevy    = e.getY();
    Orx      = e.getX();
    Ory      = e.getY();
    drawX    = e.getX();
    drawY    = e.getY();
    OrWidth  = 0;
    OrHeight = 0;
 }


 
 public void mouseDragged(MouseEvent e)
 {
    updateMouseCoordinates(e);

    switch (opStatus)
    {
       case PEN_OP   : penOperation(e);
                       break;

       case LINE_OP  : lineOperation(e);
                       break;

       case RECT_OP  : rectOperation(e);
                       break;

       case OVAL_OP  : ovalOperation(e);
                       break;

       
    }
 }


 
 public void mouseReleased(MouseEvent e)
 {
    updateMouseCoordinates(e);

    switch (opStatus)
    {
       case PEN_OP    : releasedPen();
                        break;

       case LINE_OP   : releasedLine();
                        break;

       case RECT_OP   : releasedRect();
                        break;

       case OVAL_OP   : releasedOval();
                        break;

       case FRECT_OP  : releasedFRect();
                        break;

       case FOVAL_OP  : releasedFOval();
                        break;

    }
 }


 /*
    Method will be activated when mouse enters the applet area.
    This method will then update the current mouse x and coordinates
    on the screen.
 */
 public void mouseEntered(MouseEvent e)
 {
    updateMouseCoordinates(e);
 }


 /*
   Method will set the main system color according to the
   current color status.
 */
 public void setMainColor()
 {
    switch (colorStatus)
    {
       case 1 : mainColor = Color.black;
                break;

       case 2:  mainColor = Color.blue;
                break;

       case 3:  mainColor = Color.green;
                break;

       case 4:  mainColor = Color.red;
                break;

       
    }
 }



 public void releasedPen()
 {
    initialPen = true;
 }


 /*
   Method is invoked when mouse has been released
   and current operation is Line
 */
 public void releasedLine()
 {
    if ((Math.abs(Orx - mousex) + Math.abs(Ory - mousey)) != 0)
    {
       System.out.println("Line has been released....");
       initialLine = true;
       Graphics g  = drawPanel.getGraphics();
       g.setColor(mainColor);
       g.drawLine(Orx,Ory,mousex,mousey);
    }
 }


 
 
 /*
   Method is invoked when mouse has been released
   and current operation is Rectangle
 */
 public void releasedRect()
 {
    initialRect = true;
    Graphics g  = drawPanel.getGraphics();
    g.setColor(mainColor);
    g.drawRect(drawX,drawY,OrWidth,OrHeight);
 }


 /*
   Method is invoked when mouse has been released
   and current operation is Oval
 */
 public void releasedOval()
 {
    initialOval = true;
    Graphics g  = drawPanel.getGraphics();
    g.setColor(mainColor);
    g.drawOval(drawX,drawY,OrWidth,OrHeight);
 }


 /*
   Method is invoked when mouse has been released
   and current operation is Fill-Rectangle
 */
 public void releasedFRect()
 {
    initialFRect = true;
    Graphics g  = drawPanel.getGraphics();
    g.setColor(mainColor);
    g.fillRect(drawX,drawY,OrWidth,OrHeight);
 }


 /*
   Method is invoked when mouse has been released
   and current operation is Fill-Oval
 */
 public void releasedFOval()
 {
    initialFOval = true;
    Graphics g  = drawPanel.getGraphics();
    g.setColor(mainColor);
    g.fillOval(drawX - 1,drawY - 1,OrWidth + 2,OrHeight + 2);
 }


 /*
   Method displays the mouse coordinates x and y values
   and updates the mouse status bar with the new values.
 */
 public void updateMouseCoordinates(MouseEvent e)
 {
    String xCoor ="";
    String yCoor ="";

    if (e.getX() < 0) xCoor = "0";
    else
    {
       xCoor = String.valueOf(e.getX());
    }

    if (e.getY() < 0) xCoor = "0";
    else
    {
       yCoor = String.valueOf(e.getY());
    }
    mouseStatusBar.setText("x:" + xCoor + "   y:" + yCoor);
 }


 public void updateRGBValues()
 {
    udefRedValue = redSlider.getValue();
    udefGreenValue = greenSlider.getValue();
    udefBlueValue = blueSlider.getValue();
    if (udefRedValue > 255)
       udefRedValue = 255;

    if (udefRedValue < 0 )
       udefRedValue =0;

    if (udefGreenValue > 255)
       udefGreenValue = 255;

    if (udefGreenValue < 0 )
       udefGreenValue =0;

    if (udefBlueValue > 255)
       udefBlueValue = 255;

    if (udefBlueValue < 0 )
       udefBlueValue =0;

    redValue.setText(String.valueOf(udefRedValue));
    greenValue.setText(String.valueOf(udefGreenValue));
    blueValue.setText(String.valueOf(udefBlueValue));

    userDefinedColor = new Color(udefRedValue,udefGreenValue,udefBlueValue);

    Graphics g = udefdemcolPanel.getGraphics();
    g.setColor(userDefinedColor);
    g.fillRect(0,0,800,800);
 }


 public void mouseExited(MouseEvent e)
 {
    updateMouseCoordinates(e);
 }


 /*
   Method updates mouse coordinates if mouse has moved
 */
 public void mouseMoved(MouseEvent e)
 {
    updateMouseCoordinates(e);
 }


 /*
   Method updates mouse coordinates if mouse has been pressed
 */
 public void mousePressed(MouseEvent e)
 {
    updateMouseCoordinates(e);
 }


@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

} 

