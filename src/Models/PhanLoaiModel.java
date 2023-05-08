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
import Entities.PhanLoai;

public class PhanLoaiModel {
	public List<PhanLoai>GetAllPhanLoai() throws SQLException
	{
		List<PhanLoai>PhanLoais = new ArrayList<PhanLoai>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select * from PhanLoai" ;
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
			
			PhanLoais.add(new PhanLoai(result.getString("MaPhanLoai"),result.getString("TenPhanLoai")));
		}
		return PhanLoais;
	}
	public String GetTenPhanLoaiById(String Id) throws SQLException
	{
		String tenpl = "";
		for(PhanLoai pl : GetAllPhanLoai())
		{
			if(pl.getMaPhanLoai().equals(Id))tenpl = pl.getTenPhanLoai();
		}
		return tenpl;
	}
	public void AddPhanLoai(PhanLoai pl) throws SQLException
	{
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
		"insert into PhanLoai values (?, ?  )"	
		);
		prepare.setString(1, pl.getMaPhanLoai());
		prepare.setString(1, pl.getTenPhanLoai());
		prepare.executeUpdate();
		
	}
	public String TaoIdPhanLoai() throws SQLException
	{
		String id = "";
		List<String> IdPL = new ArrayList<String>();
		Connection con = DocCsdl.getConnect();
		Statement stt = con.createStatement();
		String query = "select MaPhanLoai from PhanLoai";
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
			IdPL.add(result.getString("MaPhanLoai"));
		}
		boolean status = true;
		while (status)
		{
			status = false;
			id = (ThreadLocalRandom.current().nextInt(0, 1000 + 1)) + "";
			for (String id1 : IdPL)
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
