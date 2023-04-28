package Models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.ViewSanPham;
import Entities.SanPham;

public class ViewSanPhamModel {
	public List<ViewSanPham>GetAllViewSanPham() throws SQLException
	{
		List<ViewSanPham> list = new ArrayList<ViewSanPham>();
		SanPhamModel sp = new SanPhamModel();
		NhaSanXuatModel nsx = new NhaSanXuatModel();
		PhanLoaiModel pl = new PhanLoaiModel();
		int i = 0;
		for(SanPham s : sp.GetAllSanPham())
		{
			list.add(new ViewSanPham(++i,s.getMaSanPham(),s.getTenSanPham(),nsx.GetTenNhaSx(s.getMaNhaSanXuat()),pl.GetTenPhanLoaiById(s.getMaPhanLoai()),s.getSoLuong(),s.getGiaNhap(),s.getGiaBan(),s.getHinhAnh()));
		}		
		return list;
	}
}
