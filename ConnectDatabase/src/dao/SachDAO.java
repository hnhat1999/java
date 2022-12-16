package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.sach;

public class SachDAO implements DAOInterface<sach> {
	
	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int insert(sach t) {
		int ketqua = 0;
		try {
			// buoc 1: tao ket noi
			Connection connection = JDBCUtil.getConnection();
			// Bước 2: Tạo ra đối tượng statement	
			String sql = "INSERT INTO sach(id, tenSach, giaBan, namXuatBan)"
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement ppsm = connection.prepareStatement(sql);
			ppsm.setInt(1, t.getId());
			ppsm.setString(2, t.getTenSach());
			ppsm.setFloat(3, t.getGiaBan());
			ppsm.setInt(4, t.getNamXuatBan());
			// bước 3: thực thi câu lệnh sql
			ketqua = ppsm.executeUpdate();
			// buoc 4: xu ly ket qua
			System.out.println("so dong thay doi "+ketqua);
			System.out.println("ban da thuc thi "+sql);
			// buoc 5: ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(sach t) {
		int ketqua = 0;
		try {
			// buoc 1: tao ket noi
			Connection connection = JDBCUtil.getConnection();
			// Bước 2: Tạo ra đối tượng statement
			String sql = "UPDATE sach SET tenSach=?, giaBan=?, namXuatBan=? where id=?";
				 
			System.out.println("ban da thuc thi "+sql);
			PreparedStatement st = connection.prepareStatement(sql);			
			st.setString(1, t.getTenSach());
			st.setFloat(2, t.getGiaBan());
			st.setInt(3, t.getNamXuatBan());
			st.setInt(4, t.getId());
			ketqua = st.executeUpdate();			
			System.out.println("so dong thay doi "+ketqua);
			
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(sach t) {
		int ketqua=0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete sach where id=?";
			PreparedStatement rf = connection.prepareStatement(sql);
			rf.setInt(1, t.getId());
			ketqua = rf.executeUpdate();
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return 0;
	}

	@Override
	public ArrayList<sach> selectAll() {
		ArrayList<sach> ketqua = new ArrayList<sach>();
		try {
			// buoc 1: tao ket noi
			Connection connection = JDBCUtil.getConnection();
			// Bước 2: Tạo ra đối tượng statement
			Statement st = connection.createStatement();
			// Bước 3: Thực thi một câu lệnh SQL
//			String sql = "INSERT INTO sach(last_name, first_name, gender, dob, income)"
//					+ "VALUES ('Tran', 'Thi', 'A', '2000-09-10', '10000000')";
			String sql = "select * from sach";			
			 ResultSet rs = st.executeQuery(sql);
			
			// buoc 4: xu ly ket qua
			 while(rs.next()) {
				 int id = rs.getInt("id");
				 String tenSach = rs.getNString("tenSach");
				 float giaBan = rs.getFloat("giaBan");
				 int namXuatBan = rs.getInt("namXuatBan");
				 sach s = new sach(id, tenSach, giaBan, namXuatBan);
				 ketqua.add(s);
			 }
			System.out.println("so dong thay doi "+ketqua);
			
			// buoc 5: ngat ket noi
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public sach selectByID(int id) {
		sach ketqua=null;
		Connection connection = JDBCUtil.getConnection();
		String sql = "select * from sach where id=?";
		try {			
			PreparedStatement rf = connection.prepareStatement(sql);
			rf.setInt(1, id);
			ResultSet rs = rf.executeQuery();
			while(rs.next()) {
				int id1 = rs.getInt("id");
				String tenSach = rs.getString("tenSach");
				float giaBan = rs.getFloat("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				ketqua = new sach(id1, tenSach, giaBan, namXuatBan);
				System.out.println("so dong thay doi "+ketqua);
				return ketqua;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return ketqua;
	}

	@Override
	public ArrayList<sach> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
