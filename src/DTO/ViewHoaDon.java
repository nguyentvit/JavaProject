package DTO;

public class ViewHoaDon {
	public int Stt;
	public String MaMuaHang;
	public String TenKH;
	public String Sdt;
	public String Diachi;
	public double Tongtien;
	public int getStt() {
		return Stt;
	}
	public ViewHoaDon(int stt, String maMuaHang, String tenKH, String sdt, String diachi, double tongtien) {
		super();
		Stt = stt;
		MaMuaHang = maMuaHang;
		TenKH = tenKH;
		Sdt = sdt;
		Diachi = diachi;
		Tongtien = tongtien;
	}
	public void setStt(int stt) {
		Stt = stt;
	}
	public String getMaMuaHang() {
		return MaMuaHang;
	}
	public void setMaMuaHang(String maMuaHang) {
		MaMuaHang = maMuaHang;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getSdt() {
		return Sdt;
	}
	public void setSdt(String sdt) {
		Sdt = sdt;
	}
	public String getDiachi() {
		return Diachi;
	}
	public void setDiachi(String diachi) {
		Diachi = diachi;
	}
	public double getTongtien() {
		return Tongtien;
	}
	public void setTongtien(double tongtien) {
		Tongtien = tongtien;
	}
	
	
	

}
