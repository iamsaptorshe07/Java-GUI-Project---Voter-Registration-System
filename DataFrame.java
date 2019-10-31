package voter_regestration_system;
import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DataFrame extends JFrame {

	private JPanel dataPanel;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataFrame frame = new DataFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */Connection connection = null;
	public DataFrame() {
		connection = SQLiteConnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 538);
		dataPanel = new JPanel();
		dataPanel.setBackground(Color.CYAN);
		dataPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(dataPanel);
		
		JScrollPane viewTable = new JScrollPane();
		
		table = new JTable();
		viewTable.setViewportView(table);
		try
		{
		    	 String query = "select * from user;";
		    	 PreparedStatement pst=connection.prepareStatement(query);
		    	 ResultSet rst = pst.executeQuery();
		    	 table.setModel(DbUtils.resultSetToTableModel(rst));
		    	 rst.close();
		    	 pst.close();
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
		
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
				    	 String query = "select * from user;";
				    	 PreparedStatement pst=connection.prepareStatement(query);
				    	 ResultSet rst = pst.executeQuery();
				    	 table.setModel(DbUtils.resultSetToTableModel(rst));
				    	 rst.close();
				    	 pst.close();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,e);
				}
			}
		});
		refreshButton.setForeground(Color.CYAN);
		refreshButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		refreshButton.setBackground(Color.BLUE);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		searchButton.setForeground(Color.CYAN);
		searchButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		searchButton.setBackground(Color.BLUE);
		
		JButton updateButton = new JButton("Update");
		updateButton.setForeground(Color.CYAN);
		updateButton.setBackground(Color.BLUE);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setForeground(Color.CYAN);
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		deleteButton.setBackground(Color.BLUE);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_dataPanel = new GroupLayout(dataPanel);
		gl_dataPanel.setHorizontalGroup(
			gl_dataPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_dataPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(updateButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
						.addComponent(searchButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
						.addComponent(deleteButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
						.addComponent(refreshButton, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(viewTable, GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_dataPanel.setVerticalGroup(
			gl_dataPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGap(242)
					.addComponent(refreshButton)
					.addGap(18)
					.addComponent(searchButton)
					.addGap(18)
					.addComponent(updateButton)
					.addGap(18)
					.addComponent(deleteButton)
					.addContainerGap(101, Short.MAX_VALUE))
				.addGroup(gl_dataPanel.createSequentialGroup()
					.addGap(6)
					.addComponent(viewTable, GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
					.addGap(6))
		);
		dataPanel.setLayout(gl_dataPanel);
	}

}
