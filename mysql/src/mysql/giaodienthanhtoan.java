package mysql;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;



public class giaodienthanhtoan extends JFrame {

	private JPanel contentPane;
	private static String tong1 ="",tong2="",tong3="",tong4="",tong5="",tong6="",tong7="";
    DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giaodienthanhtoan frame = new giaodienthanhtoan(tong1,tong2,tong3,tong4,tong5,tong6,tong7);
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
	public giaodienthanhtoan(String a,String b,String c,String d,String f,String g,String h) {
	tong1=a;
	tong2=b;
	tong3=c;
	tong4=d;
	tong5=f;
	tong6=g;
	tong7=h;
	   
	    
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 506, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea(tong1+tong2+tong3+tong4+tong5+tong6+tong7);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		textArea.setBounds(10, 74, 434, 368);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Hóa Đơn Thanh Toán");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(121, 21, 190, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Thanh Toán ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thanh Toán Thành Công");
			}
		});
		btnNewButton.setBounds(306, 452, 138, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new giaodienhethong(a).setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:/Users/ASUS/eclipse-workspace/mysql/src/mysql/images.png"));
		btnNewButton_1.setBounds(10, 10, 68, 21);
		contentPane.add(btnNewButton_1);
		
	}
}
