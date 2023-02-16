package mysql;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class bientoancuc {
	private JFrame frame;
	private JLabel lblData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bientoancuc window = new bientoancuc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public bientoancuc() {
		initialize();
		loadDataFromDB();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(lblData);
	}

	private void loadDataFromDB() {
		String url = "jdbc:mysql://localhost:3306/thongtin";
		String username = "root";
		String password = "huynhquang";
		
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			String query = "SELECT Email FROM thongtin.thongtinkhachhang WHERE UserName = 'quang123';";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			String data = "";
			while (resultSet.next()) {
				data += resultSet.getString(1);
			}
			lblData.setText(data);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

