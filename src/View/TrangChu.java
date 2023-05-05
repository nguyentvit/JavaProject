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
		lblNewLabel_1.setIcon(new ImageIcon("E:\\PBL3_MAIN\\Icons\\icons8-online-store-100.png"));
		panelLogo.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-online-store-100.png"));
		panelLogo.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("  Hóa Đơn");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setIcon(new ImageIcon("E:\\PBL3_MAIN\\Icons\\icons8-paid-bill-20.png"));
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
		btnTrangCh.setIcon(new ImageIcon("E:\\PBL3_MAIN\\Icons\\icons8-home-30.png"));
		btnTrangCh.setBounds(10, 139, 159, 39);
		panelMenu.add(btnTrangCh);
		
		JButton btnSnPhm = new JButton("Sản Phẩm");
		btnSnPhm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSnPhm.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSnPhm.setHorizontalAlignment(SwingConstants.LEFT);
		btnSnPhm.setIcon(new ImageIcon("E:\\PBL3_MAIN\\Icons\\icons8-iphone-se-50.png"));
		btnSnPhm.setBounds(10, 188, 159, 39);
		panelMenu.add(btnSnPhm);
		
		JButton btnNewButton_5 = new JButton("Khách Hàng");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setIcon(new ImageIcon("E:\\PBL3_MAIN\\Icons\\icons8-customer-20.png"));
		btnNewButton_5.setBounds(10, 286, 159, 39);
		panelMenu.add(btnNewButton_5);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 629, 247);
		//getContentPane().add(scrollPane);
		
		
		panelTrangChu.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JButton btnThemSp = new JButton("Thêm sản phẩm");
		btnThemSp.setBounds(35, 31, 131, 23);
		panelTrangChu.add(btnThemSp);
		
		JButton btnSua = new JButton("Sửa ");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 int row = table.getSelectedRow();
						String id = (table.getModel().getValueAt(row, 0).toString());
						ThemSp thsp = new ThemSp();
						thsp.loadInfor(id);
						thsp.setVisible(true);
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
				
				
			}
		});
		btnSua.setBounds(229, 31, 89, 23);
		panelTrangChu.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa ");
		btnXoa.setBounds(391, 31, 89, 23);
		panelTrangChu.add(btnXoa);
		
		btnThemSp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					    ThemSp them = new ThemSp();
			            //TrangChu.this.setVisible(false);
					    //them.setLocationRelativeTo(null);
			            them.setSize(675,500);
			            them.setVisible(true);
			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			}
		});
		
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
