package quanlyshopthoitrangj74.quanlytimkiem.tkgiohang;

import java.util.Scanner;

import quanlyshopthoitrangj74.quanlybanhang.thongke.QuanLyDanhSachGioHang;

public class TimKiemGioHang {
	static Scanner sc = new Scanner(System.in);
	public static void timKiemGioHang() {
		do {
			System.out.println("\n\t\t\t==========TIM KIEM GIO HANG==========");
			System.out.println("\tTieu chi tim kiem: ");
			System.out.println("\t1. Tim kiem theo ID");
			System.out.println("\t2. Tim kiem theo ID khach hang");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Nhap vao lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch(chon) {
			case 1: timKiemTheoId(); break;
			case 2: timKiemTheoIdkh(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le!"); break;
			}
			
		}while(true);
	}
	
	public static void timKiemTheoId() {
		System.out.print("Nhap vao ID gio hang muon tim kiem: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLyDanhSachGioHang.findById(id);
		
		if(index == -1) {
			System.out.println("Khong ton tai gio hang muon tim kiem!");
			return;
		}
		QuanLyDanhSachGioHang.getList().get(index).display();
	}
	
	public static void timKiemTheoIdkh() {
		System.out.print("Nhap vao ID khach hang muon tim kiem: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLyDanhSachGioHang.findByIdkh(id);
		
		if(index == -1) {
			System.out.println("Khong ton tai gio hang muon tim kiem!");
			return;
		}
		QuanLyDanhSachGioHang.getList().get(index).display();
	}
}
