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
import Entities.ChiTietMuaHang;
import Entities.SanPham;
import DTO.ViewHoaDon;
import Entities.MuaHang;


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
	public String TaoIdCTMuaHang() throws SQLException
	{
		String id = "";
		List<String>Id = new ArrayList<String>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select MaChiTietMuaHang from ChiTietMuaHang" ;
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
			Id.add(result.getString("MaChiTietMuaHang"));
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
	public void AddChiTietMuaHang(ChiTietMuaHang ct) throws SQLException
	{
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
				"insert into ChiTietMuaHang values(?,?,?,?,?)"
				);
		prepare.setString(1, ct.getMaChiTietMuaHang());
		prepare.setString(2, ct.getMaMuaHang());
		prepare.setString(3, ct.getMaSanPham());
		prepare.setInt(4, ct.getSoLuong());
		prepare.setDouble(5, ct.getDonGia());
		prepare.executeUpdate();
		
	}
}
