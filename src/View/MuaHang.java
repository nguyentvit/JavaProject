package View;

import java.awt.Component;
import java.awt.Image;
import java.awt.Label;
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

public class MuaHang extends JFrame {
	private JTable table;
	private JPanel contentPane;
	private DefaultTableModel Table;
	public MuaHang()  throws SQLException, IOException{
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
		
		JScrollPane tableXoa = new JScrollPane();
		tableXoa.setBounds(90, 219, 556, 110);
		contentPane.add(tableXoa);
		
		JButton btnThem = new JButton("");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnThem.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-buy-25.png"));
		btnThem.setBounds(16, 75, 57, 33);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-delete-25.png"));
		btnXoa.setBounds(23, 242, 48, 30);
		contentPane.add(btnXoa);
		
		JButton btnNewButton_2 = new JButton("Xác nhận\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ChiTietHoaDon tc;
				try {
					tc = new ChiTietHoaDon();
					tc.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBackground(new Color(255, 127, 80));
		btnNewButton_2.setBounds(306, 346, 112, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnTrV = new JButton("");
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
		
		btnTrV.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-back-20.png"));
		btnTrV.setBounds(609, 16, 37, 29);
		contentPane.add(btnTrV);
		loadData();
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
			JLabel lbl1 = new JLabel();
			JLabel lbl;
			ImageIcon image1;
			DecimalFormat formatter = new DecimalFormat("0");
			if(sp.HinhAnh!= null)
			{
				
				ByteArrayInputStream bais = new ByteArrayInputStream(sp.HinhAnh);
				BufferedImage image = ImageIO.read(bais);
				ImageIcon scaledIcon = new ImageIcon(image);
				lbl = new JLabel(scaledIcon);
				lbl1 = lbl;
				image1 = scaledIcon;
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
							sp.getHinhAnh()
					});
		}
		table.setModel(Table);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(0);
		
		table.getColumnModel().getColumn(5).setMinWidth(0);
		table.getColumnModel().getColumn(5).setMaxWidth(0);
		
		table.getColumnModel().getColumn(6).setMinWidth(0);
		table.getColumnModel().getColumn(6).setMaxWidth(0);
		

		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(50);
		table.getTableHeader().setReorderingAllowed(false);
		table.getColumnModel().getColumn(8).setCellRenderer(new ImageRender());
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
