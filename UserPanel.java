package voter_regestration_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class UserPanel extends JFrame {

	private JPanel contentPanel;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField mobileField;
	private JTextField dobField;
	private JTextField gurdianField;
	private JTextField relationField;
	private JTextField addressField;
	private JTextField stateField;
	private JTextField pinField;
	private JTextField ageField;
	private JTextField aadharField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel frame = new UserPanel();
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
	Connection connection = null;
	public UserPanel() {
		connection = SQLiteConnection.dbconnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 534);
		contentPanel = new JPanel();
		contentPanel.setBackground(Color.CYAN);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		
		JLabel lblNewLabel = new JLabel("User Panel For Registration");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLUE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.BLUE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		emailField = new JTextField();
		emailField.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Phone");
		lblContactNo.setForeground(Color.BLUE);
		lblContactNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		mobileField = new JTextField();
		mobileField.setColumns(10);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setForeground(Color.BLUE);
		lblDob.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		dobField = new JTextField();
		dobField.setColumns(10);
		
		JLabel lblGurdian = new JLabel("Gurdian");
		lblGurdian.setForeground(Color.BLUE);
		lblGurdian.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		gurdianField = new JTextField();
		gurdianField.setColumns(10);
		
		JLabel lblRelWithGurdian = new JLabel("Relation");
		lblRelWithGurdian.setForeground(Color.BLUE);
		lblRelWithGurdian.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		relationField = new JTextField();
		relationField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.BLUE);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		addressField = new JTextField();
		addressField.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblState.setForeground(Color.BLUE);
		
		stateField = new JTextField();
		stateField.setColumns(10);
		
		JLabel lblPin = new JLabel("PIN");
		lblPin.setForeground(Color.BLUE);
		lblPin.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		pinField = new JTextField();
		pinField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(Color.BLUE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		ageField = new JTextField();
		ageField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.BLUE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JRadioButton maleVal = new JRadioButton("Male");
		buttonGroup.add(maleVal);
		maleVal.setBackground(Color.BLUE);
		maleVal.setFont(new Font("Tahoma", Font.BOLD, 15));
		maleVal.setForeground(Color.CYAN);
		
		JRadioButton femaleVal = new JRadioButton("Female");
		buttonGroup.add(femaleVal);
		femaleVal.setBackground(Color.BLUE);
		femaleVal.setFont(new Font("Tahoma", Font.BOLD, 15));
		femaleVal.setForeground(Color.CYAN);
		
		JRadioButton genderOtherVal = new JRadioButton("Others");
		buttonGroup.add(genderOtherVal);
		genderOtherVal.setBackground(Color.BLUE);
		genderOtherVal.setFont(new Font("Tahoma", Font.BOLD, 15));
		genderOtherVal.setForeground(Color.CYAN);
	
		ButtonGroup bg = new ButtonGroup();
		bg.add(maleVal);
		bg.add(femaleVal);
		bg.add(genderOtherVal);
		
		JLabel lblAdharNo = new JLabel("Aadhar");
		lblAdharNo.setForeground(Color.BLUE);
		lblAdharNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		aadharField = new JTextField();
		aadharField.setColumns(10);
		
		JCheckBox confirmation = new JCheckBox("All the above mentioned Informations are True");
		
		JButton submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(nameField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty() || 
						mobileField.getText().trim().isEmpty() || 
						dobField.getText().trim().isEmpty() || gurdianField.getText().trim().isEmpty() ||
						relationField.getText().trim().isEmpty() || addressField.getText().trim().isEmpty() ||
						stateField.getText().trim().isEmpty() || pinField.getText().trim().isEmpty() ||
						ageField.getText().trim().isEmpty() || aadharField.getText().trim().isEmpty() ||
						bg.getSelection()==null
					)
				         {    
					        //System.out.print("test");
				 	        JOptionPane.showMessageDialog(null,"Please fill all the information");
				         }
				else if(confirmation.isSelected()==false)
				{
					JOptionPane.showMessageDialog(null,"Please confirm it that all the informations are valid");
				}
		
		     try
		     {
		    	 String query = "insert into user values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    	 PreparedStatement pst=connection.prepareStatement(query);
		    	 pst.setString(1,nameField.getText());
		    	 pst.setString(2,emailField.getText());
		    	 pst.setString(3,mobileField.getText());
		    	 pst.setString(4,dobField.getText());
		    	 pst.setString(5,gurdianField.getText());
		    	 pst.setString(6,relationField.getText());
		    	 pst.setString(7,addressField.getText());
		    	 pst.setString(8,stateField.getText());
		    	 pst.setString(9,pinField.getText());
		    	 pst.setString(10,ageField.getText());
		    	 if(maleVal.isSelected()==true)
		    	 {
		    		pst.setString(11, maleVal.getText()); 
		    	 }
		    	 else if(femaleVal.isSelected()==true)
		    	 {
		    		 pst.setString(11, femaleVal.getText()); 
		    	 }
		    	 else
		    	 {
		    		 pst.setString(11, genderOtherVal.getText()); 
		    	 }
		    	 pst.setString(12,aadharField.getText());
		    	 pst.execute();
		    	 JOptionPane.showMessageDialog(null,"Application Submitted");
		    	 pst.close();
		     }catch(Exception error)
		     {
		    	 JOptionPane.showMessageDialog(null, error);
		     }
			
			}	
			                                            });
		submitButton.setForeground(Color.CYAN);
		submitButton.setBackground(Color.BLUE);
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			  nameField.setText("");
			  emailField.setText("");
			  mobileField.setText("");
			  dobField.setText("");
			  gurdianField.setText("");
			  relationField.setText("");
			  addressField.setText("");
			  stateField.setText("");
			  pinField.setText("");
			  ageField.setText("");
			  aadharField.setText("");
			  maleVal.setSelected(false);
			  femaleVal.setSelected(false);
			  genderOtherVal.setSelected(false);
			  
			}
		});
		resetButton.setForeground(Color.CYAN);
		resetButton.setBackground(Color.BLUE);
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		confirmation.setForeground(Color.CYAN);
		confirmation.setBackground(Color.BLUE);
		confirmation.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton showdataButton = new JButton("Show Information");
		showdataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				UserPanel.this.dispose();
				DataFrame df = new DataFrame();
				df.setVisible(true);
				
			}
		});
		showdataButton.setBackground(Color.BLUE);
		showdataButton.setForeground(Color.CYAN);
		showdataButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(15)
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(nameField, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
					.addGap(58)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(emailField, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(55)
					.addComponent(lblContactNo)
					.addGap(10)
					.addComponent(mobileField, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(31))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(15)
					.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(dobField, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
					.addGap(50)
					.addComponent(lblGurdian)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(gurdianField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
					.addGap(55)
					.addComponent(lblRelWithGurdian, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(relationField, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addGap(31))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(123)
					.addComponent(confirmation, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
					.addGap(212))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(ageField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblAdharNo)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(aadharField, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
							.addGap(58))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(addressField, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addGap(54)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(stateField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
							.addGap(55)
							.addComponent(lblPin, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(pinField, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(submitButton, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(maleVal, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
									.addGap(20)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(9)
									.addComponent(femaleVal, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(genderOtherVal, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(59)
									.addComponent(resetButton, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))))
					.addGap(41))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(205)
					.addComponent(showdataButton, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
					.addGap(246))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblContactNo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(mobileField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblDob, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(dobField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(gurdianField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblGurdian, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblRelWithGurdian, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(relationField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(stateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPin, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(pinField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(maleVal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(genderOtherVal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(femaleVal, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdharNo)
						.addComponent(aadharField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(showdataButton)
					.addGap(18)
					.addComponent(confirmation, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
	}
}
