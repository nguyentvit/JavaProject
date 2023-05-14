package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.ComboItem;
import DTO.ViewSanPham;
import Entities.Nguoi;
import Entities.SanPham;
import Models.SanPhamModel;
import Models.ViewSanPhamModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SuaSP extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtGianhap;
	private JTextField txtGiaBan;
	private JTextField txtSoLuong;
	private File file;
	private JLabel picture;

	public SuaSP(String id) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(184, 245, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Loại sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(143, 88, 126, 22);
		contentPane.add(lblNewLabel);
		
		JComboBox cbbPhanLoai = new JComboBox();
		cbbPhanLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbPhanLoai.setEnabled(false);
		cbbPhanLoai.setBounds(279, 88, 147, 22);
		contentPane.add(cbbPhanLoai);
		
		JLabel lblNewLabel_1 = new JLabel("Nhà sản xuất");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(143, 120, 126, 22);
		contentPane.add(lblNewLabel_1);
		
		JComboBox cbbNhaSx = new JComboBox();
		cbbNhaSx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbbNhaSx.setEnabled(false);
		cbbNhaSx.setBounds(279, 120, 147, 22);
		contentPane.add(cbbNhaSx);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(143, 152, 126, 22);
		contentPane.add(lblNewLabel_1_1);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTen.setEnabled(false);
		txtTen.setColumns(10);
		txtTen.setBounds(279, 159, 147, 20);
		contentPane.add(txtTen);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giá nhập");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(143, 196, 126, 22);
		contentPane.add(lblNewLabel_1_2);
		
		txtGianhap = new JTextField();
		txtGianhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGianhap.setColumns(10);
		txtGianhap.setBounds(279, 198, 147, 20);
		contentPane.add(txtGianhap);
		
		JLabel lblNewLabel_1_3 = new JLabel("Giá bán");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(143, 236, 126, 22);
		contentPane.add(lblNewLabel_1_3);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(279, 238, 147, 20);
		contentPane.add(txtGiaBan);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số lượng");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(143, 278, 126, 22);
		contentPane.add(lblNewLabel_1_4);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoLuong.setEnabled(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(279, 280, 147, 20);
		contentPane.add(txtSoLuong);
		
		JButton btnXacNhan = new JButton("");
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DecimalFormat formatter = new DecimalFormat("0");
				SanPham sp = new SanPham();
			    SanPhamModel spm = new SanPhamModel();
			  
			    try {
			    	sp = spm.GetSanPhamByIdSanPham(id);
			    	 sp.setGiaNhap(Double.parseDouble(txtGianhap.getText())); // sửa giá nhập
					    sp.setGiaBan(Double.parseDouble(txtGiaBan.getText())); // sửa giá bán
			    	spm.SuaSanPham(sp);
			    	JOptionPane .showMessageDialog(null, "Thay đổi thông tin thành công", "Thông báo", JOptionPane.OK_OPTION);
			    	
						try {
							dispose();
					    	Sanpham ph;
							ph = new Sanpham();
							ph.ShowWinDow();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    }
			    catch (SQLException e1)
			    {
			    	e1.printStackTrace();
			    }
				
			}
		});
		btnXacNhan.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-checkmark-25.png"));
		btnXacNhan.setBackground(new Color(0, 128, 192));
		btnXacNhan.setBounds(208, 349, 42, 33);
		contentPane.add(btnXacNhan);
		
		JButton btnHuy = new JButton("");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHuy.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-close-20.png"));
		btnHuy.setBackground(new Color(225, 38, 71));
		btnHuy.setBounds(336, 349, 35, 33);
		contentPane.add(btnHuy);
		
		JButton btnAnh = new JButton("");
		btnAnh.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-add-image-20.png"));
		btnAnh.setBackground(new Color(0, 183, 183));
		btnAnh.setBounds(574, 320, 79, 33);
		contentPane.add(btnAnh);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sanpham sp;
				try {
					sp = new Sanpham();
					sp.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnNewButton_2.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-back-20.png"));
		btnNewButton_2.setBounds(35, 23, 45, 26);
		contentPane.add(btnNewButton_2);
		
		SanPhamModel spm = new SanPhamModel();
		ViewSanPham view = new ViewSanPham();
	    ViewSanPhamModel viewm = new ViewSanPhamModel();
	    view = viewm.GetViewSanPhamByIdSanPham(id);
		SanPham sp = spm.GetSanPhamByIdSanPham(id);
		txtTen.setText(sp.getTenSanPham());
		txtGianhap.setText(String.valueOf(sp.getGiaNhap()));
		txtGiaBan.setText(String.valueOf(sp.getGiaBan()));
		//ImageIcon icon = new ImageIcon(sp.getHinhAnh());
		//picture.setIcon(icon);
		
		txtSoLuong.setText(String.valueOf(sp.getSoLuong()));
		cbbNhaSx.addItem(new ComboItem(sp.getMaNhaSanXuat(), view.getTenNhaSanXuat()));
		cbbPhanLoai.addItem(new ComboItem(sp.getMaPhanLoai(), view.getTenPhanLoai()));
		
		 ImageIcon icon = new ImageIcon(sp.getHinhAnh());
		    Image image = icon.getImage();
		    Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		    ImageIcon scaledIcon = new ImageIcon(scaledImage);
		    picture = new JLabel(scaledIcon);
		    picture.setBounds(522, 108, 160, 175);
		    picture.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Thêm đường viền cho JLabel
		    picture.setHorizontalAlignment(JLabel.CENTER); // Căn giữa JLabel theo chiều ngang
		    picture.setVerticalAlignment(JLabel.CENTER); // Căn giữa JLabel theo chiều dọc
		    getContentPane().add(picture);
		    getContentPane().revalidate();
		    getContentPane().repaint();
	}
	
	public void ShowWinDow() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		this.setSize(730, 500);
		this.setLocationRelativeTo(null);
}
}
