package view;

import java.awt.EventQueue;
import java.awt.JobAttributes;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.SachDAO;
import model.sach;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {
	SachDAO sachdao;
	sach sachmodel;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel df = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		sachmodel = new sach();
		sachdao = new SachDAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		df = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		df.addColumn("ID");
		df.addColumn("Tên Sách");
		df.addColumn("Giá Bán");
		df.addColumn("Năm Xuất Bản");
		List<sach> sach1 = sachdao.selectAll();
		for (sach sach : sach1) {
			df.addRow(new Object[] { sach.getId(), sach.getTenSach(), sach.getGiaBan(), sach.getNamXuatBan() });
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(54, 81, 574, 402);
		contentPane.add(panel);
		panel.setLayout(null);
		
				table = new JTable();
				table.setModel(df);
		table.setBounds(0, 0, 1, 1);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 574, 402);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(53, 28, 575, 23);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
				JButton btnThemMoi = new JButton("Thêm Mới");
				btnThemMoi.setBounds(43, 0, 89, 23);
				panel_1.add(btnThemMoi);
				
						JButton btnLamMoi = new JButton("Làm mới");
						btnLamMoi.setBounds(439, 0, 89, 23);
						panel_1.add(btnLamMoi);
						
								JButton btnNewButton = new JButton("Xóa");
								btnNewButton.setBounds(175, 0, 89, 23);
								panel_1.add(btnNewButton);
								
								JButton btnNewButton_1 = new JButton("Sửa");
								btnNewButton_1.setBounds(307, 0, 89, 23);
								panel_1.add(btnNewButton_1);
								btnNewButton_1.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										int row = table.getSelectedRow();		
										if (row == -1) {
											JOptionPane.showMessageDialog(View.this, "vui long chọn sản phẩm", "Loi",
													JOptionPane.ERROR_MESSAGE);
										} else {
											
												int id = Integer.valueOf(String.valueOf(table.getValueAt(row, 0)));						
												new ChinhSuaSach(id).setVisible(true);				
											 
											}
									}
								});
								btnNewButton.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										int row = table.getSelectedRow();
										if (row == -1) {
											JOptionPane.showMessageDialog(View.this, "vui long chọn sản phẩm", "Loi",
													JOptionPane.ERROR_MESSAGE);
										} else {
											int confirm = JOptionPane.showConfirmDialog(View.this, "ban co chac muon xoa");
											if (confirm == JOptionPane.YES_OPTION) {
												int id = Integer.valueOf(String.valueOf(table.getValueAt(row, 0)));
												String tenSach = "";
												float giaBan = Float.valueOf(String.valueOf(table.getValueAt(row, 2)));
												int namXuatBan = 0;

												sachmodel.setId(id);
												sachmodel.setTenSach(tenSach);
												sachmodel.setGiaBan(giaBan);
												sachmodel.setNamXuatBan(namXuatBan);
												sachdao.delete(sachmodel);
												df.setRowCount(0);
												List<sach> sach1 = sachdao.selectAll();
												for (sach sach : sach1) {
													df.addRow(new Object[] { sach.getId(), sach.getTenSach(), sach.getGiaBan(),
															
															sach.getNamXuatBan() });
												}
											}
										}

									}
								});
						btnLamMoi.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								df.setRowCount(0);
								List<sach> sach1 = sachdao.selectAll();
								for (sach sach : sach1) {
									df.addRow(new Object[] { sach.getId(), sach.getTenSach(), sach.getGiaBan(), sach.getNamXuatBan() });
								}
								table.setBounds(0, 0, 1, 1);
							}
						});
				btnThemMoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new ThemMoiSach().setVisible(true);

					}
				});
	}
}
