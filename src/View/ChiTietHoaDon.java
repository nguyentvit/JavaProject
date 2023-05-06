package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChiTietHoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException, IOException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChiTietHoaDon frame = new ChiTietHoaDon();
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
	public ChiTietHoaDon() throws SQLException, IOException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 248, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT HÓA ĐƠN");
		lblNewLabel.setBackground(new Color(205, 250, 252));
		lblNewLabel.setIcon(new ImageIcon("E:\\JAVA.project\\JAVA_Team\\JavaProject\\icons\\icons8-paid-bill-20.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(281, 10, 153, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày ");
		lblNewLabel_1.setBounds(50, 162, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số Lượng ");
		lblNewLabel_1_1.setBounds(50, 215, 59, 13);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(123, 72, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 113, 96, 19);
		contentPane.add(textField_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(123, 162, 96, 19);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_1_3 = new JLabel("SĐT");
		lblNewLabel_1_3.setBounds(50, 116, 45, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tổng tiền");
		lblNewLabel_1_4.setBounds(50, 271, 45, 13);
		contentPane.add(lblNewLabel_1_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 268, 96, 19);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tên KH\r\n");
		lblNewLabel_1_5.setBounds(50, 72, 45, 13);
		contentPane.add(lblNewLabel_1_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(123, 212, 96, 19);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-checkmark-25.png"));
		btnNewButton.setBounds(280, 322, 45, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-close-20.png"));
		btnNewButton_1.setBounds(335, 322, 45, 38);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(262, 72, 432, 215);
		contentPane.add(scrollPane);
		
		JButton btnTrV = new JButton("");
		btnTrV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MuaHang mh;
				try {
					mh = new MuaHang();
					mh.ShowWinDow();
				} catch (SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnTrV.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-back-20.png"));
		btnTrV.setBounds(657, 20, 37, 29);
		contentPane.add(btnTrV);
	}
	public void ShowWinDow()
	{
		
		this.setVisible(true);
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		
	}
}
