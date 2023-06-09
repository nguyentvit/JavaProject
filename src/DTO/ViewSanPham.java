package DTO;

public class ViewSanPham {
	public int Stt;
	public String MaSanPham;
	public String TenSanPham;
	public String TenNhaSanXuat;
	public String TenPhanLoai;
	public int SoLuong;
	public double GiaNhap;
	public double GiaBan;
	public byte[] HinhAnh;
	public int getStt() {
		return Stt;
	}
	public void setStt(int stt) {
		Stt = stt;
	}
	public String getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}
	public String getTenNhaSanXuat() {
		return TenNhaSanXuat;
	}
	public void setTenNhaSanXuat(String tenNhaSanXuat) {
		TenNhaSanXuat = tenNhaSanXuat;
	}
	public String getTenPhanLoai() {
		return TenPhanLoai;
	}
	public void setTenPhanLoai(String tenPhanLoai) {
		TenPhanLoai = tenPhanLoai;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public double getGiaNhap() {
		return GiaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		GiaNhap = giaNhap;
	}
	public double getGiaBan() {
		return GiaBan;
	}
	public void setGiaBan(double giaBan) {
		GiaBan = giaBan;
	}
	public byte[] getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(byte[] hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public ViewSanPham(int stt, String maSanPham, String tenSanPham, String tenNhaSanXuat, String tenPhanLoai,
			int soLuong, double giaNhap, double giaBan, byte[] hinhAnh) {
		super();
		Stt = stt;
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		TenNhaSanXuat = tenNhaSanXuat;
		TenPhanLoai = tenPhanLoai;
		SoLuong = soLuong;
		GiaNhap = giaNhap;
		GiaBan = giaBan;
		HinhAnh = hinhAnh;
	}
	public ViewSanPham() {
		super();
	}
	
	
}
