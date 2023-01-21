package mysql;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class giaodiendangky extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
    private JTextField username;
    private JPasswordField passwordField;
    private JButton btnNewButton;
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
	        setBounds(450, 190, 1014, 597);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewUserRegister = new JLabel("New User Register");
	        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
	        lblNewUserRegister.setBounds(362, 52, 325, 50);
	        contentPane.add(lblNewUserRegister);

	        username = new JTextField();
	        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        username.setBounds(306, 161, 228, 50);
	        contentPane.add(username);
	        username.setColumns(10);

	        JLabel lblUsername = new JLabel("Username");
	        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblUsername.setBounds(104, 166, 99, 29);
	        contentPane.add(lblUsername);

	        JLabel lblPassword = new JLabel("Password");
	        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblPassword.setBounds(104, 252, 99, 24);
	        contentPane.add(lblPassword);

	        passwordField = new JPasswordField();
	        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        passwordField.setBounds(306, 249, 228, 50);
	        contentPane.add(passwordField);

	        btnNewButton = new JButton("Register");
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               
	                String userName = username.getText();
	               
	                
	                String password = passwordField.getText();

	              

	                try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thongtin", "root", "huynhquang");

	                    String query = "INSERT INTO `thongtin`.`thongtinkhachhang` (`UserName`, `PassWord`) VALUES ('"+userName+"', '"+password+"');";

	                    Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnNewButton,
	                            "Welcome, " + "Your account is sucessfully created");
	                    }
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
	        btnNewButton.setBounds(399, 447, 259, 74);
	        contentPane.add(btnNewButton);
	}
}
