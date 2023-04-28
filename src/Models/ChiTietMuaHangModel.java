package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DocCsdl.DocCsdl;
import Entities.ChiTietMuaHang;


public class ChiTietMuaHangModel {
	public List<ChiTietMuaHang>GetAllChiTietMuaHang() throws SQLException
	{
		List<ChiTietMuaHang>ChiTietMuaHangs = new ArrayList<ChiTietMuaHang>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select * from ChiTietMuaHang" ;
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
			int SoLuong = Integer.parseInt(result.getString("SoLuong"));
			double DonGia = Double.parseDouble(result.getString("DonGia"));
			
			ChiTietMuaHangs.add(new ChiTietMuaHang(result.getString("MaChiTietMuaHang"),result.getString("MaMuaHang"),result.getString("MaSanPham"),SoLuong,DonGia));
		}
		return ChiTietMuaHangs;
	}
}
