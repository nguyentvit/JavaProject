package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import DTO.ViewSanPham;
import Entities.ChiTietMuaHang;
import Entities.MuaHang;
import Entities.Nguoi;
import Entities.SanPham;
import Models.ChiTietMuaHangModel;
import Models.MuaHangModel;
import Models.NguoiModel;
import Models.SanPhamModel;
import Models.ViewSanPhamModel;


import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class ChiTietHoaDon extends JFrame {
	private List<ViewSanPham>SanPhamMua;
	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtSdt;
	private JTextField txtTongTien;
	private JTable table;
	private JDateChooser date1;
	private JButton btnNewButton;
	private JTextField txtDiaChi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException, IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ChiTietHoaDon frame = new ChiTietHoaDon(SanPhamMua);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChiTietHoaDon(List<ViewSanPham> mylist) throws SQLException, IOException{
		this.SanPhamMua = mylist;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 248, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblNewLabel.setBackground(new Color(205, 250, 252));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QuanLyDienThoai\\JavaProject\\icons\\icons8-paid-bill-20.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(281, 10, 153, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày ");
		lblNewLabel_1.setBounds(50, 162, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		txtTen = new JTextField();
		txtTen.setBounds(123, 72, 96, 19);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(123, 113, 96, 19);
		contentPane.add(txtSdt);
		
		 date1 = new JDateChooser();
		date1.setBounds(123, 162, 96, 19);
		contentPane.add(date1);
		
		JLabel lblNewLabel_1_3 = new JLabel("SĐT");
		lblNewLabel_1_3.setBounds(50, 116, 45, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tổng tiền");
		lblNewLabel_1_4.setBounds(50, 246, 45, 13);
		contentPane.add(lblNewLabel_1_4);
		
		txtTongTien = new JTextField();
		txtTongTien.setEnabled(false);
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(123, 242, 96, 19);
		contentPane.add(txtTongTien);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tên KH\r\n");
		lblNewLabel_1_5.setBounds(50, 72, 45, 13);
		contentPane.add(lblNewLabel_1_5);
		
		 btnNewButton = new JButton("");
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QuanLyDienThoai\\JavaProject\\icons\\icons8-checkmark-25.png"));
		btnNewButton.setBounds(280, 322, 45, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QuanLyDienThoai\\JavaProject\\icons\\icons8-close-20.png"));
		btnNewButton_1.setBounds(335, 322, 45, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnTrV = new JButton("");
		btnTrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Muahang mh;
				try {
					mh = new Muahang();
					mh.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrV.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QuanLyDienThoai\\JavaProject\\icons\\icons8-back-20.png"));
		btnTrV.setBounds(657, 20, 37, 29);
		contentPane.add(btnTrV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 72, 400, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(123, 202, 96, 19);
		contentPane.add(txtDiaChi);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ nhận hàng");
		lblNewLabel_1_1.setBounds(50, 205, 63, 13);
		contentPane.add(lblNewLabel_1_1);
		LoadForm();
		AddControl();
	}
	private boolean CheckHopLe()
	{
		if(txtSdt.getText() == "")
		{
			return false;
		}
		if(txtTen.getText() == "")
		{
			return false;
		}
		if(date1.getDate() == null)
		{
			return false;
		}
		if(txtDiaChi.getText() == "")
		{
			return false;
		}
		
		return true;
	}
	private void AddControl()
	{
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CheckHopLe())
				{
					
					try {
						NguoiModel ngm = new NguoiModel();
						Nguoi ng = new Nguoi();
						ng.setMaNguoi(ngm.TaoIdNguoi());
						ng.setTenNguoi(txtTen.getText());
						ng.setSdt(txtSdt.getText());
						ngm.AddNguoi(ng);
						MuaHangModel mhm = new MuaHangModel();
						MuaHang mh = new MuaHang();
						mh.setMaMuaHang(mhm.TaoIdMuaHang());
						mh.setMaNguoi(ng.getMaNguoi());
						Date date2 = date1.getDate();
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
						String date1 = dateFormat.format(date2);
						mh.setThoiGianMuaHang(date1);
						mh.setDiaChiNhanHang(txtDiaChi.getText());
						mh.setTongCong(Double.parseDouble(txtTongTien.getText()));
						mhm.AddMuaHang(mh);
						ViewSanPhamModel spm = new ViewSanPhamModel();
						for(ViewSanPham s : SanPhamMua)
						{
							ViewSanPham sp = spm.GetViewSanPhamByIdSanPham(s.getMaSanPham());
							ChiTietMuaHangModel ctm = new ChiTietMuaHangModel();
							ChiTietMuaHang ct = new ChiTietMuaHang();
							ct.setMaChiTietMuaHang(ctm.TaoIdCTMuaHang());
							ct.setMaMuaHang(mh.getMaMuaHang());
							ct.setMaSanPham(s.getMaSanPham());
							ct.setSoLuong(s.getSoLuong());
							ct.setDonGia(sp.getGiaBan());
							ctm.AddChiTietMuaHang(ct);
							
							
						}
			 			JOptionPane.showMessageDialog(null,"Mua hàng thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
			 			dispose();
			 			TrangChu tc;
						try {
							tc = new TrangChu();
							tc.ShowWinDow();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			 			
						
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
		 			JOptionPane.showMessageDialog(null,"Thông tin không hợp lệ","Thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
	private void LoadForm() throws SQLException
	{
		double tt = 0;
		ViewSanPhamModel spm = new ViewSanPhamModel();
		DefaultTableModel Table = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		Table.addColumn("STT");
		Table.addColumn("Tên sản phẩm");
		Table.addColumn("Tên nhà sản xuất");
		Table.addColumn("Tên phân loại");
		Table.addColumn("Số lượng");
		Table.addColumn("Giá bán");
		Table.addColumn("Hình ảnh");
		int i=0;
		for(ViewSanPham sp : SanPhamMua)
		{
			++i;
			DecimalFormat formatter = new DecimalFormat("0");
			ViewSanPham s = spm.GetViewSanPhamByIdSanPham(sp.getMaSanPham());
			Table.addRow(new Object[]
					{
							i,
							s.getTenSanPham(),
							s.getTenNhaSanXuat(),
							s.getTenPhanLoai(),
							sp.getSoLuong(),
							formatter.format(s.getGiaBan()),
							s.getHinhAnh()
					});
			tt += s.getGiaBan()*sp.getSoLuong();
		}
		table.setModel(Table);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(50);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(6).setCellRenderer(new ImageRender());
		txtTongTien.setText(tt+"");
		
	}
	private class ImageRender extends DefaultTableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			byte[]bytes = (byte[])value;
			ImageIcon imageIcon = new ImageIcon(bytes);
			setIcon(imageIcon);
			return this;
		}
		
	}
	public void ShowWinDow()
	{
		
		this.setVisible(true);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		
	}
}
