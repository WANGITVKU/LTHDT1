package mysql;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Button;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JDesktopPane;

public class gaiodiendangnhap extends JFrame {

	private JPanel form1;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gaiodiendangnhap frame = new gaiodiendangnhap();
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
	public gaiodiendangnhap() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 655, 428);
		form1 = new JPanel();
		form1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(form1);
		form1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(251, 62, 121, 57);
		form1.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(348, 166, 201, 19);
		form1.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(348, 241, 201, 19);
		form1.add(pass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mySQL://localhost:3306/thongtin","root","huynhquang");
					Statement stmt=con.createStatement();
					String sql="Select*from thongtinkhachhang where UserName='"+user.getText()+"'and PassWord='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
						JOptionPane.showMessageDialog(null, "Login Sucessfully...");
					else 
						JOptionPane.showMessageDialog(null, "incorrect");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton.setBounds(388, 301, 114, 33);
		form1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(97, 150, 114, 42);
		form1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PassWord");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(97, 228, 121, 36);
		form1.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new giaodiendangky().setVisible(true);
				
			}
		 
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(209, 305, 93, 29);
		form1.add(btnNewButton_1);
	}
				}

