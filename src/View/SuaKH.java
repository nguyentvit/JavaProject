package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.Nguoi;
import Models.NguoiModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class SuaKH extends JFrame {

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtSdt;

	public SuaKH(String id) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 235);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 236, 253));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTen = new JTextField();
		txtTen.setBounds(153, 51, 117, 19);
		contentPane.add(txtTen);
		txtTen.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("THAY ĐỔI THÔNG TIN KHÁCH HÀNG");
		lblNewLabel.setBounds(121, 10, 217, 15);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		contentPane.add(lblNewLabel);
		
		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(153, 94, 117, 19);
		contentPane.add(txtSdt);
		
		JButton btnXacNhan = new JButton("");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Nguoi ng = new Nguoi(id, txtTen.getText(), txtSdt.getText());
				NguoiModel ngm = new NguoiModel();
				try {
					ngm.SuaNguoi(ng);
					JOptionPane .showMessageDialog(null, "Thay đổi thông tin thành công", "Thông báo", JOptionPane.OK_OPTION);
					dispose();
					KhachHang kh;
					try {
						kh = new KhachHang();
						kh.ShowWinDow();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnXacNhan.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-checkmark-25.png"));
		btnXacNhan.setBounds(177, 138, 33, 33);
		contentPane.add(btnXacNhan);
		
		JButton btnHuy = new JButton("");
		btnHuy.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-close-20.png"));
		btnHuy.setBounds(220, 138, 33, 33);
		contentPane.add(btnHuy);
		
		JLabel lblNewLabel_1 = new JLabel("Tên ");
		lblNewLabel_1.setBounds(58, 54, 60, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Số điện thoại ");
		lblNewLabel_2.setBounds(58, 97, 78, 13);
		contentPane.add(lblNewLabel_2);
		
		NguoiModel ngm = new NguoiModel();
		Nguoi ng = ngm.getNguoiByIdNguoi(id);
		txtTen.setText(ng.getTenNguoi());
		txtSdt.setText(ng.getSdt());
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-back-20.png"));
		btnNewButton_2.setBounds(389, 10, 33, 26);
		contentPane.add(btnNewButton_2);
	}
	public void ShowWinDow() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		this.setSize(730, 500);
		this.setLocationRelativeTo(null);
}
}
