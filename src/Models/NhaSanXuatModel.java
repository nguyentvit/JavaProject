package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
}
