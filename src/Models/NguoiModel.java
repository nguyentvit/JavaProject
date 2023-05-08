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
import Entities.MuaHang;
import Entities.Nguoi;

public class NguoiModel {
	public List<Nguoi>GetAllNguoi() throws SQLException
	{
		List<Nguoi>Nguois = new ArrayList<Nguoi>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select * from Nguoi" ;
		ResultSet result = stt.executeQuery(query);
		int i = 1;
		while(result.next())
		{						
			Nguois.add(new Nguoi(result.getString("MaNguoi"),result.getString("TenNguoi"),result.getString("Sdt")));
		}
		return Nguois;
	}
	public Nguoi getNguoiByIdNguoi(String Id) throws SQLException
	{
		for (Nguoi ng : GetAllNguoi())
		{
			if (ng.getMaNguoi().equals(Id))
			{
				return ng;
			}
		}
		return null;
	}
	public String TaoIdNguoi() throws SQLException
	{
		String id = "";
		List<String>Id = new ArrayList<String>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select MaNguoi from Nguoi" ;
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
			Id.add(result.getString("MaNguoi"));
		}
		boolean status = true;
		while(status)
		{
			status = false;
			id = (ThreadLocalRandom.current().nextInt(0, 1000 + 1)) + "";
			for(String id1 : Id)
			{
				if(id1.equals(id))
				{
					status = true;
				}
			}
		}
		return id;
	}
	public void AddNguoi(Nguoi ng) throws SQLException
	{
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
				"insert into Nguoi values(?,?,?)"
				);
		prepare.setString(1, ng.getMaNguoi());
		prepare.setString(2, ng.getTenNguoi());
		prepare.setString(3, ng.getSdt());
		prepare.executeUpdate();
		
	}
	public void SuaNguoi(Nguoi ng) throws SQLException
	{
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
				"update Nguoi set TenNguoi = ? , Sdt = ? where MaNguoi = ?"
				);
		prepare.setString(1, ng.getTenNguoi());
		prepare.setString(2, ng.getSdt());
		prepare.setString(3, ng.getMaNguoi());
		prepare.executeUpdate();
		
	}
}
