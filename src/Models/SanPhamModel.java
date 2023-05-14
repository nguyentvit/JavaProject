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
			double GiaNhap = Double.parseDouble(result.getString("Gia"));
			double GiaBan = Double.parseDouble(result.getString("GiaBan"));
			int SoLuong = Integer.parseInt(result.getString("SoLuong"));
			
			SanPhams.add(new SanPham(result.getString("MaSanPham"),result.getString("MaPhanLoai"),result.getString("MaNhaSanXuat"),result.getString("TenSanPham"),GiaNhap,GiaBan,SoLuong,result.getBytes("HinhAnh"),result.getBoolean("TrangThai")));
		}
		return SanPhams;
	}
	public void AddSanPham(SanPham sp) throws SQLException
	{
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
				"insert into SanPham values(?,?,?,?,?,?,?,?,?)"
				);
		prepare.setString(1, sp.getMaSanPham());
		prepare.setString(2, sp.getMaPhanLoai());
		prepare.setString(3, sp.getMaNhaSanXuat());
		prepare.setString(4, sp.getTenSanPham());
		prepare.setDouble(5, sp.getGiaNhap());
		prepare.setInt(6, sp.getSoLuong());
		prepare.setBytes(7, sp.getHinhAnh());
		prepare.setDouble(8,sp.getGiaBan());
		prepare.setBoolean(9, true);
		prepare.executeUpdate();
		
	}
	public SanPham GetSanPhamByIdSanPham(String id) throws SQLException
	{
		for(SanPham s : GetAllSanPham())
		{
			if(s.getMaSanPham().equals(id))return s;
		}
		return null;
	}
	public String TaoIdSanPham() throws SQLException
	{
		String id = "";
		List<String>IdSp = new ArrayList<String>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select MaSanPham from SanPham" ;
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
		
			IdSp.add(result.getString("MaSanPham"));
		}
		boolean status = true;
		while(status)
		{
			status = false;
			id = (ThreadLocalRandom.current().nextInt(0, 1000 + 1)) + "";
			for(String id1 : IdSp)
			{
				if(id1.equals(id))
				{
					status = true;
				}
			}
		}
		return id;
	}

	//public void SuaSanPham(SanPham sp) {
		// TODO Auto-generated method stub
	public void SuaSanPham(SanPham sp) throws SQLException {
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
				"update SanPham set Gia = ? , GiaBan = ? where MaSanPham = ?"
				);
		prepare.setDouble(1, sp.getGiaBan());
		prepare.setDouble(2, sp.getGiaNhap());
		prepare.setString(3, sp.getMaSanPham());
		prepare.executeUpdate();
		// TODO Auto-generated method stub
		
	}
	public void SuaTrangThai(SanPham sp)throws SQLException {
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
				"update SanPham set TrangThai = ? where MaSanPham = ?"
				);
		if(sp.getTrangThai()==true) {
			prepare.setInt(1, 0);
		}
		else {
			prepare.setInt(1, 1);
		}
//		prepare.setInt(1, tt);
		prepare.setString(2, sp.getMaSanPham());
		prepare.executeUpdate();
		// TODO Auto-generated method stub
		
	}
	// Thay đổi trạng thái của một sản phẩm
    public void changeProductStatus(int productId, boolean newStatus) {
        // Tìm sản phẩm có id tương ứng
//        for(SanPham p : products) {
//            if(p.getId() == productId) {
//                // Cập nhật trạng thái mới cho sản phẩm
//                p.setStatus(newStatus);
//                break;
//            }
//        }
    }
	public void ThemSL(SanPham sp) throws SQLException
	{
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
				"update SanPham set SoLuong = ? + SoLuong where MaSanPham = ?"
				);
		prepare.setInt(1, sp.getSoLuong());
		prepare.setString(2, sp.getMaSanPham());
		
		prepare.executeUpdate();
	}
		
	}
