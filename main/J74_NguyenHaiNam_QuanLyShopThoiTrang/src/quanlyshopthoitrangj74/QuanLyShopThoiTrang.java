package quanlyshopthoitrangj74;

import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.QuanLyCapNhat;
import quanlyshopthoitrangj74.capnhat.capnhatchungloai.QuanLyChungLoai;
import quanlyshopthoitrangj74.capnhat.capnhatkhachhang.QuanLyKhachHang;
import quanlyshopthoitrangj74.capnhat.capnhatnhacungcap.QuanLyNhaCungCap;
import quanlyshopthoitrangj74.capnhat.capnhatsanpham.QuanLySanPham;
import quanlyshopthoitrangj74.quanlybanhang.QuanLyBanHang;
import quanlyshopthoitrangj74.quanlytimkiem.QuanLyTimKiem;

public class QuanLyShopThoiTrang {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		QuanLyNhaCungCap.init();
		QuanLyChungLoai.init();
		QuanLySanPham.init();
		QuanLyKhachHang.init();
		do {
			System.out.println("\t\t\t===============CHUONG TRINH QUAN LY SHOP THOI TRANG===============");
			System.out.println("\tCac chuc nang cua cua hang");
			System.out.println("\t1. Cap nhat thong tin he thong");
			System.out.println("\t2. Quan ly ban hang");
			System.out.println("\t3. Tim kiem thong tin he thong");
			System.out.println("\t0. Thoat chuong trinh");

			int chon;
			System.out.print("Nhap vao lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				QuanLyCapNhat.quanLyCapNhat();
				break;
			case 2:
				QuanLyBanHang.quanLyBanHang();
				break;
			case 3:
				QuanLyTimKiem.quanLyTimKiem();
				break;
			case 0:
				System.exit(0);
				break;
			default: System.out.println("Lua chon khong hop le!"); break;
		}
	}while(true);
}
}
