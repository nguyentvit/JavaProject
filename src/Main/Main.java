package Main;

import java.io.IOException;
import java.sql.SQLException;

import Models.SanPhamModel;
import View.Muahang;
import View.Sanpham;
import View.ThemSp;
import View.TrangChu;

public class Main {

	public static void main(String[] args) throws SQLException, IOException  {
		TrangChu ch = new TrangChu();
	   Muahang tc = new Muahang();
		ch.ShowWinDow();
		//sp.ShowWinDow();
	}

}
