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
	public boolean TrangThai;
	public int getStt() {
		return Stt;
	}
	public void setStt(int stt) {
		Stt = stt;
	}
	public boolean getTrangThai() {
		return TrangThai;
	}
	public void setTrangThai(boolean tt) {
		TrangThai = tt;
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
			int soLuong, double giaNhap, double giaBan, byte[] hinhAnh, boolean trangThai) {
		super();
		Stt = stt;
		MaSanPham = maSanPham;
		TenSanPham = tenSanPham;
		TenNhaSanXuat = tenNhaSanXuat;
		TenPhanLoai = tenPhanLoai;
		SoLuong = soLuong;
		GiaNhap = giaNhap;
		GiaBan = giaBan;
		TrangThai = trangThai;
		HinhAnh = hinhAnh;
	}
	public ViewSanPham() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result
                + ((MaSanPham == null) ? 0 : MaSanPham.hashCode());
        return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ViewSanPham other = (ViewSanPham) obj;
        if (MaSanPham == null) {
            if (other.MaSanPham != null)
                return false;
        } else if (!MaSanPham.equals(other.MaSanPham))
            return false;
        return true;
	}
	
	
	
}
