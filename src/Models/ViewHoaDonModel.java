package Models;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import DTO.ViewHoaDon;
import Entities.MuaHang;
import Entities.Nguoi;

public class ViewHoaDonModel {
	public List<ViewHoaDon> getAllViewHoaDon() throws SQLException, ParseException 
	{
	    List<ViewHoaDon> list = new ArrayList<ViewHoaDon>();
	    MuaHangModel mhm = new MuaHangModel() ;
	    NguoiModel nguoi = new NguoiModel();
	    int i = 1;
	    for (MuaHang mh : mhm.GetAllMuaHang())
	    {
	    	
	    	Nguoi ng  = nguoi.getNguoiByIdNguoi(mh.getMaNguoi());
	        ViewHoaDon viewhd = new ViewHoaDon(i++,mh.getMaMuaHang() , ng.getTenNguoi(), ng.getSdt(), mh.getDiaChiNhanHang(), mh.getTongCong());
	        list.add(viewhd);
	    }
	    
	    return list;
	    
	}
//	

}
