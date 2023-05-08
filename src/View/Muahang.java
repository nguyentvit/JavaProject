package View;

import java.awt.Component;
import java.awt.Image;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import DTO.ViewSanPham;
import Models.ViewSanPhamModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import View.ThemSp;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Muahang extends JFrame {
	private JTable table, table1;
	private JPanel contentPane;
	private DefaultTableModel Table, Table1;
	private JButton btnThem,btnTrV,btnNewButton_2,btnXoa;

	public Muahang()  throws SQLException, IOException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(199, 243, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHỌN SẢN PHẨM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(298, 10, 120, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane tableThem = new JScrollPane();
		tableThem.setBounds(90, 50, 556, 140);
		contentPane.add(tableThem);
		table = new JTable();
		tableThem.setViewportView(table);
		
		table1 = new JTable();
		JScrollPane tableXoa = new JScrollPane();
		tableXoa.setBounds(90, 219, 556, 110);
		contentPane.add(tableXoa);
		tableXoa.setViewportView(table1);
		
		 btnThem = new JButton("");
		
		btnThem.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-buy-25.png"));
		btnThem.setBounds(16, 75, 57, 33);
		contentPane.add(btnThem);
		
		 btnXoa = new JButton("");
		
		btnXoa.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-delete-25.png"));
		btnXoa.setBounds(23, 242, 48, 30);
		contentPane.add(btnXoa);
		btnNewButton_2 = new JButton("Xác nhận\r\n");
		btnNewButton_2.setBackground(new Color(255, 127, 80));
		btnNewButton_2.setBounds(306, 346, 112, 21);
		contentPane.add(btnNewButton_2);
		
		btnTrV = new JButton("");
		btnTrV.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-back-20.png"));
		btnTrV.setBounds(609, 16, 37, 29);
		contentPane.add(btnTrV);
		loadData();
		AddControl();
	}
	private void AddControl()
	{
		ViewSanPhamModel spm = new ViewSanPhamModel();
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = table.getSelectedRow();
				String id = table.getModel().getValueAt(value, 1).toString();
				int sl = Integer.parseInt(table.getModel().getValueAt(value,5).toString());
				if(sl == 1)
				{
					((DefaultTableModel)table.getModel()).removeRow(value);
				}
				else {
					
					table.getModel().setValueAt(--sl, value, 5);
				}
				DefaultTableModel model = (DefaultTableModel)table1.getModel();
				try {
					boolean status = false;
					DecimalFormat formatter = new DecimalFormat("0");
					for(int i=0;i<model.getRowCount();i++)
					{
						if(model.getValueAt(i, 1).toString().equals(id)) {
							status = true;
						}
					}
					if(!status)
					{
						ViewSanPham sp = spm.GetViewSanPhamByIdSanPham(id);
						model.addRow(new Object[]
								{
										sp.getStt(),
										sp.getMaSanPham(),
										sp.getTenSanPham(),
										sp.getTenNhaSanXuat(),
										sp.getTenPhanLoai(),
										1,
										formatter.format(sp.getGiaNhap()),
										formatter.format(sp.getGiaBan()),
										sp.getHinhAnh()
								});
					}
					else {
						for(int i=0;i<model.getRowCount();i++)
						{
							if(model.getValueAt(i, 1).toString().equals(id))
							{
								int sl1 = Integer.parseInt(model.getValueAt(i, 5).toString());
								model.setValueAt(++sl1,i, 5);
							}
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int value = table1.getSelectedRow();
				String id = table1.getModel().getValueAt(value, 1).toString();
				
				int sl = Integer.parseInt(table1.getModel().getValueAt(value,5).toString());
				if(sl == 1)
				{
					((DefaultTableModel)table1.getModel()).removeRow(value);
				}
				else {
					
					table1.getModel().setValueAt(--sl, value, 5);
				}
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				try {
					boolean status = false;
					DecimalFormat formatter = new DecimalFormat("0");
					for(int i=0;i<model.getRowCount();i++)
					{
						if(model.getValueAt(i, 1).toString().equals(id)) {
							status = true;
						}
					}
					if(!status)
					{
						ViewSanPham sp = spm.GetViewSanPhamByIdSanPham(id);
						model.addRow(new Object[]
								{
										sp.getStt(),
										sp.getMaSanPham(),
										sp.getTenSanPham(),
										sp.getTenNhaSanXuat(),
										sp.getTenPhanLoai(),
										1,
										formatter.format(sp.getGiaNhap()),
										formatter.format(sp.getGiaBan()),
										sp.getHinhAnh()
								});
					}
					else {
						for(int i=0;i<model.getRowCount();i++)
						{
							if(model.getValueAt(i, 1).toString().equals(id))
							{
								int sl1 = Integer.parseInt(model.getValueAt(i, 5).toString());
								model.setValueAt(++sl1,i, 5);
							}
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ViewSanPham>list = new ArrayList<ViewSanPham>();
				for(int i=0;i<table1.getModel().getRowCount();i++)
				{
					ViewSanPham sp = new ViewSanPham();
					sp.setMaSanPham(table1.getModel().getValueAt(i, 1).toString());
					sp.setSoLuong(Integer.parseInt(table1.getModel().getValueAt(i, 5).toString()));
					list.add(sp);
				}
				dispose();
				ChiTietHoaDon tc;
				try {
					tc = new ChiTietHoaDon(list);
					tc.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	private void loadData() throws SQLException, IOException
	{
		ViewSanPhamModel Viewsp = new ViewSanPhamModel();
		Table = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		
		Table1 = new DefaultTableModel() {

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
		Table.addColumn("Hình ảnh");
		
		Table1.addColumn("STT");
		Table1.addColumn("Mã sản phẩm");
		Table1.addColumn("Tên sản phẩm");
		Table1.addColumn("Tên nhà sản xuất");
		Table1.addColumn("Tên phân loại");
		Table1.addColumn("Số lượng");
		Table1.addColumn("Giá nhập");
		Table1.addColumn("Giá bán");
		Table1.addColumn("Hình ảnh");
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
							sp.getHinhAnh()
					});
		}
		table.setModel(Table);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(0);
				
		
		table.getColumnModel().getColumn(6).setMinWidth(0);
		table.getColumnModel().getColumn(6).setMaxWidth(0);
		

		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(50);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(8).setCellRenderer(new ImageRender());
		
		table1.setModel(Table1);
		table1.getColumnModel().getColumn(1).setMinWidth(0);
		table1.getColumnModel().getColumn(1).setMaxWidth(0);
				
		
		table1.getColumnModel().getColumn(6).setMinWidth(0);
		table1.getColumnModel().getColumn(6).setMaxWidth(0);
		

		table1.getTableHeader().setReorderingAllowed(false);
		table1.setRowHeight(50);
		table1.getTableHeader().setReorderingAllowed(false);
		table1.getColumnModel().getColumn(8).setCellRenderer(new ImageRender());
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
	public void ShowWinDow() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		this.setSize(730, 500);
		this.setLocationRelativeTo(null);
	}
}
