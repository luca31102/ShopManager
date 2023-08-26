package quanlyshopthoitrangj74.capnhat;

import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.capnhatchungloai.QuanLyChungLoai;
import quanlyshopthoitrangj74.capnhat.capnhatkhachhang.QuanLyKhachHang;
import quanlyshopthoitrangj74.capnhat.capnhatnhacungcap.QuanLyNhaCungCap;
import quanlyshopthoitrangj74.capnhat.capnhatsanpham.QuanLySanPham;

public class QuanLyCapNhat {
	static Scanner sc = new Scanner(System.in);
	public static void quanLyCapNhat() {
		do {
			System.out.println("\t\t\t==========CAP NHAT THONG TIN HE THONG==========");
			System.out.println("\tChon thong tin ban muon cap nhat");
			System.out.println("\t1. Cap nhat thong tin nha cung cap");
			System.out.println("\t2. Cap nhat thong tin chung loai");
			System.out.println("\t3. Cap nhat thong tin san pham");
			System.out.println("\t4. Cap nhat thong tin khach hang");
			System.out.println("\t0. Quay lai");
			
			int chon;
			System.out.print("Nhap vao lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			
			switch(chon) {
			case 1: QuanLyNhaCungCap.quanLyNhaCungCap(); break;
			case 2: QuanLyChungLoai.quanLyChungLoai(); break;
			case 3: QuanLySanPham.quanLySanPham(); break;
			case 4: QuanLyKhachHang.quanLyKhachHang(); break;
			case 0: return; 
			default: System.out.println("Lua chon khong hop le!"); break;
			}
		}while(true);
		
	}
}
 