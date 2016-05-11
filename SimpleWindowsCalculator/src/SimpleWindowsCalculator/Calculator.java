package SimpleWindowsCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue; 
import java.awt.GridLayout; 
import java.awt.BorderLayout; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JTextField; 
import javax.swing.JButton; 
import java.awt.Container;


public class Calculator implements ActionListener {

	private JFrame mainFrame;
	private JTextField textField;
	private JPanel buttonPanel;
	
	private int currentOperation;
	private int currentCulculator;
	
	Calculator() {
		currentOperation = 0;
		this.init();
	}
	
	public void init() {
		mainFrame = new JFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(400, 400);
		mainFrame.setTitle("Calculator");
		//mainFrame.setLocation(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setEditable(false);
		
		mainFrame.add(textField, BorderLayout.NORTH);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,3));
		mainFrame.add(buttonPanel, BorderLayout.CENTER);
		
		for (int i = 0; i < 10; i++) {
			addButton(buttonPanel, String.valueOf(i));
		}
		
		final JButton addButton = new JButton();
		addButton.setActionCommand("+");
		
		OperatorAction addAction = new OperatorAction(1);
		addButton.addActionListener(addAction);
			
		final JButton subButton = new JButton();
		subButton.setActionCommand("-");
		
		OperatorAction subAction = new OperatorAction(2);
		subButton.addActionListener(subAction);
		
		final JButton multButton = new JButton();
		multButton.setActionCommand("*");
		
		OperatorAction multAction = new OperatorAction(3);
		multButton.addActionListener(multAction);
		
		final JButton divButton = new JButton();
		divButton.setActionCommand("/");
		
		OperatorAction divAction = new OperatorAction(4);
		divButton.addActionListener(divAction);
		
		JButton equalsButton = new JButton();
		equalsButton.setActionCommand("=");
		equalsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent action) {
				if (!textField.getText().isEmpty()) {
					int value = Integer.parseInt(textField.getText());
					if (currentOperation == 1) {
						int result = currentCulculator + value;
						addButton.setText(Integer.toString(result));
					} else if (currentOperation == 2) {
						int result = currentCulculator - value;
						subButton.setText(Integer.toString(result));
					} else if (currentOperation == 3) {
						int result = currentCulculator * value;
						multButton.setText(Integer.toString(result));
					} else if (currentOperation == 4) {
						int result = currentCulculator / value;
						divButton.setText(Integer.toString(result));
					}
				}
				
			}
		});
		
		
		mainFrame.add(addButton);
		mainFrame.add(subButton);
		mainFrame.add(multButton);
		mainFrame.add(divButton);
		mainFrame.add(equalsButton);
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String operation = event.getActionCommand();
		textField.setText(operation);
	}
	
	private void addButton(Container aContainer, String name) {
		JButton button = new JButton();
		button.setText(name);
		button.setActionCommand(name);
		button.addActionListener(this);
		aContainer.add(button);
	}
	
	
	private class OperatorAction implements ActionListener {

		private int operator;
		
		OperatorAction(int anOperator) {
			operator = anOperator;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			currentCulculator = Integer.parseInt(textField.getText());
			currentOperation = operator;
		}
	}
}
