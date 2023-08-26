package quanlyshopthoitrangj74.quanlytimkiem.tkchungloai;

import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.capnhatchungloai.QuanLyChungLoai;

public class TimKiemChungLoai {
	static Scanner sc = new Scanner(System.in);
	
	public static void timKiemChungLoai() {
		do {
			System.out.println("\n\t\t\t==========TIM KIEM CHUNG LOAI==========");
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
		System.out.print("Nhap vao ID chung loai muon tim kiem: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLyChungLoai.findByID(id);
		
		if(index == -1) {
			System.out.println("Chung loai khong ton tai trong danh sach!");
			return;
		}
		
		QuanLyChungLoai.getList().get(index).display();
	}
	
	public static void timKiemTheoTen() {
		System.out.print("Nhap vao ten chung loai muon tim kiem: ");
		String name = sc.nextLine();
		
		int index = QuanLyChungLoai.findByName(name);
		
		if(index == -1) {
			System.out.println("Chung loai khong ton tai trong danh sach!");
			return;
		}
		
		QuanLyChungLoai.getList().get(index).display();
	}
	
}
