package Models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import DocCsdl.DocCsdl;
import Entities.MuaHang;
import Entities.Nguoi;
import Entities.SanPham;

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
			//Date ThoiGianMuaHang = (Date) new SimpleDateFormat("dd-MM-yyyy").parse(result.getString("ThoiGianMuaHang"));	
			MuaHangs.add(new MuaHang(result.getString("MaMuaHang"),result.getString("MaNguoi"),result.getString("ThoiGianMuaHang"),result.getString("DiaChiNhanHang"),TongCong));
		}
		return MuaHangs;
	}

	public String TaoIdMuaHang() throws SQLException
	{
		String id = "";
		List<String>Id = new ArrayList<String>();
		Connection con = DocCsdl.getConnect(); 
		Statement stt = con.createStatement();
		String query = "select MaMuaHang from MuaHang" ;
		ResultSet result = stt.executeQuery(query);
		while(result.next())
		{
			Id.add(result.getString("MaMuaHang"));
		}
		boolean status = true;
		while(status)
		{
			status = false;
			id = (ThreadLocalRandom.current().nextInt(0, 1000 + 1)) + "";
			for(String id1 : Id)
			{
				if(id1.equals(id))
				{
					status = true;
				}
			}
		}
		return id;
	}
	public void AddMuaHang(MuaHang mh) throws SQLException
	{
		PreparedStatement prepare = DocCsdl.getConnect().prepareStatement(
				"insert into MuaHang values(?,?,?,?,?)"
				);
		prepare.setString(1, mh.getMaMuaHang());
		prepare.setString(2, mh.getMaNguoi());
		prepare.setString(3, mh.getThoiGianMuaHang());
		prepare.setString(4, mh.getDiaChiNhanHang());
		prepare.setDouble(5, mh.getTongCong());
		prepare.executeUpdate();
		
	}
}
