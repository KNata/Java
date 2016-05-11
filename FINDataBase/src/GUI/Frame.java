package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		table = new JTable();
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Welcome to SQLite");
		lblNewLabel.setSize(12, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setAlignmentX(20);
		btnNewButton.setAlignmentY(300);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent action) {
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnFind = new JButton("Find");
		contentPane.add(btnFind);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(new Color(238, 238, 238));
		btnRemove.setForeground(Color.BLACK);
		btnRemove.setHorizontalAlignment(SwingConstants.WEST);
		contentPane.add(btnRemove);
		
		
	}

}
