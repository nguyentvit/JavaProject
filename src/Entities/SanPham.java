package Entities;

public class SanPham {
	public String MaSanPham;
	public String MaPhanLoai;
	public String MaNhaSanXuat;
	public String TenSanPham;
	public double GiaNhap;
	public double GiaBan;
	public int SoLuong;
	public byte[] HinhAnh;
	public String getMaSanPham() {
		return MaSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		MaSanPham = maSanPham;
	}
	public String getMaPhanLoai() {
		return MaPhanLoai;
	}
	public void setMaPhanLoai(String maPhanLoai) {
		MaPhanLoai = maPhanLoai;
	}
	public String getMaNhaSanXuat() {
		return MaNhaSanXuat;
	}
	public void setMaNhaSanXuat(String maNhaSanXuat) {
		MaNhaSanXuat = maNhaSanXuat;
	}
	public String getTenSanPham() {
		return TenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
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
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public byte[] getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(byte[] hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public SanPham(String maSanPham, String maPhanLoai, String maNhaSanXuat, String tenSanPham, double giaNhap,
			double giaBan, int soLuong, byte[] hinhAnh) {
		super();
		MaSanPham = maSanPham;
		MaPhanLoai = maPhanLoai;
		MaNhaSanXuat = maNhaSanXuat;
		TenSanPham = tenSanPham;
		GiaNhap = giaNhap;
		GiaBan = giaBan;
		SoLuong = soLuong;
		HinhAnh = hinhAnh;
	}
	public SanPham() {
		super();
	}
	
}
