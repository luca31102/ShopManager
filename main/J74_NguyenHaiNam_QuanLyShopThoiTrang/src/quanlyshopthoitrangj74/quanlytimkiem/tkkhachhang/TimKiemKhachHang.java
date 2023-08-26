package quanlyshopthoitrangj74.quanlytimkiem.tkkhachhang;

import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.capnhatchungloai.QuanLyChungLoai;
import quanlyshopthoitrangj74.capnhat.capnhatkhachhang.QuanLyKhachHang;

public class TimKiemKhachHang {
	static Scanner sc = new Scanner(System.in);
	public static void timKiemKhachHang() {
		do {
			System.out.println("\n\t\t\t==========TIM KIEM KHACH HANG==========");
			System.out.println("\tTieu chi tim kiem: ");
			System.out.println("\t1. Tim kiem theo ID");
			System.out.println("\t2. Tim kiem theo ten");
			System.out.println("\t0. Quay lai");
			
			System.out.print("Nhap vao lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch(chon) {
			case 1: timKiemTheoId(); break;
			case 2: timKiemTheoTen(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le!"); break;
			}
			
		}while(true);
	}
	
	public static void timKiemTheoId() {
		System.out.print("Nhap vao ID khach hang muon tim kiem: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLyKhachHang.findById(id);
		
		if(index == -1) {
			System.out.println("Khach hang khong ton tai trong danh sach!");
			return;
		}
		
		QuanLyKhachHang.getList().get(index).display();
	}
	
	public static void timKiemTheoTen() {
		System.out.print("Nhap vao ten khach hang muon tim kiem: ");
		String name = sc.nextLine();
		
		int index = QuanLyKhachHang.findByName(name);
		
		if(index == -1) {
			System.out.println("Khach hang khong ton tai trong danh sach!");
			return;
		}
		
		QuanLyKhachHang.getList().get(index).display();
	}
}
