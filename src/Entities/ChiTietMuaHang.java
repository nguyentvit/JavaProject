package Entities;

public class ChiTietMuaHang {
	public String MaChiTietMuaHang;
	public String MaMuaHang;
	public String MaSanPham;
	public int SoLuong;
	public double DonGia;
	public String getMaChiTietMuaHang() {
		return MaChiTietMuaHang;
	}
	public void setMaChiTietMuaHang(String maChiTietMuaHang) {
		MaChiTietMuaHang = maChiTietMuaHang;
	}
	public String getMaMuaHang() {
		return MaMuaHang;
	}
	public void setMaMuaHang(String maMuaHang) {
		MaMuaHang = maMuaHang;
	}
	public String getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public double getDonGia() {
		return DonGia;
	}
	public void setDonGia(double donGia) {
		DonGia = donGia;
	}
	public ChiTietMuaHang(String maChiTietMuaHang, String maMuaHang, String maSanPham, int soLuong, double donGia) {
		super();
		MaChiTietMuaHang = maChiTietMuaHang;
		MaMuaHang = maMuaHang;
		MaSanPham = maSanPham;
		SoLuong = soLuong;
		DonGia = donGia;
	}
	public ChiTietMuaHang() {
		super();
	}
	
}
