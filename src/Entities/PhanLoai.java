package Entities;

public class PhanLoai {
	public String MaPhanLoai;
	public String TenPhanLoai;
	public String getMaPhanLoai() {
		return MaPhanLoai;
	}
	public void setMaPhanLoai(String maPhanLoai) {
		MaPhanLoai = maPhanLoai;
	}
	public String getTenPhanLoai() {
		return TenPhanLoai;
	}
	public void setTenPhanLoai(String tenPhanLoai) {
		TenPhanLoai = tenPhanLoai;
	}
	public PhanLoai(String maPhanLoai, String tenPhanLoai) {
		super();
		MaPhanLoai = maPhanLoai;
		TenPhanLoai = tenPhanLoai;
	}
	public PhanLoai() {
		super();
	}
	
}
