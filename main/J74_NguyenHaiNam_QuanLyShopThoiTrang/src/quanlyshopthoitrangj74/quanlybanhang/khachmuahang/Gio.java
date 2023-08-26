package quanlyshopthoitrangj74.quanlybanhang.khachmuahang;

import java.util.LinkedList;

import quanlyshopthoitrangj74.capnhat.capnhatkhachhang.QuanLyKhachHang;

public class Gio {
	private int id;
	private int idkh;
	LinkedList<SanPhamMua> list = new LinkedList<>();
	
	public void display() {
		System.out.println("Ma gio hang: " + this.id);
		System.out.println("Ten khach hang: " + QuanLyKhachHang.getNameById(idkh));
		System.out.printf("%-35s %-7s %-9s%n", "NAMEPRODUCT", "AMOUNT", "PRICE", "TOTAL MONEY");
		for(SanPhamMua x : list) {
			x.display();
		}
		System.out.printf("Tong tien thanh toan: %9.1f%n",totalMoney());
	}
	
	public double totalMoney() {
		double total = 0;
		for(SanPhamMua x : list) {
			total += x.totalMoney();
		}
		return total;
	}
	
	public Gio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gio(int id, int idkh, LinkedList<SanPhamMua> list) {
		super();
		this.id = id;
		this.idkh = idkh;
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdkh() {
		return idkh;
	}

	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}

	public LinkedList<SanPhamMua> getList() {
		return list;
	}

	public void setList(LinkedList<SanPhamMua> list) {
		this.list = list;
	}
	
	public int findHangTrongGioById(int id) {
		for(int index = 0; index < list.size(); ++index) {
			if(list.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}
	
	
}
