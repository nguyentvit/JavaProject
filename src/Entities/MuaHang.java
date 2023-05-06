package Entities;


public class MuaHang {
	public String MaMuaHang;
	public String MaNguoi;
	public String ThoiGianMuaHang;
	public String DiaChiNhanHang;
	public double TongCong;
	public String getMaMuaHang() {
		return MaMuaHang;
	}
	public void setMaMuaHang(String maMuaHang) {
		MaMuaHang = maMuaHang;
	}
	public String getMaNguoi() {
		return MaNguoi;
	}
	public void setMaNguoi(String maNguoi) {
		MaNguoi = maNguoi;
	}
	public String getThoiGianMuaHang() {
		return ThoiGianMuaHang;
	}
	public void setThoiGianMuaHang(String thoiGianMuaHang) {
		ThoiGianMuaHang = thoiGianMuaHang;
	}
	public String getDiaChiNhanHang() {
		return DiaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		DiaChiNhanHang = diaChiNhanHang;
	}
	public double getTongCong() {
		return TongCong;
	}
	public void setTongCong(double tongCong) {
		TongCong = tongCong;
	}
	public MuaHang(String maMuaHang, String maNguoi, String thoiGianMuaHang, String diaChiNhanHang, double tongCong) {
		super();
		MaMuaHang = maMuaHang;
		MaNguoi = maNguoi;
		ThoiGianMuaHang = thoiGianMuaHang;
		DiaChiNhanHang = diaChiNhanHang;
		TongCong = tongCong;
	}
	public MuaHang() {
		super();
	}
}
