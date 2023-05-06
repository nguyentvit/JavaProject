package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class KhachHang extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	public KhachHang() throws SQLException, IOException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 375);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 234, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbbHang = new JComboBox();
		cbbHang.setBounds(22, 47, 83, 21);
		contentPane.add(cbbHang);
		
		JComboBox cbbDong = new JComboBox();
		cbbDong.setBounds(115, 47, 83, 21);
		contentPane.add(cbbDong);
		
		JButton btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-find-20.png"));
		btnTim.setBounds(320, 47, 37, 29);
		contentPane.add(btnTim);
		
		JButton btnSua = new JButton("");
		btnSua.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-edit-20.png"));
		btnSua.setBounds(495, 47, 37, 29);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-delete-20.png"));
		btnXoa.setBounds(542, 47, 37, 29);
		contentPane.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 86, 604, 179);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textField.setBounds(208, 48, 96, 19);
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
		btnTrV.setBounds(589, 47, 37, 29);
		contentPane.add(btnTrV);
	}
	public void ShowWinDow() {
		// TODO Auto-generated method stub
		this.setVisible(true);
		this.setSize(730, 500);
		this.setLocationRelativeTo(null);
	}
}
