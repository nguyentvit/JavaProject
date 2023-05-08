package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import DocCsdl.DocCsdl;
import Entities.NhaSanXuat;

public class NhaSanXuatModel {
	public List<NhaSanXuat>GetAllNhaSanXuat() throws SQLException
	{
		List<NhaSanXuat>NhaSanXuats = new ArrayList<NhaSanXuat>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select * from NhaSanXuat" ;
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
			
			NhaSanXuats.add(new NhaSanXuat(result.getString("MaNhaSanXuat"),result.getString("TenNhaSanXuat")));
		}
		return NhaSanXuats;
	}
	public String GetTenNhaSx(String Id) throws SQLException
	{
		String tenNhaSx = "";
		for(NhaSanXuat nsx : GetAllNhaSanXuat())
		{
			if(nsx.getMaNhaSanXuat().equals(Id))
			{
				
				tenNhaSx = nsx.getTenNhaSanXuat();
			}
		}
		return tenNhaSx;
	}
	public void AddNhaSX(NhaSanXuat sx) throws SQLException
	{
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
		"insert into NhaSanXuat values (?, ?)"	
		);
		prepare.setString(1, sx.getMaNhaSanXuat());
		prepare.setString(2, sx.getTenNhaSanXuat());
		prepare.executeUpdate();
		
	}
	public String TaoIdNhaSX() throws SQLException
	{
		String id = "";
		List<String> IdSX = new ArrayList<String>();
		Connection con = DocCsdl.getConnect();
		Statement stt = con.createStatement();
		String query = "select MaNhaSanXuat from NhaSanXuat";
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
			IdSX.add(result.getString("MaNhaSanXuat"));
		}
		boolean status = true;
		while (status)
		{
			status = false;
			id = (ThreadLocalRandom.current().nextInt(0, 1000 + 1)) + "";
			for (String id1 : IdSX)
			{
				if (id1.equals(id))
				{
					status = true;
				}
			}
		}
	
	
		return id;
	}
}
