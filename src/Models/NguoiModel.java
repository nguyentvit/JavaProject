package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DocCsdl.DocCsdl;
import Entities.Nguoi;

public class NguoiModel {
	public List<Nguoi>GetAllNguoi() throws SQLException
	{
		List<Nguoi>Nguois = new ArrayList<Nguoi>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select * from Nguoi" ;
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{						
			Nguois.add(new Nguoi(result.getString("MaNguoi"),result.getString("TenNguoi"),result.getString("Sdt")));
		}
		return Nguois;
	}
}
