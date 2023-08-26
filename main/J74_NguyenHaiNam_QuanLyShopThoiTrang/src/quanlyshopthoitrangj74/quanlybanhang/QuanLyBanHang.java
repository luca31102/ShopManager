package quanlyshopthoitrangj74.quanlybanhang;

import java.util.Scanner;

import quanlyshopthoitrangj74.quanlybanhang.khachmuahang.QuanLyGioHang;
import quanlyshopthoitrangj74.quanlybanhang.thongke.QuanLyDanhSachGioHang;

public class QuanLyBanHang {
	 static Scanner sc = new Scanner(System.in);
	public static void quanLyBanHang() {
		do {
			System.out.println("\n==========CAP NHAT BAN HANG=========");
			System.out.println("Chon chuc nang quan ly");
			System.out.println("\t1. Danh cho khach hang");
			System.out.println("\t2. Danh cho nguoi quan ly ban hang");
			System.out.println("\t0. Quay lai");
			
			int chon;
			System.out.println("Nhap vao lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());

			switch(chon) {
			case 1: QuanLyGioHang.quanLyGioHang(); ; break;
			case 2: QuanLyDanhSachGioHang.quanLyDanhSachGioHang(); break;

			case 0: return; 
			default: System.out.println("Lua chon khong hop le!");
			}
		}while(true);
		
	}

}
