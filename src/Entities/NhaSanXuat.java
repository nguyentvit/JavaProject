package Entities;

public class NhaSanXuat {
	public String MaNhaSanXuat;
	public String TenNhaSanXuat;
	public String getMaNhaSanXuat() {
		return MaNhaSanXuat;
	}
	public void setMaNhaSanXuat(String maNhaSanXuat) {
		MaNhaSanXuat = maNhaSanXuat;
	}
	public String getTenNhaSanXuat() {
		return TenNhaSanXuat;
	}
	public void setTenNhaSanXuat(String tenNhaSanXuat) {
		TenNhaSanXuat = tenNhaSanXuat;
	}
	
	public NhaSanXuat(String maNhaSanXuat, String tenNhaSanXuat) {
		super();
		MaNhaSanXuat = maNhaSanXuat;
		TenNhaSanXuat = tenNhaSanXuat;
	}
	public NhaSanXuat() {
		super();
	}
	
}
