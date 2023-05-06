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
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class TrangChu extends JFrame {
	private JTable table;
	private DefaultTableModel Table;
	private JPanel panelTrangChu;
    private JButton btnTrangCh;
    private JTextField textField;
	public TrangChu() throws SQLException, IOException {
		getContentPane().setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 179, 457);
		panelMenu.setBackground(new Color(121, 218, 255));
		getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(10, 5, 159, 110);
		panelMenu.add(panelLogo);
		panelLogo.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-online-store-100.png"));
		lblNewLabel_2.setBounds(31, 10, 97, 95);
		panelLogo.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("  Hóa Đơn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HoaDon hd;
				try {
					hd = new HoaDon();
					hd.ShowWinDow();
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-paid-bill-20.png"));
		btnNewButton.setBounds(10, 231, 159, 39);
		panelMenu.add(btnNewButton);
		
		JPanel panelTrangChu = new JPanel();
		panelTrangChu.setBounds(189, 0, 649, 457);
		panelTrangChu.setBackground(new Color(155, 255, 255));
		getContentPane().add(panelTrangChu);
		panelTrangChu.setLayout(null);
		
		
		JButton btnTrangCh = new JButton("Mua Hàng ");
		btnTrangCh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MuaHang mh;
				try {
					mh = new MuaHang();
					mh.ShowWinDow();
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		});
		btnTrangCh.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrangCh.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-buy-25.png"));
		btnTrangCh.setBounds(10, 133, 159, 39);
		panelMenu.add(btnTrangCh);
		
		JButton btnSnPhm = new JButton("Sản Phẩm");
		btnSnPhm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sanpham sp;
				try {
					sp = new Sanpham();
					sp.ShowWinDow();
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		});
		btnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSnPhm.setHorizontalAlignment(SwingConstants.LEFT);
		btnSnPhm.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-iphone-se-50.png"));
		btnSnPhm.setBounds(10, 182, 159, 39);
		panelMenu.add(btnSnPhm);
		
		JButton btnNewButton_5 = new JButton("Khách Hàng");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				KhachHang kh;
				try {
					kh = new KhachHang();
					kh.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-customer-20.png"));
		btnNewButton_5.setBounds(10, 280, 159, 39);
		panelMenu.add(btnNewButton_5);
		
		JButton btnTrangCh_1 = new JButton("Phân Loại");
		btnTrangCh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PhanLoai pl;
				try {
					pl = new PhanLoai();
					pl.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrangCh_1.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-categorize-20.png"));
		btnTrangCh_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrangCh_1.setBounds(10, 329, 159, 39);
		panelMenu.add(btnTrangCh_1);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 629, 192);
		//getContentPane().add(scrollPane);
		
		
		panelTrangChu.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JComboBox cbbNhaSx = new JComboBox();
		cbbNhaSx.setBounds(10, 96, 119, 21);
		panelTrangChu.add(cbbNhaSx);
		
		JComboBox cbbPhanLoai = new JComboBox();
		cbbPhanLoai.setBounds(139, 96, 119, 21);
		panelTrangChu.add(cbbPhanLoai);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textField.setColumns(10);
		textField.setBounds(268, 97, 119, 19);
		panelTrangChu.add(textField);
		
		JButton btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-find-20.png"));
		btnTim.setBounds(413, 96, 37, 21);
		panelTrangChu.add(btnTim);
		
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
