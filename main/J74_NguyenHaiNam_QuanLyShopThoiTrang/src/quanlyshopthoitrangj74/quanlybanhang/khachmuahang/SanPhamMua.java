package quanlyshopthoitrangj74.quanlybanhang.khachmuahang;

import quanlyshopthoitrangj74.capnhat.capnhatsanpham.QuanLySanPham;
import quanlyshopthoitrangj74.capnhat.capnhatsanpham.SanPham;

public class SanPhamMua {
	private int id;
	private double amount;
	
	public void display() {
		SanPham x = QuanLySanPham.getProductById(id);
		System.out.printf("%-35s %6.1f %9.2f%n", x.getName(), this.amount, x.getPrice(), totalMoney());
	}
	
	public double totalMoney() {
		SanPham x = QuanLySanPham.getProductById(id);
		return x.getPrice() * this.amount;
	}
	
	
	
	public SanPhamMua() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPhamMua(int id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
