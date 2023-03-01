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
import java.sql.SQLException;
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
	//Lấy giá trị Giá Sản Phẩm từ Sql ra class
	public static  String  gia (String  a) {
		try {
			
	    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thongtin", "root", "huynhquang");
	    	String query = "SELECT Don_gia FROM thongtin.thongtinsanpham WHERE Ten_San_Pham= '"+a+"';";
	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(query);
	    	String data = "";
	    	while (resultSet.next()) {
	    		data = resultSet.getString(1);
	    	}
	    	return data ;	    	
		}
	    catch (Exception e) {	   
	    	JOptionPane.showMessageDialog(null, "Lỗi hệ thống không hiện được giá sản phẩm");
		}
		
		return  null;
	}
		
	public static  int  soluong (String  a) {
		try {
			
	    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thongtin", "root", "huynhquang");
	    	String query = "SELECT So_luong_hang_ton FROM thongtin.thongtinsanpham WHERE Ten_San_Pham= '"+a+"';";
	    	Statement statement = connection.createStatement();
	    	ResultSet resultSet = statement.executeQuery(query);
	    	String data = "";
	    	while (resultSet.next()) {
	    		data = resultSet.getString(1);
	    	}
	    	return Integer.valueOf(data) ;
		}
	    catch (Exception e) {	   
	    	JOptionPane.showMessageDialog(null, "Lỗi không thể tín được số nước còn lại  có trong máy");
		}
		return (Integer) null;
	}
	public giaodienhethong(String data) {
		
		dataTXT =data;
//		bientoancuc tt =new bientoancuc();
//  	Thiết Lập layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 943, 591);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//      Thiết Lập tên giao diện
		JLabel lblNewLabel_6 = new JLabel("Hệ Thống Bán Nước");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_6.setBounds(286, 10, 306, 67);
		contentPane.add(lblNewLabel_6);
//		Thiết lập Jlabel		
		JLabel stv = new JLabel("Sting Vàng");
		stv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stv.setBounds(154, 83, 87, 28);
		contentPane.add(stv);
		
		JLabel std = new JLabel("Sting Đỏ");
		std.setFont(new Font("Tahoma", Font.PLAIN, 15));
		std.setBounds(154, 232, 74, 28);
		contentPane.add(std);
		
		JLabel coca = new JLabel("Coca Cola");
		coca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		coca.setBounds(154, 397, 74, 28);
		contentPane.add(coca);
		
		JLabel pepsi = new JLabel("Pepsi");
		pepsi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pepsi.setBounds(646, 83, 103, 28);
		contentPane.add(pepsi);
		
		JLabel sprite = new JLabel("Sprite");
		sprite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sprite.setBounds(646, 232, 46, 28);
		contentPane.add(sprite);
		
		JLabel lavie = new JLabel("Lavie");
		lavie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lavie.setBounds(646, 397, 56, 28);
		contentPane.add(lavie);
//      Thiết lập các spinner		
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
		
//     thiết lập hình ảnh sản phẩm
		
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
		
		//Thiết Lập giá 
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
	    //tính tiền
	    JButton btnNewButton = new JButton("Mua");
		btnNewButton.setForeground(UIManager.getColor("Button.focus"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                               	
	                try {	                	
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thongtin", "root", "huynhquang");
	                    //thay doi so luong con lai trong he thong
	                    if(soluong(stv.getText())>0&&soluong(std.getText())>0&&soluong(coca.getText())>0&&soluong(pepsi.getText())>0&&soluong(lavie.getText())>0&&soluong(sprite.getText())>0) 
	                    {
	                    String D1= " UPDATE `thongtin`.`thongtinsanpham` SET `So_luong_hang_ton` = `So_luong_hang_ton`- "+sp_stv.getValue()+" WHERE (`ID` = '1');\r\n";
	                    String D2= " UPDATE `thongtin`.`thongtinsanpham` SET `So_luong_hang_ton` = `So_luong_hang_ton`- "+sp_std.getValue()+" WHERE (`ID` = '2');\r\n ";
	                    String D3= " UPDATE `thongtin`.`thongtinsanpham` SET `So_luong_hang_ton` = `So_luong_hang_ton`- "+sp_pepsi.getValue()+" WHERE (`ID` = '3');\r\n  ";
	                    String D4= " UPDATE `thongtin`.`thongtinsanpham` SET `So_luong_hang_ton` = `So_luong_hang_ton`- "+sp_coca.getValue()+" WHERE (`ID` = '4');\r\n  ";
	                    String D5= " UPDATE `thongtin`.`thongtinsanpham` SET `So_luong_hang_ton` = `So_luong_hang_ton`- "+sp_lavie.getValue()+" WHERE (`ID` = '5');\r\n  ";
	                    String D6= " UPDATE `thongtin`.`thongtinsanpham` SET `So_luong_hang_ton` = `So_luong_hang_ton`- "+sp_sprite.getValue()+" WHERE (`ID` = '6');\r\n  ";
	                    		
	                    Statement sta = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY,	ResultSet.CONCUR_READ_ONLY);	                    
	                    int x = sta.executeUpdate(D1);
	                    int y = sta.executeUpdate(D2);	 
	                    int z = sta.executeUpdate(D3);	 
	                    int j = sta.executeUpdate(D4);	
	                    int q = sta.executeUpdate(D5);	 
	                    int k = sta.executeUpdate(D6);	 
	                    if (x > 0||y>0||z>0||j>0||q>0||k>0) {
	                    	JOptionPane.showMessageDialog(btnNewButton,
		                    		"Mua nước thành công");	 
	                    	int True=1;
	        				
	        				if(((int)sp_stv.getValue()>0)||((int)sp_std.getValue()>0)||((int)sp_coca.getValue()>0)||((int)sp_pepsi.getValue()>0)||((int)sp_sprite.getValue()>0)||((int)sp_lavie.getValue()>0)) {
	        				String a="";
	        				String b="";
	        				String c="";
	        				String d="";
	        				String f="";
	        				String g="";
	        				String h ="";
	        				int tong1=0;
	        				int tong2=0;
	        				int tong3=0;
	        				int tong4=0;
	        				int tong5=0;
	        				int tong6=0;
	        				
	        					if((int)sp_stv.getValue()>0) {
	        					 tong1=(int)sp_stv.getValue()*Integer.valueOf(gia(stv.getText()));
	        						a ="Sting Vàng             "+ sp_stv.getValue()+"     x       "+Integer.valueOf(gia(stv.getText()))+"          "+"=  "+tong1+"đ\n";
	        					}
	        					
	        					if((int)sp_std.getValue()>0) {
	        						 tong2=(int)sp_std.getValue()*Integer.valueOf(gia(std.getText()));
	        						b ="Sting Đỏ               "+ sp_std.getValue()+"      x       "+Integer.valueOf(gia(std.getText()))+"          "+"=  "+tong2+"đ\n";
	        					}

	        					if((int)sp_coca.getValue()>0) {
	        						 tong3=(int)sp_coca.getValue()*Integer.valueOf(gia(coca.getText()));
	        						c ="CocaCola             "+ sp_coca.getValue()+"      x       "+Integer.valueOf(gia(coca.getText()))+"        "+"=  "+tong3+"đ\n";
	        					}

	        					if((int)sp_pepsi.getValue()>0) {
	        						 tong4=(int)sp_pepsi.getValue()*Integer.valueOf(gia(pepsi.getText()));
	        						d ="Pepsi                    "+ sp_pepsi.getValue()+"      x       "+Integer.valueOf(gia(pepsi.getText()))+"        "+"=  "+tong4+"đ\n";
	        					}

	        					if((int)sp_lavie.getValue()>0) {
	        						 tong5=(int)sp_lavie.getValue()*Integer.valueOf(gia(lavie.getText()));
	        						f ="Lavie                     "+ sp_lavie.getValue()+"      x       "+Integer.valueOf(gia(lavie.getText()))+"          "+"=  "+tong5+"đ\n";
	        					}

	        					if((int)sp_sprite.getValue()>0) {
	        						 tong6=(int)sp_sprite.getValue()*Integer.valueOf(gia(sprite.getText()));
	        						g ="Sprite                    "+ sp_sprite.getValue()+"      x       "+Integer.valueOf(gia(sprite.getText()))+"          "+"=  "+tong6+"đ\n";
	        					}
	        						
	        						int tongmax=tong1+tong2+tong3+tong4+tong5+tong6;
	        						h ="Tông Hóa Đơn                                          :"+(tong1+tong2+tong3+tong4+tong5+tong6)+"đ"  ;
	        					
	        					

	        					
	        				new giaodienthanhtoan(a,b,c,d,f,g,h,tongmax).setVisible(true);
	        				
	        				}	
	        				else
	        					JOptionPane.showMessageDialog(null,dataTXT+"\n"+"Bạn chưa chọn nước");
	                    }
	                    connection.close(); 
	                    
	                    }
	                    else 
	                    	JOptionPane.showMessageDialog(null," Xin Lỗi \n"
	                    			+ "Loại nước bạn chọn đã hết vui lòng chọn loại nước khác .Xin cảm ơn ");
	                    	
	                } catch (SQLException exception) {
	                    JOptionPane.showMessageDialog(btnNewButton, "Mua nước thất bại");
	                    exception.printStackTrace();
	                }
				}
			});
		
		//Hiển thị giá cả
		JLabel gia_1 = new JLabel("");
    	gia_1.setText(":"+gia(stv.getText())+"đ");
    	gia_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	gia_1.setBounds(231, 83, 87, 28);
    	contentPane.add(gia_1);
    	
    	JLabel gia_2 = new JLabel("");
    	gia_2.setText(":"+gia(std.getText())+"đ");
    	gia_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	gia_2.setBounds(231, 232, 87, 28);
    	contentPane.add(gia_2);
    	
    	JLabel gia_3 = new JLabel("");
    	gia_3.setText(":"+gia(coca.getText())+"đ");
    	gia_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	gia_3.setBounds(231, 397, 87, 28);
    	contentPane.add(gia_3);
    	
    	JLabel gia_4 = new JLabel("");
    	gia_4.setText(":"+gia(pepsi.getText())+"đ");
    	gia_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	gia_4.setBounds(696, 83, 87, 28);
    	contentPane.add(gia_4);
    	
    	JLabel gia_5 = new JLabel("");
    	gia_5.setText(":"+gia(sprite.getText())+"đ");
    	gia_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	gia_5.setBounds(706, 232, 87, 28);
    	contentPane.add(gia_5);
    	
    	JLabel gia_6 = new JLabel("");
    	gia_6.setText(":"+gia(lavie.getText())+"đ");
    	gia_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
    	gia_6.setBounds(706, 397, 87, 28);
    	contentPane.add(gia_6);
    	
		btnNewButton.setBackground(UIManager.getColor("FormattedTextField.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(784, 483, 85, 21);
		contentPane.add(btnNewButton);
		}
    } 

