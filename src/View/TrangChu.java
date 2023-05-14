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
import java.awt.Panel;
import java.awt.Button;
import javax.swing.Icon;
import javax.swing.BorderFactory;

public class TrangChu extends JFrame {
	private JTable table;
	private DefaultTableModel Table;
	private JPanel panelTrangChu;
    private JButton btnTrangCh;
    private JTextField txtTim;
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
		lblNewLabel_2.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-online-store-100.png"));
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
		btnNewButton.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-paid-bill-20.png"));
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
				Muahang mh;
				try {
					mh = new Muahang();
					mh.ShowWinDow();
				} catch (Exception ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				
			}
		});
		btnTrangCh.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrangCh.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-buy-25.png"));
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
		btnSnPhm.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-buy-25.png"));
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
		btnNewButton_5.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-customer-20.png"));
		btnNewButton_5.setBounds(10, 280, 159, 39);
		panelMenu.add(btnNewButton_5);
		
		JButton btnTrangCh_1 = new JButton("Phân Loại");
		btnTrangCh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				NhapKho pl;
				try {
					pl = new NhapKho();
					pl.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrangCh_1.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-categorize-20.png"));
		btnTrangCh_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTrangCh_1.setBounds(10, 329, 159, 39);
		panelMenu.add(btnTrangCh_1);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 135, 365, 295);
		//getContentPane().add(scrollPane);
		
		
		panelTrangChu.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTim.setColumns(10);
		txtTim.setBounds(426, 98, 119, 19);
		panelTrangChu.add(txtTim);
		
		JButton btnTim = new JButton("");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTim.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-find-20.png"));
		btnTim.setBounds(567, 96, 37, 21);
		panelTrangChu.add(btnTim);
		
		JLabel lblQuanrLysCuawr = new JLabel(" CỬA HÀNG ĐIỆN THOẠI 2GB");
		lblQuanrLysCuawr.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblQuanrLysCuawr.setBounds(162, 31, 306, 45);
		panelTrangChu.add(lblQuanrLysCuawr);
		
		JLabel picture = new JLabel(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\thiet-ke-cua-hang-dien-thoai-nho-15.jpg"));
		picture.setVerticalAlignment(SwingConstants.CENTER);
		picture.setHorizontalAlignment(SwingConstants.CENTER);
		picture.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		picture.setBounds(391, 131, 232, 299);
		panelTrangChu.add(picture);
		
		JLabel lblQuanrLysCuawr_1 = new JLabel("DANH SÁCH MẶT HÀNG BÀY BÁN:");
		lblQuanrLysCuawr_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuanrLysCuawr_1.setBounds(20, 98, 248, 45);
		panelTrangChu.add(lblQuanrLysCuawr_1);
	
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
			if(sp.getTenSanPham().contains(txtTim.getText()) && sp.getTrangThai() == true) {
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
								sp.getHinhAnh(),
								sp.getTrangThai()
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
			table.setRowHeight(35);
			table.getTableHeader().setReorderingAllowed(false);
			table.getColumnModel().getColumn(8).setCellRenderer(new ImageRender());
		}
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
