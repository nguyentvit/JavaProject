package View;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DTO.ViewSanPham;
import Models.ViewSanPhamModel;
import javax.swing.JButton;

public class TrangChu extends JFrame {
	private JTable table;
	private DefaultTableModel Table;
	public TrangChu() throws SQLException, IOException {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 304, 866, 247);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnThemSp = new JButton("Thêm sản phẩm");
		btnThemSp.setBounds(62, 11, 131, 23);
		getContentPane().add(btnThemSp);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(334, 11, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(456, 11, 89, 23);
		getContentPane().add(btnNewButton_2);
		loadData();
	}
	private void loadData() throws SQLException
	{
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
		Table.addColumn("Hình ảnh");
		
		
		for(ViewSanPham sp : Viewsp.GetAllViewSanPham())
		{
			DecimalFormat formatter = new DecimalFormat("0");
			BufferedImage hinhAnh = null;
			if(sp.getHinhAnh() != null)
			{
				try {
					
					ByteArrayInputStream bis = new ByteArrayInputStream(sp.getHinhAnh());
					hinhAnh = ImageIO.read(bis);
					bis.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
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
							hinhAnh
					});
		}
		table.setModel(Table);
		table.getTableHeader().setReorderingAllowed(false);
		
		table.setRowHeight(50);
	}
	
	public void ShowWinDow()
	{
		
		this.setVisible(true);
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		
	}
}
