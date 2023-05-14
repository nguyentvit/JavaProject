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
			list.add(new ViewSanPham(++i,s.getMaSanPham(),s.getTenSanPham(),nsx.GetTenNhaSx(s.getMaNhaSanXuat()),pl.GetTenPhanLoaiById(s.getMaPhanLoai()),s.getSoLuong(),s.getGiaNhap(),s.getGiaBan(),s.getHinhAnh(),s.getTrangThai()));
		}		
		return list;
	}

	public List<ViewSanPham>GetViewSanPhamByIdPhanLoai(String idPhanLoai) throws SQLException
	{
		List<ViewSanPham> list = new ArrayList<ViewSanPham>();
		SanPhamModel sp = new SanPhamModel();
		NhaSanXuatModel nsx = new NhaSanXuatModel();
		PhanLoaiModel pl = new PhanLoaiModel();
		int i=0;
		for(SanPham s: sp.GetAllSanPham())
		{
			if(idPhanLoai.equals("-1"))
			{
				list.add(new ViewSanPham(++i,s.getMaSanPham(),s.getTenSanPham(),nsx.GetTenNhaSx(s.getMaNhaSanXuat()),pl.GetTenPhanLoaiById(s.getMaPhanLoai()),s.getSoLuong(),s.getGiaNhap(),s.getGiaBan(),s.getHinhAnh(),s.getTrangThai()));

			}
			else if(s.getMaPhanLoai().equals(idPhanLoai))
			{
				list.add(new ViewSanPham(++i,s.getMaSanPham(),s.getTenSanPham(),nsx.GetTenNhaSx(s.getMaNhaSanXuat()),pl.GetTenPhanLoaiById(s.getMaPhanLoai()),s.getSoLuong(),s.getGiaNhap(),s.getGiaBan(),s.getHinhAnh(),s.getTrangThai()));

			}
		}
		return list;
	}
	public List<ViewSanPham>GetViewSanPhamByIdNhaSx(String idNhaSx) throws SQLException
	{
		List<ViewSanPham> list = new ArrayList<ViewSanPham>();
		SanPhamModel sp = new SanPhamModel();
		NhaSanXuatModel nsx = new NhaSanXuatModel();
		PhanLoaiModel pl = new PhanLoaiModel();
		int i=0;
		for(SanPham s: sp.GetAllSanPham())
		{
			if(idNhaSx.equals("-1"))
			{
				list.add(new ViewSanPham(++i,s.getMaSanPham(),s.getTenSanPham(),nsx.GetTenNhaSx(s.getMaNhaSanXuat()),pl.GetTenPhanLoaiById(s.getMaPhanLoai()),s.getSoLuong(),s.getGiaNhap(),s.getGiaBan(),s.getHinhAnh(),s.getTrangThai()));

			}
			else if(s.getMaNhaSanXuat().equals(idNhaSx))
			{
				list.add(new ViewSanPham(++i,s.getMaSanPham(),s.getTenSanPham(),nsx.GetTenNhaSx(s.getMaNhaSanXuat()),pl.GetTenPhanLoaiById(s.getMaPhanLoai()),s.getSoLuong(),s.getGiaNhap(),s.getGiaBan(),s.getHinhAnh(),s.getTrangThai()));

			}
		}
		return list;
	}
	public List<ViewSanPham>GetViewSanPhamByTenSP(String ten) throws SQLException
	{
		List<ViewSanPham> list = new ArrayList<ViewSanPham>();
		SanPhamModel sp = new SanPhamModel();
		NhaSanXuatModel nsx = new NhaSanXuatModel();
		PhanLoaiModel pl = new PhanLoaiModel();
		int i=0;
		for(SanPham s: sp.GetAllSanPham())
		{
			if(s.getTenSanPham().contains(ten))
			{
				list.add(new ViewSanPham(++i,s.getMaSanPham(),s.getTenSanPham(),nsx.GetTenNhaSx(s.getMaNhaSanXuat()),pl.GetTenPhanLoaiById(s.getMaPhanLoai()),s.getSoLuong(),s.getGiaNhap(),s.getGiaBan(),s.getHinhAnh(),s.getTrangThai()));

			}
		}
		return list;
	}
	public List<ViewSanPham>GetViewSanPhamByTimKiem(String idPhanLoai,String idNhaSx, String ten) throws SQLException
	{
		List<ViewSanPham> listTenSP = GetViewSanPhamByTenSP(ten);
		List<ViewSanPham> listIdPhanLoai = GetViewSanPhamByIdPhanLoai(idPhanLoai);
		List<ViewSanPham> listIdNhaSx = GetViewSanPhamByIdNhaSx(idNhaSx);
		List<ViewSanPham> list = new ArrayList<ViewSanPham>(listIdPhanLoai);
		list.retainAll(listIdNhaSx);
		list.retainAll(listTenSP);
		return list;
	}
	public ViewSanPham GetViewSanPhamByIdSanPham(String idSanPham) throws SQLException
	{
		for(ViewSanPham s : GetAllViewSanPham())
		{
			if(s.getMaSanPham().equals(idSanPham))return s;
		}
		return null;
	}
	
}
