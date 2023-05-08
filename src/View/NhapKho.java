package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.ComboItem;
import Entities.NhaSanXuat;
import Entities.PhanLoai;
import Models.NhaSanXuatModel;
import Models.PhanLoaiModel;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class NhapKho extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JComboBox cbbChon;
	private JButton btnHuy, btnLuu;

	public NhapKho()throws SQLException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(199, 243, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//		
//		JComboBox cbbChon = new JComboBox(new Object[]
//				{
//						"Nhà Sản Xuất", "Phân loại SP"
//				});
//	
		cbbChon = new JComboBox();
		cbbChon.setModel(new DefaultComboBoxModel(new String[] {"Nhà Sản Xuất", "Phân Loại SP"}));
		cbbChon.setBounds(136, 47, 136, 21);
		contentPane.add(cbbChon);
//		//cbbChon.setModel(new DefaultComboBoxModel(new String[] {"Nhà Sản Xuất", "Phân Loại SP"}));
//		cbbChon.setBounds(136, 47, 136, 21);
//		contentPane.add(cbbChon);
//		
		JLabel lblNewLabel = new JLabel("Thêm mới");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(43, 51, 73, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(42, 91, 45, 13);
		contentPane.add(lblNewLabel_1);
		SetCbb();
		
		txtTen = new JTextField();
		txtTen.setBounds(136, 88, 136, 19);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		JButton btnLuu = new JButton("");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					btnXacNhan1_actionPerformed(e);
				}catch (SQLException | IOException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnLuu.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-save-20.png"));
		btnLuu.setBounds(141, 143, 53, 29);
		contentPane.add(btnLuu);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					TrangChu s = new TrangChu();
					s.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-close-20.png"));
		btnNewButton_1.setBounds(216, 143, 53, 29);
		contentPane.add(btnNewButton_1);
		
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
		btnTrV.setBounds(389, 10, 37, 29);
		contentPane.add(btnTrV);
		
	}
	private void SetCbb() throws SQLException
	{
		
	}
	private boolean CheckHopLe() {
	    if (txtTen.getText().isEmpty()) {
	        return false;
	    }
	    return true;
	}
	public void btnXacNhan1_actionPerformed(ActionEvent e) throws SQLException, IOException
	{
		//JOptionPane.showMessageDialog(null,"Thêm sản phẩm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
		if (CheckHopLe())
		{
			//JOptionPane.showMessageDialog(null,"Thêm sản phẩm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
			String selectedOption = cbbChon.getSelectedItem().toString();
						
			if (selectedOption== "Nhà Sản Xuất")
			{
				 System.out.println("Thực hiện hàm thêm nhà sản xuất.");
				NhaSanXuatModel sxm = new NhaSanXuatModel();
				NhaSanXuat sx = new NhaSanXuat();
				sx.setMaNhaSanXuat(sxm.TaoIdNhaSX());
				sx.setTenNhaSanXuat(txtTen.getText());
				sxm.AddNhaSX(sx);
			}
			else if (selectedOption.equals("Phân loại SP"))
			{
				System.out.println("Thực hiện hàm thêm phân loại sản phẩm.");
				PhanLoaiModel plm = new PhanLoaiModel();
				PhanLoai pl = new PhanLoai();
				pl.setMaPhanLoai(plm.TaoIdPhanLoai());
				pl.setTenPhanLoai(txtTen.getText());
				plm.AddPhanLoai(pl);
			}
			JOptionPane.showMessageDialog(null,"Thêm sản phẩm thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
 			dispose();
 			TrangChu tc = new TrangChu();
 			tc.ShowWinDow();
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	public void ShowWinDow()
	{
		this.setVisible(true);
		this.setSize(500, 288);
		this.setLocationRelativeTo(null);
		
	}
}
