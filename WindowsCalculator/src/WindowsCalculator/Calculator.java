package WindowsCalculator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Calculator extends JFrame implements ActionListener 
{	
	final int MAX_INPUT_LENGTH = 20;
	final int INPUT_MODE = 0;
	final int RESULT_MODE = 1;
	final int ERROR_MODE = 2;
	int displayMode;
	boolean clearOnNextDigit;
	boolean percent;
	double lastNumber;
	String lastOperator;
	private JLabel jlOutput;
	private JButton jbButtons[];
	private JPanel jpMaster;
	private JPanel jpControl;
	
	
		
	public Calculator()
	{
		setBackground(Color.lightGray);
		jpMaster = new JPanel();
		jlOutput = new JLabel("0");
		jlOutput.setHorizontalTextPosition(JLabel.LEFT);
		jlOutput.setBackground(Color.white);
		jlOutput.setOpaque(true);
		
		getContentPane().add(jlOutput, BorderLayout.NORTH);
		jbButtons = new JButton[27];
		
		JPanel jpButtons = new JPanel();
		
		for (int i = 0; i <= 9; i++)
		{
			jbButtons[i] = new JButton(String.valueOf(i));
		}
		
		jbButtons[10] = new JButton("+/-");
		jbButtons[11] = new JButton(".");
		jbButtons[12] = new JButton("=");
		jbButtons[13] = new JButton("/");
		jbButtons[14] = new JButton("*");
		jbButtons[15] = new JButton("-");
		jbButtons[16] = new JButton("+");
		jbButtons[17] = new JButton("sqrt");
		jbButtons[18] = new JButton("%");
		jbButtons[19] = new JButton("1/x");
		
			//Function Buttons
		jbButtons[20] = new JButton("MC");
		jbButtons[21] = new JButton("MR");
		jbButtons[22] = new JButton("MS");
		jbButtons[23] = new JButton("M+");
		jbButtons[24] = new JButton("Backspace");
		jbButtons[25] = new JButton("CE");
		jbButtons[26] = new JButton("C");
		
		jpControl = new JPanel();
		jpControl.setLayout(new GridLayout(1, 3, 2, 2));
		jpControl.add(jbButtons[24]);
		jpControl.add(jbButtons[25]);
		jpControl.add(jbButtons[26]);
		
		jpButtons.setLayout(new GridLayout(4, 6, 2, 2));
		
		jpButtons.add(jbButtons[20]);  
		for (int i = 7; i <= 9; i++)  
		{
			jpButtons.add(jbButtons[i]);
		}
		jpButtons.add(jbButtons[13]); 
		jpButtons.add(jbButtons[17]); 
		
		jpButtons.add(jbButtons[21]); 
		for (int i = 4; i <= 6; i++)
		{
			jpButtons.add(jbButtons[i]); 
		}
		jpButtons.add(jbButtons[14]); 
		jpButtons.add(jbButtons[18]);  
		
			
		jpButtons.add(jbButtons[22]); 
		for (int i = 1; i <= 3; i++)
		{
			jpButtons.add(jbButtons[i]); 
		}
		jpButtons.add(jbButtons[15]); 
		jpButtons.add(jbButtons[19]);  
		
		jpButtons.add(jbButtons[23]); 
		jpButtons.add(jbButtons[0]); 
		jpButtons.add(jbButtons[10]); 
		jpButtons.add(jbButtons[11]); 
		jpButtons.add(jbButtons[16]);
		jpButtons.add(jbButtons[12]); 
		
		jpMaster.setLayout(new BorderLayout());
		jpMaster.add(jpControl, BorderLayout.EAST);
		jpMaster.add(jpButtons, BorderLayout.SOUTH);
		
		getContentPane().add(jpMaster, BorderLayout.SOUTH);
		requestFocus();
		
		for (int i = 0; i < jbButtons.length; i++)
		{
			jbButtons[i].addActionListener(this);
		}
	
		clearAll();
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosed(WindowEvent e)
			{
				System.exit(0);
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		double result = 0;
		for (int i = 0; i < jbButtons.length; i++)
		{
			if(e.getSource() == jbButtons[i])
			{
				switch(i)
				{
					case 0:
						addDigitToDisplay(i);
						break;
						
					case 1:
						addDigitToDisplay(i);
						break;
						
					case 2:
						addDigitToDisplay(i);
						break;
						
					case 3:
						addDigitToDisplay(i);
						break;
					
					case 4:
						addDigitToDisplay(i);
						break;
						
					case 5:
						addDigitToDisplay(i);
						break;
						
					case 6:
						addDigitToDisplay(i);
						break;
						
					case 7:
						addDigitToDisplay(i);
						break;
						
					case 8:
						addDigitToDisplay(i);
						break;
						
					case 9:
						addDigitToDisplay(i);
						break;
						
					case 10:
						processSignChange();
						break;
						
					case 11:
						addDecimalPoint();
						break;
						
					case 12:
						processEquals();
						break;
						
					case 13:
						processOperator("/");
						break;
						
					case 14:
						processOperator("*");
						break;
						
					case 15:
						processOperator("-");
						break;
						
					case 16:
						processOperator("+");
						break;
						
					case 17:
						if (displayMode != ERROR_MODE)
						{
							try
							{
								if (getDisplayString().indexOf("-") == 0)
									displayError("Invalid input for function.");
								
								result = Math.sqrt(getNumberInDisplay());
								displayResult(result);
							}
							catch(Exception ex)
							{
								displayError("Invalid input for function.");
								displayMode = ERROR_MODE;
							}
						}
						break;
						
					case 18:
						if (displayMode != ERROR_MODE)
						{
							try
							{
								result = getNumberInDisplay() / 100;
								displayResult(result);
							}
							catch(Exception ex)
							{
								displayError("Invalid input for function.");
								displayMode = ERROR_MODE;
							}
						}
						break;
						
					case 19:
						if (displayMode != ERROR_MODE)
						{
							try
							{
								if (getNumberInDisplay() == 0)
									displayError("Cannot divide by zero.");
								result = 1 / getNumberInDisplay();
								displayResult(result);
							}
							catch(Exception ex)
							{
								displayError("Cannot divide by zero.");
								displayMode = ERROR_MODE;
							}
						}
						break;
				
					case 20:
						if (displayMode != ERROR_MODE)
						{
							setDisplayString(getDisplayString().substring(0, getDisplayString().length() - 1));
							if (getDisplayString().length() < 1)
								setDisplayString("0");
						}
						break;
						
					case 21:
						clearExisting();
						break;
						
					case 22:
						clearAll();
						break;
					}
				}
			}
		}

		void setDisplayString(String s)
		{
			jlOutput.setText(s);
		}
		
		String getDisplayString()
		{
			return jlOutput.getText();
		}
		
		void addDigitToDisplay(int digit)
		{
			if (clearOnNextDigit)
			{
				setDisplayString("");
			}
			String inputString = getDisplayString();
			if (inputString.indexOf("0") == 0)
			{
				inputString = inputString.substring(1);
			}
			if ((!inputString.equals("0") || digit > 0) && inputString.length() < MAX_INPUT_LENGTH)
			{
				setDisplayString(inputString + digit);
			}
			displayMode = INPUT_MODE;
			clearOnNextDigit = false;
		}
		
		void addDecimalPoint()
		{
			displayMode = INPUT_MODE;
			if (clearOnNextDigit)
			{
				setDisplayString("");
			}
			String inputString = getDisplayString();
			if (inputString.indexOf(".") < 0)
			{
				setDisplayString(new String(inputString + "."));
			}
		}
		
		void processSignChange()
		{
			if (displayMode == INPUT_MODE)
			{
				String input = getDisplayString();
				if (input.length() > 0 && !input.equals("0"))
				{
					if(input.indexOf("-") == 0)
					{
						setDisplayString(input.substring(1));
					}
					else
					{
						setDisplayString("-" + input);
					}
				}
			}
		}
		
		void clearAll()
		{
			setDisplayString("0");
			lastOperator = "0";
			lastNumber = 0;
			displayMode = INPUT_MODE;
			clearOnNextDigit = true;
		}
		
		void clearExisting()
		{
			setDisplayString("0");
			clearOnNextDigit = true;
			displayMode = INPUT_MODE;
		}
		
		double getNumberInDisplay()
		{
			String input = jlOutput.getText();
			return Double.parseDouble(input);
		}
		
		void processOperator(String op)
		{
			if (displayMode != ERROR_MODE)
			{
				double numberInDisplay = getNumberInDisplay();
				if (!lastOperator.equals("0"))
				{
					try
					{
						double result = processLastOperator();
						displayResult(result);
						lastNumber = result;
					}
					catch (DivideByZeroException e)
					{
						displayError("Cannot divide by sero.");
					}
				}
				else
				{
					lastNumber = numberInDisplay;
				}
				clearOnNextDigit = true;
				lastOperator = op;
			}
		}
		
		void processEquals()
		{
			double result= 0;
			if (displayMode != ERROR_MODE)
			{
				try
				{
					result = processLastOperator();
					displayResult(result);
				}
				catch (DivideByZeroException e)
				{
					displayError("Cannot divide by sero.");
				}
				lastOperator = "0";
			}
		}
		
		double processLastOperator() throws DivideByZeroException
		{
			double result = 0;
			double numberInDisplay = getNumberInDisplay();
			if (lastOperator.equals("/"))
			{
				if (numberInDisplay == 0)
				{
					throw (new DivideByZeroException());
				}
				result = lastNumber/numberInDisplay;
			}
			if (lastOperator.equals("*"))
			{
				result = lastNumber * numberInDisplay;
			}
			if (lastOperator.equals("-"))
			{
				result = lastNumber - numberInDisplay;
			}
			if (lastOperator.equals("+"))
			{
				result = lastNumber + numberInDisplay;
			}
			return result;
		}
		
		void displayResult(double result)
		{
			setDisplayString(Double.toString(result));
			lastNumber = result;
			displayMode = RESULT_MODE;
			clearOnNextDigit = true;
		}
		
		void displayError(String errorMessage)
		{
			setDisplayString(errorMessage);
			lastNumber = 0;
			displayMode = ERROR_MODE;
			clearOnNextDigit = true;
		}
		
		public static void main(String args[]) 
		{
			Calculator calc = new Calculator();
			calc.setTitle("Calculator");
			calc.setSize(240, 200);
			calc.pack();
			calc.setLocation(400, 300);
			calc.setVisible(true);
			calc.setResizable(false);
		}
}

class DivideByZeroException extends Exception
{
	public DivideByZeroException()
	{
		super();
	}
	public DivideByZeroException(String s)
	{
		super(s);
	}
}


