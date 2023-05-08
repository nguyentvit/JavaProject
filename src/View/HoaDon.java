package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DTO.ViewHoaDon;
import DTO.ViewSanPham;
import Entities.ChiTietMuaHang;
import Models.ChiTietMuaHangModel;
import Models.ViewHoaDonModel;
import Models.ViewSanPhamModel;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class HoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private DefaultTableModel Table;

	public HoaDon() throws SQLException, IOException, ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 376);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(182, 239, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(258, 10, 142, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-delete-20.png"));
		btnXoa.setBounds(554, 63, 37, 29);
		contentPane.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 117, 607, 197);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-find-20.png"));
		btnTim.setBounds(142, 63, 37, 29);
		contentPane.add(btnTim);
		
		textField = new JTextField();
		textField.setBounds(31, 63, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
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
		btnTrV.setBounds(601, 63, 37, 29);
		contentPane.add(btnTrV);
		loadData();
	}
	private void loadData() throws SQLException, IOException, ParseException
	{
		
		Table = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		Table.addColumn("STT");
		Table.addColumn("Mã MH");
		Table.addColumn("Tên Khách Hàng");
		Table.addColumn("Sdt");
		Table.addColumn("Địa chỉ nhận hàng");
		Table.addColumn("Tổng tiền");
	//	Table.addColumn("Thời gian mua");
        ViewHoaDonModel viewhd = new ViewHoaDonModel();
        for (ViewHoaDon hd : viewhd.getAllViewHoaDon())
        {
        	Table.addRow(new Object[]
        			{
        				hd.getStt(),
        				hd.getMaMuaHang(),
        				hd.getTenKH(),
        				hd.getSdt(),
        				hd.getDiachi(),
        				hd.getTongtien()
        				
        			}
        	);
        }
		
		
		
		table.setModel(Table);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(0);
		

		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(50);
		table.getTableHeader().setReorderingAllowed(false);
		
	}
	
	public void ShowWinDow()
	{
		this.setVisible(true);
		this.setSize(847, 488);
		this.setLocationRelativeTo(null);
		
	}
}
