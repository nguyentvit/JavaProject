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
import Entities.Nguoi;
import Entities.SanPham;
import Models.ChiTietMuaHangModel;
import Models.SanPhamModel;
import Models.ViewHoaDonModel;
import Models.ViewSanPhamModel;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.util.List;
import java.awt.event.ActionEvent;

public class HoaDon extends JFrame {
	List<ChiTietMuaHang> ctmh;
	private JPanel contentPane;
	private JTextField txtTim;
	private JTable table;
	private DefaultTableModel Table;

	public HoaDon() throws SQLException, IOException, ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(182, 239, 248));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(320, 52, 239, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnXoa = new JButton("Xem chi tiết");
		btnXoa.addActionListener(new ActionListener() {//Xem chi tiet
			public void actionPerformed(ActionEvent e) {
				
				try {
					int selectedRow = table.getSelectedRow();
						if (selectedRow != -1) { // kiểm tra xem đã chọn hàng nào chưa
						    String id = table.getValueAt(selectedRow, 1).toString(); // lấy giá trị mã khách hàng từ cột 1 (cột thứ 2)
						    
							ChiTietMuaHangModel ctmhModel = new ChiTietMuaHangModel();
							ctmh = ctmhModel.GetAllCTByMaMH(id);
					    }
					
					try {
						loadData("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // truyền giá trị mã khách hàng qua form sửa
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		btnXoa.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-paid-bill-20.png"));
		btnXoa.setBounds(594, 121, 126, 29);
		contentPane.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 178, 648, 197);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnTim = new JButton("");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					loadData(null);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnTim.setIcon(new ImageIcon("D:\\java\\JavaDUAN\\JavaProject\\icons\\icons8-find-20.png"));
		btnTim.setBounds(246, 121, 46, 29);
		contentPane.add(btnTim);
		
		txtTim = new JTextField();
		txtTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTim.setBounds(107, 121, 126, 25);
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
		btnTrV.setBounds(31, 23, 46, 36);
		contentPane.add(btnTrV);
		loadData(null);
	}
	private void loadData(String maMH) throws SQLException, IOException, ParseException
	{
		
		Table = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		
    	if(maMH == null) {
    		Table.addColumn("STT");
    		Table.addColumn("Mã MH");
    		Table.addColumn("Tên khách hàng");
    		Table.addColumn("Sdt");
    		Table.addColumn("Địa chỉ nhận hàng");
    		Table.addColumn("Tổng tiền");
    	//	Table.addColumn("Thời gian mua");
            ViewHoaDonModel viewhd = new ViewHoaDonModel();
            
    		
			for (ViewHoaDon hd : viewhd.getAllViewHoaDon())
            {
				if(txtTim.getText() == "") {
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
				else {
					if(hd.getTenKH().contains(txtTim.getText()) || hd.getSdt().contains(txtTim.getText())) {
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
				}
    		}
    		
        	
        }
    	else {
    		Table.addColumn("Mã chi tiết");
    		Table.addColumn("Tên sản phẩm");
    		
    		Table.addColumn("Số lượng");
    		Table.addColumn("Đơn giá");
    	//	Table.addColumn("Thời gian mua");
            ViewHoaDonModel viewhd = new ViewHoaDonModel();
            SanPhamModel spm = new SanPhamModel();
            
    		for (ChiTietMuaHang ct : ctmh)
            {
    			SanPham sp = spm.GetSanPhamByIdSanPham(ct.getMaSanPham());
        		Table.addRow(new Object[]
            			{
            				ct.getMaChiTietMuaHang(),
            				sp.getTenSanPham(),
            				ct.getSoLuong(),
            				ct.getDonGia(),
            				
            			}
            	);
        	}
    	}
		
		
		
		table.setModel(Table);
//		table.getColumnModel().getColumn(0).setMinWidth(40);
//		table.getColumnModel().getColumn(0).setMaxWidth(40);
		

		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(40);
		table.getTableHeader().setReorderingAllowed(false);
		
	}
	
	public void ShowWinDow()
	{
		this.setVisible(true);
		this.setSize(847, 488);
		this.setLocationRelativeTo(null);
		
	}
}
