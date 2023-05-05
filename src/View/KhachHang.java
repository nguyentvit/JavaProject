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

public class KhachHang extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang frame = new KhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(196, 234, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbbHang = new JComboBox();
		cbbHang.setBounds(38, 20, 83, 21);
		contentPane.add(cbbHang);
		
		JComboBox cbbDong = new JComboBox();
		cbbDong.setBounds(131, 20, 83, 21);
		contentPane.add(cbbDong);
		
		JButton btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-find-20.png"));
		btnTim.setBounds(223, 20, 37, 29);
		contentPane.add(btnTim);
		
		JButton btnThem = new JButton("");
		btnThem.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-add-20.png"));
		btnThem.setBounds(402, 20, 37, 29);
		contentPane.add(btnThem);
		
		JButton btnSua = new JButton("");
		btnSua.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-edit-20.png"));
		btnSua.setBounds(449, 20, 37, 29);
		contentPane.add(btnSua);
		
		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-delete-20.png"));
		btnXoa.setBounds(496, 20, 37, 29);
		contentPane.add(btnXoa);
	}
}
