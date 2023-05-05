package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class SanPham extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPham frame = new SanPham();
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
	public SanPham() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(189, 255, 255));
		panel.setBounds(10, 10, 637, 413);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox cbbHang = new JComboBox();
		cbbHang.setBounds(38, 32, 83, 21);
		panel.add(cbbHang);
		
		JComboBox cbbDong = new JComboBox();
		cbbDong.setBounds(131, 32, 83, 21);
		panel.add(cbbDong);
		
		JButton btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-find-20.png"));
		btnTim.setBounds(223, 32, 37, 21);
		panel.add(btnTim);
		
		JButton btnThem = new JButton("");
		btnThem.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-add-20.png"));
		btnThem.setBounds(402, 32, 37, 29);
		panel.add(btnThem);
		
		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-delete-20.png"));
		btnXoa.setBounds(496, 32, 37, 29);
		panel.add(btnXoa);
		
		JButton btnSua = new JButton("");
		btnSua.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-edit-20.png"));
		btnSua.setBounds(449, 32, 37, 29);
		panel.add(btnSua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 122, 537, 213);
		panel.add(scrollPane);
	}
}
