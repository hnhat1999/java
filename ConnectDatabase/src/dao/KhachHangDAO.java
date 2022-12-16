package dao;

import java.util.ArrayList;

import model.khachhang;

public class KhachHangDAO implements DAOInterface<khachhang> {
	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int insert(khachhang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(khachhang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(khachhang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<khachhang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public ArrayList<khachhang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public khachhang selectByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
