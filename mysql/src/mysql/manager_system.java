package mysql;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.common.display.TableDisplayable;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class manager_system extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField soluong;
	private JTextField gia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manager_system frame = new manager_system();
					frame.setVisible(true);
				} catch (Exception e) {
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void showdata()
	{
		try {
			table.setModel(new DefaultTableModel() );
//			bientoancuc tt = new bientoancuc();
//			tt.setTen(user.getText());
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mySQL://localhost:3306/thongtin","root","huynhquang");
			Statement st=con.createStatement();
			String query="SELECT * FROM thongtin.thongtinsanpham";
			ResultSet rs =st.executeQuery(query);
			ResultSetMetaData rsmd =  (ResultSetMetaData) rs.getMetaData();
			DefaultTableModel model =(DefaultTableModel) table.getModel(); 
			
			int cols=rsmd.getColumnCount();
			String[] colName =new String[cols];
			for(int i=0 ;i<cols;i++)
					colName[i]=rsmd.getColumnName(i+1);
			model.setColumnIdentifiers(colName);
			String ID,name,gia,soluong;
			while(rs.next()) {
				 ID=rs.getString(1);
				 name=rs.getString(2);
				 gia=rs.getString(3);
				 soluong=rs.getString(4);
				 String[]row= {ID,name,gia,soluong};
				 model.addRow(row);
				 
			}
			st.close();
			con.close();
			}
			catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
	}
	public manager_system() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Kiểm tra số lượng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				showdata();
				
			}
		});
		btnNewButton.setBounds(63, 90, 157, 45);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(275, 10, 566, 121);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Thay Đổi Giá Sản Phẩm");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(43, 224, 208, 55);
		contentPane.add(lblNewLabel);
		
		String s1[]= {"Sting Vàng","Sting Đỏ","Coca Cola","Pepsi","Sprite","Lavie"};
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setBounds(275, 172, 119, 27);
		contentPane.add(comboBox);
		
		soluong = new JTextField();
		soluong.setBounds(523, 172, 109, 27);
		contentPane.add(soluong);
		soluong.setColumns(10);
		
		JButton thaythe = new JButton("Cập Nhập");
		thaythe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mySQL://localhost:3306/thongtin","root","huynhquang");
					Statement st=con.createStatement();
					String query="UPDATE `thongtin`.`thongtinsanpham` SET `So_luong_hang_ton` = "+soluong.getText()+" WHERE (`Ten_San_Pham` = '"+comboBox.getSelectedItem()+"');";
	                int x = st.executeUpdate(query);
	                if (x >0) 
	                {
                    	JOptionPane.showMessageDialog(btnNewButton,
	                    		"Cap Nhap Thanh Cong");                    	
					st.close();
					con.close();
					showdata();
	                }
	              }
				catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null,
                    		"Cập Nhập Thất Bại");
				}
			}
			
		});
		
		thaythe.setBounds(737, 172, 99, 27);
		contentPane.add(thaythe);
		
		JLabel lblNewLabel_1 = new JLabel("Thay Đổi Số Lượng ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(43, 156, 208, 55);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox(s1);
		comboBox_1.setBounds(275, 240, 121, 27);
		contentPane.add(comboBox_1);
		
		gia = new JTextField();
		gia.setColumns(10);
		gia.setBounds(523, 240, 109, 27);
		contentPane.add(gia);
		
		JButton thaythe_1 = new JButton("Cập Nhập");
		thaythe_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mySQL://localhost:3306/thongtin","root","huynhquang");
					Statement st=con.createStatement();
					String query="UPDATE `thongtin`.`thongtinsanpham` SET `Don_gia` = "+gia.getText()+" WHERE (`Ten_San_Pham` = '"+comboBox_1.getSelectedItem()+"');";
	                int x = st.executeUpdate(query);
	                if (x >0) 
	                {
                    	JOptionPane.showMessageDialog(btnNewButton,
	                    		"Cap Nhap Thanh Cong");                    	
					st.close();
					con.close();
					showdata();
	                }
	              }
				catch (ClassNotFoundException | SQLException e1) 
				{
					JOptionPane.showMessageDialog(btnNewButton,
                    		"Cập Nhập Thất Bại");
				}
			}
		});
		thaythe_1.setBounds(737, 240, 99, 27);
		contentPane.add(thaythe_1);
		
		JButton btnNewButton_1 = new JButton("Hoàn Tất");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hoàn tất cập nhập bạn sẽ được đưa về trang đăng nhập");
				new giaodiendangnhap().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(714, 318, 141, 21);
		contentPane.add(btnNewButton_1);
	}
}
