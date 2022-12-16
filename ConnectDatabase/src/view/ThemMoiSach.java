package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.SachDAO;
import model.sach;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThemMoiSach extends JFrame {
	SachDAO sachdao;
	sach sachmodel;
	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfTenSach;
	private JTextField tfGiaBan;
	private JTextField tfNamXuatBan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemMoiSach frame = new ThemMoiSach();
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
	public ThemMoiSach() {
		sachdao = new SachDAO();
		sachmodel = new sach();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm Mới Sách");
		lblNewLabel.setBounds(234, 24, 91, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(43, 66, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tên Sách");
		lblNewLabel_2.setBounds(43, 146, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giá Bán");
		lblNewLabel_3.setBounds(43, 226, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Năm Xuất Bản");
		lblNewLabel_4.setBounds(22, 306, 91, 14);
		contentPane.add(lblNewLabel_4);
		
		tfID = new JTextField();
		tfID.setBounds(123, 63, 220, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfTenSach = new JTextField();
		tfTenSach.setColumns(10);
		tfTenSach.setBounds(123, 143, 220, 20);
		contentPane.add(tfTenSach);
		
		tfGiaBan = new JTextField();
		tfGiaBan.setColumns(10);
		tfGiaBan.setBounds(123, 223, 220, 20);
		contentPane.add(tfGiaBan);
		
		tfNamXuatBan = new JTextField();
		tfNamXuatBan.setColumns(10);
		tfNamXuatBan.setBounds(123, 303, 220, 20);
		contentPane.add(tfNamXuatBan);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new View().setVisible(true);			
			}
		});
		btnNewButton.setBounds(481, 20, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sachmodel.setId(Integer.parseInt(tfID.getText()));
				sachmodel.setGiaBan(Float.parseFloat(tfGiaBan.getText()));
				sachmodel.setTenSach(tfTenSach.getText());
				sachmodel.setNamXuatBan(Integer.parseInt(tfNamXuatBan.getText()));
				sachdao.insert(sachmodel);
				new View().setVisible(true);
				dispose();				
			}
		});
		btnNewButton_1.setBounds(440, 306, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
