package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DocCsdl.DocCsdl;
import Entities.SanPham;

public class SanPhamModel {
	public List<SanPham>GetAllSanPham() throws SQLException
	{
		List<SanPham>SanPhams = new ArrayList<SanPham>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select * from SanPham" ;
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
			double GiaNhap = Double.parseDouble(result.getString("GiaNhap"));
			double GiaBan = Double.parseDouble(result.getString("GiaBan"));
			int SoLuong = Integer.parseInt(result.getString("SoLuong"));
			SanPhams.add(new SanPham(result.getString("MaSanPham"),result.getString("MaPhanLoai"),result.getString("MaNhaSanXuat"),result.getString("TenSanPham"),GiaNhap,GiaBan,SoLuong,result.getBytes("HinhAnh")));
		}
		return SanPhams;
	}
	public void AddSanPham(SanPham sp) throws SQLException
	{
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
				"insert into SanPham values(?,?,?,N?,?,?,?,?)"
				);
		prepare.setString(1, sp.getMaSanPham());
		prepare.setString(2, sp.getMaPhanLoai());
		prepare.setString(3, sp.getMaNhaSanXuat());
		prepare.setString(4, sp.getTenSanPham());
		prepare.setDouble(5, sp.getGiaNhap());
		prepare.setInt(6, sp.getSoLuong());
		prepare.setBytes(7, sp.getHinhAnh());
		prepare.setDouble(8,sp.getGiaBan());
		prepare.executeUpdate();
		
	}
	
}
