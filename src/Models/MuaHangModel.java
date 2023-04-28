package Models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DocCsdl.DocCsdl;
import Entities.MuaHang;

public class MuaHangModel {
	public List<MuaHang>GetAllMuaHang() throws SQLException, ParseException
	{
		List<MuaHang>MuaHangs = new ArrayList<MuaHang>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select * from MuaHang" ;
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
			double TongCong = Double.parseDouble(result.getString("TongCong"));
			Date ThoiGianMuaHang = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(result.getString("ThoiGianMuaHang"));	
			MuaHangs.add(new MuaHang(result.getString("MaMuaHang"),result.getString("MaNguoi"),ThoiGianMuaHang,result.getString("DiaChiNhanHang"),TongCong));
		}
		return MuaHangs;
	}
}
