package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.ViewSanPham;
import Entities.SanPham;
import Models.SanPhamModel;
import Models.ViewSanPhamModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ThemSL extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtThemSL;

	public ThemSL(String id) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(156, 240, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(157, 64, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("THÊM SỐ LƯỢNG SẢN PHẨM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(113, 23, 184, 13);
		contentPane.add(lblNewLabel);
		
		txtThemSL = new JTextField();
		txtThemSL.setBounds(157, 113, 96, 19);
		contentPane.add(txtThemSL);
		txtThemSL.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SanPham sp = new SanPham();
				SanPhamModel spm = new SanPhamModel();
				try {
					sp = spm.GetSanPhamByIdSanPham(id);
					sp.setSoLuong(Integer.parseInt(txtThemSL.getText()));
					spm.ThemSL(sp);
					JOptionPane.showMessageDialog(null, "Thay đổi thông tin thành công", "Thông báo", JOptionPane.OK_OPTION);
					dispose();
			    	Sanpham ph;
					try {
						ph = new Sanpham();
						ph.ShowWinDow();
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-checkmark-25.png"));
		btnNewButton.setBounds(158, 166, 38, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-close-20.png"));
		btnNewButton_1.setBounds(206, 166, 38, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Tên SP");
		lblNewLabel_1.setBounds(76, 67, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Số lượng ");
		lblNewLabel_2.setBounds(76, 116, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-back-20.png"));
		btnNewButton_2.setBounds(381, 10, 45, 26);
		contentPane.add(btnNewButton_2);
		SanPhamModel spm = new SanPhamModel();
		SanPham sp = new SanPham();
		ViewSanPham view = new ViewSanPham();
		ViewSanPhamModel viewm = new ViewSanPhamModel();
		sp = spm.GetSanPhamByIdSanPham(id);
		view = viewm.GetViewSanPhamByIdSanPham(id);
		textField.setText(sp.getTenSanPham());
		
	}
	public void ShowWinDow()
	{
		
		this.setVisible(true);
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		
	}
}
