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

public class TrangChu extends JFrame {
	private JTable table;
	private DefaultTableModel Table;
	private JPanel panelTrangChu;
    private JButton btnTrangCh;
	public TrangChu() throws SQLException, IOException {
		getContentPane().setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(121, 218, 255));
		panelMenu.setBounds(0, 0, 179, 457);
		getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(10, 5, 159, 110);
		panelMenu.add(panelLogo);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QuanLyDienThoai\\JavaProject\\icons\\icons8-online-store-100.png"));
		panelLogo.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QuanLyDienThoai\\JavaProject\\icons\\icons8-online-store-100.png"));
		panelLogo.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("  Hóa Đơn");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QuanLyDienThoai\\JavaProject\\icons\\icons8-paid-bill-20.png"));
		btnNewButton.setBounds(10, 237, 159, 39);
		panelMenu.add(btnNewButton);
		
		JPanel panelTrangChu = new JPanel();
		panelTrangChu.setBackground(new Color(155, 255, 255));
		panelTrangChu.setBounds(189, 0, 649, 457);
		getContentPane().add(panelTrangChu);
		panelTrangChu.setLayout(null);
		
		
		JButton btnTrangCh = new JButton("  Trang Chủ ");
		btnTrangCh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 ThemSp them = new ThemSp();
					 JPanel themPanel = new JPanel();
					 themPanel.add(them.getContentPane());
					 panelTrangChu.add(themPanel);
//					
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
				
			}
		});
		btnTrangCh.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrangCh.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QuanLyDienThoai\\JavaProject\\icons\\icons8-home-30.png"));
		btnTrangCh.setBounds(10, 139, 159, 39);
		panelMenu.add(btnTrangCh);
		
		JButton btnSnPhm = new JButton("Sản Phẩm");
		btnSnPhm.addActionListener(new ActionListener() {
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
		btnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSnPhm.setHorizontalAlignment(SwingConstants.LEFT);
		btnSnPhm.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QuanLyDienThoai\\JavaProject\\icons\\icons8-iphone-se-50.png"));
		btnSnPhm.setBounds(10, 188, 159, 39);
		panelMenu.add(btnSnPhm);
		
		JButton btnNewButton_5 = new JButton("Khách Hàng");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\QuanLyDienThoai\\JavaProject\\icons\\icons8-customer-20.png"));
		btnNewButton_5.setBounds(10, 286, 159, 39);
		panelMenu.add(btnNewButton_5);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 629, 247);
		//getContentPane().add(scrollPane);
		
		
		panelTrangChu.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
	public void ShowWinDow()
	{
		
		this.setVisible(true);
		this.setSize(847, 488);
		this.setLocationRelativeTo(null);
		
	}
}
