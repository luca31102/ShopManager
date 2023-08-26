package quanlyshopthoitrangj74.quanlytimkiem;

import java.util.Scanner;

import quanlyshopthoitrangj74.quanlytimkiem.tkchungloai.TimKiemChungLoai;
import quanlyshopthoitrangj74.quanlytimkiem.tkgiohang.TimKiemGioHang;
import quanlyshopthoitrangj74.quanlytimkiem.tkkhachhang.TimKiemKhachHang;
import quanlyshopthoitrangj74.quanlytimkiem.tknhacungcap.TimKiemNhaCungCap;
import quanlyshopthoitrangj74.quanlytimkiem.tksanpham.TimKiemSanPham;


public class QuanLyTimKiem {
	static Scanner sc = new Scanner(System.in);
	public static void quanLyTimKiem() {
		do {
			System.out.println("\n\t\t\t==========TIM KIEM==========");
			System.out.println("\tLua chon cua ban: ");
			System.out.println("\t1. Tim kiem nha cung cap");
			System.out.println("\t2. Tim kiem chung loai");
			System.out.println("\t3. Tim kiem gio hang");
			System.out.println("\t4. Tim kiem san pham");
			System.out.println("\t5. Tim kiem khach hang");
			System.out.println("\t0. Quay lai");

			System.out.print("Nhap vao lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				TimKiemNhaCungCap.timKiemNhaCungCap();
				break;
			case 2:
				TimKiemChungLoai.timKiemChungLoai();
				break;
			case 3:
				TimKiemGioHang.timKiemGioHang();
				break;
			case 4:
				TimKiemSanPham.timKiemSanPham();
				break;
			case 5:
				TimKiemKhachHang.timKiemKhachHang();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");
				break;
			}

		} while (true);

	}

}
