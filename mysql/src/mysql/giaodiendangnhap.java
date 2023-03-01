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
import java.awt.SystemColor;

public class giaodiendangnhap  extends JFrame{

	private JPanel form1;
	private static JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giaodiendangnhap frame = new giaodiendangnhap();
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
	
	public giaodiendangnhap() {		
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 428);
		form1 = new JPanel();
		form1.setBackground(SystemColor.inactiveCaption);
		form1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(form1);
		form1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(236, 42, 121, 57);
		form1.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(285, 166, 245, 19);
		form1.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(285, 241, 245, 19);
		form1.add(pass);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(61, 150, 139, 42);
		form1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PassWord");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(67, 228, 93, 36);
		form1.add(lblNewLabel_2);
		// quay lai dang nhap
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					String a = user.getText();
//					bientoancuc tt = new bientoancuc();
//					tt.setTen(user.getText());
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mySQL://localhost:3306/thongtin","root","huynhquang");
					Statement stmt=con.createStatement();
					String sql="Select*from thongtinkhachhang where UserName='"+user.getText()+"'and PassWord='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);										
					if(rs.next()) {
						new giaodienhethong(a).setVisible(true);
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Đăng thành công");}
					else 
						JOptionPane.showMessageDialog(null, "Đăng nhặp thất bại "+"\nTài khoảng hoặc mật khẩu không đúng");
						con.close();
				} catch (Exception e) {
					System.out.println(e);
				}				
			}
		});
		btnNewButton.setBounds(416, 290, 114, 33);
		form1.add(btnNewButton);	
		// mở trang đăng ký 
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				new giaodiendangky().setVisible(true);
				setVisible(false);
			}		
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(285, 292, 102, 29);
		form1.add(btnNewButton_1);
       
		//dang nhap vao he thong qua ly	
		JButton btnNewButton_2 = new JButton("system manager login");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mySQL://localhost:3306/thongtin","root","huynhquang");
						Statement stmt=con.createStatement();
						String sql="Select*from admin where UserName='"+user.getText()+"'and PassWord='"+pass.getText().toString()+"'";
						ResultSet rs=stmt.executeQuery(sql);										
						if(rs.next()) {
							new manager_system().setVisible(true);
							setVisible(false);
							JOptionPane.showMessageDialog(null, "Đăng thành công");}
						else 
							JOptionPane.showMessageDialog(null, "Đăng nhặp thất bại "+"\nTài khoảng hoặc mật khẩu không đúng");
							con.close();
						}	 
					catch (Exception ex) {}					
			}
		 });
		btnNewButton_2.setBounds(449, 10, 182, 33);
		form1.add(btnNewButton_2);		
		}
	}
	


