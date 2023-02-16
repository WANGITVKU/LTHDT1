package mysql;

import java.awt.EventQueue;


import javax.swing.border.EmptyBorder;

import com.google.protobuf.Value;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.*;

import javax.imageio.*;
import javax.swing.*; 
import java.awt.*; 
import javax.swing.event.*; 
import java.awt.BorderLayout;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import mysql.giaodiendangnhap;

public class giaodienhethong extends JFrame {

	private JPanel contentPane;
	private static String dataTXT ="";
	private static JSpinner sp_stv,sp_std,sp_pepsi,sp_coca,sp_lavie,sp_sprite; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giaodienhethong frame = new giaodienhethong(dataTXT);
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
	
		
	
	public giaodienhethong(String data) {
		dataTXT =data;
//		bientoancuc tt =new bientoancuc();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 591);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Sting Vàng : 7000đ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(141, 83, 147, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sting Đỏ :7000đ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(154, 232, 121, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Coca Cola :10000đ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(154, 397, 134, 28);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pepsi :10000đ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(646, 83, 103, 28);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sprite :7000đ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(646, 232, 103, 28);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("lavie :5000đ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(646, 397, 103, 28);
		contentPane.add(lblNewLabel_5);
		
		JSpinner sp_std = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		sp_std.setBounds(172, 270, 56, 31);
		contentPane.add(sp_std);
		
		JSpinner sp_coca = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		sp_coca.setBackground(new Color(0, 0, 0));
		sp_coca.setBounds(172, 435, 56, 31);
		contentPane.add(sp_coca);
		
		JSpinner sp_pepsi = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		sp_pepsi.setBounds(646, 121, 56, 31);
		contentPane.add(sp_pepsi);
		
		JSpinner sp_sprite = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		sp_sprite.setBounds(646, 270, 56, 31);
		contentPane.add(sp_sprite);
		
		JSpinner sp_lavie = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		sp_lavie.setBounds(646, 435, 56, 31);
		contentPane.add(sp_lavie);
		
		JSpinner sp_stv = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		
		sp_stv.setBounds(172, 122, 56, 31);
		contentPane.add(sp_stv);

		JButton btnNewButton = new JButton("Mua");
		btnNewButton.setForeground(UIManager.getColor("Button.focus"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int True=1;
				
				if(((int)sp_stv.getValue()>0)||((int)sp_std.getValue()>0)||((int)sp_coca.getValue()>0)||((int)sp_pepsi.getValue()>0)||((int)sp_sprite.getValue()>0)||((int)sp_lavie.getValue()>0)) {
				String a= "";
				String b="";
				String c="";
				String d="";
				String f="";
				String g="";
				String h = "";
					if((int)sp_stv.getValue()>0) {
						int tong1=(int)sp_stv.getValue()*7000;
						a ="Sting Vàng            "+ sp_stv.getValue()+"     x       "+"7000          "+"=  "+tong1+"đ\n";
					}
					if((int)sp_std.getValue()>0) {
						int tong2=(int)sp_std.getValue()*7000;
						b ="Sting Đỏ               "+ sp_std.getValue()+"      x       "+"7000          "+"=  "+tong2+"đ\n";
					}

					if((int)sp_coca.getValue()>0) {
						int tong3=(int)sp_coca.getValue()*10000;
						c ="CocaCola             "+ sp_coca.getValue()+"      x       "+"10000        "+"=  "+tong3+"đ\n";
					}

					if((int)sp_pepsi.getValue()>0) {
						int tong4=(int)sp_pepsi.getValue()*10000;
						d ="Pepsi                    "+ sp_pepsi.getValue()+"      x       "+"10000        "+"=  "+tong4+"đ\n";
					}

					if((int)sp_lavie.getValue()>0) {
						int tong5=(int)sp_lavie.getValue()*5000;
						f ="Lavie                     "+ sp_lavie.getValue()+"      x       "+"5000          "+"=  "+tong5+"đ\n";
					}

					if((int)sp_sprite.getValue()>0) {
						int tong6=(int)sp_sprite.getValue()*7000;
						g ="Sprite                    "+ sp_sprite.getValue()+"      x       "+"7000          "+"=  "+tong6+"đ\n";
					}
					
						
						h ="Tông Hóa Đơn                                          :"+((int)sp_stv.getValue()*7000+(int)sp_std.getValue()*7000+(int)sp_coca.getValue()*10000+(int)sp_pepsi.getValue()*10000+(int)sp_lavie.getValue()*5000+(int)sp_sprite.getValue()*7000)+"đ"  ;
					
					

					
				new giaodienthanhtoan(a,b,c,d,f,g,h).setVisible(true);
				
				}	
				else
					JOptionPane.showMessageDialog(null,dataTXT+"\n"+"Bạn chưa chọn nước");
				}
		});
		btnNewButton.setBackground(UIManager.getColor("FormattedTextField.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(784, 483, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Hệ Thống Bán Nước");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_6.setBounds(286, 10, 306, 67);
		contentPane.add(lblNewLabel_6);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:/Users/ASUS/eclipse-workspace/mysql/src/mysql/sting.jpg"));
		label.setBounds(61, 80, 60, 100);
		contentPane.add(label);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\mysql\\src\\mysql\\coca.jpg"));
		lblNewLabel_7.setBounds(61, 386, 74, 100);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\mysql\\src\\mysql\\pepsi.jpg"));
		lblNewLabel_8.setBounds(535, 83, 74, 100);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\mysql\\src\\mysql\\sting2.jpg"));
		lblNewLabel_9.setBounds(65, 228, 56, 100);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\mysql\\src\\mysql\\Lavie.jpg"));
		lblNewLabel_10.setBounds(546, 386, 67, 100);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\ASUS\\eclipse-workspace\\mysql\\src\\mysql\\sprite.jpg"));
		lblNewLabel_11.setBounds(535, 227, 74, 103);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon("C:/Users/ASUS/eclipse-workspace/mysql/src/mysql/avatar1.png"));
		lblNewLabel_12.setBounds(686, 10, 46, 57);
		contentPane.add(lblNewLabel_12);
		//thêm họ và tên vào hệ thống
	    try {	                	
	    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thongtin", "root", "huynhquang");
	    	String query = "SELECT FullName FROM thongtin.thongtinkhachhang WHERE UserName = '"+dataTXT+"';";
	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(query);
	    	String data1 = "";
	    	while (resultSet.next()) {
	    		data1 += resultSet.getString(1);
	    	}
	    	JLabel FullName = new JLabel("");
	    	FullName.setBounds(752, 24, 154, 37);
	    	contentPane.add(FullName);
	    	FullName.setText(data1);
		}
	    catch (Exception e) {	   
			// TODO: handle exception
		}
		}
    } 

