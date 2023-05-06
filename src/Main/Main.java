package Main;

import java.io.IOException;
import java.sql.SQLException;

import Models.SanPhamModel;
import View.MuaHang;
import View.Sanpham;
import View.ThemSp;
import View.TrangChu;

public class Main {

	public static void main(String[] args) throws SQLException, IOException  {
	   MuaHang tc = new MuaHang();
		//Sanpham sp = new Sanpham();
		tc.ShowWinDow();
		//sp.ShowWinDow();
	}

}
