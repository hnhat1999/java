package model;

import java.sql.Date;

public class khachhang {
	private int id;
	private String hoTen;
	private Date ngaySinh;
	private String diaChi;

	public khachhang(int id, String hoTen, Date ngaySinh, String diaChi) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}

	public khachhang() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "khachhang [id=" + id + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + "]";
	}

}
