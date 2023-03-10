
package mysql;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
public class mysql {
	
	public static Connection getConnection() {
		Connection c = null;
	
	try {
		// Đăng ký MySQL Driver với DriverManager
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		// Các thông số
		String url = "jdbc:mySQL://localhost:3306/thongtin";
		String username = "root";
		String password = "huynhquang";
		
		// Tạo kết nối
		c = DriverManager.getConnection(url, username, password);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return c;
}

public static void closeConnection(Connection c) {
	try {
		if(c!=null) {
			c.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public static void printInfo(Connection c) {
	try {
		if(c!=null) {
			DatabaseMetaData mtdt = c.getMetaData();
			System.out.println(mtdt.getDatabaseProductName());
			System.out.println(mtdt.getDatabaseProductVersion());
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void main(String[] args) {
	Connection connection = mysql.getConnection();
	
	mysql.printInfo(connection);
	
	mysql.closeConnection(connection);
	

}}




	