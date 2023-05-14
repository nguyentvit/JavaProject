package DocCsdl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DocCsdl {
	public static Connection getConnect() throws SQLException
	{
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QuanLyDienThoai;user=Daisy;password=10042003;encrypt=false");
//Class.forName("com.mysql.jdbc.Driver");
//			
//			String url = "jdbc:mysql://127.0.0.1:3306/quanlydienthoai";
//			Connection con = DriverManager.getConnection(url,"root","");
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception: " + e.toString());
		}
		catch(ClassNotFoundException cE)
		{
			System.out.println("Class Not Found Exception: "+cE.toString());
		}
		return conn;
	}
}
