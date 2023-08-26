package quanlyshopthoitrangj74.quanlybanhang.khachmuahang;

import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.capnhatkhachhang.KhachHang;
import quanlyshopthoitrangj74.capnhat.capnhatkhachhang.QuanLyKhachHang;
import quanlyshopthoitrangj74.capnhat.capnhatsanpham.QuanLySanPham;
import quanlyshopthoitrangj74.capnhat.capnhatsanpham.SanPham;
import quanlyshopthoitrangj74.quanlybanhang.thongke.QuanLyDanhSachGioHang;

public class QuanLyGioHang {
	static Scanner sc = new Scanner(System.in);
	public static void quanLyGioHang() {
		Gio gio = new Gio();
		do {
			System.out.println("\n\t\t\t==========QUAN LY GIO HANG==========");
			System.out.println("Nhap vao lua chon cua ban: ");
			System.out.println("\t1. Hien thi gio hang");
			System.out.println("\t2. Them san pham vao gio hang");
			System.out.println("\t3. Sua san pham trong gio hang");
			System.out.println("\t4. Xoa san pham trong gio hang");
			System.out.println("\t5. Huy gio hang");
			System.out.println("\t6. Thanh toan gio hang");
			System.out.println("\t0. Quay lai");
			
			int chon;
			System.out.print("Nhap vao lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			
			switch(chon) {
			case 1: gio.display(); break;
			case 2: add(gio); break;
			case 3: update(gio); break;
			case 4: delete(gio); break;
			case 5: gio = new Gio(); break;
			case 6: payment(gio);
			case 0: gio = null; return;
			}
		}while(true);
	}
	private static void add(Gio gio) {
		System.out.println("\n\t\t\t==========THEM SAN PHAM VAO GIO HANG==========");
		System.out.print("Nhap vao id san pham muon mua: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLySanPham.findById(id);
		if(index == -1) {
			System.out.println("San pham nay cua hang khong kinh doanh!");
			return;
		}
		System.out.print("Nhap vao so luong san pham muon mua: ");
		double amount = Double.parseDouble(sc.nextLine());
		if(amount <= 0) {
			System.out.println("So luong san pham phai lon hon 0");
			return;
		}
		
		int indexHangOfGio = gio.findHangTrongGioById(id);
		if(indexHangOfGio != -1) {
			amount += gio.getList().get(indexHangOfGio).getAmount();
		}
		
		if(indexHangOfGio != -1) {
			gio.getList().get(indexHangOfGio).setAmount(amount);
		}else {
			gio.getList().add(new SanPhamMua(id, amount));
		}
		System.out.println("Them san pham vao gio hang thanh cong!");
		
	}
	private static void update(Gio gio) {
		System.out.println("\n\t\t\t==========SUA SAN PHAM VAO GIO HANG==========");
		System.out.print("Nhap vao ma san pham muon sua trong gio: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = gio.findHangTrongGioById(id);
		if(gio.findHangTrongGioById(id) == -1) {
			System.out.println("San pham hien khong co trong gio hang!");
			return;
		}
		System.out.print("Nhap vao so luong moi: ");
		double amount = Double.parseDouble(sc.nextLine());
		if(amount <= 0) {
			System.out.println("So luong phai lon hon 0");
			return;
		}
		if(amount > QuanLySanPham.getList().get(index).getAmount()) {
			System.out.println("So luong phai nho hon so luong trong kho!");
			return;
		}
		gio.getList().get(index).setAmount(amount);
		System.out.println("Sua thong tin san pham thanh cong!");
		
	}
	private static void delete(Gio gio) {
		System.out.println("\n\t\t\t==========XOA SAN PHAM VAO GIO HANG==========");
		System.out.print("Nhap vao ma san pham muon xoa trong gio: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = gio.findHangTrongGioById(id);
		if(gio.findHangTrongGioById(id) == -1) {
			System.out.println("San pham hien khong co trong gio hang!");
			return;
		}
		
		gio.getList().remove(index);
		System.out.println("Xoa san pham thanh cong!");
	}
	private static void payment(Gio gio) {
		System.out.println("\n\t\t\t==========THANH TOAN==========");
		System.out.print("Nhap vao id cua khach hang: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLyKhachHang.findById(id);
		if(index == -1) {
			String name = "";
			String phone = "";
			do {
				System.out.print("Nhap vao ten khach hang moi: ");
				name = sc.nextLine();
				if(name.trim().length() == 0) {
					System.out.println("Ten khach hang khong duoc de trong!");
					return;
				}
				System.out.print("Nhap vao so dien thoai moi: ");
				phone = sc.nextLine();
				int indexphone = QuanLyKhachHang.findByPhone(phone);
				if(indexphone != -1) {
					System.out.println("So dien thoai cua khach hang da ton tai trong danh sach!");
					return;
				}
			}while(name.trim().length() == 0 && index != -1);
			id = QuanLyKhachHang.autoId++;
			QuanLyKhachHang.getList().add(new KhachHang(id, name, phone));
		}
		
		gio.setId(QuanLyDanhSachGioHang.autoId++);
		gio.setIdkh(id);
		System.out.println("\n\t\t\t==========THANH TOAN==========");
		gio.display();
		QuanLyDanhSachGioHang.getList().add(gio);
		for(SanPhamMua x : gio.getList()) {
			for(SanPham y : QuanLySanPham.getList()) {
				if(x.getId() == y.getId()) {
					y.setAmount(y.getAmount() - x.getAmount());
				}
			}
			
		}
		System.out.println("Thanh toan thanh cong");
		
	}
}
