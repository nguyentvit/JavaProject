package View;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DTO.ComboItem;
import DTO.ViewSanPham;
import Entities.NhaSanXuat;
import Entities.PhanLoai;
import Entities.SanPham;
import Models.NhaSanXuatModel;
import Models.PhanLoaiModel;
import Models.SanPhamModel;
import Models.ViewSanPhamModel;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class Sanpham extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel Table;
	private JComboBox cbbPhanLoai, cbbNhaSx;
	private JTextField textField;

	public Sanpham() throws SQLException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 255, 255));
		panel.setBounds(0, 0, 677, 447);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 cbbNhaSx = new JComboBox();
		 cbbNhaSx.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbNhaSx.setBounds(57, 60, 98, 21);
		panel.add(cbbNhaSx);
		
		 cbbPhanLoai = new JComboBox();
		 cbbPhanLoai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbPhanLoai.setBounds(165, 60, 98, 21);
		panel.add(cbbPhanLoai);

		JButton btnTim = new JButton("");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadData("");
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTim.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-find-20.png"));
		btnTim.setBounds(370, 60, 37, 21);
		panel.add(btnTim);
		//XÓA KHỎI DANH SÁCH BÁN
		JButton btnXoa = new JButton("");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) { // kiểm tra xem đã chọn hàng nào chưa
					    String id = table.getValueAt(selectedRow, 1).toString(); // lấy giá trị mã khách hàng từ cột 1 (cột thứ 2)
					    
					    SanPhamModel sp = new SanPhamModel();
						SanPham sanPham = sp.GetSanPhamByIdSanPham(id);
						sp.SuaTrangThai(sanPham);
					    if(sanPham.getTrangThai() == false) {
					    	int choice = JOptionPane.showConfirmDialog(null, "Đã thêm sản phẩm vào mặt hàng bày bán.", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
					 
								try {
									loadData("");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					    }
					    else {
					    	int choice = JOptionPane.showConfirmDialog(null, "Đã xóa sản phẩm khỏi mặt hàng bày bán.", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
					    
								try {
									loadData("");
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					    }
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // truyền giá trị mã khách hàng qua form sửa
			}
		});
		btnXoa.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-delete-20.png"));
		btnXoa.setBounds(602, 21, 37, 29);
		panel.add(btnXoa);
		
		JButton btnSua = new JButton("");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int selectedRow = table.getSelectedRow();
					if (selectedRow != -1) { // kiểm tra xem đã chọn hàng nào chưa
					    String id = table.getValueAt(selectedRow, 1).toString(); // lấy giá trị mã khách hàng từ cột 1 (cột thứ 2)
					    SuaSP sua;
					sua = new SuaSP(id);
					 sua.ShowWinDow();
				}} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // truyền giá trị mã khách hàng qua form sửa
			}
		});
		btnSua.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-edit-20.png"));
		btnSua.setBounds(555, 21, 37, 29);
		panel.add(btnSua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 104, 629, 321);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTrV = new JButton("");
		btnTrV.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-back-20.png"));
		btnTrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TrangChu tc;
				try {
					tc = new TrangChu();
					tc.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnTrV.setBounds(22, 21, 37, 29);
		panel.add(btnTrV);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(273, 61, 83, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnThemSP = new JButton("");
		btnThemSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ThemSp t;
				try {
					t = new ThemSp();
					t.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnThemSP.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-buy-25.png"));
		btnThemSP.setBounds(508, 21, 37, 29);
		panel.add(btnThemSP);
		
		JButton btnThemSL = new JButton("");
		btnThemSL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) { // kiểm tra xem đã chọn hàng nào chưa
				    String id = table.getValueAt(selectedRow, 1).toString(); // lấy giá trị mã khách hàng từ cột 1 (cột thứ 2)
				    ThemSL them;
				try {
					them = new ThemSL(id);
					them.ShowWinDow();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
}
				
			}
		});
		btnThemSL.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-add-20.png"));
		btnThemSL.setBounds(461, 21, 37, 29);
		panel.add(btnThemSL);
		loadData(null);
		SetCbb();
	}
	protected void showWindow() {
		// TODO Auto-generated method stub
		
		
	}
	private void SetCbb() throws SQLException
	{
		PhanLoaiModel pl = new PhanLoaiModel();
		cbbPhanLoai.addItem(new ComboItem("-1","All"));
		cbbNhaSx.addItem(new ComboItem("-1","All"));
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
	private void loadData(String txt) throws SQLException, IOException
	{
		table.removeAll();
		ViewSanPhamModel Viewsp = new ViewSanPhamModel();
		Table = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		Table.addColumn("STT");
		Table.addColumn("Mã sản phẩm");
		Table.addColumn("Tên sản phẩm");
		Table.addColumn("Tên nhà sản xuất");
		Table.addColumn("Tên phân loại");
		Table.addColumn("Số lượng");
		Table.addColumn("Giá nhập");
		Table.addColumn("Giá bán");
		Table.addColumn("Trạng thái");
		Table.addColumn("Hình ảnh");
		if(txt == null)
		{
			
			for(ViewSanPham sp : Viewsp.GetAllViewSanPham())
			{
				DecimalFormat formatter = new DecimalFormat("0");
				Table.addRow(new Object[]
						{
								sp.getStt(),
								sp.getMaSanPham(),
								sp.getTenSanPham(),
								sp.getTenNhaSanXuat(),
								sp.getTenPhanLoai(),
								sp.getSoLuong(),
								formatter.format(sp.getGiaNhap()),
								formatter.format(sp.getGiaBan()),
								sp.getTrangThai(),
								sp.getHinhAnh()
						});
			}
		}
		else {
			String idPhanLoai = ((ComboItem)(cbbPhanLoai.getSelectedItem())).getKey();
			String idNhaSx = ((ComboItem)(cbbNhaSx.getSelectedItem())).getKey();
			for(ViewSanPham sp : Viewsp.GetViewSanPhamByTimKiem(idPhanLoai,idNhaSx,textField.getText().toString()))
			
			{
				DecimalFormat formatter = new DecimalFormat("0");
				Table.addRow(new Object[]
						{
								sp.getStt(),
								sp.getMaSanPham(),
								sp.getTenSanPham(),
								sp.getTenNhaSanXuat(),
								sp.getTenPhanLoai(),
								sp.getSoLuong(),
								formatter.format(sp.getGiaNhap()),
								formatter.format(sp.getGiaBan()),
								sp.getTrangThai(),
								sp.getHinhAnh()
						});
			}
		}
		table.setModel(Table);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(50);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(9).setCellRenderer(new ImageRender());
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
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		
	}
}
