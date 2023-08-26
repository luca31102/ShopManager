package quanlyshopthoitrangj74.capnhat.capnhatkhachhang;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.capnhatnhacungcap.NhaCungCap;
import quanlyshopthoitrangj74.quanlybanhang.thongke.QuanLyDanhSachGioHang;

public class QuanLyKhachHang {
	static Scanner sc = new Scanner(System.in);
	
	private static LinkedList<KhachHang> list = new LinkedList<>();
	
	public static LinkedList<KhachHang> getList() {
		return list;
	}

	public static void setList(LinkedList<KhachHang> list) {
		QuanLyKhachHang.list = list;
	}

	public static int autoId = 1;
	
	public static void init() {
		list.add(new KhachHang(autoId++,"Nguyen Hoang Long", "0923452654"));
		list.add(new KhachHang(autoId++,"Le Van Luong", "0987234987"));
		list.add(new KhachHang(autoId++,"Tran Tuan Hung", "01223456666"));
		list.add(new KhachHang(autoId++,"John Wick", "0321765456"));
		list.add(new KhachHang(autoId++,"Nguyen Van Toan", "0999999999"));
	}

	public static void quanLyKhachHang() {
		do {
			System.out.println("\n\t\t\t=========CAP NHAT THONG TIN NHA CUNG CAP=========");
			System.out.println("Chon thong tin cap nhat");
			System.out.println("\t1. Xem danh sach khach hang");
			System.out.println("\t2. Them khach hang moi");
			System.out.println("\t3. Sua thong tin khach hang");
			System.out.println("\t4. Xoa thong tin khach hang");
			System.out.println("\t5. Sap xep danh sach khach hang");
			System.out.println("\t0. Quay lai");

			int chon;
			System.out.print("Nhap vao lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				display();
				break;
			case 2:
				add();
				break;
			case 3:
				update();
				break;
			case 4:
				remove();
				break;
			case 5:
				sort();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");
			}
		} while (true);
		
	}

	private static void display() {
		System.out.println("\t\t\t==========DANH SACH KHACH HANG==========");
		System.out.printf("%10s %-35s %-12s%n","ID", "NAME", "PHONE");
		for(KhachHang x : list) {
			x.display();
		}
	}

	private static void add() {
		System.out.println("\t\t\t==========THEM KHACH HANG==========");
		System.out.print("Nhap vao so luong khach hang muon them: ");
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; ++i) {
			System.out.println("Nhap vao thong tin khach hang thu " + (i+1));
			System.out.print("Nhap vao ten khach hang: ");
			String name = sc.nextLine();
			if(name.length() == 0) {
				System.out.println("Ten khong duoc de trong!");
				return;
			}
			System.out.print("Nhap vao so dien thoai: ");
			String phone = sc.nextLine();
			if(phone.length() == 0) {
				System.out.println("So dien thoai khong duoc de trong!");
				return;
			}
			if(findByPhone(phone) != -1) {
				System.out.println("So dien thoai hien da ton tai!");
				return;
			}
			list.add(new KhachHang(autoId++, name, phone));
		}
		System.out.println("Them khach hang thanh cong");
	}

	private static void update() {
		System.out.println("\t\t\t==========SUA THONG TIN KHACH HANG==========");
		System.out.print("Nhap vao id khach hang can sua: ");
		int id  = Integer.parseInt(sc.nextLine());
		int index = findById(id);
		if(index == -1) {
			System.out.println("Khach hang khong ton tai trong danh sach!");
			return;
		}
		System.out.print("Nhap ten moi cua khach hang: ");
		String name = sc.nextLine();
		if(name.length() == 0) {
			System.out.println("Ten cua khach hang khong duoc de trong!");
			return;
		}
		list.get(index).setName(name);
		System.out.print("Nhap vao so dien thoai moi cua khach hang: ");
		String phone = sc.nextLine();
		if(phone.length() == 0) {
			System.out.print("So dien thoai cua khach hang khong duoc de trong!");
			return;
		}
		if(findByPhone(phone) != -1) {
			System.out.println("So dien thoai ban vua nhap hien da ton tai trong danh sach!");
			return;
		}
		list.get(index).setPhone(phone);
		
		System.out.println("Chinh sua thong tin cua khach hang thanh cong!");
	}

	private static void remove() {
		System.out.println("\t\t\t==========XOA KHACH HANG==========");
		System.out.print("Nhap vao id khach hang can xoa: ");
		int id  = Integer.parseInt(sc.nextLine());
		int index = findById(id);
		if(index == -1) {
			System.out.println("Khach hang khong ton tai trong danh sach!");
			return;
		}
		
		if(QuanLyDanhSachGioHang.findByIdkh(id) != -1) {
			System.out.println("Khong the xoa khach hang da co trong gio hang!");
			return;
		}
		list.remove(index);
		System.out.println("Xoa khach hang thanh cong!");
	}

	private static void sort() {
		Collections.sort(list, new Comparator<KhachHang>() {

			@Override
			public int compare(KhachHang o1, KhachHang o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
		System.out.println("Sap xep thanh cong!");
		
	}
	
	public static int findById(int id) {
		for(int index = 0; index < list.size(); ++index) {
			if(list.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}
	
	public static int findByName(String name) {
		for(int index = 0; index < list.size(); ++index) {
			if(list.get(index).getName().equalsIgnoreCase(name)) {
				return index;
			}
		}
		return -1;
	}
	
	public static int findByPhone(String phone) {
		for(int index = 0; index < list.size(); ++index) {
			if(list.get(index).getPhone().equalsIgnoreCase(phone)) {
				return index;
			}
		}
		return -1;
	}
	
	public static String getNameById(int id) {
		for(int index = 0; index < list.size(); ++index) {
			if(list.get(index).getId() == id) {
				return list.get(index).getName();
			}
		}
		return null;
	}
}
