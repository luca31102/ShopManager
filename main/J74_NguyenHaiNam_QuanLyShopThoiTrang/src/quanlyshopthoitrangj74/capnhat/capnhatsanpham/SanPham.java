package quanlyshopthoitrangj74.capnhat.capnhatsanpham;

import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.capnhatchungloai.QuanLyChungLoai;
import quanlyshopthoitrangj74.capnhat.capnhatnhacungcap.NhaCungCap;
import quanlyshopthoitrangj74.capnhat.capnhatnhacungcap.QuanLyNhaCungCap;

public class SanPham {
	
	static Scanner sc = new Scanner(System.in);
	
	private int id;
	private int idncc;
	private int idcl;
	private String name;
	private double amount;
	private double price;

	public void display() {
		System.out.printf("%10d %-35s %-35s %-35s %6.1f %9.2f%n", this.id, QuanLyNhaCungCap.getNameByID(idncc),
				QuanLyChungLoai.getNameByID(idcl), this.name, this.amount, this.price);
	}

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPham(int id, int idncc, int idcl, String name, double amount, double price) {
		super();
		this.id = id;
		this.idncc = idncc;
		this.idcl = idcl;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdncc() {
		return idncc;
	}

	public void setIdncc(int idncc) {
		this.idncc = idncc;
	}

	public int getIdcl() {
		return idcl;
	}

	public void setIdcl(int idcl) {
		this.idcl = idcl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void updateIdncc() {
		System.out.print("Nhap vao ID nha cung cap moi: ");
		int idncc = Integer.parseInt(sc.nextLine());
		if(QuanLyNhaCungCap.findByID(idncc) == -1) {
			System.out.println("Nha cung cap khong ton tai trong danh sach!");
			return;
		}
		this.setIdncc(idncc);
		System.out.println("Sua ID nha cung cap thanh cong!");
	}

	public void updateIdcl() {
		System.out.print("Nhap vao ID chung loai moi: ");
		int idcl = Integer.parseInt(sc.nextLine());
		if(QuanLyChungLoai.findByID(idcl) == -1) {
			System.out.println("Chung loai khong ton tai trong danh sach!");
			return;
		}
		this.setIdcl(idcl);
		System.out.println("Sua ID chung loai thanh cong!");
		
	}

	public void updateName() {
		System.out.print("Nhap vao ten san pham moi: ");
		String name = sc.nextLine();
		if(name.length() == 0) {
			System.out.println("Ten khong duoc de trong!");
			return;
		}
		if(QuanLySanPham.findByName(name) != -1) {
			System.out.println("Ten san pham da xuat hien trong danh sach!");
			return;
		}
		this.setName(name);
		System.out.println("Sua san pham thanh cong!");
	}

	public void updateAmount() {
		System.out.print("Nhap vao so luong san pham moi: ");
		double amount = Double.parseDouble(sc.nextLine());
		if(amount < 0) {
			System.out.println("So luong san pham khong duoc am!");
			return;
		}
		this.setAmount(amount);
		System.out.println("Sua so luong san pham thanh cong!");
	}

	public void updatePrice() {
		System.out.print("Nhap vao gia san pham moi: ");
		double price = Double.parseDouble(sc.nextLine());
		if(price < 0) {
			System.out.println("Gia san pham khong duoc am!");
			return;
		}
		this.setPrice(price);
		System.out.println("Sua gia san pham thanh cong!");
		
	}
}
