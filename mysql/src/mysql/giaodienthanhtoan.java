package mysql;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Locale;

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
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.ContentType;
import javax.mail.internet.MimeMultipart;


public class giaodienthanhtoan extends JFrame {

	private JPanel contentPane;
	private static String tong1 ="",tong2="",tong3="",tong4="",tong5="",tong6="",tong7="";
	private static int tongmax;
    DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws MessagingException, IOException  {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giaodienthanhtoan frame = new giaodienthanhtoan(tong1,tong2,tong3,tong4,tong5,tong6,tong7,tongmax);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	// kiem tra thanh toan 
	public static void quang(int tong) throws MessagingException, IOException {
		double number = tong;
		NumberFormat nf = NumberFormat.getInstance(Locale.US);
		nf.setMinimumFractionDigits(2);
		nf.setGroupingUsed(true);
		String formattedNumber = nf.format(number);
	      Properties props = new Properties();
	      props.setProperty("mail.store.protocol", "imaps");
	      Session session = Session.getDefaultInstance(props, null);
	      Store store = session.getStore("imaps");
	      store.connect("imap.gmail.com", "huynhquangvku22ns@gmail.com", "blflnuaqkgovmphc");
	      Folder inbox = store.getFolder("INBOX");
	      inbox.open(Folder.READ_ONLY);
	      
	      String messageId = "huynhquang91100@gamil.com";
	      int messageCount = inbox.getMessageCount();	      
	      Message[] messages = inbox.getMessages(messageCount, messageCount);
	      // Lọc nội dung email chứa dòng "quangdeptrai"
	      
	      for (Message message : messages) {
	    
	    		    // kiểm tra xem email có chứa từ "quang dep trai" hay không
	    		    String contentType = message.getContentType();
	    		    if (contentType.contains("multipart")) {
	    		        // nếu email là định dạng multipart, lặp qua các phần tử để tìm nội dung
	    		        Multipart multiPart = (Multipart) message.getContent();
	    		        for (int i = 0; i < multiPart.getCount(); i++) {
	    		            BodyPart bodyPart = multiPart.getBodyPart(i);
	    		            String body = bodyPart.getContent().toString();
	    		            if (body.contains(formattedNumber)) {
	    		                
	    		            	JOptionPane.showMessageDialog(null,formattedNumber+"Thanh Toán Thành Công" );;
	    		            			break;
	    		             
	    		            }
	    		            else
	    		            	JOptionPane.showMessageDialog(null,formattedNumber+" Thanh Toán Thất Bại" );;
	    		        }
	    		    } else {
	    		        // nếu email là định dạng khác, truy cập trực tiếp nội dung
	    		        String body = message.getContent().toString();
	    		        if (body.contains(formattedNumber)) {
	    		            // email có chứa từ "quang dep trai"
	    		        	JOptionPane.showMessageDialog(null,"Thanh toán thất bại" );;
	    		        }
	    		        else
	    		        	JOptionPane.showMessageDialog(null,"Thanh toán thất bại" );;
	    		    
	    		    }
	    		}
	      
	   }
	public giaodienthanhtoan(String a,String b,String c,String d,String f,String g,String h, int tongmax2) {
	tong1=a;
	tong2=b;
	tong3=c;
	tong4=d;
	tong5=f;
	tong6=g;
	tong7=h;
	int tong=tongmax2;
	   
	    
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 929, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea(tong1+tong2+tong3+tong4+tong5+tong6+tong7);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		textArea.setBounds(20, 74, 434, 311);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Hóa Đơn Thanh Toán");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(273, 21, 274, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Thanh Toán ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						quang(tong);
					} catch (MessagingException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
			}
		});
		btnNewButton.setBounds(638, 441, 138, 34);
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/C:/Users/ASUS/eclipse-workspace/mysql/src/mysql/anhQR1.jpg"));
		lblNewLabel_1.setBounds(534, 74, 300, 311);
		contentPane.add(lblNewLabel_1);
		
	}
}
