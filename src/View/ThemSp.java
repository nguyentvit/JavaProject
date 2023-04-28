package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import DTO.ComboItem;
import Entities.NhaSanXuat;
import Entities.PhanLoai;
import Models.NhaSanXuatModel;
import Models.PhanLoaiModel;

import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

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
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loại sản phẩm");
		lblNewLabel.setBounds(432, 11, 79, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhà sản xuất");
		lblNewLabel_1.setBounds(432, 67, 79, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1.setBounds(432, 119, 79, 22);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giá nhập");
		lblNewLabel_1_2.setBounds(432, 167, 79, 22);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giá bán");
		lblNewLabel_1_3.setBounds(432, 223, 79, 22);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số lượng");
		lblNewLabel_1_4.setBounds(432, 269, 79, 22);
		getContentPane().add(lblNewLabel_1_4);
		
		cbbPhanLoai = new JComboBox();
		cbbPhanLoai.setBounds(521, 11, 125, 22);
		getContentPane().add(cbbPhanLoai);
		
		cbbNhaSx = new JComboBox();
		cbbNhaSx.setBounds(521, 67, 125, 22);
		getContentPane().add(cbbNhaSx);
		
		txtTenSp = new JTextField();
		txtTenSp.setBounds(521, 120, 125, 20);
		getContentPane().add(txtTenSp);
		txtTenSp.setColumns(10);
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(521, 168, 125, 20);
		getContentPane().add(txtGiaNhap);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(521, 224, 125, 20);
		getContentPane().add(txtGiaBan);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(521, 270, 125, 20);
		getContentPane().add(txtSoLuong);
		
		 btnXacNhan = new JButton("Xác nhận");
		 btnXacNhan.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		btnXacNhan_actionPerformed(e);
		 	}
		 });
		btnXacNhan.setBounds(250, 443, 89, 23);
		getContentPane().add(btnXacNhan);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(462, 443, 89, 23);
		getContentPane().add(btnHuy);
		
		
		
		btnAnh = new JButton("Browser...");
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
		btnAnh.setBounds(159, 343, 89, 23);
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
	public void btnAnh_actionPerformed(ActionEvent e) throws SQLException, IOException {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setMultiSelectionEnabled(false);
		if(jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				this.file = jFileChooser.getSelectedFile();
				String sname = file.getAbsolutePath();
				ImageIcon icon = new ImageIcon(sname);
				picture = new JLabel(icon,JLabel.CENTER);
				picture.setBounds(10, 11, 377, 321);
				getContentPane().add(picture);
				getContentPane().revalidate();
				getContentPane().resize(900,600);
			};
			
	}
	public void btnXacNhan_actionPerformed(ActionEvent e) {
 		
 	}
	public void ShowWinDow()
	{
		
		this.setVisible(true);
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		
	}
}
