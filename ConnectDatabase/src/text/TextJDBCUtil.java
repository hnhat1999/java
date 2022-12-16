package text;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.text.View;

import dao.SachDAO;
import database.JDBCUtil;
import model.sach;

public class TextJDBCUtil {
	public static void main(String[] args) {
//		sach sach1 = new sach(03, "LapTrinhJava", 5000, 2012);
//		SachDAO.getInstance().selectByID(2);
 //       SachDAO.getInstance().insert(sach1);
//		sach sach4 = new sach(03, "LapTrinhthaydoi2", 5000, 2012);
		
//		ArrayList<sach> s = SachDAO.getInstance().selectAll();
//		for (sach sa  : s) {
//			System.out.println(sa.toString());
//		}
		sach sachmodel = new sach();
	sachmodel = SachDAO.getInstance().selectByID(2);
	System.out.println("day la ten sach"+sachmodel.getGiaBan());
	}
}
