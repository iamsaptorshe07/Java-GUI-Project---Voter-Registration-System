package voter_regestration_system;
import java.sql.*;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class LoginPanel {

	private JFrame frame;
	private JTextField userEmail;
	private JPasswordField userPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel window = new LoginPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connection = null;
	public LoginPanel() {
		initialize();
		connection = SQLiteConnection.dbconnector();
		JOptionPane.showMessageDialog(null,"Starting the Application \nCreated By \nUniversity Of Engineering & Management \n CSE Department \nSaptrshe Das 72 \n Aman Sharma 73");
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(127, 255, 212));
		frame.setBounds(100, 100, 821, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel companyIcon = new JLabel("");
		companyIcon.setHorizontalAlignment(SwingConstants.CENTER);
		Image companylogo = new ImageIcon(this.getClass().getResource("/uemlogo.png")).getImage();
		companyIcon.setIcon(new ImageIcon(companylogo));
		
		JLabel loginPanelLogo = new JLabel("");
		loginPanelLogo.setHorizontalAlignment(SwingConstants.CENTER);
		Image loginlogo = new ImageIcon(this.getClass().getResource("/icon1.png")).getImage();
		loginPanelLogo.setIcon(new ImageIcon(loginlogo));
		
		JLabel emailLabel = new JLabel("User Email");
		emailLabel.setForeground(Color.BLUE);
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(Color.BLUE);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		userEmail = new JTextField();
		userEmail.setHorizontalAlignment(SwingConstants.CENTER);
		userEmail.setColumns(10);
		
		userPassword = new JPasswordField();
		userPassword.setHorizontalAlignment(SwingConstants.CENTER);
		userPassword.setColumns(10);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				userEmail.setText("");
				userPassword.setText("");
			}
		});
		resetButton.setForeground(Color.WHITE);
		resetButton.setBackground(Color.BLUE);
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{   String query = "select * from admin where email=? and passwd=?";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1,userEmail.getText());
					pst.setString(2,userPassword.getText());
					ResultSet rst = pst.executeQuery();
					int count=0;
					while(rst.next()) {
						count++;
					}
					if(count==1)
					{
						
						frame.dispose();
						UserPanel upnl = new UserPanel();
						upnl.setVisible(true);
						userEmail.setText("");
						userPassword.setText("");
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate User name and Password found");
						userEmail.setText("");
						userPassword.setText("");
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong Information Provided");
						userEmail.setText("");
						userPassword.setText("");
					}
					rst.close();
					pst.close();
				}catch(Exception error)
				{
					JOptionPane.showMessageDialog(null, "Wrong Info Provided");
				}
			}
		});
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(new Color(0, 0, 255));
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Voter Registration System");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(182)
					.addComponent(companyIcon, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
					.addGap(143))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(118)
					.addComponent(loginPanelLogo, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(emailLabel, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
						.addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(userEmail, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addComponent(userPassword, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
					.addGap(73))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(302)
					.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
					.addGap(241))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(302)
					.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
					.addGap(241))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(companyIcon, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(userEmail, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(39)
									.addComponent(userPassword, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
							.addGap(45)
							.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(loginPanelLogo, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))))
		);
		frame.getContentPane().setLayout(groupLayout);
		
		
	}
}
