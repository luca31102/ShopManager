package quanlyshopthoitrangj74.quanlybanhang.thongke;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.capnhatkhachhang.KhachHang;
import quanlyshopthoitrangj74.capnhat.capnhatkhachhang.QuanLyKhachHang;
import quanlyshopthoitrangj74.quanlybanhang.khachmuahang.Gio;

public class QuanLyDanhSachGioHang {
	static Scanner sc = new Scanner(System.in);

	static LinkedList<Gio> list = new LinkedList<>();
	
	static LinkedList<ThongKeKhachHang> list2 = new LinkedList<>();

	public static LinkedList<Gio> getList() {
		return list;
	}

	public static void setList(LinkedList<Gio> list) {
		QuanLyDanhSachGioHang.list = list;
	}

	public static int autoId = 701;

	public static void quanLyDanhSachGioHang() {
		do {
			System.out.println("\n\t\t\t=========THONG KE==========");
			System.out.println("\t1. Hien thi danh sach gio hang");
			System.out.println("\t2. Thong ke so tien thu duoc theo khach hang");
			System.out.println("\t0. Quay lai");
			System.out.print("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				hienThiDanhSachGioHang();
				break;
			case 2:
				thongKeKhachHang();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");
			}

		} while (true);
	}

	public static void hienThiDanhSachGioHang() {
		System.out.println("\n\t\t\t==========DANH SACH GIO HANG==========");
		double total = 0;
		for (Gio x : list) {
			x.display();
			total += x.totalMoney();
			System.out.println(
					"------------------------------------------------------------------------------------------");
		}
		System.out.printf("Tong so tien thu duoc tu tat ca cac gio hang la: %10.1f%n", total);
	}
	public static void thongKeKhachHang() {
		System.out.println("\n\t\t\t==========THONG KE SO TIEN THU DUOC THEO KHACH HANG==========");
		for(Gio x : list) {
			boolean isExist = list2.stream().anyMatch(p -> p.getIdkh() == x.getIdkh());
			if(!isExist) {
				list2.add(new ThongKeKhachHang(x.getIdkh(), x.totalMoney()));
			}else {
				if(!list2.isEmpty()) {
					double oldPrice = 0;
					int index = 0;
					for(ThongKeKhachHang t : list2) {
						if(t.getIdkh() == x.getIdkh()) {
							oldPrice = t.getPrice();
							index = list2.indexOf(t);
						}
					}
					double totalPrice = oldPrice + x.totalMoney();
					ThongKeKhachHang newItem = new ThongKeKhachHang(x.getIdkh(), totalPrice);
					list2.set(index, newItem);
				}
			}
		}
		System.out.printf("%-35s %-11s%n","Ten khach hang", "Tong tien");
		double t = 0;
		for(ThongKeKhachHang j : list2) {
			System.out.printf("%-35s %10.1f%n",QuanLyKhachHang.getNameById(j.getIdkh()), j.getPrice());
			t = t + j.getPrice();
		}
		System.out.printf("\nTong so tien thu duoc la: %10.1f", t);
	}

	public static int findById(int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public static int findByIdkh(int id) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getIdkh() == id) {
				return i;
			}
		}
		return -1;
	}
	

}
