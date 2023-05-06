package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import DTO.ComboItem;
import DocCsdl.DocCsdl;
import Entities.NhaSanXuat;
import Entities.PhanLoai;
import Entities.SanPham;
import Models.NhaSanXuatModel;
import Models.PhanLoaiModel;
import Models.SanPhamModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Image;

public class ThemSp extends JFrame{
	private JTextField txtTenSp;
	private JTextField txtGiaNhap;
	private JTextField txtGiaBan;
	private JTextField txtSoLuong;
	private JComboBox cbbPhanLoai,cbbNhaSx;
	private JButton btnAnh,btnXacNhan;
	private File file;
	private JLabel picture;
	public ThemSp() throws SQLException, IOException {
		getContentPane().setBackground(new Color(217, 255, 255));
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Loại sản phẩm");
		lblNewLabel.setBounds(117, 28, 79, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhà sản xuất");
		lblNewLabel_1.setBounds(117, 60, 79, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1.setBounds(117, 92, 79, 22);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giá nhập");
		lblNewLabel_1_2.setBounds(117, 136, 79, 22);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giá bán");
		lblNewLabel_1_3.setBounds(117, 176, 79, 22);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số lượng");
		lblNewLabel_1_4.setBounds(117, 218, 79, 22);
		getContentPane().add(lblNewLabel_1_4);
		
		cbbPhanLoai = new JComboBox();
		cbbPhanLoai.setBounds(213, 28, 125, 22);
		getContentPane().add(cbbPhanLoai);
		
		cbbNhaSx = new JComboBox();
		cbbNhaSx.setBounds(213, 60, 125, 22);
		getContentPane().add(cbbNhaSx);
		
		txtTenSp = new JTextField();
		txtTenSp.setBounds(213, 99, 125, 20);
		getContentPane().add(txtTenSp);
		txtTenSp.setColumns(10);
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(213, 138, 125, 20);
		getContentPane().add(txtGiaNhap);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(213, 178, 125, 20);
		getContentPane().add(txtGiaBan);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(213, 220, 125, 20);
		getContentPane().add(txtSoLuong);
		
		 btnXacNhan = new JButton("Xác nhận");
		 btnXacNhan.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
					btnXacNhan_actionPerformed(e);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 	}
		 });
		btnXacNhan.setBounds(151, 278, 89, 23);
		getContentPane().add(btnXacNhan);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					Sanpham s = new Sanpham();
					s.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		btnHuy.setBounds(267, 278, 89, 23);
		getContentPane().add(btnHuy);
		
		
		
		btnAnh = new JButton("Ảnh");
		btnAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnAnh_actionPerformed(e);
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAnh.setBounds(440, 218, 89, 23);
		getContentPane().add(btnAnh);
		
		
		
		LoadData();
	}
	private void LoadData() throws SQLException, IOException {
		PhanLoaiModel pl = new PhanLoaiModel();
		for(PhanLoai p : pl.GetAllPhanLoai())
		{
			cbbPhanLoai.addItem(new ComboItem(p.getMaPhanLoai(),p.getTenPhanLoai()));
		}
		NhaSanXuatModel nsx = new NhaSanXuatModel();
		for(NhaSanXuat sx : nsx.GetAllNhaSanXuat())
		{
			cbbNhaSx.addItem(new ComboItem(sx.getMaNhaSanXuat(),sx.getTenNhaSanXuat()));
		}
		
		
	}
	public void loadInfor(String id)
	{
		Connection conn = null;

		try {
	        conn = DocCsdl.getConnect();
	        String sql = "Select * from SanPham where MaSanPham = '" + id + "'";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, id);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	            txtTenSp.setText(rs.getString("TenSanPham"));
	            txtGiaBan.setText(rs.getString("GiaBan"));
	            txtGiaNhap.setText(rs.getString("GiaNhap"));
	            txtSoLuong.setText(rs.getString("SoLuong"));
	            
	        }
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, e.getMessage());
	    } finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public void btnAnh_actionPerformed(ActionEvent e) throws SQLException, IOException {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setMultiSelectionEnabled(false);
		if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		    this.file = jFileChooser.getSelectedFile();
		    String sname = file.getAbsolutePath();
		    ImageIcon icon = new ImageIcon(sname);
		    Image image = icon.getImage();
		    Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		    ImageIcon scaledIcon = new ImageIcon(scaledImage);
		    picture = new JLabel(scaledIcon);
		    picture.setBounds(420, 60, 150, 150);
		    picture.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Thêm đường viền cho JLabel
		    picture.setHorizontalAlignment(JLabel.CENTER); // Căn giữa JLabel theo chiều ngang
		    picture.setVerticalAlignment(JLabel.CENTER); // Căn giữa JLabel theo chiều dọc
		    getContentPane().add(picture);
		    getContentPane().revalidate();
		    getContentPane().repaint();
		};
			
	}
	private boolean CheckHopLe()
	{
		if(txtTenSp.getText() == "")
		{
			return false;
		}
		if(txtGiaBan.getText() == "")
		{
			return false;
		}
		if(txtGiaNhap.getText() == "")
		{
			return false;
		}
		if(txtSoLuong.getText() == "")
		{
			return false;
		}
		try {
			Double.parseDouble(txtGiaBan.getText());
			Double.parseDouble(txtGiaNhap.getText());
			Integer.parseInt(txtSoLuong.getText());
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		return true;
		
				
	}
	public void btnXacNhan_actionPerformed(ActionEvent e) throws SQLException, IOException {
 		if(CheckHopLe())
 		{
 			SanPhamModel spm = new SanPhamModel();
 			SanPham sp = new SanPham();
 			sp.setMaSanPham(spm.TaoIdSanPham());
 			//String maPhanLoai = 
 			sp.setMaPhanLoai(((ComboItem)(cbbPhanLoai.getSelectedItem())).getKey());
 			sp.setMaNhaSanXuat(((ComboItem)(cbbNhaSx.getSelectedItem())).getKey());
 			sp.setTenSanPham(txtTenSp.getText());
 			sp.setGiaNhap(Double.parseDouble(txtGiaNhap.getText()));
 			sp.setGiaBan(Double.parseDouble(txtGiaBan.getText()));
 			sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
 			if(file != null)
 			{			
 				sp.setHinhAnh(Files.readAllBytes(file.toPath()));
 			}
 			spm.AddSanPham(sp);
 			JOptionPane.showMessageDialog(null,"Thêm sản phẩm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
 			dispose();
 			Sanpham s = new Sanpham();
 			s.ShowWinDow();
 			
 		}
 		else {
 			JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ","Thông báo",JOptionPane.INFORMATION_MESSAGE);
 		}
 			
 	}
	public void ShowWinDow()
	{
		this.setVisible(true);
		this.setSize(847, 488);
		this.setLocationRelativeTo(null);
		
	}
}
