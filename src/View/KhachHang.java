package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entities.Nguoi;
import Models.NguoiModel;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;

public class KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField txtTim;
	private JTable table;
	private DefaultTableModel Table;
	public KhachHang() throws SQLException, IOException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 470);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 234, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTim = new JButton("");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loadData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTim.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-find-20.png"));
		btnTim.setBounds(295, 119, 37, 29);
		contentPane.add(btnTim);
		
		JButton btnSua = new JButton("");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
					try {
						int selectedRow = table.getSelectedRow();
						if (selectedRow != -1) { // kiểm tra xem đã chọn hàng nào chưa
						    String id = table.getValueAt(selectedRow, 1).toString(); // lấy giá trị mã khách hàng từ cột 1 (cột thứ 2)
						    SuaKH sua;
						sua = new SuaKH(id);
						 sua.ShowWinDow();
					}} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // truyền giá trị mã khách hàng qua form sửa
				   
				
			}
		});
		btnSua.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-edit-20.png"));
		btnSua.setBounds(582, 119, 50, 29);
		contentPane.add(btnSua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 179, 599, 231);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTim.setBounds(104, 124, 146, 24);
		contentPane.add(txtTim);
		txtTim.setColumns(10);
		
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
		btnTrV.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-back-20.png"));
		btnTrV.setBounds(24, 24, 50, 35);
		contentPane.add(btnTrV);
		
		JLabel lblDanhSchKhch = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblDanhSchKhch.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDanhSchKhch.setBounds(253, 54, 265, 29);
		contentPane.add(lblDanhSchKhch);
		loadData();
	}
	private void loadData() throws SQLException
	{
		Table = new DefaultTableModel()
				{
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
				};
				Table.addColumn("Stt");
				Table.addColumn("Mã KH");
				Table.addColumn("Tên KH");
				Table.addColumn("SDT");
				//Table.addColumn("Địa chỉ nhận hàng");
				NguoiModel nguoi = new NguoiModel();
				int i = 1;
				
				if(txtTim.getText()=="") {
					for (Nguoi Ng : nguoi.GetAllNguoi())
					{
						Table.addRow(new Object[]
						{
							i++,
							Ng.getMaNguoi(),
							Ng.getTenNguoi(),
							Ng.getSdt()
							
						}
						);
					}
				}
				else {
					for (Nguoi Ng : nguoi.SearchNguoi(txtTim.getText()))
					{
						Table.addRow(new Object[]
						{
							i++,
							Ng.getMaNguoi(),
							Ng.getTenNguoi(),
							Ng.getSdt()
							
						}
						);
					}
				}
				table.setModel(Table);
				table.getColumnModel().getColumn(1).setMinWidth(0);
				table.getColumnModel().getColumn(1).setMaxWidth(0);

				table.getTableHeader().setReorderingAllowed(false);
				table.setRowHeight(35);
				table.getTableHeader().setReorderingAllowed(false);
				
				
				
	}
	public void ShowWinDow() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		this.setSize(730, 500);
		this.setLocationRelativeTo(null);
	}
}
