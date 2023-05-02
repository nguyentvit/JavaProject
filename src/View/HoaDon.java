package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class HoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		setBounds(100, 100, 656, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(185, 248, 251));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HÓA ĐƠN ");
		lblNewLabel.setBackground(new Color(205, 250, 252));
		lblNewLabel.setIcon(new ImageIcon("E:\\PBL3_MAIN\\Icons\\icons8-paid-bill-20.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(257, 10, 111, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày ");
		lblNewLabel_1.setBounds(50, 180, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số Lượng ");
		lblNewLabel_1_1.setBounds(332, 229, 59, 13);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(123, 72, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 126, 96, 19);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Hãng");
		lblNewLabel_1_2.setBounds(332, 75, 45, 13);
		contentPane.add(lblNewLabel_1_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(441, 71, 96, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Tên SP");
		lblNewLabel_1_2_1.setBounds(332, 129, 45, 13);
		contentPane.add(lblNewLabel_1_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(441, 125, 96, 21);
		contentPane.add(comboBox_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(123, 180, 96, 19);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_1_3 = new JLabel("SĐT");
		lblNewLabel_1_3.setBounds(50, 129, 45, 13);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Giá");
		lblNewLabel_1_4.setBounds(332, 180, 45, 13);
		contentPane.add(lblNewLabel_1_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(441, 177, 96, 19);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tên KH\r\n");
		lblNewLabel_1_5.setBounds(50, 72, 45, 13);
		contentPane.add(lblNewLabel_1_5);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(441, 226, 96, 19);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-save-20.png"));
		btnNewButton.setBounds(243, 281, 45, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\HP VICTUS\\Downloads\\icons8-delete-20.png"));
		btnNewButton_1.setBounds(315, 281, 45, 38);
		contentPane.add(btnNewButton_1);
	}
}
