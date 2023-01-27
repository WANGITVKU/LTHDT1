package mysql;

import java.awt.EventQueue;


import javax.swing.border.EmptyBorder;

import com.google.protobuf.Value;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
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
	public giaodiendangnhap dn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giaodienhethong frame = new giaodienhethong();
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

	public giaodienhethong() {
		bientoancuc tt =new bientoancuc();
		
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
		
		JSpinner spinner_1 = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		spinner_1.setBounds(172, 270, 56, 31);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		spinner_2.setBackground(new Color(0, 0, 0));
		spinner_2.setBounds(172, 435, 56, 31);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		spinner_3.setBounds(646, 121, 56, 31);
		contentPane.add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		spinner_4.setBounds(646, 270, 56, 31);
		contentPane.add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		spinner_5.setBounds(646, 435, 56, 31);
		contentPane.add(spinner_5);
		
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(0,0,100,1));
		spinner.setBounds(172, 122, 56, 31);
		contentPane.add(spinner);
		
		JButton btnNewButton = new JButton("Mua");
		btnNewButton.setForeground(UIManager.getColor("Button.focus"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"t "+spinner.getValue()+"  sahsahad sgi ashjs akhjas ds adas asd s" );
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
		lblNewLabel_12.setBounds(716, 10, 46, 57);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel();
		lblNewLabel_13.setText(tt.getTen());
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_13.setBounds(784, 21, 147, 46);
		contentPane.add(lblNewLabel_13);
		}
    } 

