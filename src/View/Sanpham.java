package View;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DTO.ComboItem;
import DTO.ViewSanPham;
import Entities.NhaSanXuat;
import Entities.PhanLoai;
import Models.NhaSanXuatModel;
import Models.PhanLoaiModel;
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

public class Sanpham extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel Table;
	private JComboBox cbbPhanLoai, cbbNhaSx;
	private JTextField textField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sanpham frame = new Sanpham();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 */
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
		cbbNhaSx.setBounds(22, 32, 83, 21);
		panel.add(cbbNhaSx);
		
		 cbbPhanLoai = new JComboBox();
		cbbPhanLoai.setBounds(115, 32, 83, 21);
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
		btnTim.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-find-20.png"));
		btnTim.setBounds(301, 32, 37, 21);
		panel.add(btnTim);
		
		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-delete-20.png"));
		btnXoa.setBounds(567, 32, 37, 29);
		panel.add(btnXoa);
		
		JButton btnSua = new JButton("");
		btnSua.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-edit-20.png"));
		btnSua.setBounds(520, 32, 37, 29);
		panel.add(btnSua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 104, 629, 243);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTrV = new JButton("");
		btnTrV.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-back-20.png"));
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
		btnTrV.setBounds(614, 32, 37, 29);
		panel.add(btnTrV);
		
		textField = new JTextField();
		textField.setBounds(208, 33, 83, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnThem_1 = new JButton("");
		btnThem_1.addActionListener(new ActionListener() {
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
		btnThem_1.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-add-20.png"));
		btnThem_1.setBounds(473, 32, 37, 29);
		panel.add(btnThem_1);
		loadData(null);
		SetCbb();
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
								sp.getHinhAnh()
						});
			}
		}
		else {
			String idPhanLoai = ((ComboItem)(cbbPhanLoai.getSelectedItem())).getKey();
			String idNhaSx = ((ComboItem)(cbbNhaSx.getSelectedItem())).getKey();
			for(ViewSanPham sp : Viewsp.GetViewSanPhamByTimKiem(idPhanLoai,idNhaSx))
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
		}
		table.setModel(Table);
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
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		
	}
}
