package Main;

import java.io.IOException;
import java.sql.SQLException;

import Models.SanPhamModel;
import View.Sanpham;
import View.ThemSp;
import View.TrangChu;

public class Main {

	public static void main(String[] args) throws SQLException, IOException  {
	   TrangChu tc = new TrangChu();
		Sanpham sp = new Sanpham();
		tc.ShowWinDow();
		//sp.ShowWinDow();
	}

}
