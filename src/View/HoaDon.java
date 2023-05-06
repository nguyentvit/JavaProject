package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class HoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon frame = new HoaDon();
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
	public HoaDon() {
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
		btnXoa.setBounds(598, 63, 37, 29);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("");
		btnSua.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-edit-20.png"));
		btnSua.setBounds(551, 63, 37, 29);
		contentPane.add(btnSua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 117, 604, 197);
		contentPane.add(scrollPane);
		
		JComboBox cbbHang = new JComboBox();
		cbbHang.setBounds(31, 71, 83, 21);
		contentPane.add(cbbHang);
		
		JComboBox cbbDong = new JComboBox();
		cbbDong.setBounds(135, 71, 83, 21);
		contentPane.add(cbbDong);
		
		JButton btnTim = new JButton("");
		btnTim.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-find-20.png"));
		btnTim.setBounds(363, 63, 37, 29);
		contentPane.add(btnTim);
		
		textField = new JTextField();
		textField.setBounds(242, 72, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	public void ShowWinDow()
	{
		this.setVisible(true);
		this.setSize(847, 488);
		this.setLocationRelativeTo(null);
		
	}
}
