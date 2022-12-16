package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.SachDAO;
import model.sach;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChinhSuaSach extends JFrame {
	private SachDAO sachdao;
	private sach sachmodel;
	private JPanel contentPane;
	private JTextField idTF;
	private JTextField tenSachTF;
	private JTextField giaBanTF;
	private JTextField namXuatBanTF;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ChinhSuaSach(int id) {
		
		sachdao = new SachDAO();
		sachmodel = sachdao.getInstance().selectByID(id);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idTF = new JTextField();
		idTF.setBounds(153, 64, 86, 20);
		contentPane.add(idTF);
		idTF.setColumns(10);
		idTF.setText(String.valueOf(sachmodel.getId()));
		
		tenSachTF = new JTextField();
		tenSachTF.setBounds(153, 129, 86, 20);
		contentPane.add(tenSachTF);
		tenSachTF.setColumns(10);
		tenSachTF.setText(sachmodel.getTenSach());
		
		giaBanTF = new JTextField();
		giaBanTF.setBounds(153, 222, 86, 20);
		contentPane.add(giaBanTF);
		giaBanTF.setColumns(10);
		giaBanTF.setText(String.valueOf(sachmodel.getGiaBan()));
		
		namXuatBanTF = new JTextField();
		namXuatBanTF.setBounds(153, 309, 86, 20);
		contentPane.add(namXuatBanTF);
		namXuatBanTF.setColumns(10);
		namXuatBanTF.setText(String.valueOf(sachmodel.getNamXuatBan()));
		
		JButton btnNewButton = new JButton("Chỉnh sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sachmodel.setId(Integer.parseInt(idTF.getText()));
				sachmodel.setGiaBan(Float.parseFloat(giaBanTF.getText()));
				sachmodel.setTenSach(tenSachTF.getText());
				sachmodel.setNamXuatBan(Integer.parseInt(namXuatBanTF.getText()));
				sachdao.update(sachmodel);
				new View().setVisible(true);
				dispose();			
			}
		});
		btnNewButton.setBounds(391, 342, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(41, 67, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Sách");
		lblNewLabel_1.setBounds(41, 132, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Giá Bán");
		lblNewLabel_2.setBounds(41, 225, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Năm Xuất Bản");
		lblNewLabel_3.setBounds(26, 312, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Chỉnh sửa sách");
		lblNewLabel_4.setBounds(230, 21, 86, 14);
		contentPane.add(lblNewLabel_4);
	}
}
