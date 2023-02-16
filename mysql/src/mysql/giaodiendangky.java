package mysql;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class giaodiendangky extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
    private JTextField username;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JPasswordField passwordField_1;
    private JTextField fullname;
    private JTextField email;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giaodiendangky frame = new giaodiendangky();
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
	public giaodiendangky() {
		
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 901, 470);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBackground(SystemColor.inactiveCaption);
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewUserRegister = new JLabel("Register");
	        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
	        lblNewUserRegister.setBounds(230, 10, 193, 50);
	        contentPane.add(lblNewUserRegister);

	        username = new JTextField();
	        username.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        username.setBounds(198, 110, 206, 29);
	        contentPane.add(username);
	        username.setColumns(10);

	        JLabel lblUsername = new JLabel("UserName");
	        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblUsername.setBounds(48, 110, 155, 29);
	        contentPane.add(lblUsername);

	        JLabel lblPassword = new JLabel("PassWord");
	        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblPassword.setBounds(48, 198, 155, 24);
	        contentPane.add(lblPassword);

	        passwordField = new JPasswordField();
	        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        passwordField.setBounds(198, 191, 206, 29);
	        contentPane.add(passwordField);

	        btnNewButton = new JButton("Register");
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            		            	
	                String userName  = username.getText();
	                String password  = passwordField.getText();
	                String password1 = passwordField_1.getText();
	                String FullName  = fullname.getText();
	                String Email     = email.getText();
	                StringBuilder ab=new StringBuilder();
					

	                if (userName.equals("")) {
						ab.append("Tài khoảng không được để trắng \n");
					}
					if (password.equals("")) {
						ab.append("không được để mật khẩu trắng \n");
					}
					if (password1.equals("")) {
						ab.append("bạn chưa nhập lại mật khẩu  \n");
					}
					if (password.equals(password1)==false) {
						ab.append("Tài khoảng mật khẩu trùng nhau");
					}
					if (FullName.equals("")) {
						ab.append("Bạn chưa nhập họ và tên \n");
					}
					if (Email.equals("")) {
						ab.append("bạn chưa nhập email \n");
					}
					 if (ab.length()>0) {
							JOptionPane.showMessageDialog(null, ab.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
							return;}
					else {
	                try {	                	
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thongtin", "root", "huynhquang");
	                    String query = "INSERT INTO `thongtin`.`thongtinkhachhang` (`UserName`, `PassWord`,`FullName`,`Email`) VALUES ('"+userName+"', '"+password+"','"+FullName+"','"+Email+"');";
	                    Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);	                  
	                    if (x > 0) {
	                    	JOptionPane.showMessageDialog(btnNewButton,
		                    		"Welcome, " + "Your account is sucessfully created");	                    	
	                    }
	                    connection.close();
	                    
	                    
	                } catch (SQLException exception) {
	                    JOptionPane.showMessageDialog(btnNewButton, "Tài khoảng đã tồn tại");
	                }
	               
						
	                }
	            }});
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        btnNewButton.setBounds(558, 368, 175, 41);
	        contentPane.add(btnNewButton);
	        
	        JLabel lblNewLabel = new JLabel("Re-enter PassWord. ");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNewLabel.setBounds(10, 283, 193, 29);
	        contentPane.add(lblNewLabel);
	        
	        passwordField_1 = new JPasswordField();
	        passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        passwordField_1.setBounds(198, 278, 206, 29);
	        contentPane.add(passwordField_1);
	        
	        JButton btnNewButton_1 = new JButton("Login");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		new giaodiendangnhap().setVisible(true);
					setVisible(false);
	        	}
	        });
	        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        btnNewButton_1.setBounds(173, 368, 120, 41);
	        contentPane.add(btnNewButton_1);
	        
	        JLabel lblFullname = new JLabel("FullName");
	        lblFullname.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblFullname.setBounds(462, 110, 108, 29);
	        contentPane.add(lblFullname);
	        
	        JLabel lblEmail = new JLabel("Email");
	        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblEmail.setBounds(462, 193, 83, 29);
	        contentPane.add(lblEmail);
	        
	        fullname = new JTextField();
	        fullname.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        fullname.setColumns(10);
	        fullname.setBounds(620, 110, 206, 29);
	        contentPane.add(fullname);
	        
	        email = new JTextField();
	        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        email.setColumns(10);
	        email.setBounds(620, 193, 206, 29);
	        contentPane.add(email);
	}
}
