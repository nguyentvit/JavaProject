package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DocCsdl.DocCsdl;
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
}
