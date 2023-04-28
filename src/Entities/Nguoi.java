package Entities;

public class Nguoi {
	public String MaNguoi;
	public String TenNguoi;
	public String Sdt;
	public String getMaNguoi() {
		return MaNguoi;
	}
	public void setMaNguoi(String maNguoi) {
		MaNguoi = maNguoi;
	}
	public String getTenNguoi() {
		return TenNguoi;
	}
	public void setTenNguoi(String tenNguoi) {
		TenNguoi = tenNguoi;
	}
	public String getSdt() {
		return Sdt;
	}
	public void setSdt(String sdt) {
		Sdt = sdt;
	}
	public Nguoi(String maNguoi, String tenNguoi, String sdt) {
		super();
		MaNguoi = maNguoi;
		TenNguoi = tenNguoi;
		Sdt = sdt;
	}
	public Nguoi() {
		super();
	}
	
}
